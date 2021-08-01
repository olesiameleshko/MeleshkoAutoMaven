package com.customertimes.test.hw4.registration;

import com.customertimes.framework.pages.LoginPage;
import com.customertimes.framework.pages.RegistrationPage;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmailValidationTest extends BaseTest {
    
    String expectedEmailError = "Email address is not valid.";
    Customer customer;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @BeforeClass
    public void setup() {
        driver.get("http://localhost:3000/#/");
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("@").build();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void userCannotProvideInvalidEmail() {
        loginPage.navigateToRegistrationPage();

        registrationPage.enterEmailReg(customer.getEmail());
        registrationPage.clickOnPasswordRegField();

        String actualEmailError = registrationPage.getEmailValidationError();
        Assert.assertEquals(actualEmailError, expectedEmailError, "Invalid email field validation error doesn't match");
    }
}