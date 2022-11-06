package Homework.lesson27;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LaptopsAndComputersPageLogic {

    private String laptopsOptionLocator = "//*[contains(@href, 'c80004')]";

    public LaptopsPageLogic clickOnLaptopsOption(){
        $(byXpath(laptopsOptionLocator)).click();
        return page(LaptopsPageLogic.class);
    }
}
