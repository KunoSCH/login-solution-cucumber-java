Feature: Login
  This feature allows the user to perform the login.
  Background:
    Given The browser is open
    And The user is on the homepage

    Scenario: Valid login
      Given This user
        | Fields                 | Values               |
        | username               | John                |
        | password               | secret               |
      When The user enters his username in the username field
      And The user enters his password in the password field
      And The user presses the login button
      Then The system should display "Hello John"