package Homework.lesson28;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class SidebarMenuCategoryPageLogic extends SidebarMenuCategoryPageElements{
    public PortalGridOptionPageLogic clickOnOption(int index){
        portalGridOption.get(index).click();
        return page(PortalGridOptionPageLogic.class);
    }
}