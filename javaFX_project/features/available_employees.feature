Feature: Get list of available employees
  Description: when a user wants a list of all available employees
  Actors: user

  Scenario: User successfully gets list of available employees
    Given employee "HUBA" already exist
    And there exists an available user "JOHA" from week 1 till week 2
    When the user requests list of available employees from week 1 till week 2
    Then the user is given list of available employees in week 1 till week 2 containing at least "JOHA"
