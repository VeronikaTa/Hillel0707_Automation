package lesson25.lesson28;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideCollectionExample {
    @BeforeTest
    public void before(){
        Configuration.browserSize = "1920x10800";
        Configuration.browserPosition = "1x1";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void example(){
        ElementsCollection sidebarMenu = $$(byXpath("//ul[@class='menu-categories menu-categories_type_main']/li"));
        sidebarMenu.shouldHave(CollectionCondition.size(16));
        sidebarMenu.shouldHave(CollectionCondition.sizeNotEqual(17));

        String text = sidebarMenu.get(1).getText();
        System.out.println(text);

        ElementsCollection sidebarWithFilter = sidebarMenu.filterBy(Condition.text(text));
        sidebarWithFilter.shouldHave(CollectionCondition.size(1));
    }
}
