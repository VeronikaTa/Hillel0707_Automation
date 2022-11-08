package Homework.lesson28;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class CartPopupLogic {
    ElementsCollection titleOfProductsInCart = $$(byXpath("//a[@class='cart-product__title']"));

    public String getTitleOfProductInCart(int index){
        String productTitle = titleOfProductsInCart.get(index).attr("innerText").trim();
        if(productTitle.isBlank()){
            throw new IllegalArgumentException("Expected product title is blank");
        }
        return productTitle;
    }
}
