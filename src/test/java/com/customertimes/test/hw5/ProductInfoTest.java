package com.customertimes.test.hw5;
import com.customertimes.framework.config.TestConfig;
import com.customertimes.framework.pages.AllProductsPage;
import com.customertimes.test.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Epic("All products")
public class ProductInfoTest extends BaseTest {

    AllProductsPage allProductsPage;
    String expectedProductName = "Banana Juice (1000ml)";
    String expectedDescription = "Monkeys love it the most.";
    String expectedPrice = "1.99¤";

    @BeforeClass
    public void setup() {
        driver.get(TestConfig.CONFIG.baseUrl());
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        allProductsPage = new AllProductsPage(driver);
    }

    @Test
    @Feature("Product info")
    @Description("The user can get actual info about product in Juice Shop")
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
