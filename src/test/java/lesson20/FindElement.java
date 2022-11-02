package lesson20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElement {
    private WebDriver driver;

    @BeforeTest
    public void setUpTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void run(){
        driver.get("https://www.google.com/");
        WebElement acceptAllButtonSearch =  driver.findElement(By.id("L2AGLb"));
        WebElement shareButtonsearch =  driver.findElement(By.className("kmjBcc"));

       acceptAllButtonSearch.click();
       shareButtonsearch.click();
    }
}
