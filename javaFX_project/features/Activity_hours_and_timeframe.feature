Feature: Manage timeframe and hours for activities
  Description: User adds timeframes or budgeted hours for activities
  Actors: Employee

# Scenario 1:
  Scenario: set budgeted hours on activity
    Given project "project-1" already exists
    And the user has an activity "activity1" in project "project-1"
    When the user adds 1 budgeted hour to activity "activity1" in project "project-1"
    Then activity "activity1" in project "project-1" has 1 budgeted hour

    # Scenario 2:
  Scenario: Add time-frame to activity successfully
    Given project "project-1" already exists
    Given the user has an activity "activity2" in project "project-1"
    When the user sets Activity "activity2" in project "project-1" to start week to 1 and end week to 2
    Then the user sets the timeframe for activity "activity2" in project "project-1" to week 1 until week 2
