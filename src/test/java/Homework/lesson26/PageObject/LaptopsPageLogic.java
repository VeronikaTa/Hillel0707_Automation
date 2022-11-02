package Homework.lesson26.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LaptopsPageLogic {

    By titlesOnPage = By.xpath("//span[@class='goods-tile__title']");
    By pricesOnPage = By.xpath("//span[@class='goods-tile__price-value']");

    private WebDriver driver;
    private WebDriverWait wait;

    public LaptopsPageLogic(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public List<WebElement> getTitles(){
        return driver.findElements(titlesOnPage);
    }

    public List<WebElement> getPrices(){
        return driver.findElements(pricesOnPage);
    }
}