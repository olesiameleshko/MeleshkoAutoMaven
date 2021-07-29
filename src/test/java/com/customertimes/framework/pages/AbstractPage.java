package com.customertimes.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int TIME_OUT = 10;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait (driver, TIME_OUT);
    }

    public abstract void openPage();

    public WebElement getElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        return driver.findElement(locator);
    }

    public WebElement getElementByPresence(By locator1) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator1));
        return driver.findElement(locator1);
    }
}




