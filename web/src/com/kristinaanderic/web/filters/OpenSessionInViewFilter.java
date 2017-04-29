package com.kristinaanderic.web.filters;

import net.sf.hibernate.SessionFactory;

import com.kristinaanderic.core.Kernel;

public class OpenSessionInViewFilter extends org.springframework.orm.hibernate.support.OpenSessionInViewFilter {
    
    protected SessionFactory lookupSessionFactory() {
        return (SessionFactory)Kernel.getCore().getContext().getBean(getSessionFactoryBeanName());
    }
    
}
