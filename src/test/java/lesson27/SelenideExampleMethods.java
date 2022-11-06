package lesson27;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideExampleMethods {
    @BeforeTest
    public void before(){
        Configuration.browserSize = "1920x10800";
        Configuration.browserPosition = "1x1";
        //Configuration.timeout = 6000; --default 4000ms
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void runTest(){
        SelenideElement findButton = $(byXpath("//button[contains(@class, 'button_color_green')]"));
        String textFromFindButton = findButton.text();
        System.out.println(textFromFindButton);

        String formActionAttributeFromFindButton = findButton.attr("formAction");
        System.out.println(formActionAttributeFromFindButton);

        String backgroundColorFromFindButton = findButton.getCssValue("backgroundColor");
        System.out.println(backgroundColorFromFindButton);

    }
}
