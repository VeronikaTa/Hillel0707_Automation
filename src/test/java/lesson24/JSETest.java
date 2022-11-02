package lesson24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class JSETest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void testSetUP(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua");
    }

    @Test
    public void rozetkaTest() throws InterruptedException {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Mac");

        WebElement buttonSearch = driver.findElement(By.xpath("//button[contains(@class, 'button_color_green')]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",buttonSearch);

        TimeUnit.SECONDS.sleep(10);
    }


    @AfterMethod
    public void after(){
        driver.quit();
    }
}
