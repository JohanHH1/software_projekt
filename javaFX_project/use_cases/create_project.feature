Feature: Create project
  Description: A project is created
  Actors: Employee (or already assigned Project Manager)

Scenario: Add project successfully:
    When i add the project "project-1"
    And "project-1" does not exist
    Then "project-1" is created










  ##When an employee enters "project-1"

  #!Then "project-1" will be created with the name
  #And the system will give it a number "2401" consisting of year and serialnumber
  #And "project-1" is added to the list of projects
