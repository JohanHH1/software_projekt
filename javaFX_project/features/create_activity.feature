Feature: Create an activity in a project
  Description: User creates an activity in a project
  Actors: Employee

# Scenario 1:
Scenario: Create activity successfully
  Given project "project-1" already exists
  When the user creates "activity1" in "project-1"
  Then the user has activity "activity1" in project "project-1"

