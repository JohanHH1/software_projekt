package example.cucumber;
import dtu.timeregistering.app.MainPage;
import dtu.timeregistering.app.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class AddProject {
    private MainPage mainpage;
    private ArrayList<String> listOfProjects;
    @When("i add the project {string}")
    public void i_add_the_project(String projectName) {
        mainpage.addProject(projectName);
    }
    @When("{string} does not exist")
    public void does_not_exist(String projectName) throws Exception {
        if (listOfProjects.contains(projectName)){
            throw new Exception("A project with this name already exists.");
        } else {
            is_created(projectName);
        }

    }
    @Then("{string} is created")
    public void is_created(String projectName) {
    }
}
