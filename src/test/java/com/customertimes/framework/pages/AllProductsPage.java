package com.customertimes.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllProductsPage extends AbstractPage{

    private WebDriverWait wait;
    private By yourBasketButton = By.cssSelector("button[aria-label='Show the shopping cart']");
    private By addAppleToBacket = By.cssSelector("mat-grid-tile:first-child button[aria-label='Add to Basket']");
    private By productTileButton = By.cssSelector(".mat-grid-tile:nth-child(3)");
    private By productName = By.cssSelector(".mat-dialog-content h1");
    private By productDescription = By.cssSelector(".mat-dialog-content h1+div");
    private By productPrice = By.cssSelector(".mat-dialog-content p:only-child");
    private By dismissCookieMessageButton = By.cssSelector("a[aria-label='dismiss cookie message']");
    private By nextPageButton = By.cssSelector("button[aria-label='Next page']");
    private By soldOutProduct = By.xpath("//span[contains(.,'Sold Out')]//..//..//button[@aria-label='Add to Basket']");
    private By soldOutMessage = By.cssSelector(".mat-simple-snackbar.ng-star-inserted span");



    public AllProductsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    public void openPage() {

    }

    public void clickAddProductToBasket() {
        wait.until(ExpectedConditions.presenceOfElementLocated(addAppleToBacket));
        driver.findElement(addAppleToBacket).click();
    }

    public void clickYourBasketButton() {
        driver.findElement(yourBasketButton).click();
    }

    public void clickOnProductTile() {

        driver.findElement(productTileButton).click();
    }


    public String getProductName() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(productName)));
        String actualProductName = driver.findElement(productName).getText();
        return actualProductName;
    }

    public String getProductDescription() {
        String actualProductDescription = driver.findElement(productDescription).getText();
        return actualProductDescription;
    }

    public String getProductPrice() {
        String actualProductPrice = driver.findElement(productPrice).getText();
        return actualProductPrice;
    }

    public void dismissCookieMessage() {
        driver.findElement(dismissCookieMessageButton).click();
    }

    public JavascriptExecutor navigateToNextPageUsingScroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(nextPageButton);
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].scrollIntoView();", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        return js;
    }

    public void addToBasketSoldOutProduct() {
        driver.findElement(soldOutProduct).click();
    }

    public String getActualSoldOutMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(soldOutMessage));
        String actualSoldOutMessage = driver.findElement(soldOutMessage).getText();
        return actualSoldOutMessage;
    }
}
