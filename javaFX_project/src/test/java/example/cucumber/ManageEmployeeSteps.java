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
        timeapp.initializeActivities();
    }

    @When("I enter initials {string}")
    public void i_enter_initials(String initials){
        Employee employeeToCheck = timeapp.getEmployee(initials);
    }

    @Then("employee {string} total hours worked is displayed")
    public void employeeTotalHoursWorkedIsDisplayed(String initials) {
        timeapp.displayMyHoursWorked(initials);
    }
    @And("employee {string} list of activities is displayed")
    public void employeeListOfActivitiesIsDisplayed(String initials) {
        System.out.println("Here is a list of your current activities: ");
        timeapp.displayMyActivityList(initials);
    }



    //----------------------------------------------------------------------------------------------------

}
