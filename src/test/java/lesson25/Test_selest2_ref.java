package lesson25;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_selest2_ref {
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

        makerlist.click();

        selectOption("5");

        TimeUnit.SECONDS.sleep(5);
    }

    public void selectOption(String option){
        String makerListOption = String.format("//select[@id='form_maker_id']/optgroup[2]/option[@value='%s']",option);

        driver.findElement(By.xpath(makerListOption));
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
