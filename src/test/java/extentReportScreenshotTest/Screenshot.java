package extentReportScreenshotTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static String getScreenshot(WebDriver driver, String name){
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "./Screenshot/" + name + ".png";
        File destination = new File(path);

        try {
            FileUtils.copyFile(src, destination);

        } catch (IOException e) {
            System.out.println("Capture failed " +  e.getMessage());
        }
        return path;
    }
}