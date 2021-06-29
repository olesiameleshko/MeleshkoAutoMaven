package com.customertimes.test.hw4.registration;
import com.customertimes.framework.driver.WebdriverRunner;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;

public class EmailValidationTest extends BaseTest {

    String userMailReg = "@";
    String expectedEmailError = "Email address is not valid.";

    @BeforeClass
    public void setup() throws InterruptedException {
        getWebDriver().get("http://localhost:3000/#/");
        getWebDriver().findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
    }

    @AfterClass
    public void turnDown() {

        WebdriverRunner.closeWebDriver();
    }

    @Test
    public void userCannotProvideInvalidEmail() {
        getWebDriver().findElement(By.id("navbarAccount")).click();
        getWebDriver().findElement(By.id("navbarLoginButton")).click();

        getWebDriver().findElement(By.id("newCustomerLink")).click();

        getWebDriver().findElement(By.id("emailControl")).clear();
        getWebDriver().findElement(By.id("emailControl")).sendKeys(userMailReg);

        getWebDriver().findElement(By.id("passwordControl")).click();

        String actualEmailError = getWebDriver().findElement(By.id("mat-error-7")).getText();
        Assert.assertEquals(actualEmailError, expectedEmailError, "Invalid email field validation error doesn't match");
    }
}