package com.customertimes.test.hw4.login;
import com.customertimes.framework.config.TestConfig;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;
import com.customertimes.framework.pages.LoginFluentPage;

@Epic("Sign in/Sign up")
public class LoginWithEmptyPasswordTest extends BaseTest {

    Customer customer;
    LoginFluentPage loginFluentPage;
    boolean expectedStateLoginButton = false;

    @BeforeClass
    public void setup() {
        driver.get(TestConfig.CONFIG.baseUrl());
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("omeleshko57@gmail.com").build();
        loginFluentPage = new LoginFluentPage(driver);
    }

    @Test
    @Feature("Login validation")
    @Description("The user can't login to Juice Shop without password")
    public void userCannotLoginWithoutPassword() {
        boolean actualStateLoginButton = loginFluentPage
                .navigateToLoginPage()
                .enterEmail(customer.getEmail())
                .getActualStateLoginButton();
        Assert.assertEquals(actualStateLoginButton, expectedStateLoginButton, "Login button is enabled");
    }
}
