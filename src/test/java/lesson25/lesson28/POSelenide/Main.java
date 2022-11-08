package lesson25.lesson28.POSelenide;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Main {

    MainPageLogic mainPageLogic = new MainPageLogic();
    CategoryPageLogic categoryPageLogic = new CategoryPageLogic();

    @BeforeTest
    public void before(){
        Configuration.browserSize = "1920x10800";
        Configuration.browserPosition = "1x1";
        open("https://rozetka.com.ua/ua/");
    }
    @Test
    public void checkProductTitleQuantity(){
        new MainPageLogic()
                .checkCategoryQuantity(17)
                .chooseCategoryOption(mainPageLogic.laptopsAndComputers)
                .chooseCategoryOption(categoryPageLogic.laptopsOption)
                .checkProductQuantity(60);
    }
}
