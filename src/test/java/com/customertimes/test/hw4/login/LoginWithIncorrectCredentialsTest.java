package com.customertimes.test.hw4.login;
import com.customertimes.framework.driver.WebdriverRunner;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;

public class LoginWithIncorrectCredentialsTest extends BaseTest {
    String userMail = "omeleshko27@gmail.com";
    String incorrectPassword = "22334455Le";
    String expectedValidationError = "Invalid email or password.";
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws InterruptedException {
        getWebDriver().get("http://localhost:3000/#/");
        getWebDriver().findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        wait = new WebDriverWait(getWebDriver(), 1);
    }

    @AfterClass
    public void turnDown() {
        WebdriverRunner.closeWebDriver();
    }

    @Test
    public void userCannotUseIncorrectCredentials() {
        getWebDriver().findElement(By.id("navbarAccount")).click();
        getWebDriver().findElement(By.id("navbarLoginButton")).click();

        getWebDriver().findElement(By.id("email")).clear();
        getWebDriver().findElement(By.id("email")).sendKeys(userMail);

        getWebDriver().findElement(By.id("password")).clear();
        getWebDriver().findElement(By.id("password")).sendKeys(incorrectPassword);

        getWebDriver().findElement(By.id("loginButton")).click();

        wait.until(ExpectedConditions.textToBe(By.cssSelector("mat-sidenav-content .error.ng-star-inserted"), expectedValidationError));
        String actualValidationError = getWebDriver().findElement(By.cssSelector("mat-sidenav-content .error.ng-star-inserted")).getText();
        Assert.assertEquals(actualValidationError, expectedValidationError, "Incorrect credentials validation doesn't work correctly");
    }
}
