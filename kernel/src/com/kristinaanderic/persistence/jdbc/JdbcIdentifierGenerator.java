package com.kristinaanderic.persistence.jdbc;

import com.kristinaanderic.persistence.Identifier;
import com.kristinaanderic.persistence.IdentifierGenerator;

/**
 * @author Eric Westfall
 * @created Aug 22, 2004
 */
public class JdbcIdentifierGenerator extends JdbcSupport implements IdentifierGenerator {
	
	private static final int DEFAULT_NUM_IN_RANGE = 100;
	
	private static final String LOCK_TABLES = "LOCK TABLES Identifiers WRITE";
	private static final String UNLOCK_TABLES = "UNLOCK TABLES";
	private static final String SELECT_MAX = "SELECT MAX(id) FROM Identifiers";
	private static final String INSERT_ID = "INSERT INTO Identifiers VALUES(?)";
	
	private int numInRange = DEFAULT_NUM_IN_RANGE;
	private IdentifierRange currentRange;
	
	public synchronized Identifier generate() {
            System.out.println("GENERATING");
		if (currentRange == null || !currentRange.hasNext()) {
			currentRange = getNextRange();
		}
		return currentRange.getNext();
	}
	
	public int getNumInRange() {
		return numInRange;
	}
	
	public void setNumInRange(int numInRange) {
		this.numInRange = numInRange;
	}

	private IdentifierRange getNextRange() {
            System.out.println("GETTING NEXT RANGE");
		getJdbcTemplate().execute(LOCK_TABLES);
		long currentMax = getJdbcTemplate().queryForLong(SELECT_MAX);
		currentMax++;
		IdentifierRange range = new IdentifierRange(currentMax, numInRange);
		long lastId = range.getLastId();
		getJdbcTemplate().update(INSERT_ID, new Object[] { new Long(lastId) });
		getJdbcTemplate().execute(UNLOCK_TABLES);
		return range;
	}
	
	private class IdentifierRange {
		
		private long current;
		private int numRemaining;
		
		public IdentifierRange(long start, int numInRange) {
			this.current = start;
			this.numRemaining = numInRange;
		}
		
		public Identifier getNext() {
			Identifier id = null;
			if (hasNext()) {
				id = new Identifier(current);
				current++;
				numRemaining--;
			}
			return id;
		}
		
		public boolean hasNext() {
			return numRemaining > 0;
		}
		
		public long getLastId() {
			return current+numRemaining;
		}
		
	}
	
}
