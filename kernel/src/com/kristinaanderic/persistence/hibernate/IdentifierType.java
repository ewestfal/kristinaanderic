package com.kristinaanderic.persistence.hibernate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.UserType;

import com.kristinaanderic.persistence.Identifier;

/**
 * @author Eric Westfall
 * @created Apr 1, 2004
 */
public class IdentifierType implements UserType, java.io.Serializable {

    private static final int[] SQL_TYPES = new int[] { Types.BIGINT };

    public int[] sqlTypes() {
        return SQL_TYPES;
    }

    public Class returnedClass() {
        return Identifier.class;
    }

    public boolean equals(Object x, Object y) throws HibernateException {
        return (x==y) || (x!=null && y!=null && x.equals(y));
    }

    public Object nullSafeGet(ResultSet rs, String[] names, Object owner) 
        throws HibernateException, SQLException
    {
        long value = rs.getLong(names[0]);
        if (rs.wasNull()) return null;
        return new Identifier(value);
    }

    public void nullSafeSet(PreparedStatement st, Object value, int index)
        throws HibernateException, SQLException 
    {
    	if (value == null) {
        	st.setNull(index, Types.BIGINT);
        }
        else {
            st.setLong(index, ((Identifier)value).getValue());
        }
    }

    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    public boolean isMutable() {
        return false;
    }

}
