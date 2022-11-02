package lesson25;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_select2 {
    private WebDriver driver;

    @BeforeTest
    public void setUpTest(){
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.autodoc.de/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void runTest() throws InterruptedException {
        WebElement makerlist  = driver.findElement(By.id("form_maker_id"));
        WebElement makerListOption = driver.findElement(By.xpath("//select[@id='form_maker_id']/optgroup[2]/option[@value='2']"));

        makerlist.click();
        makerListOption.click();

        TimeUnit.SECONDS.sleep(5);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
