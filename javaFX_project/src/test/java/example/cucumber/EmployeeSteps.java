package example.cucumber;

import dtu.timeregistering.app.TimeApp;
import dtu.timeregistering.domain.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class EmployeeSteps {
    // Fields
    private TimeApp timeapp;
    private String errorMessage;

    // Constructor
    public EmployeeSteps(TimeApp timeApp) {
        this.timeapp = timeApp;
    }
    //----------------------------------------------------------------------------------------------------
    // Scenarios:
    // Given bruges i begge 2 scenarios
    @Given("employee {string} already exist")
    public void employee_already_exist (String initials){
        timeapp.initializeEmployees();
    }
    //----------------------------------------------------------------------------------------------------
    // Feature: select employee,  Scenario: An employee logs in successfully:
    @When("I enter the initials {string}")
    public void i_enter_the_initials (String initials){
        timeapp.logIn(initials);
    }
    @Then("I am logged in as initials {string}")
    public void i_am_logged_in_as_initials (String initials){
        assertTrue(timeapp.isLoggedIn(initials));
    }

    //----------------------------------------------------------------------------------------------------
    // Feature: Assign project manager,  Scenario: Assign project manager successfully
    @When("the user assigns initials {string} as project manager")
    public void the_user_assigns_initials_as_project_manager(String initials){
        timeapp.assignProjectmanager(initials);
    }
    @Then("the user initials {string} is project manager")
        public void the_user_initials_is_project_manager(String initials) {
        assertTrue(timeapp.isProjectManager(initials));
    }
    //----------------------------------------------------------------------------------------------------
    //Feature: employees,      Scenario: employee registers hours
    @Given("employee {string} is assigned to the activity {string} in project {string}")
    public void employee_is_assigned_to_the_activity_in_project(String initials, String activityName, String projectName) {
        timeapp.addEmployeeToActivity(activityName,initials,projectName);
    }

    @When("employee {string} enters {int} hours spent on activity {string} in project {string}")
    public void employeeEntersHoursSpentOnActivityInProject(String initials, int hours, String activityName, String projectName) {
        timeapp.addHoursToActivityAndEmployee(activityName,initials,projectName,hours);
    }

    @Then("activity {string} in project {string} is updated with {int} hours spent")
    public void activityInProjectIsUpdatedWithHoursSpent(String activityName, String projectName, int hours) {
        assertTrue(timeapp.getProject(projectName).getActivity(activityName).getHoursSpentOnActivity()==hours);
    }

    @And("employee {string} hours worked is updated to {int} hours more")
    public void employeeHoursWorkedIsUpdatedToHoursMore(String initials, int hours) {
        assertTrue(timeapp.getEmployee(initials).getHoursWorked()==hours);
    }

    @When("employee {string} marks himself unavailable in week {int}")
    public void employee_marks_himself_unavailable_in_week(String initials, Integer unavailableWeek) {
        timeapp.markEmployeeUnavailableSingleWeek(initials,unavailableWeek);

    }
    @Then("employee {string} is unavailable in week {int}")
    public void employee_is_unavailable_in_week(String initials, Integer unavailableWeek) {
        assertTrue(timeapp.getEmployee(initials).getUnavailableWeeks().contains(unavailableWeek));
    }
    @When("employee {string} marks himself unavailable in week {int} to week {int}")
    public void employee_marks_himself_unavailable_in_week_to_week(String initials, Integer startWeekUnavailable, Integer endWeekUnavailable) {
        timeapp.markEmployeeUnavailableSeveralWeeks(initials, startWeekUnavailable, endWeekUnavailable);
    }
    @Then("employee {string} is unavailable in week {int} to week {int}")
    public void employee_is_unavailable_in_week_to_week(String initials, Integer startWeekUnavailable, Integer endWeekUnavailable) {
       for (int i = startWeekUnavailable; i <= endWeekUnavailable; i++) {
           assertTrue(timeapp.getEmployee(initials).getUnavailableWeeks().contains(i));
       }

    }
}
