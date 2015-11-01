package net.rossmoug.cast_on.impl.db;

import java.sql.ResultSet;

/**
 *
 * @author Ross Moug (ross.moug@gmail.com)
 */
public interface IDBAdapter {
	
	public void openDB(); // to return database object type, for example SQLiteDatabase
	
	public void closeDB();
	
	public void getDB(); // to return database object type, for example SQLiteDatabase
	
	public long tableCount(String tableName);
	
	public ResultSet executeQuery(String query);

}
