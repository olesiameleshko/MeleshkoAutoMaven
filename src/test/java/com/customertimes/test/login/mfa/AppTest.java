package com.customertimes.test.login.mfa;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.File;
//Lesson 1
public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        String separator = File.separator;
        System.setProperty("webdriver.chrome.driver", separator + "Program Files" + "chromedriver_win32" + "chromedriver" + "bin");
        WebDriver driver = new ChromeDriver();
        driver.get("https://customertimes.com");
        try {
            Thread.sleep(15_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
        System.out.println("Hello Maven");

    }
}
