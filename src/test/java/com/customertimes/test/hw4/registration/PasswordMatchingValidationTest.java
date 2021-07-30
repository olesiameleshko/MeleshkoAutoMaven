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

public class PasswordMatchingValidationTest extends BaseTest {

    Customer customer;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    String wrongPasswordRegRepeat = "22334455Le";
    String expectedPasswordError = "Passwords do not match";

    @BeforeClass
    public void setup() throws InterruptedException {
        driver.get("http://localhost:3000/#/");
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("omeleshko32@gmail.com").withPassword("22334455Le+").build();
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
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


