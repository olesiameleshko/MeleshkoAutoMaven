package com.customertimes.test.hw4.registration;

import com.customertimes.framework.config.TestConfig;
import com.customertimes.framework.pages.LoginPage;
import com.customertimes.framework.pages.RegistrationPage;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Registration")
public class PasswordMatchingValidationTest extends BaseTest {

    Customer customer;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    String wrongPasswordRegRepeat = "22334455Le";
    String expectedPasswordError = "Passwords do not match";

    @BeforeClass
    public void setup() {
        driver.get(TestConfig.CONFIG.baseUrl());
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("omeleshko32@gmail.com").withPassword("22334455Le+").build();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @Feature("Registration validation")
    @Description("The user can't register to Juice Shop if password mismatched")
    public void userPasswordsMatched() {
        loginPage.navigateToRegistrationPage();

        registrationPage.enterEmailReg(customer.getEmail());
        registrationPage.enterPasswordReg(customer.getPassword());
        registrationPage.enterRepeatPasswordReg(wrongPasswordRegRepeat);
        registrationPage.clickSecurityQuestionDropDown();

        String actualPasswordError = registrationPage.getPasswordMatchingError();
        Assert.assertEquals(actualPasswordError, expectedPasswordError, "Password matching validation do not match.");
    }
}


