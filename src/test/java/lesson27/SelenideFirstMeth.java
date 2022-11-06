package lesson27;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideFirstMeth {
    @BeforeTest
    public void before(){
        Configuration.browserSize = "1920x10800";
        Configuration.browserPosition = "1x1";
        //Configuration.timeout = 6000; --default 4000ms
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void firstTest(){
        $(By.name("search"))
                .setValue("Mac");

        $(By.xpath("//button[contains(@class, 'button_color_green')]"))
                .shouldBe(visible)
                .shouldHave(text("Знайти"), Duration.ofSeconds(7))
                .shouldNotHave(text("Alex"))
                .click();
    }

}