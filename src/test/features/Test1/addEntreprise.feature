Feature: Add Enterprise

@test1
Scenario: Add Enterprise with valid information 
  Given load the login page
  When I enter user email
  And I enter user password
  And I logged in
  And I click the enterprise button
  And I click the add_enterprise button
  And I enter the enterprise name
  And I enter the enterprise matricule
  And I enter the enterprise email
  And I enter the enterprise phone
  And I select from the country dropdown
  And I select from the city dropdown
  And I enter the enterprise address
  And I enter the enterprise postal code
  And I click the next button
  And I enter the department name
  And I enter the department matricule
  And I select from the department type dropdown
  And I click next
  And I enter the manager first name 
  And I enter the manager last name
  And I enter the manager email 
  And I enter the manager phone
  And I choose the manager gender
  And I click add button
  Then I should add the enterprise successfully
