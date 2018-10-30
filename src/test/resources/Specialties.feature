Feature: Specialties functionality

  Scenario: Add new specialties
    Given I navigate to the add new specialties page
    When I enter a new specialty "Dermatology"
    And I click on saveButton
    Then The newly added specialty "Dermatology" should be found on specialties list

    Scenario: Edit new specialties
      Given I navigate to the all specialties page
      And I click on the edit button of the newly added specialty "Dermatology"
      When I enter new specialty name "dermatology"
      And I click on update button
      Then The updated specialty "dermatology" should be found on specialties list

