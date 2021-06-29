package com.customertimes.test.hw4.registration;
import com.customertimes.framework.driver.WebdriverRunner;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;

public class UniqueEmailValidationTest extends BaseTest {

    String userMailReg = "omeleshko27@gmail.com";
    String passwordReg = "22334455Le+";
    String answerReg = "Crime and Punishment";
    String expectedError = "Email must be unique";
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws InterruptedException {
        getWebDriver().get("http://localhost:3000/#/");
        Thread.sleep(1000);
        getWebDriver().findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        wait = new WebDriverWait(getWebDriver(), 5);
    }

    @AfterClass
    public void turnDown() {

        WebdriverRunner.closeWebDriver();
    }

    @Test
    public void userCannotUseEmailTwice() {
        getWebDriver().findElement(By.id("navbarAccount")).click();
        getWebDriver().findElement(By.id("navbarLoginButton")).click();

        getWebDriver().findElement(By.cssSelector("simple-snack-bar .mat-button-wrapper")).click();

        getWebDriver().findElement(By.id("newCustomerLink")).click();

        getWebDriver().findElement(By.id("emailControl")).clear();
        getWebDriver().findElement(By.id("emailControl")).sendKeys(userMailReg);

        getWebDriver().findElement(By.id("passwordControl")).clear();
        getWebDriver().findElement(By.id("passwordControl")).sendKeys(passwordReg);

        getWebDriver().findElement(By.id("repeatPasswordControl")).clear();
        getWebDriver().findElement(By.id("repeatPasswordControl")).sendKeys(passwordReg);

        WebElement securityQuestionDropDown = getWebDriver().findElement(By.cssSelector(".mat-select[role='combobox']"));
        securityQuestionDropDown.click();
        getWebDriver().findElement(By.cssSelector(".mat-option[id='mat-option-13']")).click();

        getWebDriver().findElement(By.id("securityAnswerControl")).clear();
        getWebDriver().findElement(By.id("securityAnswerControl")).sendKeys(answerReg);

        getWebDriver().findElement(By.id("registerButton")).click();

        wait.until(ExpectedConditions.visibilityOf(getWebDriver().findElement(By.cssSelector("div.error"))));

        String actualError = getWebDriver().findElement(By.cssSelector("div.error")).getText();
        Assert.assertEquals(actualError, expectedError, "Unique email field validation error doesn't match");
    }
}
