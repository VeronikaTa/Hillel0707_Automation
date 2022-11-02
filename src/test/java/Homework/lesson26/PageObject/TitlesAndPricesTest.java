package Homework.lesson26.PageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class TitlesAndPricesTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void testSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void runTest(){
        new MainPageLogic(driver,wait).clickOnLaptopsAndComputersOption().clickOnLaptopsOption();

        LaptopsPageLogic laptopsPageLogic = new LaptopsPageLogic(driver,wait);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//rz-cart/button")));

        List<WebElement> titles = laptopsPageLogic.getTitles();
        Assert.assertEquals(titles.size(), 60, "Number of titles on page doesn't equal to 60");

        List<WebElement> prices = laptopsPageLogic.getPrices();

        HashMap<String,String> titlesAndPrices = WorkWithHashMap.makeAHashMap(titles,prices);

        WorkWithHashMap.writeToFile(titlesAndPrices);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
