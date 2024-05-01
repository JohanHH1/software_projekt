Feature: Manage timeframe and hours for activities
  Description: User adds timeframes or budgeted hours for activities
  Actors: Employee

# Scenario 1:
  Scenario: set budgeted hours on activity
    Given project "project-1" already exists
    And the user has an activity "activity1" in project "project-1"
    When the user adds 1 budgeted hour to activity "activity1" in project "project-1"
    Then activity "activity1" in project "project-1" has 1 budgeted hour