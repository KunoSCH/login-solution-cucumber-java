Feature: Login
  This feature allows the user to perform the login.
  Background:
    Given The browser is open
    And The user is on the homepage

  Scenario: Login with valid credentials
    When The user enters "John" in the username field
    And The user enters "secret" in the password field
    And The user presses the login button
    Then The system should display "Login success"

  Scenario: Login with invalid credentials
    When The user enters "Peter" in the username field
    And The user enters "password" in the password field
    And The user presses the login button
    Then The system should display "Invalid username or password"