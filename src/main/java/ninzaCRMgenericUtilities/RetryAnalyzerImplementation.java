package ninzaCRMgenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * this class provides implementation to IretryerAnalyzer interface
 */
public class RetryAnalyzerImplementation implements IRetryAnalyzer {
//it implements only if test script is failed
	
	int count =0;
	int retrycount = 3;//Manual Analysis do it manually and update it
	
	@Override
	public boolean retry(ITestResult result) {
		
		while(count<retrycount)//recounts=3==false
		{
			count++;//1,2,3
			return true;//retry,rerun,rerun
		}
		return false;//stop retry
	}
	
	

}
