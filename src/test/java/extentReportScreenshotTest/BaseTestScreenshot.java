package extentReportScreenshotTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTestScreenshot {

    public static ExtentReports extentReports;
    public static ExtentHtmlReporter extentHtmlReporter;
    public static ExtentTest extentTest;
    public static WebDriver driver;

    @BeforeSuite
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nicolas.Onufryjczuk\\Desktop\\Selenium\\SeleniumWeb\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver(); driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com/");
        Thread.sleep(2000);
    }

    @AfterSuite
    public void closeBrowser(){
        driver.close();
    }
}