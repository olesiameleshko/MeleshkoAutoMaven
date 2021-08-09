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
import org.testng.annotations.*;

@Epic("Sign in/Sign up")
public class LoginTest extends BaseTest {

    Customer customer;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        driver.get(TestConfig.CONFIG.baseUrl());
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("omeleshko57@gmail.com").withPassword("22334455Le+").build();
        loginPage = new LoginPage(driver);
    }

    @Test
    @Feature("Ability to login")
    @Description("The user can login to Juice Shop")
    public void userCanLoginToJuiceShop() {

        loginPage.loginAs(customer);

        loginPage.clickOnAccountButton();

        String actualNameText = loginPage.getActualNameText(customer.getEmail());
        Assert.assertEquals(actualNameText, customer.getEmail(), "User name doesn't match");
    }
}
