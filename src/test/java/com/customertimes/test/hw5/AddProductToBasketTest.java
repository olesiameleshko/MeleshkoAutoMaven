package com.customertimes.test.hw5;

import com.customertimes.framework.pages.AllProductsPage;
import com.customertimes.framework.pages.BasketPage;
import com.customertimes.framework.pages.LoginPage;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddProductToBasketTest extends BaseTest {

    Customer customer;
    LoginPage loginPage;
    AllProductsPage allProductsPage;
    BasketPage basketPage;
    String expectedProductInBasket = "Apple Juice (1000ml)";
    String expectedQuantityInBasket = "1";

    @BeforeClass
    public void setup() {
        driver.get("http://localhost:3000/#/");
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("omeleshko53@gmail.com").withPassword("22334455Le+").withAnswerReg("Crime and Punishment").build();
        loginPage = new LoginPage(driver);
        allProductsPage = new AllProductsPage(driver);
        basketPage = new BasketPage(driver);
    }

    @Test
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
