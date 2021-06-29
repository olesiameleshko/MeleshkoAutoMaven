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

public class LoginWithIncorrect2FATest extends BaseTest {
    String userMail = "omeleshko44@gmail.com";
    String password = "22334455Le+";
    String incorrect2FACode ="111111";
    String expected2FAError = "The token appears to be invalid.";
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws InterruptedException {
        getWebDriver().get("http://localhost:3000/#/");
        getWebDriver().findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        wait = new WebDriverWait(getWebDriver(), 5);
    }

    @AfterClass
    public void turnDown() {

        WebdriverRunner.closeWebDriver();
    }

    @Test
    public void userCannotLoginWithIncorrect2FA() {
        getWebDriver().findElement(By.id("navbarAccount")).click();
        getWebDriver().findElement(By.id("navbarLoginButton")).click();

        getWebDriver().findElement(By.id("email")).clear();
        getWebDriver().findElement(By.id("email")).sendKeys(userMail);

        getWebDriver().findElement(By.id("password")).clear();
        getWebDriver().findElement(By.id("password")).sendKeys(password);

        getWebDriver().findElement(By.id("loginButton")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("totpToken")));
        getWebDriver().findElement(By.id("totpToken")).clear();
        getWebDriver().findElement(By.id("totpToken")).sendKeys(incorrect2FACode);

        getWebDriver().findElement(By.id("totpSubmitButton")).click();

        wait.until(ExpectedConditions.textToBe(By.cssSelector("app-two-factor-auth-enter .error.ng-star-inserted"), expected2FAError));
        String actual2FAError = getWebDriver().findElement(By.cssSelector("app-two-factor-auth-enter .error.ng-star-inserted")).getText();
        Assert.assertEquals(actual2FAError, expected2FAError, "2FA validation doesn't work correctly");
    }
}
