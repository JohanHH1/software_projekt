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
    Then employee "HUBA" total hours worked is displayed
    And employee "HUBA" list of activities is displayed
