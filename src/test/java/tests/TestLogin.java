package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import pages.HomePage;

public class TestLogin extends BasePage{

	
	
	HomePage hp;
	@Test
	public void testLogin() {
		 hp = new HomePage();
		 hp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		 System.out.println(hp.headerTitle());
		 Assert.assertEquals(hp.headerTitle(), "Dashboard");
	}
}
