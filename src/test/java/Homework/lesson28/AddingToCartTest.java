package Homework.lesson28;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class AddingToCartTest {
    ProductsPageLogic product = new ProductsPageLogic();
    CartPopupLogic cartPopupLogic = new CartPopupLogic();

    @BeforeTest
    public void before(){
        Configuration.browserSize = "1920x10800";
        Configuration.browserPosition = "1x1";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void addProductToCartAndAssertItsTitle() {
        new MainPageLogic()
                .clickOnOption(0)
                .clickOnOption(0)
                .clickOnBuyButton(0);

        Assert.assertEquals(product.getCartIterator(), "1", "Number of products in cart expected 1 but was " + product.getCartIterator());
        String expectedProductTitle = product.getProductTitle(0);

        product.clickOnCartButton();
        String actualProductTitle = cartPopupLogic.getTitleOfProductInCart(0);
        Assert.assertEquals(actualProductTitle,expectedProductTitle,"Titles on page and in cart aren't equal");
    }
}
