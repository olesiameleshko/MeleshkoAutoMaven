package com.customertimes.test.hw4.login;

import com.customertimes.framework.config.TestConfig;
import com.customertimes.framework.pages.LoginPage;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("Sign in/Sign up")
public class LoginWithIncorrectCredentialsTest extends BaseTest {

    Customer customer;
    LoginPage loginPage;
    String incorrectPassword = "22334455Le";
    String expectedValidationError = "Invalid email or password.";

    @BeforeClass
    public void setup() {
        driver.get(TestConfig.CONFIG.baseUrl());
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("omeleshko57@gmail.com").withPassword(incorrectPassword).build();
        loginPage = new LoginPage(driver);
    }


    @Test
    @Feature("Login validation")
    @Description("The user can't login to Juice Shop with incorrect credentials")
    public void userCannotUseIncorrectCredentials() {
        loginPage.loginAs(customer);

        String actualValidationError = loginPage.getIncorrectCredentialsError();
        Assert.assertEquals(actualValidationError, expectedValidationError, "Incorrect credentials validation doesn't work correctly");
    }
}
