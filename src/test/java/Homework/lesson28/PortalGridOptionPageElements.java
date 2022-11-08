package Homework.lesson28;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PortalGridOptionPageElements {
    ElementsCollection buyButtons = $$(byXpath("//button[contains(@class,'buy-button')]"));
    ElementsCollection productTitles = $$(byXpath("//span[@class='goods-tile__title']"));
    SelenideElement cartIterator = $(byXpath("//span[contains(@class,'counter')]"));
    SelenideElement cartButton = $(byXpath("//rz-cart/button"));
}
