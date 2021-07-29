package com.customertimes.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllProductsPage extends AbstractPage{

    private WebDriverWait wait;
    private By yourBasketButton = By.cssSelector("button[aria-label='Show the shopping cart']");
    private By addAppleToBacket = By.cssSelector("mat-grid-tile:nth-child(2) button[aria-label='Add to Basket']");
    private By productTileButton = By.cssSelector(".mat-grid-tile:nth-child(4)");
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

        getElement(addAppleToBacket).click();
    }

    public void clickYourBasketButton() {

        getElement(yourBasketButton).click();
    }

    public void clickOnProductTile() {

        getElement(productTileButton).click();
    }

    public String getProductName() {
        String actualProductName = getElement(productName).getText();
        return actualProductName;
    }

    public String getProductDescription() {
        String actualProductDescription = getElement(productDescription).getText();
        return actualProductDescription;
    }

    public String getProductPrice() {
        String actualProductPrice = getElement(productPrice).getText();
        return actualProductPrice;
    }

    public void dismissCookieMessage() {

        getElement(dismissCookieMessageButton).click();
    }

    public JavascriptExecutor navigateToNextPageUsingScroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = getElement(nextPageButton);
        js.executeScript("arguments[0].scrollIntoView();", element);
        getElement(nextPageButton);
        element.click();
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        return js;
    }

    public void addToBasketSoldOutProduct() {
        getElement(soldOutProduct).click();
    }

    public String getActualSoldOutMessage() {
        String actualSoldOutMessage = getElementByPresence(soldOutMessage).getText();
        return actualSoldOutMessage;
    }
}
