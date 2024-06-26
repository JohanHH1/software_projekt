package example.cucumber;
import dtu.timeregistering.app.TimeApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;

public class ProjectSteps {
    // Fields
    private TimeApp timeApp;
    private String errorMessage;

    // Constructor
    public ProjectSteps(TimeApp timeApp) {
        this.timeApp = timeApp;
    }
    //----------------------------------------------------------------------------------------------------
    // Scenarios:

    //----------------------------------------------------------------------------------------------------
    // Scenario 1: Add project successfully:
    @When("{string} does not already exist")
    public void does_not_exist(String projectName) {
        assertFalse(timeApp.isInProjectList(projectName));
    }
    @And("i add the project {string}")
    public void i_add_the_project(String projectName) throws Exception{
        try {
            timeApp.addProject(projectName);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
    }
    @Then("{string} is created")
    public void is_created(String projectName) {
        System.out.println(projectName + " was successfully created");
    }
    @And("a project number is added to project {string}")
    public void aProjectNumberIsAddedToProject(String projectName) {
        assertNotEquals(0, timeApp.getProject(projectName).getProjectNumber());
    }
    //----------------------------------------------------------------------------------------------------
    // Scenario 2: Add project unsuccessfully:
    @Given("project {string} already exists")
    public void already_exists(String projectName) {
        timeApp.addProject(projectName);
    }

    @Then("error message {string} is thrown")
    public void error_message_is_thrown(String em)  {
        assertEquals(em,errorMessage);
    }


    //--------------------------------------------------------------------------------------------
   // display total hours in project
    @When("the user wants to see the total hours spent on a project {string}")
    public void theUserWantsToSeeTheTotalHoursSpentOnAProject(String projectName) {
        timeApp.getProject(projectName);
    }

    @Then("the total hours on project {string} is displayed")
    public void theTotalHoursOnProjectIsDisplayed(String projectName) {
        timeApp.displayTotalHoursOnProject(projectName);
    }


    //----------------------------------------------------------------------------------------------------
}