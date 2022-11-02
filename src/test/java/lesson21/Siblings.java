package lesson21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Siblings {
    private WebDriver driver;

    @BeforeTest
    public void testSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void run(){
        driver.get("https://rozetka.com.ua/");
        WebElement mobileUserMenu = driver.findElement(By.xpath("//a[@class='header__logo']/preceding-sibling::rz-mobile-user-menu"));
        WebElement mainUserMenu2 = driver.findElement(By.xpath("//rz-top-page-banner/preceding-sibling::section"));
        WebElement element = driver.findElement(By.xpath("//button[@class='header__button']/following-sibling::rz-drawer"));//failing
    }
}
