package com.customertimes.framework.pages;

import com.customertimes.model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        wait.until(ExpectedConditions.textToBe(goToUserProfileButton, currentEmail));
        String actualNameText = driver.findElement(goToUserProfileButton).getText();
        return actualNameText;
    }

    public void clickOnAccountButton() {

        driver.findElement(navBarAccount).click();
    }

    public void clickOnLoginButton() {

        driver.findElement(loginButton).click();
    }

    public void enterPassword(String password) {
        WebElement passwordEllement = driver.findElement(passwordField);
        passwordEllement.clear();
        passwordEllement.sendKeys(password);
    }

    public void enterEmail(String email) {
        WebElement emailEllement = driver.findElement(emailField);
        emailEllement.clear();
        emailEllement.sendKeys(email);
    }

    public void navigateToLoginPage() {
        clickOnAccountButton();
        driver.findElement(loginSubmitButton).click();
    }

    public void loginAs(Customer customer) {
        navigateToLoginPage();
        enterEmail(customer.getEmail());
        enterPassword(customer.getPassword());
        clickOnLoginButton();
    }

    public void waitOfPresenseEmail() {

        wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
    }

    public void clickNewCustomerButton() {

        driver.findElement(goToRegistrationPage).click();
    }

    public void clickOnForcePageReloadButton() {
        driver.findElement(forcePageReloadButton).click();
    }

    public void navigateToRegistrationPage() {
        navigateToLoginPage();
        clickOnForcePageReloadButton();
        clickNewCustomerButton();
    }
    public String getIncorrectCredentialsError() {
        wait.until(ExpectedConditions.presenceOfElementLocated(incorrectCredentialsError));
        String actualValidationError = driver.findElement(incorrectCredentialsError).getText();
        return actualValidationError;

    }
}

