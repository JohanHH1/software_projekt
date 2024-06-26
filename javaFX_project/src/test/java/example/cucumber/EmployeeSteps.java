package example.cucumber;

import dtu.timeregistering.app.TimeApp;
import dtu.timeregistering.domain.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmployeeSteps {
    // Fields
    private TimeApp timeapp;
    private ErrorMessageHolder errorMessage;

    // Constructor
    public EmployeeSteps(TimeApp timeApp, ErrorMessageHolder errorMessage) {
        this.timeapp = timeApp;
        this.errorMessage = errorMessage;
    }

    //----------------------------------------------------------------------------------------------------
    // Scenarios:
    // Given bruges i begge 2 scenarios
    @Given("employee {string} already exist")
    public void employee_already_exist(String initials) {
        timeapp.initializeEmployees();
        assertTrue(timeapp.getListOfEmployees().contains(timeapp.getEmployee(initials)));
    }

    //----------------------------------------------------------------------------------------------------
    // Feature: select employee,  Scenario: An employee logs in successfully:
    @When("I enter the initials {string}")
    public void i_enter_the_initials(String initials) {
        timeapp.logIn(initials);
    }

    @Then("I am logged in as initials {string}")
    public void i_am_logged_in_as_initials(String initials) {
        assertTrue(timeapp.isLoggedIn(initials));
    }

    //----------------------------------------------------------------------------------------------------
    // Feature: Assign project manager,  Scenario: Assign project manager successfully
    @When("the user assigns initials {string} as project manager")
    public void the_user_assigns_initials_as_project_manager(String initials) {
        timeapp.assignProjectmanager(initials);
    }

    @Then("the user initials {string} is project manager")
    public void the_user_initials_is_project_manager(String initials) {
        assertTrue(timeapp.isProjectManager(initials));
    }

    //----------------------------------------------------------------------------------------------------
    //Feature: employees, Scenario: employee registers hours
    @Given("employee {string} is assigned to the activity {string} in project {string}")
    public void employee_is_assigned_to_the_activity_in_project(String initials, String activityName, String projectName) {
        timeapp.addEmployeeToActivity(activityName, initials, projectName);
    }

    @When("employee {string} enters {float} hours spent on activity {string} in project {string}")
    public void employeeEntersHoursSpentOnActivityInProject(String initials, float hours, String activityName, String projectName) {
        timeapp.addHoursToActivityAndEmployee(activityName, initials, projectName, hours);
    }

    @When("employee {string} edits hours spent on activity {string} in project {string} to {float}")
    public void employeeEditsHoursSpentOnActivityInProjectFromTo(String initials, String activityName, String projectName, float updatedHours) {
        timeapp.addHoursToActivityAndEmployee(activityName, initials, projectName, updatedHours);
    }

    @When("employee {string} removes {float} hours spent on activity {string} in project {string}")
    public void employeeRemovesHoursSpentOnActivityInProjectTo(String initials, float updateHours, String activityName, String projectName) {
        timeapp.removeHoursInActiivtyAndEmployee(activityName, initials, projectName, updateHours);
    }


    @Then("activity {string} in project {string} is updated with {float} hours spent")
    public void activityInProjectIsUpdatedWithHoursSpent(String activityName, String projectName, float hours) {
        assertTrue(timeapp.getProject(projectName).getActivity(activityName).getHoursSpentOnActivity() == hours);
    }

    @And("employee {string} hours worked is updated to {float} hours more")
    public void employeeHoursWorkedIsUpdatedToHoursMore(String initials, float hours) {
        assertTrue(timeapp.getEmployee(initials).getHoursWorked() == hours);
    }

    @When("employee {string} marks himself unavailable in week {int}")
    public void employee_marks_himself_unavailable_in_week(String initials, Integer unavailableWeek) {
        timeapp.markEmployeeUnavailableSingleWeek(initials, unavailableWeek);

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

    @When("the user assigns initials {string} as project manager for project {string}")
    public void theUserAssignsInitialsAsProjectManagerForProject(String initials, String projectName) {
        timeapp.assignProjectManagerToProject(initials, projectName);
    }


    @Then("the user initials {string} is project manager for project {string}")
    public void theUserInitialsIsProjectManagerForProject(String initials, String projectName) {
        assertTrue(timeapp.isProjectManagerOnProject(initials, projectName));
    }

    // Feature get available employees successfully
    @Given("there exists an available user {string} from week {int} till week {int}")
    public void there_exists_an_available_user_from_week_till_week(String initials, Integer startWeek, Integer endWeek) {
        timeapp.employeeIsAvailable(initials, startWeek, endWeek);
    }

    @When("the user requests list of available employees from week {int} till week {int}")
    public void the_user_requests_list_of_available_employees_from_week_till_week(Integer startWeek, Integer endWeek) {
        try {
            timeapp.getListOfAvailableEmployees(startWeek, endWeek);
        } catch (Exception e) {
            System.out.println("hello" + e.getMessage());
            errorMessage.setError_message(e.getMessage());
        }
    }

    @Then("the user is given list of available employees in week {int} till week {int} containing at least {string}")
    public void the_user_is_given_list_of_available_employees_in_week_till_week_containing_at_least(Integer startWeek, Integer endWeek, String initials) {
        try {
            assertTrue(timeapp.getListOfAvailableEmployees(startWeek, endWeek).contains(timeapp.getEmployee(initials)));
        } catch (Exception e) {
            errorMessage.setError_message(e.getMessage());
        }
    }
}