package com.customertimes.test.hw4.login;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;
import com.customertimes.framework.pages.LoginFluentPage;

public class LoginWithEmptyPasswordTest extends BaseTest {

    Customer customer;
    LoginFluentPage loginFluentPage;
    boolean expectedStateLoginButton = false;

    @BeforeClass
    public void setup() throws InterruptedException {
        getWebDriver().get("http://localhost:3000/#/");
        getWebDriver().findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("omeleshko11@gmail.com").build();
        loginFluentPage = new LoginFluentPage(driver);
    }

    @Test
    public void userCannotLoginWithoutPassword() {
        boolean actualStateLoginButton = loginFluentPage
                .navigateToLoginPage()
                .enterEmail(customer.getEmail())
                .getActualStateLoginButton();
        Assert.assertEquals(actualStateLoginButton, expectedStateLoginButton, "Login button is enabled");
    }
}
