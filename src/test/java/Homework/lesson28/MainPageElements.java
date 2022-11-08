package Homework.lesson28;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class MainPageElements {
    ElementsCollection sidebarOptions = $$(byXpath("//ul[@class='menu-categories menu-categories_type_main']/li"));
}
