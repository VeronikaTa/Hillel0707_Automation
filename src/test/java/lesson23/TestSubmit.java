package lesson23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSubmit {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void testSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://google.com.ua");
    }

    @Test
    public void submitText(){
        WebElement inputSearch = driver.findElement(By.name("q"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(inputSearch));
        inputSearch.sendKeys("QA");

        WebElement btnSearch = driver.findElement(By.name("btnK"));

        if(btnSearch.getAttribute("value").equals("Cerca con Google")){
            btnSearch.submit();
        }
        else{
            Assert.fail();
        }
    }
}
