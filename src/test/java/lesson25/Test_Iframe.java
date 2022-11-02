package lesson25;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_Iframe {
    private WebDriver driver;

    @BeforeTest
    public void setUpTest(){
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void runTest() throws InterruptedException {
        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);

        WebElement input = driver.findElement(By.id("tinymce"));
        input.sendKeys("Test on frame!");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
