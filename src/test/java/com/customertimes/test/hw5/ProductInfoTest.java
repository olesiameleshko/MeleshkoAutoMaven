package com.customertimes.test.hw5;
import com.customertimes.framework.pages.AllProductsPage;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductInfoTest extends BaseTest {

    WebDriverWait wait;
    AllProductsPage allProductsPage;
    String expectedProductName = "Banana Juice (1000ml)";
    String expectedDescription = "Monkeys love it the most.";
    String expectedPrice = "1.99¤";

    @BeforeClass
    public void setup() throws InterruptedException {
        driver.get("http://localhost:3000/#/");
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        wait = new WebDriverWait(driver, 5);
        allProductsPage = new AllProductsPage(driver);
    }

    @Test
    public void productInfoMatchingTest() {
        allProductsPage.clickOnProductTile();

        String actualProductName = allProductsPage.getProductName();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(actualProductName, expectedProductName, "The product name doesn't match");
        String actualDescription = allProductsPage.getProductDescription();
        softassert.assertEquals(actualDescription, expectedDescription, "The description doesn't match");
        String actualPrice = allProductsPage.getProductPrice();
        softassert.assertEquals(actualPrice, expectedPrice, "The price doesn't match");
        softassert.assertAll();
    }
}
