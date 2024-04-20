package example.cucumber;

import dtu.timeregistering.app.TimeApp;
import dtu.timeregistering.domain.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class AddActivity {

    private TimeApp timeApp;
    private Project project;


    public AddActivity(TimeApp timeApp) {
        this.timeApp = timeApp;
    }

    @Then("the user creates {string} in {string}")
    public void the_user_creates_in(String activityName, String projectName) {
        timeApp.createActivity(activityName, timeApp.getProject(projectName));
    }
    @When("{string} exists in {string}")
    public void exists_in(String activityName, String projectName) {
        timeApp.addProject(projectName);
        timeApp.createActivity(activityName, timeApp.getProject(projectName));
        assertTrue(timeApp.isInActivityList(activityName));


    }
    @When("the user sets start week to {int} and end week to {int}")
    public void the_user_sets_start_week_to_and_end_week_to(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user sets the timeframe for {string} to week {int} until week {int}")
    public void the_user_sets_the_timeframe_for_to_week_until_week(String string, Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
