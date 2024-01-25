Feature: Add Collaborator

  @test1
  Scenario: 
    Given login page
    When I pass user informations and log in
    And I press the users button
    And I press the collaborator button
    And I press add admin button
    And I enter admin first name
    And I enter admin last name
    And I enter admin email
    And I enter admin gender
    And I enter admin phone
    And I press add button
    Then I should add admin successfully
