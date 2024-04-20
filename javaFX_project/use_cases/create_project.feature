Feature: Create project
  Description: A project is created
  Actors: Employee (or already assigned Project Manager)

Scenario: Add project successfully:
    When "project-1" does not already exist
    And i add the project "project-1"
    Then "project-1" is created

  Scenario: Add project unsuccessfully:
    When "project-1" already exists
    And i add the project "project-1"
    Then error message "A project with this name already exists" is thrown
