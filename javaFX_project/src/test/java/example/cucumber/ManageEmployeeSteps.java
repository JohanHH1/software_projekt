package example.cucumber;

import dtu.timeregistering.app.TimeApp;
import dtu.timeregistering.domain.Employee;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class ManageEmployeeSteps {
    // Fields
    private TimeApp timeapp;
    private String errorMessage;

    // Constructor
    public ManageEmployeeSteps(TimeApp timeApp) {
        this.timeapp = timeApp;
    }
    //----------------------------------------------------------------------------------------------------
    //Feature: Manage employees
    // Scenario: An employee with no current activities checks employee data:
    // Scenario: An employee with current activities checks employee data:


    @And("employee {string} has at least one activity in their list of activities")
    public void employeeHasAtLeastOneActivityInTheirListOfActivities(String initials) {
        timeapp.initializeEmployees();
        timeapp.initializeProjectsAndActivities();
    }

    @When("I enter initials {string}")
    public void i_enter_initials(String initials){
        Employee employeeToCheck = timeapp.getEmployee(initials);
    }

    @Then("employee {string} information in project {string}  is displayed")
    public void employeeInformationInProjectIsDisplayed(String initials, String projectName) {
        timeapp.displayAllMyInformation(initials);
    }

    @When("I enter activity {string} in project {string}")
    public void iEnterActivityInProject(String activityName, String projectName) {
        timeapp.getProject(projectName).getActivity(activityName);

    }

    @Then("activity {string} in project  {string} information is displayed")
    public void activityInProjectInformationIsDisplayed(String activityName, String projectName) {
        timeapp.displayActivityInformation(activityName,projectName);
    }

    //----------------------------------------------------------------------------------------------------

}
