package com.customertimes.test.hw5;

import com.customertimes.framework.config.TestConfig;
import com.customertimes.framework.pages.AllProductsPage;
import com.customertimes.framework.pages.BasketPage;
import com.customertimes.framework.pages.LoginPage;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Epic("All products")
public class AddProductToBasketTest extends BaseTest {

    Customer customer;
    LoginPage loginPage;
    AllProductsPage allProductsPage;
    BasketPage basketPage;
    String expectedProductInBasket = "Apple Juice (1000ml)";
    String expectedQuantityInBasket = "1";

    @BeforeClass
    public void setup() {
        driver.get(TestConfig.CONFIG.baseUrl());
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("omeleshko56@gmail.com").withPassword("22334455Le+").withAnswerReg("Crime and Punishment").build();
        loginPage = new LoginPage(driver);
        allProductsPage = new AllProductsPage(driver);
        basketPage = new BasketPage(driver);
    }

    @Test
    @Feature("Ability to add product to basket")
    @Description("The user can add product Juice Shop basket")
    public void userCanAddProductToBasket() {
        loginPage.loginAs(customer);

        allProductsPage.clickAddProductToBasket();

        allProductsPage.clickYourBasketButton();

        String actualProductInBasket = basketPage.getActualProductInBasket();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(actualProductInBasket, expectedProductInBasket, "The product doesn't match");
        String actualQuantityInBasket = basketPage.getActualQuantityInBasket();
        softassert.assertEquals(actualQuantityInBasket, expectedQuantityInBasket, "The quantity doesn't match");
        softassert.assertAll();
    }




}
