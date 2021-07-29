package com.customertimes.framework.pages;

import com.customertimes.model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends AbstractPage {

    private WebDriverWait wait;

    private By navBarAccount = By.id("navbarAccount");
    private By loginButton = By.id("loginButton");
    private By passwordField =  By.id("password");
    private By emailField = By.id("email");
    private By loginSubmitButton = By.id("navbarLoginButton");
    private By goToUserProfileButton = By.cssSelector("button[aria-label='Go to user profile'] span");
    private By goToRegistrationPage = By.id("newCustomerLink");
    private By forcePageReloadButton = By.cssSelector("simple-snack-bar .mat-button-wrapper");
    private By incorrectCredentialsError = By.cssSelector("mat-sidenav-content .error.ng-star-inserted");


    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }


    @Override
    public void openPage() {

        driver.get("url/login");
    }


    public String getActualNameText(String currentEmail) {
        String actualNameText = getElement(goToUserProfileButton).getText();
        return actualNameText;
    }

    public void clickOnAccountButton() {

        getElement(navBarAccount).click();
    }

    public void clickOnLoginButton() {

        getElement(loginButton).click();
    }

    public void enterPassword(String password) {
        WebElement passwordEllement = getElement(passwordField);
        passwordEllement.clear();
        passwordEllement.sendKeys(password);
    }

    public void enterEmail(String email) {
        WebElement emailEllement = getElement(emailField);
        emailEllement.clear();
        emailEllement.sendKeys(email);
    }

    public void navigateToLoginPage() {
        clickOnAccountButton();
        getElement(loginSubmitButton).click();
    }

    public void loginAs(Customer customer) {
        navigateToLoginPage();
        enterEmail(customer.getEmail());
        enterPassword(customer.getPassword());
        clickOnLoginButton();
    }

    public void clickNewCustomerButton() {
        getElement(goToRegistrationPage).click();
    }

    public void clickOnForcePageReloadButton() {
        getElement(forcePageReloadButton).click();
    }

    public void navigateToRegistrationPage() {
        navigateToLoginPage();
        clickOnForcePageReloadButton();
        clickNewCustomerButton();
    }

    public String getIncorrectCredentialsError() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(incorrectCredentialsError));
        String actualValidationError = getElement(incorrectCredentialsError).getText();
        return actualValidationError;
    }
}

