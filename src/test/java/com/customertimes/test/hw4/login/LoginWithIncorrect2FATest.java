package com.customertimes.test.hw4.login;

import com.customertimes.framework.pages.LoginPageFactory;
import com.customertimes.framework.pages.TwoFactorAuthenticationPage;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginWithIncorrect2FATest extends BaseTest {

    WebDriverWait wait;
    Customer customer;
    LoginPageFactory loginPageFactory;
    TwoFactorAuthenticationPage twoFactorAuthenticationPage;
    String incorrect2FACode ="111111";
    String expected2FAError = "The token appears to be invalid.";

    @BeforeClass
    public void setup() throws InterruptedException {
        driver.get("http://localhost:3000/#/");
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("omeleshko52@gmail.com").withPassword("22334455Le+").withTwoFA(incorrect2FACode).build();
        loginPageFactory = new LoginPageFactory(driver);
        twoFactorAuthenticationPage = new TwoFactorAuthenticationPage(driver);
    }

    @Test
    public void userCannotLoginWithIncorrect2FA() {

    loginPageFactory.loginAs(customer);

    twoFactorAuthenticationPage.enter2FA(customer.getTwoFA());

    twoFactorAuthenticationPage.clickSubmitButton();

    String actual2FAError = twoFactorAuthenticationPage.getActual2FAError();
    Assert.assertEquals(actual2FAError, expected2FAError, "2FA validation doesn't work correctly");
    }
}
