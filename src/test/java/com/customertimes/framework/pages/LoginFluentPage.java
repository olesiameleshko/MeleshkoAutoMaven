package com.customertimes.framework.pages;

import com.customertimes.model.Customer;
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
    public void openPage() {
        driver.get("url/login");
        //driver.get(BASE_PAGE + "/login");
    }


    public void searchByText(String text) {

        driver.findElement(By.xpath(String.format(searchXpathLocator, text)));
    }

    public boolean getActualStateLoginButton() {
        boolean actualState = driver.findElement(loginButton).isEnabled();
        return actualState;
    }

    public LoginFluentPage clickOnAccountButton() {
        driver.findElement(navBarAccount).click();
        return this;
    }

    public LoginFluentPage clickOnLoginButton() {
        driver.findElement(loginButton).click();
        return this;
    }

    public LoginFluentPage enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.clear();
        passwordElement.sendKeys(password);
        return this;
    }

    public LoginFluentPage enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.clear();
        emailElement.sendKeys(email);
        return this;
    }

    public LoginFluentPage navigateToLoginPage() {
        clickOnAccountButton();
        driver.findElement(loginSubmitButton).click();
        return this;
    }

    public LoginFluentPage loginAs(Customer customer) {
        navigateToLoginPage();
        enterEmail(customer.getEmail());
        enterPassword(customer.getPassword());
        clickOnLoginButton();
        return this;
    }
}
