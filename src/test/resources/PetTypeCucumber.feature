Feature: Pet types field

  # positive testcase - add a new pet type
  Scenario: Add new pet type
    Given I navigate to the add new pet type page
    When I enter a new pet type name "Adimal"
    And I click on save Button
    Then The newly added pet type "Adimal" should be found on pet type list

    # negative testcase - delete newly added pet type
    Scenario: Delete newly added pet type
      Given I navigate to the pet types page
      When I delete the newly "Adimal" pet type
      Then The deleted pet type "Adimal" can no longer be found in the list
