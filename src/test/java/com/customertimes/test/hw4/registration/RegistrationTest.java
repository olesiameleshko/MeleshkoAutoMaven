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

public class RegistrationTest extends BaseTest {

    String userMailReg = "omeleshko27@gmail.com";
    String passwordReg = "22334455Le+";
    String answerReg = "Crime and Punishment";
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws InterruptedException {
        getWebDriver().get("http://localhost:3000/#/");
        getWebDriver().findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        //userMailReg = "omeleshko" + System.currentTimeMillis() + "@gmail.com";
        wait = new WebDriverWait(getWebDriver(), 5);
    }

    @AfterClass
    public void turnDown() {

        WebdriverRunner.closeWebDriver();
    }

    @Test
    public void userCanRegisterToJuicyShop() {
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

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        getWebDriver().findElement(By.id("email")).clear();
        getWebDriver().findElement(By.id("email")).sendKeys(userMailReg);

        getWebDriver().findElement(By.id("password")).clear();
        getWebDriver().findElement(By.id("password")).sendKeys(passwordReg);

        getWebDriver().findElement(By.id("loginButton")).click();

        getWebDriver().findElement(By.id("navbarAccount")).click();

        wait.until(ExpectedConditions.textToBe(By.cssSelector("button[aria-label='Go to user profile'] span"), userMailReg));
        String actualNameText = getWebDriver().findElement(By.cssSelector("button[aria-label='Go to user profile'] span")).getText();
        Assert.assertEquals(actualNameText, userMailReg, "User name doesn't match");
    }
}

