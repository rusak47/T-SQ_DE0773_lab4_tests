Feature: Customer Registration

  Scenario: Successful registration with unique email
    Given I navigate to registration page
    When I register with new unique credentials
    Then I should see successful registration confirmation

  Scenario: Attempt duplicate registration
    Given an existing user with email "test@example.com"
    When I attempt to register with the same email
    Then I should see error message "There is already an account with this email address"
