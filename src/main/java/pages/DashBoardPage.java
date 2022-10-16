package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

	WebDriver driver;
	
	@FindBy(xpath="//body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/button[1]")
	private WebElement getStartedButton;
	
	@FindBy(xpath="//body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	private WebElement searchBox;
	
	@FindBy(xpath="//body[1]/div[1]/div[5]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/button[1]")
	private WebElement buyButton;
	
	@FindBy(xpath="//body[1]/div[1]/form[1]/section[1]/div[1]/footer[1]/div[2]/button[1]/span[1]")
	private WebElement outerBuyButton;
	
	@FindBy(xpath="//*[@class='message']")
	WebElement textMessage;
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonGetStarted()
	{
		getStartedButton.click();
	}
	
	public void searchshares()
	{
		searchBox.sendKeys("SBIN");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	public void buyshares()
	{
		buyButton.click();
		outerBuyButton.click();
		String message = textMessage.getText();
		System.out.println(message);
	}
}
