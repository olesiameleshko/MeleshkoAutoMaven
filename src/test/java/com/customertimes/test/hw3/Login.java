package com.customertimes.test.hw3;

public class Login {
    private String emailCss = "[name=email]";
    private String emailXpath = "//input[@name='email']";
    private String passwordCss = "[name=password]";
    private String passwordXpath = "//input[@name='password']";
    private String buttonToDisplayHidePasswordCSS = "[button.mat-focus-indicator.mat-tooltip-trigger.mat-icon-button.mat-button-base.ng-star-inserted]";
    private String buttonToDisplayHidePasswordXpath = "//*[contains(concat(' ', normalize-space(@class), ' '), 'mat-focus-indicator mat-tooltip-trigger mat-icon-button mat-button-base ng-star-inserted')]";
    private String forgotPasswordCSS = "a[href*=forgot-password]";
    private String forgotPasswordXpath = "//a[@href='#/forgot-password']";
    private String loginButtonCss = "[id=loginButton]";
    private String loginButtonXpath = "//button[@id='loginButton']";
    private String rememberMeCSS = "[id=rememberMe]";
    private String rememberMeXpath = "//mat-checkbox[@id='rememberMe']";
    private String notYetACustomerCSS = "div#newCustomerLink a";
    private String notYetACustomerXpath = "//*[@id='newCustomerLink']/a";

}
