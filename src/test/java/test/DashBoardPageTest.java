package test;

import org.testng.annotations.Test;

import extentlisteners.Listeners;

public class DashBoardPageTest extends Listeners {

	@Test(priority=3)
	public void searchValidation()
	{
		db.clickonGetStarted();
		test.info("Clicked on the GetStarted button");
		db.searchshares();
		test.info("Searched the Shares");
	}
	
	@Test(priority=4)
	public void buysharevalidation()
	{
		db.buyshares();
		test.info("Shares has been buyed");
	}
}
