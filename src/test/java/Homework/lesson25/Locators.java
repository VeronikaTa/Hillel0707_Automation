package Homework.lesson25;

import org.openqa.selenium.By;

public enum Locators {
    SALESTILES(By.xpath("//rz-goods-sections/section[1]//li")),
    SALESTILESREVISITED(By.xpath("//rz-goods-sections/section[5]//li")),
    FIRSTTILE(By.xpath("//rz-goods-sections/section[1]//li[1]//a[@class='tile__picture']")),
    FIRSTPRICE(By.xpath("//rz-goods-sections/section[1]//li[1]//div[contains(@class,'tile__price_color_red')]")),
    PRICEONPAGE(By.xpath("//p[contains(@class,'product-prices__big')]")),
    LOGO(By.xpath("//a[@class='header__logo']"));

    public By locator;

    Locators(By xPath){
        this.locator = xPath;
    }
}
