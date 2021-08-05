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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Registration")
public class EmailValidationTest extends BaseTest {
    
    String expectedEmailError = "Email address is not valid.";
    Customer customer;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @BeforeClass
    public void setup() {
        driver.get(TestConfig.CONFIG.baseUrl());
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("@").build();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @Feature("Registration validation")
    @Description("The user can't register to Juice Shop with invalid email")
    public void userCannotProvideInvalidEmail() {
        loginPage.navigateToRegistrationPage();

        registrationPage.enterEmailReg(customer.getEmail());
        registrationPage.clickOnPasswordRegField();

        String actualEmailError = registrationPage.getEmailValidationError();
        Assert.assertEquals(actualEmailError, expectedEmailError, "Invalid email field validation error doesn't match");
    }
}