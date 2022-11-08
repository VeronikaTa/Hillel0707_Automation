package Homework.lesson28;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic extends MainPageElements{

    public SidebarMenuCategoryPageLogic clickOnOption(int index){
        sidebarOptions.get(index).click();
        return page(SidebarMenuCategoryPageLogic.class);
    }
}
