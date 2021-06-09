package Falkenberg.testcases.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		// basic configuration of Extent REports with Standalone Test 
		//ExtentReports class and , ExtentSparkReporter class its helper class
		
		String path =System.getProperty("user.dir")+"\\src\\test\\resources\\extentreports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomation results");
	    reporter.config().setDocumentTitle("TestResults");
	    
	    //main class responsible for to drive all your reporting execution 
	    
	    ExtentReports extent = new ExtentReports();
	    // attach extentspark report to main class 
	    extent.attachReporter(reporter);
	    // tester name 
	    extent.setSystemInfo("tester","Deepika");
	    return extent;
	    
	}

}
