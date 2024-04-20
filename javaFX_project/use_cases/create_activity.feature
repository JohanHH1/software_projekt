Feature: Create activity
  Description: A activity is created
  Actors: Employee (or already assigned Project Manager)

  Scenario: Add activity successfully:
    When "activity-1" does not already exist
    And I add the activity "activity-1"
    Then "activity-1" is created