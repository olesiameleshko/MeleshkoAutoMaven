package com.customertimes.cucumber.page;


import com.customertimes.framework.pages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllProductsPage extends AbstractPage {

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
    private By closeWelcomeBanner = By.cssSelector("button[aria-label='Close Welcome Banner']");
    private By allProductOnDanskLanguage = By.cssSelector(".heading.mat-elevation-z6 div:first-child");

    public AllProductsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    @Step("Open page")
    public void openPage() {
        driver.get(BASE_PAGE);

    }

    @Step("Click Add to basket button")
    public void clickAddProductToBasket() {

        getElement(addAppleToBacket).click();
    }

    @Step("Click Your basket button")
    public void clickYourBasketButton() {

        getElement(yourBasketButton).click();
    }

    @Step("Click on Product tile")
    public void clickOnProductTile() {

        getElement(productTileButton).click();
    }

    @Step("Get Product name")
    public String getProductName() {
        String actualProductName = getElement(productName).getText();
        return actualProductName;
    }

    @Step("Get Product description")
    public String getProductDescription() {
        String actualProductDescription = getElement(productDescription).getText();
        return actualProductDescription;
    }

    @Step("Get Product price")
    public String getProductPrice() {
        String actualProductPrice = getElement(productPrice).getText();
        return actualProductPrice;
    }

    @Step("Dismiss Cookie message")
    public void dismissCookieMessage() {

        getElement(dismissCookieMessageButton).click();
    }

    @Step("Navigate to Next page using scroll")
    public JavascriptExecutor navigateToNextPageUsingScroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = getElement(nextPageButton);
        js.executeScript("arguments[0].scrollIntoView();", element);
        getElement(nextPageButton);
        element.click();
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        return js;
    }

    @Step("Add to Basket Sold out product")
    public void addToBasketSoldOutProduct() {

        getElement(soldOutProduct).click();
    }

    @Step("Get Actual Sold out message")
    public String getActualSoldOutMessage() {
        String actualSoldOutMessage = getElementByPresence(soldOutMessage).getText();
        return actualSoldOutMessage;
    }

    @Step("Dismiss Welcome banner")
    public void dismissWelcomeBanner() {
        getElement(closeWelcomeBanner).click();
    }
    @Step("Check All Products on Dansk language")
    public String getAllProductsHeaderOnDansk() {
        String actualAllProductsOnDansk = getElement(allProductOnDanskLanguage).getText();
        return actualAllProductsOnDansk;
    }

}

