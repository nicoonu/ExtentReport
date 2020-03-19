package extentReportsTest.testTwitter;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import extentReportPages.pagesTwitter.HomePageTw;
import extentReportPages.pagesTwitter.LoginPageTw;

public class LoginTwTest extends ExtentReportTest {

    @Test (priority = 0)
    public void verifyCorrectUser() throws Exception {
        extentTest = extentReport.createTest("verifyCorrectUser");

        HomePageTw homePage = new HomePageTw(driver);
        LoginPageTw loginPageTw = PageFactory.initElements(driver, LoginPageTw.class);
        homePage.goTo("https://twitter.com/");

        extentTest.log(Status.INFO, "Se ingresa a la pagina de inicio de sesion.");
        loginPageTw.clickSignIn();

        extentTest.log(Status.INFO, "Se ingresa usuario.");
        loginPageTw.setUser("nikoonu@gmail.com");

        Assert.assertEquals(loginPageTw.userName.getAttribute("value"), "nikoonu@gmail.com");
    }

    @Test (priority = 1)
    public void verifyIncorrectUser() {
        extentTest = extentReport.createTest("verifyIncorrectUser");

        HomePageTw homePage = new HomePageTw(driver);
        LoginPageTw loginPageTw = PageFactory.initElements(driver, LoginPageTw.class);
        homePage.goTo("https://twitter.com/");
        WebDriverWait wait = new WebDriverWait(driver,20);

        extentTest.log(Status.INFO, "Se ingresa a la pagina de inicio de sesion.");
        loginPageTw.clickSignIn();
        extentTest.log(Status.INFO, "Se ingresa usuario.");
        loginPageTw.setUser("nicolas@hotmail.com");

        Assert.assertEquals(loginPageTw.userName.getAttribute("value"), "nicolas@hotmail.com");
    }

    @Test (priority = 2)
    public void verifyIncorrectPassword(){
        extentTest = extentReport.createTest("verifyIncorrectPassword");

        HomePageTw homePage = new HomePageTw(driver);
        LoginPageTw loginPageTw = PageFactory.initElements(driver, LoginPageTw.class);
        homePage.goTo("https://twitter.com/");

        extentTest.log(Status.INFO, "Se ingresa a la pagina de inicio de sesion.");
        loginPageTw.clickSignIn();

        extentTest.log(Status.INFO, "Se ingresa contraseña.");
        loginPageTw.setPassword("12345");

        Assert.assertEquals(loginPageTw.password.getAttribute("value"), "12345");
    }

    @Test (priority = 3)
    public void verifyIncorrectLogin(){
        extentTest = extentReport.createTest("verifyIncorrectLogin");

        HomePageTw homePage = new HomePageTw(driver);
        LoginPageTw loginPageTw = PageFactory.initElements(driver, LoginPageTw.class);
        homePage.goTo("https://twitter.com/");

        extentTest.log(Status.INFO, "Se ingresa a la pagina de inicio de sesion.");
        loginPageTw.clickSignIn();

        extentTest.log(Status.INFO, "Se ingresa usuario.");
        loginPageTw.setUser("nico.onu@yahoo.com");

        extentTest.log(Status.INFO, "Se ingresa contraseña.");
        loginPageTw.setPassword("tsoft2020");

        homePage.loginTo();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://twitter.com/login/error"));
    }
}