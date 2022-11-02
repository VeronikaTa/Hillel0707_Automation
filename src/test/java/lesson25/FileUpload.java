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

public class FileUpload {
    private WebDriver driver;

    @BeforeTest
    public void setUpTest(){
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void runTest() throws InterruptedException {
        WebElement uploadElement = driver.findElement(By.id("file-upload"));
        uploadElement.sendKeys("C:\\Users\\38099\\OneDrive\\Documents\\english starters\\Get_Ready_for_Starters_2ed_SB_www.frenglish.ru\\Get_Ready_for_Starters_2ed_SB_www.frenglish.ru.pdf");

        WebElement send = driver.findElement(By.id("file-submit"));
        TimeUnit.SECONDS.sleep(5);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
