package net.rossmoug.cast_on.impl.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.apache.log4j.Logger;

import net.rossmoug.cast_on.impl.web.oauth.RavelryOAuthService;

/**
 * Class which will process data retrieved from Ravelry (www.ravelry.com) via the
 * OAuth/HTTP requests.
 *
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.2
 * @see RavelryOAuthService
 * @see https://docs.oracle.com/javaee/7/api/javax/json/package-summary.html
 */
public class RavelryDataReader {

	private final static String RAVELRY_URI = "https://www.ravelry.com/";

	private static Logger logger = Logger.getLogger(RavelryDataReader.class);

	public void data() {
		logger.trace("data");
		URL url;
		try {
			url = new URL(RAVELRY_URI);
			try (
				InputStream is = url.openStream();
				JsonReader rdr = Json.createReader(is)
			) {

				JsonObject obj = rdr.readObject();
				JsonArray results = obj.getJsonArray("data");
				for (JsonObject result : results.getValuesAs(JsonObject.class)) {
					logger.debug(result.getJsonObject("from").getString("name"));
					logger.debug(": ");
					logger.debug(result.getString("message", ""));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
