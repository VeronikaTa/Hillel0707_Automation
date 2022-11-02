package lesson23;

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
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Test_findElements {
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

        List<WebElement> goodsTitles = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));

        int countOfGoods = goodsTitles.size();
        assertEquals(countOfGoods,60);
        }


    @AfterTest
    public void after(){
        driver.quit();
    }
}
