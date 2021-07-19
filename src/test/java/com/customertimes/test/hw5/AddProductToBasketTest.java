package com.customertimes.test.hw5;

import com.customertimes.framework.driver.WebdriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;

public class AddProductToBasketTest {
    String userMail = "omeleshko28@gmail.com";
    String password = "22334455Le+";
    WebDriverWait wait;
    String expectedProductInBasket = "Apple Juice (1000ml)";
    String expectedQuantityInBasket = "1";

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
    public void userCanAddProductToBasket() {
        getWebDriver().findElement(By.id("navbarAccount")).click();
        getWebDriver().findElement(By.id("navbarLoginButton")).click();

        getWebDriver().findElement(By.id("email")).clear();
        getWebDriver().findElement(By.id("email")).sendKeys(userMail);

        getWebDriver().findElement(By.id("password")).clear();
        getWebDriver().findElement(By.id("password")).sendKeys(password);

        getWebDriver().findElement(By.id("loginButton")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("mat-grid-tile:first-child button[aria-label='Add to Basket']")));
        getWebDriver().findElement(By.cssSelector("mat-grid-tile:first-child button[aria-label='Add to Basket']")).click();

        getWebDriver().findElement(By.cssSelector("button[aria-label='Show the shopping cart']")).click();
        String actualProductInBasket = getWebDriver().findElement(By.cssSelector(".mat-table.cdk-table mat-cell+mat-cell")).getText();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(actualProductInBasket, expectedProductInBasket, "The product doesn't match");
        String actualQuantityInBasket = getWebDriver().findElement(By.cssSelector(".mat-table.cdk-table button+span")).getText();
        softassert.assertEquals(actualQuantityInBasket, expectedQuantityInBasket, "The quantity doesn't match");
        softassert.assertAll();
    }
}
