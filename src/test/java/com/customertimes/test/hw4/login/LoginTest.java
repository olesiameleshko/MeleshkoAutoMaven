package com.customertimes.test.hw4.login;

import com.customertimes.framework.pages.LoginPage;
import com.customertimes.model.Customer;
import com.customertimes.test.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

    Customer customer;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        driver.get("http://localhost:3000/#/");
        driver.findElement(By.cssSelector("button[aria-label='Close Welcome Banner']")).click();
        customer = Customer.newBuilder().withName("omeleshko57@gmail.com").withPassword("22334455Le+").build();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void userCanLoginToJuiceShop() throws InterruptedException {

        loginPage.loginAs(customer);
        Thread.sleep(10_000);
        loginPage.clickOnAccountButton();

        String actualNameText = loginPage.getActualNameText(customer.getEmail());
        Assert.assertEquals(actualNameText, customer.getEmail(), "User name doesn't match");
    }
}
