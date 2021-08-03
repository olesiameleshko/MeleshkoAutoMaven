package com.customertimes.framework.pages;

import com.customertimes.model.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFluentPage extends AbstractPage {

    private WebDriverWait wait;

    private By navBarAccount = By.id("navbarAccount");
    private By loginButton = By.id("loginButton");
    private By passwordField = By.id("password");
    private By emailField = By.id("email");
    private By loginSubmitButton = By.id("navbarLoginButton");
    private By goToUserProfileButton = By.cssSelector("button[aria-label='Go to user profile'] span");
    private String searchXpathLocator = "//*[text()='%s']";



    public LoginFluentPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    @Step("Open Page")
    public void openPage() {
        driver.get("url/login");
        driver.get(BASE_PAGE + "/login");
    }

    @Step("Search by text")
    public void searchByText(String text) {
        driver.findElement(By.xpath(String.format(searchXpathLocator, text)));
    }

    @Step("Get Actual state of Login button")
    public boolean getActualStateLoginButton() {
        boolean actualState = getElement(loginButton).isEnabled();
        return actualState;
    }

    @Step("Click on Account button")
    public LoginFluentPage clickOnAccountButton() {
        getElement(navBarAccount).click();
        return this;
    }

    @Step("Click on Login button")
    public LoginFluentPage clickOnLoginButton() {
        getElement(loginButton).click();
        return this;
    }

    @Step("Enter Password field")
    public LoginFluentPage enterPassword(String password) {
        WebElement passwordElement = getElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
        return this;
    }

    @Step("Enter Email field")
    public LoginFluentPage enterEmail(String email) {
        WebElement emailElement = getElement(emailField);
        emailElement.clear();
        emailElement.sendKeys(email);
        return this;
    }

    @Step("Navigate to Login page")
    public LoginFluentPage navigateToLoginPage() {
        clickOnAccountButton();
        getElement(loginSubmitButton).click();
        return this;
    }

    @Step("Login as Customer")
    public LoginFluentPage loginAs(Customer customer) {
        navigateToLoginPage();
        enterEmail(customer.getEmail());
        enterPassword(customer.getPassword());
        clickOnLoginButton();
        return this;
    }
}
