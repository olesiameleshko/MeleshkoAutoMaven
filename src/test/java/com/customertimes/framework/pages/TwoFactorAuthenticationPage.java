package com.customertimes.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TwoFactorAuthenticationPage extends AbstractPage {

    private WebDriverWait wait;

    private By submitButton = By.id("totpSubmitButton");
    private By twoFATokenField = By.id("totpToken");
    private By twoFAerror = By.cssSelector("app-two-factor-auth-enter .error.ng-star-inserted");

    public TwoFactorAuthenticationPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    @Step("Open page")
    public void openPage() {

    }

    @Step("Enter 2FA field")
    public void enter2FA(String twoFA) {
        WebElement twoFAEllement = getElement(twoFATokenField);
        twoFAEllement.clear();
        twoFAEllement.sendKeys(twoFA);
    }

    @Step("Click Submit button")
    public void clickSubmitButton() {

        getElement(submitButton).click();
    }

    @Step("Get Actual 2FA error")
    public String getActual2FAError() {
        String actual2FAError = getElement(twoFAerror).getText();
        return actual2FAError;
    }
}
