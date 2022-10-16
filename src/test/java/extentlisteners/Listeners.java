package extentlisteners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import test.BaseTest;
import utility.ScreenShot;

public class Listeners extends BaseTest implements ITestListener{

	public static ExtentTest test; 
	ExtentReports extent = ExtentReportGen.extentreportgenerator();/*calling
	extent report gen class in this method*/
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Started:"+result.getName());
		test = extent.createTest(result.getName());
		driver.manage().deleteAllCookies();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Passed:"+result.getName());
		test.log(Status.PASS, "Test Case is Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case Failed:"+ result.getName());
		test.log(Status.FAIL, "Test Case is Failed:"+result.getName());
		test.log(Status.FAIL, "Test Case is Failed:"+result.getThrowable());
		try {
			test.addScreenCaptureFromPath(ScreenShot.capturescreenshot(driver, result.getName() ), "Captured Screenshot");
		}catch (IOException e) {
			System.out.println("Exception occured while taking screenshot");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		System.out.println("Test Case Skipped:"+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Started:"+ context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Completed:"+ context.getName());
		extent.flush();
	}
	
	
	
	
	

}
