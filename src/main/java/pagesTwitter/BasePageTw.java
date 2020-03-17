package pagesTwitter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePageTw {

    WebDriver driver;

    public BasePageTw(WebDriver d) {
        this.driver = d;
    }

    /* Metodo click */
    public void click(By elementBy) {
        driver.findElement(elementBy).submit();
    }

    /* Metodo escribir texto */
    public void writeText(WebElement element, String text) {
        element.sendKeys(text);
    }
}
