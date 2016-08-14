package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import model.LoginService;

public class LoginHashTest {
	
	@Test
	/**
	 * Test of generating hash to person
	 */
	public void generateTestHashTrueReturend() {
		String pass = "TestHash";
		String localSalt = "abc";
		int resultSalt = -1026383571;
		
		LoginService loginService = new LoginService();
		int matchingResultSalt = loginService.hashCode(pass, localSalt);
		
		assertEquals(resultSalt, matchingResultSalt);
	}
}
