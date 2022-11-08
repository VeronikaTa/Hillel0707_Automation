package Homework.lesson28;

import static com.codeborne.selenide.Selenide.page;

public class SidebarMenuCategoryPageLogic extends SidebarMenuCategoryPageElements{
    public ProductsPageLogic clickOnOption(int index){
        portalGridOption.get(index).click();
        return page(ProductsPageLogic.class);
    }
}