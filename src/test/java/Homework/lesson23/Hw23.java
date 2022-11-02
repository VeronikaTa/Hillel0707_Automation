package Homework.lesson23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Hw23 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void testSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ ");
    }

    @Test
    public void run() throws InterruptedException {
        WebElement laptopsAndPCOption = driver.findElement(By.xpath("//ul[contains(@class,'menu-categories_type_main')]/li[1]/a"));
        laptopsAndPCOption.click();

        WebElement laptopsOption = driver.findElement(By.xpath("//div[@class='tile-cats']/a[1]"));
        laptopsOption.click();

        WebElement firstItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul/li[1]//div[@class='g-id display-none']")));
        String firstItemId = firstItem.getAttribute("innerText");

        WebElement buyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-buy-button[@goods_id='"+firstItemId+"']/button")));
        buyButton.click();

        WebElement basketCounter = wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class,'counter--green')]"))));
        String counter = basketCounter.getAttribute("innerText");
        assertEquals(counter,"1","Wrong counter");

        Thread.sleep(5000);
        WebElement firstItemTitle = driver.findElement(By.xpath("//div[@data-goods-id='"+firstItemId+"']/descendant::a[@class='goods-tile__heading ng-star-inserted']"));
        String titleExpected = firstItemTitle.getAttribute("innerText").trim();

        wait.until(ExpectedConditions.elementToBeClickable(buyButton)).click();
        WebElement titleInCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='cart-product__title']")));
        String titleActual = titleInCart.getAttribute("innerText").trim();

        assertEquals(titleActual,titleExpected,"Title in cart and first product title don't match");
    }

    @AfterTest
    public void afterRun(){
        driver.quit();
    }
}
