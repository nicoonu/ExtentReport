package testTwitter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ExtentReportTest extends BaseTest{

    public static ExtentTest extentTest;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReport;

    @BeforeTest
    public void setUpReport(){
        htmlReporter = new ExtentHtmlReporter("./Reports/login.html");
        extentReport = new ExtentReports();
        extentReport.attachReporter(htmlReporter);
    }

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.fail(MarkupHelper.createLabel(result.getName() + " Test Case Failed", ExtentColor.RED));
            extentTest.fail(result.getThrowable());
        }

        if(result.getStatus() == ITestResult.SUCCESS){
            extentTest.pass(MarkupHelper.createLabel(result.getName() + " Test Case Passed", ExtentColor.GREEN));
        }

        else{
            extentTest.fail(MarkupHelper.createLabel(result.getName() + " Test Case Skipped", ExtentColor.BLUE));
            extentTest.skip(result.getThrowable());
        }
    }

    @AfterTest
    public void tearDownReport(){
        extentReport.flush();
    }
}
