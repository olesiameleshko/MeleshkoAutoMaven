package com.customertimes.framework.pages;

import com.customertimes.model.Customer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    public void openPage() {

    }
    public void enterEmailReg (String emailReg) {
        WebElement emailRegEllement = driver.findElement(emailFieldReg);
        emailRegEllement.clear();
        emailRegEllement.sendKeys(emailReg);
    }
    public void enterPasswordReg(String passwordReg) {
        WebElement passwordRegEllement = driver.findElement(passwordRegField);
        passwordRegEllement.clear();
        passwordRegEllement.sendKeys(passwordReg);
    }

    public void enterRepeatPasswordReg(String repeatPasswordReg) {
        WebElement repeatPasswordRegEllement = driver.findElement(repeatPasswordRegField);
        repeatPasswordRegEllement.clear();
        repeatPasswordRegEllement.sendKeys(repeatPasswordReg);
    }

    public void clickSecurityQuestionDropDown() {
        WebElement securityQuestionDropDownEllement = driver.findElement(securityQuestionDropDown);
        securityQuestionDropDownEllement.click();
    }

    public void clickOnPasswordRegField() {

        driver.findElement(passwordRegField).click();
    }

    public void chooseSecurityQuestionOption() {
        driver.findElement(securityQuestionOption).click();
    }

    public void enterSecurityAnswer(String securityAnswer) {
        WebElement securityAnswerEllement = driver.findElement(securityAnswerField);
        securityAnswerEllement.clear();
        securityAnswerEllement.sendKeys(securityAnswer);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void registerAs(Customer customer) {
        enterEmailReg(customer.getEmail());
        enterPasswordReg(customer.getPassword());
        enterRepeatPasswordReg(customer.getPassword());
        clickSecurityQuestionDropDown();
        chooseSecurityQuestionOption();
        enterSecurityAnswer(customer.getAnswerReg());
        clickRegisterButton();
    }

    public String getEmailValidationError() {
        String actualEmailError = driver.findElement(emailRegValidation).getText();
        return actualEmailError;
    }

    public String getPasswordMatchingError() {
        String actualPasswordError = driver.findElement(passwordErrorValidation).getText();
        return actualPasswordError;
    }

    public String getUniqueValidationError() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(uniqueValidation)));
        String actualUniqueError = driver.findElement(uniqueValidation).getText();
        return actualUniqueError;
    }
}
