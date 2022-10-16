package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentlisteners.Listeners;

public class LoginPageTest extends Listeners{

	@Test(priority = 1)
	public void verifyLogin()
	{
		lp.enterCredentials();
		test.info("Credentials has been entered");
		lp.clickonLogin();
		test.info("Clicked on Login");
		lp.enterPinandclickContinue();
		test.info("Pin has been entered successfully");
	}
	
	@Test(priority=2)
	public void verifypagetitle()
	{
		String actualtitle = lp.getTitleofPage();
		test.info("Title of the Page has been fetched");
		Assert.assertEquals(actualtitle, "Kite - Zerodha's fast and elegant flagship trading platform");
	}
	
}
