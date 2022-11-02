package Homework.lesson25;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import java.util.List;

public class lesson25 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void testSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void salesCheck() throws InterruptedException{
        waitForPageLoad(By.xpath("//rz-cart/button"));

        tilesCountAssert(Locators.SALESTILES.locator,5);

        String expectedPrice = getPrice(Locators.FIRSTPRICE.locator);

        driver.findElement(Locators.FIRSTTILE.locator).click();

        waitForPageLoad(By.xpath("//img[@_ngcontent-rz-client-c286]"));

        String actualPrice = getPrice(Locators.PRICEONPAGE.locator);

        Assert.assertEquals(actualPrice,expectedPrice,"prices on the page doesn't match the product price");

        driver.findElement(Locators.LOGO.locator).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://rozetka.com.ua/", "URLs don't match");

        waitForPageLoad(By.xpath("//rz-cart/button"));
        scroll();
        Thread.sleep(1000);
        tilesCountAssert(Locators.SALESTILESREVISITED.locator, 5);
    }

    public void waitForPageLoad(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void tilesCountAssert(By tiles, int expectedNumber){
        List<WebElement> productTiles = driver.findElements(tiles);
        Assert.assertEquals(productTiles.size(),expectedNumber);
    }

    public String getPrice(By element){
        String price = driver.findElement(element).getAttribute("innerText").replace("\u20b4"," ").trim();
        if(price.isBlank() || price.isEmpty()){
           throw new IllegalArgumentException("Price is empty");
        }
        return price;
    }

    public void scroll(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scroll(0, 2000);");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
