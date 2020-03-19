package extentReportsTest.testFlights;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTestFly {

    WebDriver driver;

    @BeforeSuite
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nicolas.Onufryjczuk\\Desktop\\Selenium\\SeleniumWeb\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown(){
        driver.close();
    }
}