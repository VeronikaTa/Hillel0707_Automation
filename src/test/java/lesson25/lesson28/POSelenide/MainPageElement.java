package lesson25.lesson28.POSelenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPageElement {
    ElementsCollection sidebarMenu = $$(byXpath("//ul[@class='menu-categories menu-categories_type_main']/li"));
    SelenideElement laptopsAndComputers = $(byXpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]/a"));

}
