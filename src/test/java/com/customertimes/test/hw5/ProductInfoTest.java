package com.customertimes.test.hw5;
import com.customertimes.framework.driver.WebdriverRunner;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;

public class ProductInfoTest extends BaseTest {
    String expectedProductName = "Banana Juice (1000ml)";
    String expectedDescription = "Monkeys love it the most.";
    String expectedPrice = "1.99¤";
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
    public void productInfoMatchingTest() {
        getWebDriver().findElement(By.cssSelector(".mat-grid-tile:nth-child(3)")).click();

        wait.until(ExpectedConditions.visibilityOf(getWebDriver().findElement(By.cssSelector(".mat-dialog-content h1"))));
        String actualProductName = getWebDriver().findElement(By.cssSelector(".mat-dialog-content h1")).getText();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(actualProductName, expectedProductName, "The product name doesn't match");
        String actualDescription = getWebDriver().findElement(By.cssSelector(".mat-dialog-content h1+div")).getText();
        softassert.assertEquals(actualDescription, expectedDescription, "The description doesn't match");
        String actualPrice = getWebDriver().findElement(By.cssSelector(".mat-dialog-content p:only-child")).getText();
        softassert.assertEquals(actualPrice, expectedPrice, "The price doesn't match");
        softassert.assertAll();
    }
}
