package extentReportsTest.testFlights;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import extentReportPages.pagesFlights.HomePageFly;
import extentReportPages.pagesFlights.PageFly;

public class CheckTestFly extends ExReportTest{

    @Test (priority = 0, description = "Verifico que el lugar de origen de mi vuelo sea efectivamente Berlin")
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

    @Test (priority = 1, description = "Verifico que mi lugar de destino de mi vuelo sea efectivamente Manhattan")
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

    @Test (priority = 2, description = "Verifico que luego de ingresar los datos de mi vuelo hayan sido los esperados" +
            "y sea redirigido a la pagina donde se encuentran los resultados de haber buscado.")
    public void verifyFlightFromEgyptToAustralia() throws InterruptedException {
        extentTest = extentReport.createTest("verifyDestinyPlaceIsManhattan");

        PageFly pageFly = PageFactory.initElements(driver, PageFly.class);
        HomePageFly homePageFly = new HomePageFly(driver);

        homePageFly.goTo("https://www.despegar.com.ar/");

        homePageFly.goToFlights();
        homePageFly.goToOneWay();

        pageFly.from.clear(); pageFly.writeFrom("El Cairo, Egipto");
        Thread.sleep(1000); pageFly.from.sendKeys(Keys.ENTER);
        pageFly.to.clear(); pageFly.writeDestiny("Sidney, Australia");
        Thread.sleep(1000); pageFly.to.sendKeys(Keys.ENTER);

        Assert.assertTrue(pageFly.from.getAttribute("value").contains("El Cairo"));
        Assert.assertTrue(pageFly.to.getAttribute("value").contains("Sídney"));

        pageFly.fechaClick.click();
        pageFly.enterDate(); homePageFly.searchFlights();

        Assert.assertTrue(driver.getCurrentUrl().contains(".despegar.com.ar/shop/flights"));
    }
}