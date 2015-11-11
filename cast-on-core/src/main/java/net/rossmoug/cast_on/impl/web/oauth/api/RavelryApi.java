package net.rossmoug.cast_on.impl.web.oauth.api;

import org.apache.log4j.Logger;
import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

import net.rossmoug.cast_on.impl.web.oauth.RavelryOAuthService;

/**
 * Class which represents the HTTP API used by Ravelry (www.ravelry.com). This
 * is required by Scribe.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 * @see https://github.com/fernandezpablo85/scribe-java
 */
public class RavelryApi extends DefaultApi10a {

	public static final String AUTHORISATION_URL = "https://www.ravelry.com/oauth/authorize?token=";
	private static final String ACCESS_TOKEN_URL  = "https://www.ravelry.com/oauth/access_token";
	private static final String REQUEST_TOKEN_URL = "https://www.ravelry.com/oauth/request_token";

	private static Logger logger = Logger.getLogger(RavelryApi.class);

	@Override
	public String getAccessTokenEndpoint() {
		logger.trace("getAccessTokenEndpoint");
		return ACCESS_TOKEN_URL;
	}

	@Override
	public String getRequestTokenEndpoint() {
		logger.trace("getRequestTokenEndpoint");
		return REQUEST_TOKEN_URL;
	}

	@Override
	public String getAuthorizationUrl(Token requestToken) {
		logger.trace("getAuthorizationUrl(\n" + "  requestToken => " + requestToken.toString() + "\n)");
	    return String.format(AUTHORISATION_URL + "%s", requestToken.getToken());
	}

}
