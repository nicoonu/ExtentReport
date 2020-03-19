package extentReportPages.pagesFlights;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageFly extends BasePageFly {

    public HomePageFly(WebDriver d) {
        super(d);
    }

    /* By de los botones para buscar en la pagina. */
    By buttonOneWay = By.xpath("//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[1]/div[3]/div[2]/div/span[2]/label/i");
    By buttonFlights = By.xpath("/html/body/nav/div[2]/div[1]/div[3]/ul/li[2]/a/div/i");
    By searchButton = By.linkText("Buscar");

    /* Me lleva a la pagina principal */
    public void goTo(String URL){
        driver.get(URL);
    }

    /* Me lleva a la pagina de "Solo ida" */
    public void goToOneWay(){
        click(buttonOneWay);
    }

    /* Me lleva a la seccion de "Vuelos" */
    public void goToFlights(){
        click(buttonFlights);
    }

    /* Hace click en buscarVuelos para redigirme a la pagina donde estan los resultados
       de vuelos buscados */
    public void searchFlights(){ click(searchButton);}
}