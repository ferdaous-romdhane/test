Feature: Delete Enterprise

@test1
Scenario: Delete Enterprise 
  Given open login page
  When I enter email
  And I enter password
  And I logged 
  And I click enterprise
  And I click delete button
  Then the enterprise deleted successfully