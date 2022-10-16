package extentlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGen {
	
		public static ExtentReports extent;
		
		public static ExtentReports extentreportgenerator()
		{
			String path = System.getProperty("user.dir")+"//NewReports//kitezerodhareport.html";
			ExtentSparkReporter spark = new ExtentSparkReporter(path);
			spark.config().setDocumentTitle("Kite Zerodha Automation Test Report");
			spark.config().setReportName("Zerodha Report");
			spark.config().setTheme(Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("Project Name", "Kite Zerodha");
			extent.setSystemInfo("Host Name", "Local Host");
			extent.setSystemInfo("Environment", "SIT");
			extent.setSystemInfo("Tester", "Sushant K");
			extent.setSystemInfo("OS", "Windows OS");
			extent.setSystemInfo("Browser","Google Chrome");

			return extent;
		}
}
