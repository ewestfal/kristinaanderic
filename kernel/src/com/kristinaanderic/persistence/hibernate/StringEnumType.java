package com.kristinaanderic.persistence.hibernate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.UserType;
/**
 * @author Eric Westfall
 */
public abstract class StringEnumType implements UserType, java.io.Serializable {
	
	private static final int[] SQL_TYPES = new int[]{Types.VARCHAR};
	
	public int[] sqlTypes() {
		return SQL_TYPES;
	}
	
	public boolean equals(Object x, Object y) throws HibernateException {
		return (x == y) || (x != null && y != null && x.equals(y));
	}
	
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
			throws HibernateException, SQLException {
		String value = rs.getString(names[0]);
		if (rs.wasNull())
			value = null;
		return stringToEnum(value);
	}
	
	public void nullSafeSet(PreparedStatement st, Object value, int index)
			throws HibernateException, SQLException {
		if (value == null) {
			st.setNull(index, Types.VARCHAR);
		} else {
			st.setString(index, enumToString(value));
		}
	}
	
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}
	
	public boolean isMutable() {
		return false;
	}
	
	public abstract Class returnedClass();
	
	protected abstract Object stringToEnum(String value);
	
	protected abstract String enumToString(Object enumValue);
	
}