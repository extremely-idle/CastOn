package net.rossmoug.cast_on.impl.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Ross Moug (ross.moug@gmail.com)
 */
public class RavelryDataReader {

	public void data() {
		URL url;
		try {
			url = new URL("https://www.ravelry.com/");
			try (
				InputStream is = url.openStream();
				JsonReader rdr = Json.createReader(is)
			) {

				JsonObject obj = rdr.readObject();
				JsonArray results = obj.getJsonArray("data");
				for (JsonObject result : results.getValuesAs(JsonObject.class)) {
					System.out.print(result.getJsonObject("from").getString(
							"name"));
					System.out.print(": ");
					System.out.println(result.getString("message", ""));
					System.out.println("-----------");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
