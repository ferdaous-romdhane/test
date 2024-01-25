Feature: Delete Collaborator

  @test1
  Scenario: 
    Given loginPpage
    When I pass informations and log in
    And I press the users_button
    And I press the collaborator_button
    And I press menu button
    And I press delete
    And I confirm the action  
    Then I should delete admin successfully
