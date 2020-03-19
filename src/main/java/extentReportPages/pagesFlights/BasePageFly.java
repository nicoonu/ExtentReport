package extentReportPages.pagesFlights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageFly {

    WebDriver driver;

    public BasePageFly(WebDriver d) {
        this.driver = d;
    }

    public void click(By elementBy) {
        driver.findElement(elementBy).click();
    }

    public void writeText(WebElement element, String text) {
        element.sendKeys(text);
    }
}