package Homework.lesson28;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class SidebarMenuCategoryPageElements {
    ElementsCollection portalGridOption = $$(byXpath("//a[contains(@class,'tile-cats__heading tile-cats_')]"));
}
