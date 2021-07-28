package com.customertimes.test.hw4.login;

import com.customertimes.framework.pages.LoginPage;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginWithIncorrectCredentialsTest extends BaseTest {
    String incorrectPassword = "22334455Le";
    String expectedValidationError = "Invalid email or password.";
    WebDriverWait wait;
    Customer customer;
    LoginPage loginPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver.get("http://localhost:3000/#/");
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        wait = new WebDriverWait(driver, 1);
        customer = Customer.newBuilder().withName("omeleshko44@gmail.com").withPassword(incorrectPassword).build();
        loginPage = new LoginPage(driver);
    }


    @Test
    public void userCannotUseIncorrectCredentials() {
        loginPage.loginAs(customer);

        String actualValidationError = loginPage.getIncorrectCredentialsError();
        Assert.assertEquals(actualValidationError, expectedValidationError, "Incorrect credentials validation doesn't work correctly");
    }
}
