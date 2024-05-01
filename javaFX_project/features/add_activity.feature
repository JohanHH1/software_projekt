Feature: Create an activity in a project
  Description: User creates an activity in a project
  Actors: Employee

# Scenario 1:
Scenario: Create activity successfully
  Given project "project-1" already exists
  When the user creates "activity1" in "project-1"
  Then the user has activity "activity1" in project "project-1"

# Scenario 2:
Scenario: Add time-frame to activity successfully
  Given project "project-1" already exists
  Given the user has an activity "activity1" in project "project-1"
  When the user sets Activity "activity1" in project "project-1" to start week to 1 and end week to 2
  Then the user sets the timeframe for activity "activity1" in project "project-1" to week 1 until week 2

# Scenario 3:
Scenario: Add employee to activity
  Given employee "HUBA" already exist
  Given project "project-1" already exists
  And the user has an activity "activity1" in project "project-1"
  And the user "HUBA" has less than 20 activities
  When employee "HUBA" is added to activity "activity1" in project "project-1"
  Then activity "activity1" is added to employee "HUBA" list of activities in project "project-1"
  And employee "HUBA" is added to activity "activity1" list of employees in project "project-1"

# Scenario 4:
  Scenario: Removing an employee from an activity
    Given employee "HUBA" already exist
    Given project "project-1" already exists
    Given the user has an activity "activity1" in project "project-1"
    And the user has an activity "activity1" in project "project-1"
    And employee "HUBA" is assigned to activity "activity1" in project "project-1"
    When employee "HUBA" is removed from activity "activity1" in project "project-1"
    Then the employee "HUBA" should be removed from activity "activity1" in project "project-1" successfully


