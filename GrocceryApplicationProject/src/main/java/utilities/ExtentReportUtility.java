package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();// static instance of extentreports that can 
		// be shared accross the application 

public synchronized static ExtentReports createExtentReports() { 

ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");  // folder creation
reporter.config().setReportName("GroceryAppProject"); 
extentReports.attachReporter(reporter); 

extentReports.setSystemInfo("Organization", "Obsqura"); 
extentReports.setSystemInfo("Name", " Marina"); // provides context of the report 
return extentReports; 

}
}
