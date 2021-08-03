package com.customertimes.framework.pages;

import com.customertimes.model.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends AbstractPage{

    private WebDriverWait wait;
    private By emailFieldReg = By.id("emailControl");
    private By passwordRegField = By.id("passwordControl");
    private By repeatPasswordRegField = By.id("repeatPasswordControl");
    private By securityQuestionDropDown = By.cssSelector(".mat-select[role='combobox']");
    private By securityAnswerField = By.id("securityAnswerControl");
    private By securityQuestionOption = By.cssSelector(".mat-option[id='mat-option-13']");
    private By registerButton = By.id("registerButton");
    private By emailRegValidation = By.id("mat-error-7");
    private By passwordErrorValidation = By.id("mat-error-10");
    private By uniqueValidation = By.cssSelector("div.error");


    public RegistrationPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, TIME_OUT);
    }

    @Override
    @Step("Open page")
    public void openPage() {

    }

    @Step("Enter Email field (registration form)")
    public void enterEmailReg (String emailReg) {
        WebElement emailRegEllement = getElement(emailFieldReg);
        emailRegEllement.clear();
        emailRegEllement.sendKeys(emailReg);
    }

    @Step("Enter Password field (registration form)")
    public void enterPasswordReg(String passwordReg) {
        WebElement passwordRegEllement = getElement(passwordRegField);
        passwordRegEllement.clear();
        passwordRegEllement.sendKeys(passwordReg);
    }

    @Step("Enter Repeat password field")
    public void enterRepeatPasswordReg(String repeatPasswordReg) {
        WebElement repeatPasswordRegEllement = getElement(repeatPasswordRegField);
        repeatPasswordRegEllement.clear();
        repeatPasswordRegEllement.sendKeys(repeatPasswordReg);
    }

    @Step("Click on Security Question drop down")
    public void clickSecurityQuestionDropDown() {
        WebElement securityQuestionDropDownEllement = getElement(securityQuestionDropDown);
        securityQuestionDropDownEllement.click();
    }

    @Step("Click on Password field (registration form)")
    public void clickOnPasswordRegField() {

        getElement(passwordRegField).click();
    }

    @Step("Choose Security Question option")
    public void chooseSecurityQuestionOption() {

        getElement(securityQuestionOption).click();
    }

    @Step("Enter Security answer")
    public void enterSecurityAnswer(String securityAnswer) {
        WebElement securityAnswerEllement = getElement(securityAnswerField);
        securityAnswerEllement.clear();
        securityAnswerEllement.sendKeys(securityAnswer);
    }

    @Step("Click Registration button")
    public void clickRegisterButton() {

        getElement(registerButton).click();
    }

    @Step("Register as Customer")
    public void registerAs(Customer customer) {
        enterEmailReg(customer.getEmail());
        enterPasswordReg(customer.getPassword());
        enterRepeatPasswordReg(customer.getPassword());
        clickSecurityQuestionDropDown();
        chooseSecurityQuestionOption();
        enterSecurityAnswer(customer.getAnswerReg());
        clickRegisterButton();
    }

    @Step("Get Email validation error")
    public String getEmailValidationError() {
        String actualEmailError = getElement(emailRegValidation).getText();
        return actualEmailError;
    }

    @Step("Get Password matching error")
    public String getPasswordMatchingError() {
        String actualPasswordError = getElement(passwordErrorValidation).getText();
        return actualPasswordError;
    }

    @Step("Get Unique validation error")
    public String getUniqueValidationError() {
        String actualUniqueError = getElement(uniqueValidation).getText();
        return actualUniqueError;
    }
}
