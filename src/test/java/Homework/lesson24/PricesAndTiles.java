package Homework.lesson24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PricesAndTiles {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void testSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void runTest(){
        WebElement laptopsAndComp = driver.findElement(By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]/a"));
        laptopsAndComp.click();

        WebElement laptops = driver.findElement(By.xpath("//*[contains(@href, 'c80004')]"));
        laptops.click();

        By title = By.xpath("//span[@class='goods-tile__title']");
        By price = By.xpath("//span[@class='goods-tile__price-value']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//rz-cart/button")));

        List<WebElement> titles =  driver.findElements(title);
        List<WebElement> prices = driver.findElements(price);

        HashMap<String, String> titlesAndPrices = makeMap(titles,prices);

        writeToFile(titlesAndPrices);
    }

    private  HashMap<String,String> makeMap(List<WebElement> titles, List<WebElement> prices) {
        if(titles.size() != prices.size()){
            throw new IllegalArgumentException();
        }
        int length = titles.size();
        HashMap<String, String> titlesAndPrices = new HashMap<>();
        for(int i = 0; i < length; i++){
            titlesAndPrices.put(titles.get(i).getAttribute("innerText").replace("\u00A0"," ").trim(),prices.get(i).getAttribute("innerHTML").replace("&nbsp;"," ").trim());
        }
        return titlesAndPrices;
    }

    private void writeToFile(HashMap<String,String> titlesAndPrices){
        try {
            FileWriter writer = new FileWriter("titlesAndPrices.txt");
            int i = 1;
            for(Map.Entry<String,String> entry : titlesAndPrices.entrySet()){
                writer.write(i+".");
                writer.write(entry.getKey()+"-" + entry.getValue());
                writer.write("\n");
                i++;
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
