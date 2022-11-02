package Homework.lesson26.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaptopsAndComputersPageLogic {

    By laptopsOption = By.xpath("//*[contains(@href, 'c80004')]");
    private WebDriver driver;
    private WebDriverWait wait;

    public LaptopsAndComputersPageLogic(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public LaptopsPageLogic clickOnLaptopsOption(){
        driver.findElement(laptopsOption).click();
        return new LaptopsPageLogic(driver, wait);
    }
}
