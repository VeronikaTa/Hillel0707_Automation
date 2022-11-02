package lesson26.PageObjEx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageLogic {
    By searchInput = By.name("search");
    By findButton = By.xpath("//button[contains(@class, 'button_color_green')]");

    private WebDriver driver;
    private WebDriverWait wait;

   public MainPageLogic(WebDriver driver, WebDriverWait wait){
       this.driver = driver;
       this.wait = wait;
    }

    public MainPageLogic clickSearchInput(){
       driver.findElement(searchInput).click();
       return this;
    }

    public MainPageLogic sendKeysToSearch(String keys){
       driver.findElement(searchInput).sendKeys(keys);
       return  this;
    }

    public SearchPageLogic clickSearchButton(){
       driver.findElement(findButton).click();
       return new SearchPageLogic(driver, wait);
    }
}
