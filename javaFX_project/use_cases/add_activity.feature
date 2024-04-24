Feature: Create an activity in a project
  Description: User creates an activity in a project
  Actors: Employee

Scenario: Create activity successfully
  Given project "project-1" already exists
  When the user creates "activity1" in "project-1"
  Then the user has activity "activity1" in project "project-1"

Scenario: Add time-frame to activity successfully
  Given project "project-1" already exists
  Given the user has an activity "activity1" in project "project-1"
  When the user sets Activity "activity1" in project "project-1" to start week to 1 and end week to 2
  Then the user sets the timeframe for activity "activity1" in project "project-1" to week 1 until week 2

  Scenario: Add employee to activity
    Given project "project-1" already exists
    And the user has an activity "activity1" in project "project-1"
    When employee "HUBA" is added to activity "activity1" in project "project-1"
    Then activity "activity1" is added to employee "HUBA" list of activities in project "project-1"
    And employee "HUBA" is added to activity "activity1" list of employees in project "project-1"

