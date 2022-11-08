package lesson25.lesson28.POSelenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic extends MainPageElement{
    public MainPageLogic checkCategoryQuantity(int size){
        sidebarMenu.shouldHave(CollectionCondition.size(size));
        return this;
    }

public CategoryPageLogic chooseCategoryOption(SelenideElement category){
        category.click();
        return Selenide.page(CategoryPageLogic.class);
}
}
