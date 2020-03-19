package extentReportScreenshotTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestScreenshot extends ExtentReportScreenshot {

    @Test
    public void verifyTitle() throws IOException {
        extentTest = extentReports.createTest("verifyTitle");
        Assert.assertTrue(driver.getTitle().contains("YouTube"));
    }
}