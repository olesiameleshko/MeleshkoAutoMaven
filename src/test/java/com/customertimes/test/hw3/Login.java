package com.customertimes.test.hw3;

public class Login {
    private String emailCss = "[name=email]";
    private String emailXpath = "//input[@name='email']";
    private String passwordCss = "[name=password]";
    private String passwordXpath = "//input[@name='password']";
    private String buttonToDisplayHidePasswordCSS = "#login-form [aria-label~=Eye]";
    private String buttonToDisplayHidePasswordXpath = "//*[@id='login-form']//*[contains(@aria-label, 'Eye')]";
    private String forgotPasswordCSS = "a[href*=forgot-password]";
    private String forgotPasswordXpath = "//a[@href='#/forgot-password']";
    private String loginButtonCss = "[id=loginButton]";
    private String loginButtonXpath = "//button[@id='loginButton']";
    private String rememberMeCSS = "[#rememberMe]";
    private String rememberMeXpath = "//mat-checkbox[@id='rememberMe']";
    private String notYetACustomerCSS = "div#newCustomerLink a";
    private String notYetACustomerXpath = "//*[@id='newCustomerLink']/a";

}
