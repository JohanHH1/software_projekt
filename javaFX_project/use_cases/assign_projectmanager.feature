Feature: Assign project manager
  Description: Assign project manager to a project
  Actors: Employee

  Scenario: Assign project manager successfully
    Given employee "HUBA" already exist
    When the user assigns initials "HUBA" as project manager
    Then the user initials "HUBA" is project manager