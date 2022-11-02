package lesson21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice {
    private WebDriver driver;

    @BeforeTest
    public void testSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void run(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rozetka.com.ua");

        WebElement searchInput = driver.findElement(By.xpath("//input[@name='search']"));
        searchInput.sendKeys("Mac");
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(), 'Знайти')]"));
        searchButton.click();

        WebElement firstProduct = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='goods-tile__colors']/following-sibling::a")));
        String firstProductTitle = firstProduct.getText();

//        if(firstProductTitle.contains("Mac")){
//            System.out.println("Title contains searching data");
//        }
//        else{
//            System.out.println("Title doesn't contain searching data");
//        }

        if(!firstProductTitle.contains("Mac")){
            Assert.fail("Title doesn't contain searching data");
        }
        else{
            System.out.println("Title contains searching data");
        }

        String titleFirstItemExpected = "Комп'ютер Apple Mac Studio M1 Ultra/48 ядер GPU/64GB/1TB";
        Assert.assertEquals(titleFirstItemExpected, firstProductTitle, "Title doesn't equal searching data");
    }

    @AfterMethod
    public void end(){
        driver.quit();
    }
}
