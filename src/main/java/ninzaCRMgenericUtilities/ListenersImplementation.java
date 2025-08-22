package ninzaCRMgenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * this class provides implementation for ITestListener of testng
 */
public class ListenersImplementation implements ITestListener{

	
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		
		String methodname= result.getMethod().getMethodName();
		System.out.println(methodname+ "Test Execution started");
		
		//intimate extentreports for test start
		ExtentTest test = report.createTest(methodname);//this method has started the execution
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname= result.getMethod().getMethodName();
		//System.out.println(methodname+ "Test Execution sucess");
		
		//log the status of @test as PASS in extentreport
		test.log(Status.PASS,methodname+ "Test Execution sucess" );
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname= result.getMethod().getMethodName();
		//System.out.println(methodname+ "Test Execution Failure");
		
		//log the status as fail in extentreport
		test.log(Status.FAIL, methodname+ "Test Execution Failure");
		
		//capture the exception
		System.out.println(result.getThrowable());
		
		//log the exception in extent reports 
		test.log(Status.WARNING, result.getThrowable());
		
		//capture the screenshot
		JavaUtility ju = new JavaUtility();
		WebDriverUtility w = new WebDriverUtility();
		
		//screenshotname
		String screenshotname = methodname+ju.getsystemDate();
		try {
			//w.captureScreenShot(BaseClass.sdriver, screenshotname);//do not create object in baseclass
			//just reinitalize the driver and utilize it as sdriver from the base class
		
		String path = w.captureScreenShot(BaseClass.sdriver, screenshotname);
		
		//attach screenshot to report
		test.addScreenCaptureFromPath(path);//adding logs to capture the screenshot 
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname= result.getMethod().getMethodName();
		System.out.println(methodname+ "Test Execution Skipped");
		
		//log the skip status
		//test.log(Status.SKIP, methodname+ "Test Execution Skipped");
		
		
		//capture the exception
		System.out.println(result.getThrowable());
		
		//log the exception
		test.log(Status.WARNING, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String methodname= result.getMethod().getMethodName();
		System.out.println(methodname+ "Test Execution started");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		String methodname= result.getMethod().getMethodName();
		System.out.println(methodname+ "Test Execution Failed");
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println( "Test Execution started");
		
		//extent report configuration
    ExtentSparkReporter ers = new ExtentSparkReporter(".\\ExtenrReports\\Extent-Report-" +new JavaUtility().getsystemDate()+".html");
	ers.config().setDocumentTitle("Ninza CRM Automation Report");
	ers.config().setTheme(Theme.DARK);
	ers.config().setReportName("Automation Execution Report");
	
	//create a object for ER class
    report = new ExtentReports();
	report.attachReporter(ers);
	report.setSystemInfo("Base Browser", "Microsoft Edge");
	report.setSystemInfo("Base Platform", "Windows");
	report.setSystemInfo("base URL", "Test Env");
	report.setSystemInfo("Reporter Name", "Anusha TS");
	
	
	}

	@Override
	public void onFinish(ITestContext context) {
		
		report.flush();
		System.out.println( "Test Execution finished");
		
		//extentreport will understand the execution by seeing the flush()method
		//report generation 
		
		
	}
	
	

}
