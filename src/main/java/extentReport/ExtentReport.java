package extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	
	
	private static ExtentReports extent ;
	 
	 
	 public static ExtentReports createInstance(String fileName) {
		 
		 ExtentSparkReporter spark = new ExtentSparkReporter(fileName);
		 spark.config().setDocumentTitle(fileName);
		 spark.config().setEncoding("utf-8");
		 spark.config().setTheme(Theme.DARK);
		 spark.config().setReportName(fileName);
		 
		 extent = new ExtentReports();
		 
		 extent.attachReporter(spark);
		 extent.setSystemInfo("Automation Tester", "Fouad Mesrane");
	     extent.setSystemInfo("Organization", "Way2Automation");
	     extent.setSystemInfo("Build no", "W2A-1234");
		 
		 return extent;
		 
		 
	 }
	 
	 
	
	 
	 
	 
	 
}
