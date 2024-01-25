@tag
Feature: Login Scenarios

  @Test1
  Scenario Outline: Log in with valid credentials
    Given I am on the login page
    When I enter the email "<email>"
    And I enter the password "<password>"
    And I click the login button
    Then I should be logged in successfully

    Examples: 
      | email                    | password |
      | hamza.ramy.ing@gmail.com | Aziz@123 |
      | test3@gmail.com          | Aziz@123 |

  @Test2
  Scenario Outline: Log in with invalid credentials
    Given I am on the login page
    When I enter the email "<email>"
    And I enter the password "<password>"
    And I click the login button
    Then I should be faile to log in

    Examples: 
      | email                    | password   |
      | hamza.ramy@gmail.com     | jhztuzheuh |
      | hamza.ramy.ing@gmail.com | azjnaiujr  |

  @Test3
  Scenario Outline: Log in with  invalid format
    Given I am on the login page
    When I enter the email "<email>"
    And I enter the password "<password>"
    Then I can t click the button

    Examples: 
      | email                    | password   |
      | hamza.ramy.gmail.com     | jhztuzheuh |
      | hamza.ramy.ing@gmail.com | aa         |
