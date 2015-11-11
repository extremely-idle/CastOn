package net.rossmoug.cast_on.impl.web.oauth;

import org.apache.log4j.Logger;
import org.scribe.builder.ServiceBuilder;
import org.scribe.exceptions.OAuthException;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import net.rossmoug.cast_on.impl.web.oauth.api.RavelryApi;

/**
 * Central service which allows for authentication and information retrieval
 * from Ravelry (www.ravelry.com) via OAuth and HTTPs.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 * @version 1.1
 * @see https://github.com/fernandezpablo85/scribe-java
 */
public class RavelryOAuthService {

	private static final String API_KEY = "2E3B6FB9A651CC9B8AF4";
	private static final String API_SECRET = "s+0aLLpCfOR+2o64n9MRkO7yW7ar9/xmuccFeg6Y";

	private static OAuthService service;
	private static Logger logger = Logger.getLogger(RavelryOAuthService.class);

	/**
	 * 
	 */
	public RavelryOAuthService() {
		init();
	}

	/**
	 * 
	 */
	public void init() {
		logger.trace("init");
		service = new ServiceBuilder().provider(RavelryApi.class).apiKey(API_KEY).apiSecret(API_SECRET).build();
	}

	/**
	 * 
	 */
	public Token authorise() {
		logger.trace("authorise");
		try {
			return service.getRequestToken();
		} catch (OAuthException oae) {
			System.err.println(oae.getMessage());
		}
		return null;
	}

	/**
	 * 
	 * @param requestToken
	 * @param verifier
	 */
	public void access(Token requestToken, String verifier) {
		logger.trace(
				"access(\n" + "  requestToken => " + requestToken.toString() + "\n  verifier => " + verifier + "\n)");
		try {
			Verifier v = new Verifier(verifier);

			Token accessToken = service.getAccessToken(requestToken, v); // the
																			// requestToken
																			// you
																			// had
																			// from
																			// step
																			// 2

			OAuthRequest request = new OAuthRequest(Verb.GET, ""); // resource
																	// that
																	// needs to
																	// accessed

			service.signRequest(accessToken, request); // the access token from
														// step 4

			Response response = request.send();
			System.out.println("code => " + response.getCode());
			System.out.println("message => " + response.getMessage());
			System.out.println("body => " + response.getBody());
		} catch (OAuthException oae) {
			System.err.println(oae.getMessage());
		}
	}
}
