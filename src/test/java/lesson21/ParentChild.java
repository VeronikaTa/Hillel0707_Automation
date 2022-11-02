package lesson21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParentChild {
    private WebDriver driver;

    @BeforeTest
    public void testSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void run(){
        driver.get("https://rozetka.com.ua/");
        WebElement headerActionItem = driver.findElement(By.xpath("//a[starts-with(@class, 'help-zsu')]/parent::li"));
        WebElement greenButton = driver.findElement(By.xpath("//nav[@class='main-categories']/child::button"));
    }
}
