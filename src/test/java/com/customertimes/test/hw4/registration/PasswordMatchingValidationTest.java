package com.customertimes.test.hw4.registration;
import com.customertimes.framework.driver.WebdriverRunner;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;

public class PasswordMatchingValidationTest extends BaseTest {

    String userMailReg = "omeleshko32@gmail.com";
    String passwordReg = "22334455Le+";
    String passwordRegRepeat = "22334455Le";
    String expectedPasswordError = "Passwords do not match";

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
    public void userPasswordsMatched() {
        getWebDriver().findElement(By.id("navbarAccount")).click();
        getWebDriver().findElement(By.id("navbarLoginButton")).click();

        getWebDriver().findElement(By.id("newCustomerLink")).click();

        getWebDriver().findElement(By.id("emailControl")).clear();
        getWebDriver().findElement(By.id("emailControl")).sendKeys(userMailReg);

        getWebDriver().findElement(By.id("passwordControl")).clear();
        getWebDriver().findElement(By.id("passwordControl")).sendKeys(passwordReg);

        getWebDriver().findElement(By.id("repeatPasswordControl")).clear();
        getWebDriver().findElement(By.id("repeatPasswordControl")).sendKeys(passwordRegRepeat);

        WebElement securityQuestionDropDown = getWebDriver().findElement(By.cssSelector(".mat-select[role='combobox']"));
        securityQuestionDropDown.click();

        String actualPasswordError = getWebDriver().findElement(By.id("mat-error-10")).getText();
        Assert.assertEquals(actualPasswordError, expectedPasswordError, "Password matching validation do not match.");
    }
}
