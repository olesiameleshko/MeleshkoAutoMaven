package com.customertimes.cucumber.stepdefs;

import com.customertimes.cucumber.page.AllProductsPage;
import com.customertimes.cucumber.page.Toolbar;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;

public class TranslationsStepdefs {

    private AllProductsPage allProductsPage = new AllProductsPage(getWebDriver());
    private Toolbar toolbar = new Toolbar(getWebDriver());
    String expectedLanguageChangeMessage = "Language has been changed to Dansk";
    String expectedAllProductsDansk = "Alle produkter";

    @Given("User goes to Juice Shop")
    public void navigateToLoginPage() {
        allProductsPage.openPage();
        allProductsPage.dismissWelcomeBanner();
    }

    @When("User change language preferences")
    public void userChangeLanguagePreferences() {
        toolbar.clickOnLanguageButton();
    }

    @Then("Juice Shop should be translated")
    public void juiceShopShouldBeTranslated() {
        String actualLanguageChangeMessage = toolbar.getLanguageChangeMessage();
        SoftAssert softassert = new SoftAssert();
        softassert.assertEquals(actualLanguageChangeMessage, expectedLanguageChangeMessage, "Language changing message doesn't match");
        String actualAllProductsHeaderDansk = allProductsPage.getAllProductsHeaderOnDansk();
        softassert.assertEquals(actualAllProductsHeaderDansk, expectedAllProductsDansk, "All Products header doesn't match");
        softassert.assertAll();
    }
}
