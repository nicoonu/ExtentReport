package testOle;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesFlights.HomePageFly;
import pagesFlights.PageFly;

public class CheckTestFly extends ExReportTest{

    @Test (priority = 0)
    public void verifyStartingPlaceIsBerlin() throws InterruptedException {

        extentTest = extentReport.createTest("verifyStartingPlaceIsBerlin");

        PageFly pageFly = PageFactory.initElements(driver, PageFly.class);
        HomePageFly homePageFly = new HomePageFly(driver);

        homePageFly.goTo("https://www.despegar.com.ar/");

        homePageFly.goToFlights();
        homePageFly.goToOneWay();

        pageFly.from.clear(); pageFly.writeFrom("Berlin, Alemania");
        Thread.sleep(1000); pageFly.from.sendKeys(Keys.ENTER);

        Assert.assertTrue(pageFly.from.getAttribute("value").contains("Berlín"));
    }

    @Test (priority = 1)
    public void verifyDestinyPlaceIsManhattan() throws InterruptedException {

        extentTest = extentReport.createTest("verifyDestinyPlaceIsManhattan");

        PageFly pageFly = PageFactory.initElements(driver, PageFly.class);
        HomePageFly homePageFly = new HomePageFly(driver);

        homePageFly.goTo("https://www.despegar.com.ar/");

        homePageFly.goToFlights();
        homePageFly.goToOneWay();

        pageFly.to.clear(); pageFly.writeDestiny("Manhattan, Estados Unidos");
        Thread.sleep(1000); pageFly.to.sendKeys(Keys.ENTER);

        Assert.assertTrue(pageFly.to.getAttribute("value").contains("Manhattan"));
    }

    @Test
    public void verifyFlightFromEgyptToAustralia() throws InterruptedException {
        extentTest = extentReport.createTest("verifyDestinyPlaceIsManhattan");

        PageFly pageFly = PageFactory.initElements(driver, PageFly.class);
        HomePageFly homePageFly = new HomePageFly(driver);

        homePageFly.goTo("https://www.despegar.com.ar/");

        homePageFly.goToFlights();
        homePageFly.goToOneWay();

        pageFly.from.clear(); pageFly.writeFrom("El Cairo, Egipto");
        Thread.sleep(1000); pageFly.from.sendKeys(Keys.ENTER);
        pageFly.to.clear(); pageFly.writeDestiny("Sydney, Australia");
        Thread.sleep(1000); pageFly.to.sendKeys(Keys.ENTER);

        pageFly.fechaClick.click();
        pageFly.enterDate(); homePageFly.searchFlights();

        Assert.assertTrue(driver.getCurrentUrl().contains(".despegar.com.ar/shop/flights"));
    }
}