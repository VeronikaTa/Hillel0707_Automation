package lesson25.lesson28.POSelenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class CategoryPageLogic extends CategoryPageElements{
    public SearchPageLogic chooseCategoryOption(SelenideElement category){
        category.click();
        return Selenide.page(SearchPageLogic.class);
    }
}
