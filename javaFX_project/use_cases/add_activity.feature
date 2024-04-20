Feature: Create an activity in a project
  Description: User creates an activity in a project
  Actors: Employee

Scenario: Create activity successfully
  When "project-1" already exists
  Then the user creates "activity1" in "project-1"

Scenario: Add time-frame to activity successfully
  When "activity1" exists in "project-1"
  And the user sets start week to 1 and end week to 2
  Then the user sets the timeframe for "activity1" to week 1 until week 2

