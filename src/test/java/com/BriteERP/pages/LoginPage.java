package com.BriteERP.pages;

import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(css = "input[id='login']")
    public WebElement userNameField;
    @FindBy(css = "input[id='password']")
    public WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    public WebElement loginButton;
    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement errorMessageElement;

    public LoginPage() {//constractor
        PageFactory.initElements(Driver.getDriver(), this);//  PageFactory is a class
    }

    public void login(String username, String password) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

    }

    public String getErrorMessage() {

        return errorMessageElement.getText();


    }
}
