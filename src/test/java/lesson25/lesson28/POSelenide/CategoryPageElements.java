package lesson25.lesson28.POSelenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CategoryPageElements {
SelenideElement laptopsOption  = $(byXpath("//*[contains(@href, 'c80004')]"));
}
