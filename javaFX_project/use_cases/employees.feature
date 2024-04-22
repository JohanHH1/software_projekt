Feature: select employee
  Description: an employee is logged in
  Actors: Employee

  Scenario: An employee logs in successfully:
    Given employee "HUBA" already exist
    When I enter the initials "HUBA"
    Then I am logged in as initials "HUBA"
