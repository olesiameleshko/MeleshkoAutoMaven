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

public class LoginTest extends BaseTest {
    String userMail = "omeleshko11@gmail.com";
    String password = "22334455Le+";
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
    public void userCanLoginToJuiceShop() {
        getWebDriver().findElement(By.id("navbarAccount")).click();
        getWebDriver().findElement(By.id("navbarLoginButton")).click();

        getWebDriver().findElement(By.id("email")).clear();
        getWebDriver().findElement(By.id("email")).sendKeys(userMail);

        getWebDriver().findElement(By.id("password")).clear();
        getWebDriver().findElement(By.id("password")).sendKeys(password);

        getWebDriver().findElement(By.id("loginButton")).click();

        getWebDriver().findElement(By.id("navbarAccount")).click();

        wait.until(ExpectedConditions.textToBe(By.cssSelector("button[aria-label='Go to user profile'] span"), userMail));
        String actualNameText = getWebDriver().findElement(By.cssSelector("button[aria-label='Go to user profile'] span")).getText();
        Assert.assertEquals(actualNameText, userMail, "User name doesn't match");
    }
}
