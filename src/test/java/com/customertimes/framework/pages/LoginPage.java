package com.customertimes.framework.pages;

import com.customertimes.model.Customer;
import io.qameta.allure.Step;
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
    @Step("Open Page")
    public void openPage() {

        driver.get("url/login");
    }

    @Step("Get Actual name")
    public String getActualNameText(String currentEmail) {
        String actualNameText = getElement(goToUserProfileButton).getText();
        return actualNameText;
    }
    @Step("Click on Account button")
    public void clickOnAccountButton() {

        getElement(navBarAccount).click();
    }
    @Step("Click on Login button")
    public void clickOnLoginButton() {

        getElement(loginButton).click();
    }
    @Step("Enter Password field")
    public void enterPassword(String password) {
        WebElement passwordEllement = getElement(passwordField);
        passwordEllement.clear();
        passwordEllement.sendKeys(password);
    }
    @Step("Enter Email field")
    public void enterEmail(String email) {
        WebElement emailEllement = getElement(emailField);
        emailEllement.clear();
        emailEllement.sendKeys(email);
    }
    @Step("Navigate to Login Page")
    public void navigateToLoginPage() {
        clickOnAccountButton();
        getElement(loginSubmitButton).click();
    }
    @Step("Login as Customer")
    public void loginAs(Customer customer) {
        navigateToLoginPage();
        enterEmail(customer.getEmail());
        enterPassword(customer.getPassword());
        clickOnLoginButton();
    }
    @Step("Click New Customer button")
    public void clickNewCustomerButton() {

        getElement(goToRegistrationPage).click();
    }
    @Step("Click on Page Reload button to dismiss pop-up")
    public void clickOnForcePageReloadButton() {

        getElement(forcePageReloadButton).click();
    }
    @Step("Navigate to Registration Page")
    public void navigateToRegistrationPage() {
        navigateToLoginPage();
        clickOnForcePageReloadButton();
        clickNewCustomerButton();
    }
    @Step("Get Incorrect credentials error")
    public String getIncorrectCredentialsError() {
        String actualValidationError = getElement(incorrectCredentialsError).getText();
        return actualValidationError;
    }
}

