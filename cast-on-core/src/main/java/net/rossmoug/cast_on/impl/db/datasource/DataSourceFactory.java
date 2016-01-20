package net.rossmoug.cast_on.impl.db.datasource;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.sql.DataSource;

/**
 * Factory to create DataSource objects for specific DB vendors.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 */
public class DataSourceFactory {

	final static String PROP_FILE_NAME = "db.properties";
	final static String SEP = "_";
	
	/**
	 * 
	 * @return
	 */
	public static DataSource getSQLLiteDataSource() {
		Properties props = new Properties();
		FileInputStream in = null;
		SQLiteDataSource sqliteDataSource = null;
		try {
			in = new FileInputStream(PROP_FILE_NAME);
			props.load(in);
			sqliteDataSource = new SQLiteDataSource();
			sqliteDataSource.setUrl(new URI(props.getProperty(DBVendor.SQLITE + SEP + "_DB_URL")));
			sqliteDataSource.setUsername(props.getProperty(DBVendor.SQLITE + SEP + "_DB_USERNAME"));
			sqliteDataSource.setPassword(props.getProperty(DBVendor.SQLITE + SEP + "_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return sqliteDataSource;
	}

	/**
	 * 
	 * @return
	 */
	public static DataSource getMongoDataSource() {
		// TODO
		return null;
	}
}
