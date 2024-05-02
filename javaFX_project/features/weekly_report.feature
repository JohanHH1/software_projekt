Feature: Weekly report
  Description: a weekly report is shown with various information about employees and activities
  Actors: Employee


  Scenario: A weekly report is displayed
    When I enter the weekly report "weekly report 1"
    Then the information for a weekly report "weekly report 1" is displayed