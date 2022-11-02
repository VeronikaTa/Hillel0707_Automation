package lesson24;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class Alert {
    private WebDriver driver;

    private WebDriverWait wait;

    @BeforeTest
    public void testSetUp(){
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.google.com.ua/");
    }

    @Test
    public void run() throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("alert('Are you sure?');");

        driver.switchTo().alert().accept();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
