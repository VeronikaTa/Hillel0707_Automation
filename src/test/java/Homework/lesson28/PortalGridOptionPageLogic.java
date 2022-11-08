package Homework.lesson28;

import com.codeborne.selenide.Condition;

public class PortalGridOptionPageLogic extends PortalGridOptionPageElements{

    public PortalGridOptionPageLogic clickOnBuyButton(int index){
        buyButtons.get(index).click();
        return this;
    }

    public String getCartIterator(){
       return cartIterator.attr("innerText").trim();
    }

    public String getProductTitle(int index){
        String productTitle = productTitles.get(index).attr("innerText").trim();
        if(productTitle.isBlank()){
            throw new IllegalArgumentException("Expected product title is blank");
        }
        return productTitle;
    }

    public CartPopupLogic clickOnCartButton(){
        cartButton.should(Condition.visible);
        cartButton.click();
        return new CartPopupLogic();
    }
}
