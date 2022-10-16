package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	WebDriver driver;
	
	@FindBy(xpath="//input[@id='userid']")
	private WebElement username;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/input[1]")
	private WebElement password;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/button[1]")
	private WebElement loginbutton;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]")
	private WebElement pintextfield;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/button[1]")
	private WebElement continuebutton;
	
	@FindBy(xpath="//body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/button[1]")
	private WebElement getStartedbutton;
	
	public LoginPage(WebDriver driver) throws IOException
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterCredentials()
	{
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));//note these steps
	}
	
	public void clickonLogin()
	{
		loginbutton.click();
	}
	
	public void enterPinandclickContinue()
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		pintextfield.sendKeys(prop.getProperty("pin"));
		continuebutton.click();
	}
	
	public String getTitleofPage()
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		boolean getstartedbutton = getStartedbutton.isDisplayed();
		System.out.println(getstartedbutton);
		String titleofpage = driver.getTitle();
		System.out.println(titleofpage);
		return titleofpage;
	}
	
	
	
	
	
}
