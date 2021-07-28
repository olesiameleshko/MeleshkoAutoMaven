package com.customertimes.framework.pages;

import com.customertimes.framework.config.TestConfig;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int TIME_OUT = 10;

    public AbstractPage(
            WebDriver driver) {

        this.driver = driver;
    }

    public abstract void openPage();

}