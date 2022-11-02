package lesson21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StartsWith {
    private WebDriver driver;

    @BeforeTest
    public void testSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void run(){
        driver.get("https://rozetka.com.ua/");
        WebElement wishButton = driver.findElement(By.xpath("//a[@class='menu-categories__link' and starts-with(text(),'Ноутбуки та')]"));

    }
}
