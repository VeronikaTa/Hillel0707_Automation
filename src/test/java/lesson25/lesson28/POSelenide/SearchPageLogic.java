package lesson25.lesson28.POSelenide;

import com.codeborne.selenide.CollectionCondition;

public class SearchPageLogic extends SearchPageElement{
    public SearchPageLogic checkProductQuantity(int size){
        titles.shouldHave(CollectionCondition.size(size));
        return this;
    }
}
