Feature: Create an activity in a project
  Description: User creates an activity in a project
  Actors: Employee

 Scenario: Create activity successfully
   When "project-1" already exists
   Then the user creates "activity1" in "project-1"

