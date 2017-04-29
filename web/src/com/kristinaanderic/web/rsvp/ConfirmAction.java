package com.kristinaanderic.web.rsvp;

import java.util.Date;
import java.util.Iterator;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.kristinaanderic.core.Kernel;
import com.kristinaanderic.guests.Food;
import com.kristinaanderic.guests.Party;
import com.kristinaanderic.guests.Respondant;
import com.kristinaanderic.guests.Rsvp;
import com.kristinaanderic.persistence.PersistenceEngine;
import com.kristinaanderic.util.Name;
import com.kristinaanderic.web.WebConstants;

public final class ConfirmAction extends Action {

    private static final org.apache.log4j.Logger LOGGER =
        org.apache.log4j.Logger.getLogger(ConfirmAction.class);
    
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
	    	Party party = (Party)request.getSession().getAttribute("loggedInParty");
	    	if (party == null) return mapping.findForward(WebConstants.TIMEOUT_FORWARD);
	    	ActionErrors errors = new ActionErrors();
			RsvpForm rsvpForm = (RsvpForm)form;
			party = rsvpForm.getParty();
			Long id = party.getId();
			LOGGER.info(logPrefix(id)+"Confirming party ("+party+") "+party.getPartyName());
			LOGGER.info(logPrefix(id)+"information --> " + logRsvpForm(rsvpForm));
			PersistenceEngine engine = Kernel.getCore().getPersistenceEngine();
			Rsvp rsvp = party.getRsvp();
			String isAttendingValue = rsvpForm.getAttending();
			boolean isAttending = Boolean.valueOf(isAttendingValue).booleanValue();
			String comments = rsvpForm.getComments();
			rsvp.setResponseDate(new Date());
			rsvp.setAttending(isAttending);
			rsvp.setComments(comments);
			rsvp.getAttendingRespondants().clear();
			if (isAttending) {
			    buildRespondants(rsvpForm, rsvp);
			}
			engine.save(party);
			LOGGER.info(logPrefix(id)+"saved, sending email");
			emailConfirmation(party);
			LOGGER.info(logPrefix(id)+"email sending complete");
			request.getSession().setAttribute("rsvpForm", null);
		return mapping.findForward(WebConstants.SUCCESS_FORWARD);

	}

    private void buildRespondants(RsvpForm rsvpForm, Rsvp rsvp) {
        String[] firstNames = rsvpForm.getFirstNames();
        String[] lastNames = rsvpForm.getLastNames();
        String[] meals = rsvpForm.getMeals();
        rsvp.getAttendingRespondants().clear();
        for (int index = 0; index < meals.length; index++) {
            Food food = Food.fromValue(meals[index]);
            if (food != null) {
                String firstName = firstNames[index];
                String lastName = lastNames[index];
                if (firstName == null) firstName = "";
                if (lastName == null) lastName = "";
                Name name = new Name(firstNames[index], lastNames[index]);
                Respondant respondant = new Respondant(name, food);
                rsvp.getAttendingRespondants().add(respondant);
            }
        }
    }
    
    private void emailConfirmation(Party party) {
        Rsvp rsvp = party.getRsvp();
        String partyName = party.getPartyName();
        boolean isAttending = rsvp.isAttending();
        final Date responseDate = rsvp.getResponseDate();
        final String[] names = new String[rsvp.getAttendingRespondants().size()];
        final String[] meals = new String[rsvp.getAttendingRespondants().size()];
        final String comments = (rsvp.getComments() == null || rsvp.getComments().equals("") ? "(None)" : rsvp.getComments());
        int index = 0;
        for (Iterator it = rsvp.getAttendingRespondants().iterator(); it.hasNext();) {
            Respondant respondant = (Respondant)it.next();
            names[index] = respondant.getName().toString();
            meals[index] = respondant.getFood().toString();
            index++;
        }
        ConfirmationEmailer emailer = new ConfirmationEmailer(partyName, isAttending, responseDate,
                names, meals, comments);
        new Thread(emailer).start();
    }
    
    private String logPrefix(Long logId) {
        return "[CONFIRM "+logId+"] ";
    }
    
    private String logRsvpForm(RsvpForm form) {
        StringBuffer buffer = new StringBuffer();
        try {
        buffer.append("party: [" + form.getParty().getPartyName()+"], ");
        buffer.append("isAttending? [" + form.getAttending()+"], ");
        buffer.append("guests: [");
        for (int index = 0; index < form.getLastNames().length; index++) {
            String firstName = form.getFirstNames()[index];
            String lastName = form.getLastNames()[index];
            String meal = form.getMeals()[index];
            if (firstName != null && !firstName.equals("") &&
                    lastName != null && !lastName.equals("")) {
                buffer.append(firstName+" "+lastName+" - "+meal);
                if (index != form.getLastNames().length-1) {
                    buffer.append(", ");
                }
            }
        }
        buffer.append("], ");
        buffer.append("Comments: [\"");
        buffer.append(form.getComments()+"\"]");        
        } catch (Exception e) {
            buffer.append(" --> ERROR!!!");
            LOGGER.error("Error creating rsvp log data.", e);
        }
        return buffer.toString();
    }

    private class ConfirmationEmailer implements Runnable {
        
        private final org.apache.log4j.Logger LOGGER =
            org.apache.log4j.Logger.getLogger(ConfirmationEmailer.class);
        private final String partyName;
        private final boolean isAttending;
        private final Date responseDate;
        private final String[] names;
        private final String[] meals;
        private final String comments;
        
        public ConfirmationEmailer(String partyName, boolean isAttending, Date responseDate,
                String[] names, String[] meals, String comments) {
            this.partyName = partyName;
            this.isAttending = isAttending;
            this.responseDate = responseDate;
            this.names = names;
            this.meals = meals;
            this.comments = comments;
        }
    
        public void run() {
            try {
            final String isAttendingValue = (isAttending ? "YES" : "NO");
            JavaMailSender mailer = (JavaMailSender)Kernel.getCore().getContext().getBean("mailer");
            mailer.send(new MimeMessagePreparator() {
                public void prepare(MimeMessage mimeMessage) throws MessagingException {
                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                    message.setFrom("krisanderic@kristinaanderic.com");
                    message.addTo("ewestfal@mailcan.com");
                    message.addTo("kwestfal@mailcan.com");
                    message.setSubject("[rsvp] "+isAttendingValue+" - "+partyName);
                    StringBuffer bodyBuffer = new StringBuffer();
                    bodyBuffer.append("This party has entered and confirmed their RSVP.\n\n");
                    bodyBuffer.append("Party Name: " + partyName+"\n");
                    bodyBuffer.append("Is Attending? " + isAttendingValue+"\n");
                    bodyBuffer.append("Response Date: " + responseDate.toString()+"\n\n");
                    if (isAttending) {
                        bodyBuffer.append("People Attending from this Party and their meal choice:\n");
                        for (int index = 0; index < names.length; index++) {
                            bodyBuffer.append(names[index]);
                            bodyBuffer.append(" -- ");
                            bodyBuffer.append(meals[index]);
                            bodyBuffer.append("\n");
                        }
                        bodyBuffer.append("\n");
                    }
                    bodyBuffer.append("Comments:\n");
                    bodyBuffer.append(comments);
                    message.setText(bodyBuffer.toString());
                }
            });
            } catch (Exception e) {
                LOGGER.fatal("There was an error sending the confirmation email.", e);
            }
        }
    }

}
