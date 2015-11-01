package net.rossmoug.cast_on.test.web.oauth;

import net.rossmoug.cast_on.impl.web.oauth.RavelryOAuthService;
import net.rossmoug.cast_on.impl.web.oauth.api.RavelryApi;

import org.junit.Assert;
import org.junit.Test;
import org.scribe.model.Token;

/**
 * Tests to ensure that the application can successfully authenticate and 
 * retrieve information from Ravelry via OAuth/HTTPS.
 * 
 * @author Ross Moug (ross.moug@gmail.com)
 */
public class RavelryOAuthServiceTest {

	private static final String AUTHORISATION_URL = "https://www.ravelry.com/oauth/authorize";
	
	@Test
	/**
	 * Ensure that application can authenticate successfully with Ravelry
	 */
	public void validAuthTest(){
		RavelryApi api = new RavelryApi();
		RavelryOAuthService service = new RavelryOAuthService();

		Token requestToken = service.authorise();
		
		Assert.assertNotNull("Request token is not null", requestToken);
		Assert.assertEquals(api.getAuthorizationUrl(requestToken), AUTHORISATION_URL + requestToken.getToken());
	}
	
}
