package com.customertimes.test.hw3;

public class Registration {
    private String emailCSS = "input#emailControl:first-child";
    private String emailXPath = "(//input)[2]";
    private String passwordCSS = "#passwordControl[type=password]";
    private String passwordXpath = "//*[@id='passwordControl' and @type='password']";
    private String repeatPasswordCSS = "input[aria-label~='confirm']";
    private String repeatPasswordXpath = "//input[@id='repeatPasswordControl']";
    private String showPasswordAdviceCSS = "#mat-slide-toggle-7";
    private String snowPasswordAdviceXpath = "//*[@id='mat-slide-toggle-7']";
    private String securityQuestionCSS = "mat-select, [role='combobox']";
    private String securityQuestionXPath = "//mat-select[@role='combobox']";
    private String answerCSS = "input[data-placeholder^='Answer to your security']";
    private String answerXpath = "//input[starts-with(@data-placeholder, 'Answer to your security')]";
    private String registerButtonCSS = "button[aria-label$=registration]";
    private String registerButtonXpath = "//button[contains(@aria-label, 'registration')]";
    private String alreadyACustomerCSS = "[id=alreadyACustomerLink]";
    private String alreadyACustomerXpath = "//*[@id='alreadyACustomerLink']";
}
