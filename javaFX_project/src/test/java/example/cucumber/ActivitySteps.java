package example.cucumber;

import dtu.timeregistering.app.TimeApp;
import dtu.timeregistering.domain.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class ActivitySteps {
    // Fields
    private TimeApp timeApp;
    private Project project;

    // Constructor
    public ActivitySteps(TimeApp timeApp) {
        this.timeApp = timeApp;
    }
    //----------------------------------------------------------------------------------------------------
    // Scenarios:

    // Den samme @Given bruges i alle 4 scenarios
    @Given("the user has an activity {string} in project {string}")
    public void theUserHasAnActivityInProject(String activityName, String projectName) {
        try {
            timeApp.createActivity(activityName, projectName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //----------------------------------------------------------------------------------------------------
    // Scenario 1: Create activity successfully
    @When("the user creates {string} in {string}")
    public void the_user_creates_in(String activityName, String projectName) throws Exception {
        timeApp.createActivity(activityName, projectName);

    }

    @Then("the user has activity {string} in project {string}")
    public void theUserHasActivityInProject(String activityName, String projectName) throws Exception {
        assertTrue(timeApp.isInActivityList(activityName, projectName));
    }

    //----------------------------------------------------------------------------------------------------
    // Scenario 2: Add time-frame to activity successfully
    @When("the user sets Activity {string} in project {string} to start week to {int} and end week to {int}")
    public void the_user_sets_start_week_to_and_end_week_to(String activityName, String projectName, Integer startWeek, Integer endWeek) {
        try {
            timeApp.setTimeFrame(activityName, projectName, startWeek, endWeek);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the user sets the timeframe for activity {string} in project {string} to week {int} until week {int}")
    public void the_user_sets_the_timeframe_for_activity_to_week_until_week(String activityName, String projectName, Integer startWeek, Integer endWeek) {
        assertTrue(timeApp.getProject(projectName).hasTimeFrame(timeApp.getProject(projectName).getActivity(activityName)));
    }

    //----------------------------------------------------------------------------------------------------
    // Scenario 3: Add employee to activity
    @Given("the user {string} has less than {int} activities")
    public void the_user_has_less_than_activities(String initials, Integer maxNumberOfActivities) {
        assertTrue(timeApp.getEmployee(initials).getMyActivityList().size()<maxNumberOfActivities);
    }
    @When("employee {string} is added to activity {string} in project {string}")
    public void employeeIsAddedToActivityInProject(String initials, String activityName, String projectName) {
        timeApp.initializeEmployees();
        timeApp.addEmployeeToActivity(activityName, initials, projectName);
    }

    @Then("activity {string} is added to employee {string} list of activities in project {string}")
    public void activity_is_added_to_employee_list_of_activities_in_project(String activityName, String initials, String projectName) {
        assertTrue(timeApp.isInEmployeesListOfActivities(activityName, initials, projectName));
    }

    @Then("employee {string} is added to activity {string} list of employees in project {string}")
    public void employee_is_added_to_activity_list_of_employees_in_project(String initials, String activityName, String projectName) {
        assertTrue(timeApp.isInActivityListOfEmployees(activityName, initials, projectName));
    }

    //----------------------------------------------------------------------------------------------------
    // Scenario 4: remove employee from activity

    @And("employee {string} is assigned to activity {string} in project {string}")
    public void employeeIsAssignedToActivityInProject(String initials, String activityName, String projectName) {
        timeApp.initializeEmployees();
        timeApp.addEmployeeToActivity(activityName, initials, projectName);

    }

    @When("employee {string} is removed from activity {string} in project {string}")
    public void employeeIsRemovedFromActivityInProject(String initials, String activityName, String projectName) {
        timeApp.removeEmployeeFromActivity(initials, activityName,projectName);

    }

    @Then("the employee {string} should be removed from activity {string} in project {string} successfully")
    public void theEmployeeShouldBeRemovedFromActivityInProjectSuccessfully(String initials, String activityName, String projectName) {
        assertFalse(timeApp.isInActivityListOfEmployees(activityName, initials, projectName ));
    }
    //----------------------------------------------------------------------------------------------------
    // Scenario 1 in time feature - add budgeted hours to activity

    @When("the user adds {int} budgeted hour to activity {string} in project {string}")
    public void the_user_adds_budgeted_hour_to_activity_in_project(Integer budgetedHours, String activityName, String projectName) {
        timeApp.setBudgetedHoursForActivity(budgetedHours, activityName, projectName);
    }
    @Then("activity {string} in project {string} has {int} budgeted hour")
    public void activity_in_project_has_budgeted_hour(String activityName, String projectName, Integer budgetedHours) {
        assertEquals(timeApp.getProject(projectName).getActivity(activityName).getBudgetedHours(), (int) budgetedHours);
    }

}
    //----------------------------------------------------------------------------------------------------
