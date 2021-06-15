package com.customertimes.test.hw3;

public class Profile {
    private String emailCss = "[name=email]";
    private String emailXpath = "//input[@name='email']";
    private String usernameCss = "[name=username]";
    private String usernameXpath = "//input[@name='username']";
    private String setUsernameCSS = "[id=submit]";
    private String setUsernameXpath = "//*[@id='submit']";
    private String chooseFileCSS = "#picture[accept^=image]";
    private String chooseXpath = "//*[@id='picture' and @accept='image/*']";
    private String uploadPictureCSS = "button:last-child";
    private String uploadPictureXpath = "//button[contains(., 'Upload Picture')]";
    private String imageUrlCSS = "[name=imageUrl]";
    private String imageUrlXpath = "//input[@name='imageUrl']";
    private String linkImageCSS = "form[action$=url] div.form-group + button";
    private String linkImageXpath = "//*[contains(concat(' ', normalize-space(@class), ' '), 'mdl-cell mdl-cell--6-col-desktop mdl-cell--12-col-tablet mdl-cell--12-col-phone')]/form[2]/button";
}
