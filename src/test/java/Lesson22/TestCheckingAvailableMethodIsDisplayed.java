package Lesson22;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;


public class TestCheckingAvailableMethodIsDisplayed {
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

        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class = 'goods-tile__title']")));
        firstProduct.click();

        WebElement productTitle = driver.findElement(By.xpath("//h1[@class='product__title']"));
        WebElement productPrice = driver.findElement(By.xpath("//p[@class='product-prices__big']"));

        String productTitleText = productTitle.getAttribute("innerText");
        String productPriceText =productPrice.getText();

        WebElement productAvailability = driver.findElement(By.cssSelector("p.status-label--green"));
        String availabilityOfProductColor = productAvailability.getCssValue("color");


        if(productAvailability.isDisplayed() && availabilityOfProductColor.equals("rgba(0, 160, 70, 1)")){
            try {
               FileWriter writer = new FileWriter("test");
                writer.write(productTitleText + " " + productPriceText);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
