package com.customertimes.cucumber.stepdefs;
import com.customertimes.cucumber.page.LoginPage;
import com.customertimes.cucumber.page.Toolbar;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;
public class LogoutStepdefs {

    private LoginPage loginPage = new LoginPage(getWebDriver());
    private Toolbar toolbarFunctionality = new Toolbar(getWebDriver());
    boolean expectedStateOfLoginButton = true;

    @Given("User logged in to the app using {string} and {string}")
    public void userLoggedInJuiceShop(String email, String password) {
        loginPage.openPage();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
    }

    @When("User logged out")
    public void userLogoutFromJuiceShop() {
        toolbarFunctionality.logout();
    }

    @Then("The user should be logged out from Juice Shop")
    public void userShouldBeLoggedOut() {
        loginPage.clickOnAccountButton();
         boolean actualStateOfLogin = loginPage.getActualStateOfLogin();
         Assert.assertEquals(actualStateOfLogin, expectedStateOfLoginButton, "The user isn't logged out from Juice Shop");
    }
}


