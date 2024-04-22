Feature: Create an activity in a project
  Description: User creates an activity in a project
  Actors: Employee

Scenario: Create activity successfully
  Given project "project-1" already exists
  When the user creates "activity1" in "project-1"
  Then the user has activity "activity1" in project "project-1"
#
#Scenario: Add time-frame to activity successfully
#  Given the user has "activity1" in "project-1"
#  When the user sets start week to 1 and end week to 2
#  Then the user sets the timeframe for "activity1" to week 1 until week 2

