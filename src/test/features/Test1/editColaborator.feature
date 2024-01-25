Feature: Edit Collaborator 

@test1
Scenario: 
Given  login_page
    When I enter informations and log in
    And I click the users_button
    And I click the collaborator_button
    And I click menu button
    And I click edit
    And I change admin informations 
    And I click modify  
    Then I should edit admin successfully
