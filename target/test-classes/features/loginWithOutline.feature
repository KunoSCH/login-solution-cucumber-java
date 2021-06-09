Feature: Login
  This feature allows the user to perform the login.
  Background:
    Given The browser is open
    And The user is on the homepage

  Scenario Outline: Login validation
    When The user enters "<username>" in the username field
    And The user enters "<password>" in the password field
    And The user presses the login button
    Then The system should display "<message>"
    Examples: Valid Logins
      | username | password | message       |
      | John     | secret   | Login success |
      | admin    | admin    | Login success |
      | Anna     | abcde    | Login success |

    Examples: Invalid Logins
      | username | password | message                      |
      | aabbcc   | abcd     | Invalid username or password |
      | Peter    | Pan      | Invalid username or password |
      | Luke     | ekul     | Invalid username or password |
