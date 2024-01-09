package com.qc.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestConfiguration {

    static ExtentReports extent;

    public static ExtentReports getReportObject() {
        String path = "test-output/TestNGReport.html";
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
        reporter.config().setReportName("Test Automation Report");
        reporter.config().setDocumentTitle("Genpact");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Host Name", "Genpact");
        extent.setSystemInfo("User Name", "Rushikesh Bulbule");
        return extent;
    }

}

		
