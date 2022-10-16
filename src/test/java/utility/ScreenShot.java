package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	public static String capturescreenshot(WebDriver driver, String filename) throws IOException
	{
		TakesScreenshot scrnshot = (TakesScreenshot)driver;
		File source = scrnshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"//Screenshots//" +filename + "//.png";
		File destination = new File(path);
		FileHandler.copy(source, destination);
		return path;
		
	}
}
