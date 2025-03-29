package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentSparkReporter htmlReporter;
    private static ExtentTest test;

    public static ExtentReports setupReport() {
        // Set the location of the report file
        String reportPath = System.getProperty("user.dir") + "/target/ExtentReports/extentReport.html";
        htmlReporter = new ExtentSparkReporter(reportPath);

        // Configure the report
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setReportName("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }
}
