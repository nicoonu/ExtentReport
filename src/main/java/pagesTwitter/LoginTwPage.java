package pagesTwitter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginTwPage extends BasePage{

    public LoginTwPage(WebDriver d) {
        super(d);
    }

    @FindBy (name = "session[username_or_email]") public WebElement userName;

    @FindBy (name = "session[password]") public WebElement password;

    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div/main/div/div/div/div[1]/div/a[2]") WebElement signInButton;

    public void setUser(String uN){
        writeText(userName, uN);
    }

    public void setPassword(String pW){
        writeText(password, pW);
    }

    public void clickSignIn(){
        signInButton.click();
    }
}