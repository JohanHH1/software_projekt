Feature: Manage employees
  Description: the user is managing employees
  Actors: Employee

  # 3 manage employees (made)
  # 3.1 see employee data(virker ikke)
  # 3.2 register unavailable(virker ikke)
  # 3.3 assign employee(made)
  # 3.4 register hours(made)
  # 3.5 edit hours(virker ikke

# See employee data

  Scenario: An employee with current activities checks employee data:
    Given employee "HUBA" already exist
    And employee "HUBA" has at least one activity in their list of activities
    When I enter the initials "HUBA"
    Then employee "HUBA" information is displayed

  Scenario: An Activitys information is displayed:
    Given project "project-1" already exists
    Given the user has an activity "activity1" in project "project-1"
    When I enter activity "activity1" in project "project-1"
    Then activity "activity1" in project  "project-1" information is displayed

