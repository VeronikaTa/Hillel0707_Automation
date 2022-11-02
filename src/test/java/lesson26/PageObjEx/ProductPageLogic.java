package lesson26.PageObjEx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPageLogic {

    By productTitle = By.xpath("//h1[@class='product__title']");

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPageLogic(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public String getTitleText(){
       return driver.findElement(productTitle).getAttribute("innerText").trim();
    }
}
