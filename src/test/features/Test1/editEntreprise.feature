Feature: Edit Entreprise

@test1
Scenario: 
 Given load login page
  When I pass user email
  And I pass user password
  And I click log in
  And I press the enterprise button
  And I click the edit_enterprise button
  And I change the enterprise name
  And I change the enterprise matricule
  And I change the enterprise email
  And I change the enterprise phone
  And I click modify button
  Then I should edit the entreprise successfully