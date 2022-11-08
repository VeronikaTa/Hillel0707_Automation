package lesson24.lesson27;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LaptopsPageLogic {

    private String firstProductCartButtonLocator = "//ul[contains(@class,'catalog-grid')]/li[1]//button[contains(@class,'buy-button')]";
    private String firstProductTitle = "//ul[contains(@class,'catalog-grid')]/li[1]//span[contains(@class,'title')]";
    private String cartIteratorLocator = "//rz-icon-counter/span";
    private String cartButtonLocator = "//rz-cart/button";

    public LaptopsPageLogic addFirstProductToCart(){
        $(byXpath(firstProductCartButtonLocator)).click();
        return page(LaptopsPageLogic.class);
    }

    public String getCartIterator() {
   return  $(byXpath(cartIteratorLocator)).innerText().trim();
    }

    public String getTitleOfFirstProduct(){
        return $(byXpath(firstProductTitle)).innerText().trim();
    }

    public CartPopupLogic clickOnCart(){
        $(byXpath(cartButtonLocator)).click();
        return new CartPopupLogic();
    }
}