package com.customertimes.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage extends AbstractPage{

    private WebDriverWait wait;
    private By productInBasket = By.cssSelector(".mat-table.cdk-table mat-cell+mat-cell");
    private By quantityInBasket = By.cssSelector(".mat-table.cdk-table button+span");



    public BasketPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    @Step("Open page")
    public void openPage() {

    }

    @Step("Get Actual Product in Basket")
    public String getActualProductInBasket() {
        String actualProductInBasket = getElement(productInBasket).getText();
        return actualProductInBasket;
    }

    @Step("Get Actual Quantity in Basket")
    public String getActualQuantityInBasket() {
        String actualQuantityInBasket = getElement(quantityInBasket).getText();
        return actualQuantityInBasket;
    }
}
