package lesson21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Contains {
    private WebDriver driver;
    @BeforeTest
    public void setUpTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void run(){
        driver.get("https://rozetka.com.ua/");
        WebElement headBar = driver.findElement(By.xpath("//div[contains(@class, 'header-layout')]"));
    }
}
