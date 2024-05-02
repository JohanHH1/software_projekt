Feature: Get Employee Data
  Description: the user getting employee data
  Actors: Employee

  Scenario: An employee with current activities checks employee data:
    Given employee "HUBA" already exist
    And employee "HUBA" has at least one activity in their list of activities
    When I enter the initials "HUBA"
    Then employee "HUBA" information in project "project-1"  is displayed

  Scenario: An Activitys information is displayed:
    Given project "project-1" already exists
    Given the user has an activity "activity1" in project "project-1"
    When I enter activity "activity1" in project "project-1"
    Then activity "activity1" in project  "project-1" information is displayed

