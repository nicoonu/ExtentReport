package pagesOle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFly extends BasePageFly{

    @FindBy (xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[2]/div[1]/div[1]/div/div/div/input")
    public WebElement from;

    @FindBy (xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[2]/div[1]/div[2]/div/div/div/div/input")
    public WebElement to;

    @FindBy (xpath = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div/div[3]/div[2]/div[2]/div[2]/div[1]/div[2]/input")
    public WebElement fechaClick;

    @FindBy (xpath = "/html/body/div[4]/div/div[5]/div[1]/div[4]/span[18]/span[1]")
    public WebElement departure;;

    public PageFly(WebDriver d) {
        super(d);
    }

    public void writeFrom(String f){
        writeText(from, f);
    }

    public void writeDestiny(String d){
        writeText(to, d);
    }

    public void enterDate(){
        departure.click();
    }
}