package lesson25;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class KeysSend {
    private WebDriver driver;


    @BeforeTest
    public void testSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
    }

    @Test
    public void testRun() throws InterruptedException{
        WebElement searchInput = driver.findElement(By.name("search"));

        searchInput.sendKeys(Keys.chord(Keys.SHIFT,"mac"));

        TimeUnit.SECONDS.sleep(3);
        searchInput.sendKeys(Keys.ENTER);
        TimeUnit.SECONDS.sleep(5);

    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
