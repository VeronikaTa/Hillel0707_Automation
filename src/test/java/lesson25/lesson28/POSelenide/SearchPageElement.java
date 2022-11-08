package lesson25.lesson28.POSelenide;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPageElement {
    ElementsCollection titles = $$(byXpath("//span[@class='goods-tile__title']"));
}
