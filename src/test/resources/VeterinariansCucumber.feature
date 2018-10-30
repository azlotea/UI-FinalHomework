Feature: Veterinarians functionality

  Scenario: Add new veterinarian
    Given I navigate to the add new veterinarian page
    When I enter valid data for first name "Adrian", last name "Veterinarul" and select first type
    Then The newly added veterinarian "Adrian Veterinarul" should be found on the list

    Scenario: Delete new veterinarian
      Given I navigate to the all veterinarians page
      When I delete the newly added veterinarian "Adrian Veterinarul"
      Then The deleted veterinarian "Adrian Veterinarul" can no longer be found in the list

