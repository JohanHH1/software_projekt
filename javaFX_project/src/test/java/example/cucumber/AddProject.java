package example.cucumber;
import dtu.timeregistering.app.*;


public class AddProject {
    @When("i add the project {string}")
    public void i_add_the_project(String projectName) {
        addProject(projectName);
    }


    @When("{string} does not exist")
    public void does_not_exist(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("{string} is created")
    public void is_created(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
