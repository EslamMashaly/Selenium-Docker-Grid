package utils.ExtenReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utils.dataReaders.PropertiesReader;

public class ExtentReport {

    public static ExtentReports getReportObject() {

        String reportPath = PropertiesReader.pathsData.getProperty("ExtentReport");
        ExtentSparkReporter report = new ExtentSparkReporter(reportPath);
        report.config().setReportName("Tests Report");
        report.config().setDocumentTitle("Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("Eslam Mashaly", "Tester");
        return extent;
    }
}
