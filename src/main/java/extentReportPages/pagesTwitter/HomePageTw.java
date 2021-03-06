package extentReportPages.pagesTwitter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageTw extends BasePageTw {

    By loginButton = By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/form/div/div[3]/div/div/span/span");

    public HomePageTw(WebDriver d) {
        super(d);
    }

    public void goTo(String URL){
        driver.get(URL);
    }

    public void loginTo() {
        click(loginButton);
    }
}
