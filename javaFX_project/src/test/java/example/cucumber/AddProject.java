package example.cucumber;
import dtu.timeregistering.app.TimeApp;
import dtu.timeregistering.domain.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class AddProject {
    private TimeApp timeApp;



    public AddProject(TimeApp timeApp) {
        this.timeApp = timeApp;
    }

    @When("{string} does not already exist")
    public void does_not_exist(String projectName) {
        timeApp.isIn(projectName);
    }
    @And("i add the project {string}")
    public void i_add_the_project(String projectName) {
        timeApp.addProject(projectName);
    }

    @Then("{string} is created")
    public void is_created(String projectName) {
        System.out.println(projectName + " was successfully created");
    }
}
