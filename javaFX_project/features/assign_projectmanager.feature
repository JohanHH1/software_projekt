Feature: Assign project manager
  Description: Assign project manager to a project
  Actors: Employee

  Scenario: Assign project manager successfully
    Given employee "HUBA" already exist
    When the user assigns initials "HUBA" as project manager
    Then the user initials "HUBA" is project manager

  Scenario: Assign project manager successfully
    Given employee "HUBA" already exist
    Given project "project-1" already exists
    When the user assigns initials "HUBA" as project manager for project "project-1"
    Then the user initials "HUBA" is project manager for project "project-1"