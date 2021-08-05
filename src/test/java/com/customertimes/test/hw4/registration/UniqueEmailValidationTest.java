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
public class UniqueEmailValidationTest extends BaseTest {

    Customer customer;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    String expectedError = "Email must be unique";

    @BeforeClass
    public void setup() {
        driver.get(TestConfig.CONFIG.baseUrl());
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("omeleshko56@gmail.com").withPassword("22334455Le+").withAnswerReg("Crime and Punishment").build();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @Feature("Registration validation")
    @Description("The user can't register to Juice Shop if password non-unique")
    public void userCannotUseEmailTwice() {
        loginPage.navigateToRegistrationPage();

        registrationPage.registerAs(customer);

        String actualError = registrationPage.getUniqueValidationError();
        Assert.assertEquals(actualError, expectedError, "Unique email field validation error doesn't match");
    }
}
