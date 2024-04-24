package example.cucumber;

import dtu.timeregistering.app.TimeApp;
import dtu.timeregistering.domain.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class ActivitySteps {

    private TimeApp timeApp;
    private Project project;


    public ActivitySteps(TimeApp timeApp) {
        this.timeApp = timeApp;
    }

    @When("the user creates {string} in {string}")
    public void the_user_creates_in(String activityName, String projectName) {
        try {
            timeApp.createActivity(activityName,projectName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @When("the user sets Activity {string} in project {string} to start week to {int} and end week to {int}")
    public void the_user_sets_start_week_to_and_end_week_to(String activityName, String projectName, Integer startWeek, Integer endWeek) {
        try {
            timeApp.setTimeFrame(activityName, projectName, startWeek, endWeek);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Then("the user sets the timeframe for activity {string} in project {string} to week {int} until week {int}")
    public void the_user_sets_the_timeframe_for_activity_to_week_until_week(String activityName,String projectName, Integer startWeek, Integer endWeek) {
       assertTrue(timeApp.getProject(projectName).hasTimeFrame(timeApp.getProject(projectName).getActivity(activityName)));
    }

    @Given("the user has an activity {string} in project {string}")
    public void theUserHasAnActivityInProject(String activityName, String projectName) {
        try {
            timeApp.createActivity(activityName,projectName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Then("the user has activity {string} in project {string}")
    public void theUserHasActivityInProject(String activityName, String projectName) throws Exception {
        assertTrue(timeApp.isInActivityList(activityName,projectName));
    }


    @When("employee {string} is added to activity {string} in project {string}")
    public void employeeIsAddedToActivityInProject(String initials, String activityName, String projectName) {
        timeApp.initializeEmployees();
        timeApp.addEmployeeToActivity(activityName,initials,projectName);
    }
    @Then("activity {string} is added to employee {string} list of activities in project {string}")
    public void activity_is_added_to_employee_list_of_activities_in_project(String activityName, String initials, String projectName) {
        assertTrue(timeApp.isInEmployeesListOfActivities(activityName,initials,projectName));
    }
    @Then("employee {string} is added to activity {string} list of employees in project {string}")
    public void employee_is_added_to_activity_list_of_employees_in_project(String initials, String activityName, String projectName) {
        assertTrue(timeApp.isInActivityListOfEmployees(activityName,initials,projectName));
    }


}