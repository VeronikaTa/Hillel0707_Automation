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

public class Test_select {
    private WebDriver driver;

    @BeforeTest
    public void setUpTest(){
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
    }

    @Test
    public void runTest() throws InterruptedException {
        WebElement element = driver.findElement(By.id("dropdown"));

        Select dropdown = new Select(element);
        dropdown.selectByValue("1");

        Thread.sleep(2000);

        dropdown.selectByValue("2");

        Thread.sleep(2000);
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
