package example.cucumber;
import dtu.timeregistering.app.TimeApp;
import dtu.timeregistering.domain.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;

public class AddProject {
    private TimeApp timeApp;
    private String errorMessage;


    public AddProject(TimeApp timeApp) {
        this.timeApp = timeApp;
    }

    @When("{string} does not already exist")
    public void does_not_exist(String projectName) {
        assertFalse(timeApp.isIn(projectName));
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

    @When("{string} already exists")
    public void already_exists(String projectName) {
        timeApp.addProject(projectName);
        assertTrue(timeApp.isIn(projectName));
    }
    @Then("error message {string} is thrown")
    public void error_message_is_thrown(String em)  {
        assertEquals(em,errorMessage);
    }

    @And("I add the activity {string}")
    public void iAddTheActivity(String arg0) {
    }
}
