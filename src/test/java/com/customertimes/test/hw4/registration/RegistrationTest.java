package com.customertimes.test.hw4.registration;

import com.customertimes.framework.pages.LoginPage;
import com.customertimes.framework.pages.RegistrationPage;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    Customer customer;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @BeforeClass
    public void setup() {
        driver.get("http://localhost:3000/#/");
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        //userMailReg = "omeleshko" + System.currentTimeMillis() + "@gmail.com";
        customer = Customer.newBuilder().withName("omeleshko54@gmail.com").withPassword("22334455Le+").withAnswerReg("Crime and Punishment").build();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void userCanRegisterToJuicyShop() {
        loginPage.navigateToRegistrationPage();

        registrationPage.registerAs(customer);

        loginPage.loginAs(customer);
        loginPage.clickOnAccountButton();

        String actualNameText = loginPage.getActualNameText(customer.getEmail());
        Assert.assertEquals(actualNameText, customer.getEmail(), "User name doesn't match");
    }
}

