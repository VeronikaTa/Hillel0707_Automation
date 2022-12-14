package Lesson22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class TestTitleOnProductPage {
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
    public void rozetkaTest(){
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Mac");

        WebElement buttonSearch = driver.findElement(By.xpath("//button[contains(@class, 'button_color_green')]"));
        buttonSearch.click();

        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='goods-tile__title']")));

        String titleOfFirstProduct = firstProduct.getText().trim();
        firstProduct.click();

        WebElement productTitle = driver.findElement(By.xpath("//h1[@class='product__title']"));
        String productPageTitleText = productTitle.getAttribute("innerText").trim();

        assertEquals(titleOfFirstProduct,productPageTitleText, "Titles don't match");
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
