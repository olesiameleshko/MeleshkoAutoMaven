package com.customertimes.framework.pages;

import com.customertimes.framework.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int TIME_OUT = 10;
    protected WebDriverWait wait;
    protected final String BASE_PAGE = TestConfig.CONFIG.baseUrl();

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
    public WebElement getElementIfClickable(By locator2) {
        wait.until(ExpectedConditions.elementToBeClickable(locator2));
        return driver.findElement(locator2);
    }
}




