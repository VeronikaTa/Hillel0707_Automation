package lesson24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class JSE_Scroll {
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
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scroll(0, 1000);");

        TimeUnit.SECONDS.sleep(10);
    }


    @AfterMethod
    public void after(){
        driver.quit();
    }
}
