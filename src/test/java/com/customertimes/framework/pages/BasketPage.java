package com.customertimes.framework.pages;

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
    public void openPage() {

    }

    public String getActualProductInBasket() {
        String actualProductInBasket = getElement(productInBasket).getText();
        return actualProductInBasket;
    }

    public String getActualQuantityInBasket() {
        String actualQuantityInBasket = getElement(quantityInBasket).getText();
        return actualQuantityInBasket;
    }
}
