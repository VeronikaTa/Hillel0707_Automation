package lesson24.lesson27;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CartPopupLogic {

    String titleOfFirstProductInCartLocator = "//a[contains(@class,'cart-product__title')]";

    public String getTitleOfProductInCart(){
        return $(byXpath(titleOfFirstProductInCartLocator)).innerText().trim();
    }
}
