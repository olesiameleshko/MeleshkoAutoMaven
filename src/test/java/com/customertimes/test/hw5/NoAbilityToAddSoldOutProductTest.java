package com.customertimes.test.hw5;

import com.customertimes.framework.config.TestConfig;
import com.customertimes.framework.pages.AllProductsPage;
import com.customertimes.framework.pages.LoginPage;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Epic("All products")
public class NoAbilityToAddSoldOutProductTest extends BaseTest {

    WebDriverWait wait;
    LoginPage loginPage;
    Customer customer;
    AllProductsPage allProductsPage;
    String expectedSoldOutMessage = "We are out of stock! Sorry for the inconvenience.";

    @BeforeClass
    public void setup() {
        driver.get(TestConfig.CONFIG.baseUrl());
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("omeleshko56@gmail.com").withPassword("22334455Le+").withAnswerReg("Crime and Punishment").build();
        loginPage = new LoginPage(driver);
        allProductsPage = new AllProductsPage(driver);
    }

    @Test
    @Feature("Non-ability to add Sold out product to basket")
    @Description("The user can't add Sold out product Juice Shop basket")
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
