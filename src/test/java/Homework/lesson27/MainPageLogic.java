package Homework.lesson27;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic {
    private String laptopsAndComputersLocator = "//ul[@class='menu-categories menu-categories_type_main']/li[1]/a";

    public LaptopsAndComputersPageLogic clickOnLaptopsAndComputersOption(){
        $(byXpath(laptopsAndComputersLocator)).click();
        return page(LaptopsAndComputersPageLogic.class);
    }
}