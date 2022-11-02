package Homework.lesson26.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageLogic {

    By laptopsAndComputersOption = By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]/a");
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPageLogic(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public LaptopsAndComputersPageLogic clickOnLaptopsAndComputersOption(){
        driver.findElement(laptopsAndComputersOption).click();
        return new LaptopsAndComputersPageLogic(driver, wait);
    }
}
