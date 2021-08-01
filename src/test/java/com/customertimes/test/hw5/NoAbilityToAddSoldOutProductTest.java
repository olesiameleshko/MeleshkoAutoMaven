package com.customertimes.test.hw5;

import com.customertimes.framework.pages.AllProductsPage;
import com.customertimes.framework.pages.LoginPage;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NoAbilityToAddSoldOutProductTest extends BaseTest {

    WebDriverWait wait;
    LoginPage loginPage;
    Customer customer;
    AllProductsPage allProductsPage;
    String expectedSoldOutMessage = "We are out of stock! Sorry for the inconvenience.";

    @BeforeClass
    public void setup() {
        driver.get("http://localhost:3000/#/");
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("omeleshko53@gmail.com").withPassword("22334455Le+").withAnswerReg("Crime and Punishment").build();
        loginPage = new LoginPage(driver);
        allProductsPage = new AllProductsPage(driver);
    }

    @Test
    public void userCannotAddSoldOutProductToBasket() {
        loginPage.loginAs(customer);
        loginPage.clickOnForcePageReloadButton();

        allProductsPage.dismissCookieMessage();
        allProductsPage.navigateToNextPageUsingScroll();
        allProductsPage.addToBasketSoldOutProduct();

        String actualSoldOutMessage = allProductsPage.getActualSoldOutMessage();
        Assert.assertEquals(actualSoldOutMessage, expectedSoldOutMessage, "Sold Out Products validation error doesn't match");
    }
}
