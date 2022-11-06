package Homework.lesson27;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestAddingAProductToTheCart {

    @BeforeTest
    public void setUp(){
        Configuration.browserSize = "1920x10800";
        Configuration.browserPosition = "1x1";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void testAddingFirstProductToTheCartAndAssertingProductTitle() {
        new MainPageLogic()
                .clickOnLaptopsAndComputersOption()
                .clickOnLaptopsOption()
                .addFirstProductToCart();

        LaptopsPageLogic laptopsPageLogic = new LaptopsPageLogic();
        Integer actualCartIterator = Integer.valueOf(laptopsPageLogic.getCartIterator());
        Assert.assertEquals(actualCartIterator,1,"Expected 1, but actual " + actualCartIterator);

        String expectedTitleOfProductAddedToCart = laptopsPageLogic.getTitleOfFirstProduct();
        laptopsPageLogic.clickOnCart();
        CartPopupLogic cartPopupLogic = new CartPopupLogic();
        String actualTitleOfProductInCart = cartPopupLogic.getTitleOfProductInCart();
        Assert.assertEquals(actualTitleOfProductInCart,expectedTitleOfProductAddedToCart,"Titles of added product in cart and on page don't match");
    }
}
