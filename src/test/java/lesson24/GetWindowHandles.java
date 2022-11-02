package lesson24;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class GetWindowHandles {
private WebDriver driver;
private WebDriverWait wait;


@BeforeTest
    public void testSetup(){
    ChromeDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get("https://rozetka.com.ua/");
}

@Test
public void run() throws InterruptedException{
    WebElement loginButton = driver.findElement(By.xpath("//ul[@class='header-actions']/li[3]/rz-user/button"));
    loginButton.click();

    WebElement registerButton = driver.findElement(By.xpath("//button[contains(@class,'__register-link')]"));
    registerButton.click();

    WebElement privatePolicyButton = driver.findElement(By.xpath("//p[@class='form__caption']/a[1]"));
    privatePolicyButton.click();

    String mainTab = driver.getWindowHandle();
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    String tb2 = tabs.get(1);

    driver.switchTo().window(tb2);
    driver.switchTo().window(mainTab);
}

@AfterTest
    public void afterTest(){
    driver.quit();
    }
}
