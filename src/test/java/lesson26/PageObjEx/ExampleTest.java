package lesson26.PageObjEx;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExampleTest {
//    На главной странице в инпут ввести Мас;
//    Сохранить тайл первого товара в поисковой выдаче;
//    Перейти на продуктовую страницу первого товара;
//    Проверить, что тайл на поисковой выдаче соответствует тайлу на поисковой странице;

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void testSetUP(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua");
    }

    @Test
    public void testPageObjects(){
        new MainPageLogic(driver,wait).clickSearchInput()
                .sendKeysToSearch("Mac")
                .clickSearchButton();

        SearchPageLogic searchPageLogic = new SearchPageLogic(driver, wait);

        String expectedTitle = searchPageLogic.getFirstTitle();
        searchPageLogic.clickOnFirstProduct();

        String actualTitle = new ProductPageLogic(driver, wait).getTitleText();

        Assert.assertEquals(actualTitle,expectedTitle,"Titles don't match");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
