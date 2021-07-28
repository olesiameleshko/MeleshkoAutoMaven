package com.customertimes.test.hw4.registration;

import com.customertimes.framework.pages.LoginPage;
import com.customertimes.framework.pages.RegistrationPage;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UniqueEmailValidationTest extends BaseTest {

    WebDriverWait wait;
    Customer customer;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    String expectedError = "Email must be unique";

    @BeforeClass
    public void setup() throws InterruptedException {
        driver.get("http://localhost:3000/#/");
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        wait = new WebDriverWait(driver, 5);
        customer = Customer.newBuilder().withName("omeleshko50@gmail.com").withPassword("22334455Le+").withAnswerReg("Crime and Punishment").build();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void userCannotUseEmailTwice() {
        loginPage.navigateToRegistrationPage();

        registrationPage.registerAs(customer);

        String actualError = registrationPage.getUniqueValidationError();
        Assert.assertEquals(actualError, expectedError, "Unique email field validation error doesn't match");
    }
}
