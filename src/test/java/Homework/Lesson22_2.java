package Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class  Lesson22_2 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void testSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://rozetka.com.ua");
    }

    @Test
    public void runIt() {
        WebElement laptopsAndPCOption = driver.findElement(By.xpath("//rz-sidebar-fat-menu/descendant::a[1]"));
        laptopsAndPCOption.click();

        WebElement laptopsOption = driver.findElement(By.xpath("//ul[contains(@class,'portal-grid_type_1_6')]/child::li[1]"));
        laptopsOption.click();

        WebElement sellerRozetkaOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-id='Rozetka']")));
        sellerRozetkaOption.click();

        WebElement priceInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='max']")));
        Actions action = new Actions(driver);
        action.moveToElement(priceInput).click().perform();
       priceInput.clear();
       wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='max']"))));
       priceInput.sendKeys("100000");

        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'slider-filter__button')]")));
        okButton.click();

        WebElement goodsPromoted = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'promo-label_type_popularity')]/following-sibling::a[contains(@class,'goods-tile')]")));
        action.moveToElement(goodsPromoted).click().perform();

        WebElement popularityLabel = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class,'promo-label_type_popularity')]")));

        if(popularityLabel.isDisplayed()){
            System.out.println("Popularity label is present");
        }
        else{
            System.out.println("Popularity label is absent");
        }
    }

    @AfterTest
    public void after(){
        driver.quit();
   }
}
