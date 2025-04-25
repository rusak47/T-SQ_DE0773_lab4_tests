package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("confirm_password");
    private By registerButton = By.id("register");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public WebElement getConfirmPasswordField() {
        return driver.findElement(confirmPasswordField);
    }

    public WebElement getRegisterButton() {
        return driver.findElement(registerButton);
    }

    public void fillRegistrationForm(String email, String password) {
        getEmailField().sendKeys(email);
        getPasswordField().sendKeys(password);
        getConfirmPasswordField().sendKeys(password);
    }

    public void submitRegistration() {
        getRegisterButton().click();
    }

    public String getSuccessMessage() {
        return driver.findElement(By.id("registration-success-message")).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(By.id("registration-error-message")).getText();
    }
}
