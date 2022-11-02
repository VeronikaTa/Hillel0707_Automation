package Homework.lesson20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Locators {

    WebDriver driver;
    @BeforeTest
    public void setUpTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void run(){
        driver.get("https://rozetka.com.ua/");
        WebElement logoImageCss = driver.findElement(By.cssSelector("img[alt='Rozetka Logo']"));
        WebElement searchButtonCss = driver.findElement(By.cssSelector(".button_color_green"));
        WebElement AuthentButtonCss = driver.findElement(By.cssSelector("body > app-root > div > div > rz-header > rz-main-header > header > div > div > ul > li.header-actions__item.header-actions__item--user > rz-user > button"));

        WebElement logoImageXpath = driver.findElement(By.xpath("//img[@alt ='Rozetka Logo']"));
        WebElement searchButtonXPath = driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']"));
        WebElement popupAuthentButtonXpath = driver.findElement(By.xpath("//li[3]/rz-user/button"));
    }
}
