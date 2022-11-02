package lesson19;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestRun {
    private WebDriver driver;

    @BeforeClass()
    public void setUp(){
      WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void setUpTest(){
        driver = new ChromeDriver();
    }

    @Test()
    public void firstRun(){
        driver.get("https://google.com/");
    }
}
