package com.example.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.pages.RegistrationPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationSteps {

    WebDriver driver = new ChromeDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @Given("I navigate to registration page")
    public void i_navigate_to_registration_page() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.linkText("Create an Account")).click();
    }

    @When("I register with new unique credentials")
    public void i_register_with_new_unique_credentials() {
        registrationPage.fillRegistrationForm("unique@example.com", "Password123");
        registrationPage.submitRegistration();
    }

    @Then("I should see successful registration confirmation")
    public void i_should_see_successful_registration_confirmation() {
        assertTrue(registrationPage.getSuccessMessage().contains("Thank you for registering"));
        driver.quit();
    }

    @Given("an existing user with email {string}")
    public void an_existing_user_with_email(String email) {
        // Assume the email already exists
    }

    @When("I attempt to register with the same email")
    public void i_attempt_to_register_with_the_same_email() {
        registrationPage.fillRegistrationForm("test@example.com", "Password123");
        registrationPage.submitRegistration();
    }

    @Then("I should see error message {string}")
    public void i_should_see_error_message(String errorMessage) {
        assertTrue(registrationPage.getErrorMessage().contains(errorMessage));
        driver.quit();
    }
}
