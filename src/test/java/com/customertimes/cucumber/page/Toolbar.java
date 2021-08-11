package com.customertimes.cucumber.page;

import com.customertimes.framework.pages.AbstractPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.customertimes.framework.driver.WebdriverRunner.getWebDriver;

public class Toolbar extends AbstractPage {

    private LoginPage loginPage = new LoginPage(getWebDriver());
    private By logoutButton = By.id("navbarLogoutButton");
    private By languageButton = By.cssSelector("button[aria-label='Language selection menu']");
    private By danskRadioButton = By.id("mat-radio-5-input");
    private By languageChangeMessage = By.cssSelector("#cdk-overlay-3 span");

    public Toolbar(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
    }

    @Step("Logout from Juice Shop")
    public void logout() {
        loginPage.clickOnAccountButton();
        WebElement menuPanel = getElement(logoutButton);
        menuPanel.click();
    }

    @Step("Change Language to Dansk")
    public void clickOnLanguageButton() {
        getElement(languageButton).click();
        WebElement element = getElement(danskRadioButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    @Step("Check Language changing message")
    public String getLanguageChangeMessage() {
        String actualLanguageChangeMessage = getElementByPresence(languageChangeMessage).getText();
        return actualLanguageChangeMessage;
    }
}
