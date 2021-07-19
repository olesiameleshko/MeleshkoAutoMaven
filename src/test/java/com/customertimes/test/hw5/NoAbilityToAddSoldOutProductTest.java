package com.customertimes.test.hw5;

import com.customertimes.framework.driver.WebdriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;

public class NoAbilityToAddSoldOutProductTest {
    String userMail = "omeleshko28@gmail.com";
    String password = "22334455Le+";
    WebDriverWait wait;
    String expectedSoldOutMessage = "We are out of stock! Sorry for the inconvenience.";

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
    public void userCannotAddSoldOutProductToBasket() throws InterruptedException {
        getWebDriver().findElement(By.id("navbarAccount")).click();
        getWebDriver().findElement(By.id("navbarLoginButton")).click();

        getWebDriver().findElement(By.cssSelector("simple-snack-bar .mat-button-wrapper")).click();

        getWebDriver().findElement(By.id("email")).clear();
        getWebDriver().findElement(By.id("email")).sendKeys(userMail);

        getWebDriver().findElement(By.id("password")).clear();
        getWebDriver().findElement(By.id("password")).sendKeys(password);

        getWebDriver().findElement(By.id("loginButton")).click();

        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        getWebDriver().findElement(By.cssSelector("a[aria-label='dismiss cookie message']")).click();
        WebElement element = getWebDriver().findElement(By.cssSelector("button[aria-label='Next page']"));
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].scrollIntoView();", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

        getWebDriver().findElement(By.xpath("//span[contains(.,'Sold Out')]//..//..//button[@aria-label='Add to Basket']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".mat-simple-snackbar.ng-star-inserted span")));

        String actualSoldOutMessage = getWebDriver().findElement(By.cssSelector(".mat-simple-snackbar.ng-star-inserted span")).getText();
        Assert.assertEquals(actualSoldOutMessage, expectedSoldOutMessage, "Sold Out Products validation error doesn't match");
    }
}
