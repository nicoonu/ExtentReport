package extentReportScreenshotTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class ExtentReportScreenshot extends BaseTestScreenshot {
    @BeforeTest
    public void setUpReports(){
        extentHtmlReporter = new ExtentHtmlReporter("reports/reportScreenshot/screenshotYT_Report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
    }

    @AfterMethod
    public void tearDown() {
        extentReports.flush();
    }

    @AfterMethod
    public void getResult(ITestResult testResult) throws IOException {
        if(testResult.getStatus() == ITestResult.FAILURE){
            String temp = "." + Screenshot.getScreenshot(driver, "titleYoutubeTest");
            extentTest.fail(testResult.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }
    }
}