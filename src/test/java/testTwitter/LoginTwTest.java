package testTwitter;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesTwitter.HomePage;
import pagesTwitter.LoginTwPage;

public class LoginTwTest extends ExtentReportTest {

    @Test (priority = 0)
    public void verifyCorrectUser() throws Exception {

        extentTest = extentReport.createTest("verifyCorrectUser");

        HomePage homePage = new HomePage(driver);
        LoginTwPage loginTwPage = PageFactory.initElements(driver, LoginTwPage.class);
        homePage.goTo("https://twitter.com/");

        extentTest.log(Status.INFO, "Se ingresa a la pagina de inicio de sesion.");
        loginTwPage.clickSignIn();

        extentTest.log(Status.INFO, "Se ingresa usuario correcto.");
        loginTwPage.setUser("nikoonu@gmail.com");

        Assert.assertEquals(loginTwPage.userName.getAttribute("value"), "nikoonu@gmail.com");
    }

    @Test (priority = 1)
    public void verifyIncorrectUser() {

        extentTest = extentReport.createTest("verifyIncorrectUser");

        HomePage homePage = new HomePage(driver);
        LoginTwPage loginTwPage = PageFactory.initElements(driver, LoginTwPage.class);
        homePage.goTo("https://twitter.com/");

        extentTest.log(Status.INFO, "Se ingresa a la pagina de inicio de sesion.");
        loginTwPage.clickSignIn();
        extentTest.log(Status.INFO, "Se ingresa usuario incorrecto.");
        loginTwPage.setUser("nicolas@hotmail.com");

        Assert.assertEquals(loginTwPage.userName.getAttribute("value"), "nicolas@hotmail.com");
    }

    @Test (priority = 2)
    public void verifyIncorrectPassword(){
        extentTest = extentReport.createTest("verifyIncorrectPassword");

        HomePage homePage = new HomePage(driver);
        LoginTwPage loginTwPage = PageFactory.initElements(driver, LoginTwPage.class);
        homePage.goTo("https://twitter.com/");

        extentTest.log(Status.INFO, "Se ingresa a la pagina de inicio de sesion.");
        loginTwPage.clickSignIn();

        extentTest.log(Status.INFO, "Se ingresa contraseña incorrecta");
        loginTwPage.setPassword("12345");

        Assert.assertEquals(loginTwPage.password.getAttribute("value"), "12345");
    }

    @Test (priority = 3)
    public void verifyIncorrectLogin(){
        extentTest = extentReport.createTest("verifyIncorrectLogin");

        HomePage homePage = new HomePage(driver);
        LoginTwPage loginTwPage = PageFactory.initElements(driver, LoginTwPage.class);
        homePage.goTo("https://twitter.com/");

        extentTest.log(Status.INFO, "Se ingresa a la pagina de inicio de sesion.");
        loginTwPage.clickSignIn();

        extentTest.log(Status.INFO, "Se ingresa usuario incorrecta.");
        loginTwPage.setUser("_nico.onu@yahoo.com");

        extentTest.log(Status.INFO, "Se ingresa contraseña incorrecta");
        loginTwPage.setPassword("tsoft2020");

        homePage.loginTo();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://twitter.com/login/error"));
    }

}