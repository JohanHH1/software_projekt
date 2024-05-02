Feature: select employee
  Description: an employee is logged in
  Actors: Employee

  Scenario: An employee logs in successfully:
    Given employee "HUBA" already exist
    When I enter the initials "HUBA"
    Then I am logged in as initials "HUBA"

  Scenario: an employee registers hours spent on an activity
    Given employee "HUBA" already exist
    Given project "project-1" already exists
    And the user has an activity "activity1" in project "project-1"
    And employee "HUBA" is assigned to the activity "activity1" in project "project-1"
    When employee "HUBA" enters 10 hours spent on activity "activity1" in project "project-1"
    Then activity "activity1" in project "project-1" is updated with 10 hours spent
    And employee "HUBA" hours worked is updated to 10 hours more

  Scenario: an employee edits hours spent on an activity
    Given employee "HUBA" already exist
    Given project "project-1" already exists
    And the user has an activity "activity1" in project "project-1"
    And employee "HUBA" is assigned to the activity "activity1" in project "project-1"
    When employee "HUBA" enters 10 hours spent on activity "activity1" in project "project-1"
    When employee "HUBA" removes 6 hours spent on activity "activity1" in project "project-1"
    Then activity "activity1" in project "project-1" is updated with 4 hours spent
    And employee "HUBA" hours worked is updated to 4 hours more


  Scenario: Employee registers as unavailable for a specific week
      Given employee "HUBA" already exist
      When employee "HUBA" marks himself unavailable in week 1
      Then employee "HUBA" is unavailable in week 1

  Scenario: Employee registers as unavailable for several weeks
      Given employee "HUBA" already exist
      When employee "HUBA" marks himself unavailable in week 1 to week 7
      Then employee "HUBA" is unavailable in week 1 to week 7



