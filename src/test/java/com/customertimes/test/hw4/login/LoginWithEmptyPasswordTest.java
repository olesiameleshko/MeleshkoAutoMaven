package com.customertimes.test.hw4.login;
import com.customertimes.framework.driver.WebdriverRunner;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;

public class LoginWithEmptyPasswordTest extends BaseTest {
    String userMail = "omeleshko11@gmail.com";
    boolean expectedStateLoginButton = false;

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
    public void userCannotLoginWithoutPassword() {
        getWebDriver().findElement(By.id("navbarAccount")).click();
        getWebDriver().findElement(By.id("navbarLoginButton")).click();

        getWebDriver().findElement(By.id("email")).clear();
        getWebDriver().findElement(By.id("email")).sendKeys(userMail);

        boolean actualStateLoginButton = getWebDriver().findElement(By.id("loginButton")).isEnabled();
        Assert.assertEquals(actualStateLoginButton, expectedStateLoginButton, "Login button is enabled");
    }
}
