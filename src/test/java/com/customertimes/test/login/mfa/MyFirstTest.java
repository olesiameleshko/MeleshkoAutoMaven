package com.customertimes.test.login.mfa;


import com.customertimes.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class MyFirstTest extends BaseTest {
    @Test
    public void checkSiteTitle()
    {
        driver.get("https://google.com");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle, "Title");
        softAssert.assertAll();
    }
}
