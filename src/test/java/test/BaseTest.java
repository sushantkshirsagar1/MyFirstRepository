package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashBoardPage;
import pages.LoginPage;

public class BaseTest {
	
	public static WebDriver driver;
	public LoginPage lp;
	public DashBoardPage db;
	
	@BeforeSuite
	public void initbrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://kite.zerodha.com");
	}
	
	@AfterSuite
	public void teardown()
	{
		driver.quit();
	}
	
	public void objectcreation() throws IOException
	{
		lp = new LoginPage(driver);
		db = new DashBoardPage(driver);
		
	}

}
