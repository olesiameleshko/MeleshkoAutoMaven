package com.customertimes.test;

import com.customertimes.framework.driver.WebdriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void setup(){
        driver = WebdriverRunner.getWebDriver();
        System.out.println("The driver is opened");
    }

    @AfterSuite
    public void turnDown() {
        WebdriverRunner.closeWebDriver();
        System.out.println("The driver is closed");
    }
}
