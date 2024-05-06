Feature: Add or remove employee to activity in a project
  Description: User adds or removes employee to/from activity
  Actors: Employee

# Scenario 1:
Scenario: Add employee to activity
Given employee "HUBA" already exist
Given project "project-1" already exists
And the user has an activity "activity3" in project "project-1"
And the user "HUBA" has less than 20 activities
When employee "HUBA" is added to activity "activity3" in project "project-1"
Then activity "activity3" is added to employee "HUBA" list of activities in project "project-1"
And employee "HUBA" is added to activity "activity3" list of employees in project "project-1"

# Scenario 2:
Scenario: Removing an employee from an activity
Given employee "HUBA" already exist
Given project "project-1" already exists
Given the user has an activity "activity4" in project "project-1"
And employee "HUBA" is assigned to activity "activity4" in project "project-1"
When employee "HUBA" is removed from activity "activity4" in project "project-1"
Then the employee "HUBA" should be removed from activity "activity4" in project "project-1" successfully


