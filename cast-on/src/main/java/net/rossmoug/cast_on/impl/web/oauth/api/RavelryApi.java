package net.rossmoug.cast_on.impl.web.oauth.api;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.OAuthConfig;
import org.scribe.model.Token;
import org.scribe.oauth.OAuthService;

/**
 * Class which represents the HTTP API used by Ravelry (www.ravelry.com). This
 * is required by Scribe.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.0
 * @see https://github.com/fernandezpablo85/scribe-java
 */
public class RavelryApi extends DefaultApi10a {

	private static final String AUTHORISATION_URL = "https://www.ravelry.com/oauth/authorize?token=%s";
	private static final String ACCESS_TOKEN_URL  = "https://www.ravelry.com/oauth/access_token";
	private static final String REQUEST_TOKEN_URL = "https://www.ravelry.com/oauth/request_token";

	@Override
	public String getAccessTokenEndpoint() {
		return ACCESS_TOKEN_URL;
	}

	@Override
	public String getRequestTokenEndpoint() {
		return REQUEST_TOKEN_URL;
	}

	@Override
	public String getAuthorizationUrl(Token requestToken) {
	    return String.format(AUTHORISATION_URL, requestToken.getToken());
	}

}
