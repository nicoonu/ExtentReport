package pagesOle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageFly extends BasePageFly {

    public HomePageFly(WebDriver d) {
        super(d);
    }

    By buttonOneWay = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[1]/div[3]/div[2]/div/span[2]/label/i");
    By buttonFlights = By.xpath("/html/body/nav/div[2]/div[1]/div[3]/ul/li[2]/a/div/i");
    By searchButton = By.linkText("Buscar");

    public void goTo(String URL){
        driver.get(URL);
    }

    public void goToOneWay(){
        click(buttonOneWay);
    }

    public void goToFlights(){
        click(buttonFlights);
    }

    public void searchFlights(){ click(searchButton);}
}