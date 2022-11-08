package lesson25.lesson28;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.source;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SeleniumExample {
    @BeforeTest
    public void before(){
        Configuration.browserSize = "1920x10800";
        Configuration.browserPosition = "1x1";
        open("https://rozetka.com.ua/ua/");
    }
    @Test
    public void example(){
        String currentUrl = url();

        String source = source();
        System.out.println(currentUrl);
        System.out.println(source);
    }
}
