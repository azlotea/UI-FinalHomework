Feature:Owner functionality

  # positive testcase - trying to add a new owner using valid data in all fields
  Scenario: Add new owner with valid data
    Given I navigate to the add new owner page
    When I enter valid data for first name "Adrian", last name "Cucumber", address "Buciumasilor 4-6", city "Bucuresti" and telephone "0766258942" fields
    And I click on AddOwner button
    Then The newly added veterinarian should be found on the list

    # negative testcase - trying to add a new owner using characters for telephone field
    Scenario: Add new owner with invalid data for telephone field
      Given I navigate to the add new owner page
      When I enter valid data for first name "Adrian", last name "Cucumber", address "Buciumasilor 4-6", city "Bucuresti" fields and invalid for telephone "numar" field
      Then The error message "Phone number only accept digits" should appear

      Scenario: Add a new owner without completing fields
        Given I navigate to the add new owner page
        When I do not complete any field
        Then The AddOwner button is invalid