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
public class RegistrationTest extends BaseTest {

    Customer customer;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @BeforeClass
    public void setup() {
        driver.get(TestConfig.CONFIG.baseUrl());
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        //userMailReg = "omeleshko" + System.currentTimeMillis() + "@gmail.com";
        customer = Customer.newBuilder().withName("omeleshko60@gmail.com").withPassword("22334455Le+").withAnswerReg("Crime and Punishment").build();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @Feature("Ability to register")
    @Description("The user can register to Juice Shop")
    public void userCanRegisterToJuicyShop() {
        loginPage.navigateToRegistrationPage();

        registrationPage.registerAs(customer);

        loginPage.loginAs(customer);
        loginPage.clickOnAccountButton();

        String actualNameText = loginPage.getActualNameText(customer.getEmail());
        Assert.assertEquals(actualNameText, customer.getEmail(), "User name doesn't match");
    }
}

