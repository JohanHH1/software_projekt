package example.cucumber;

import dtu.timeregistering.app.TimeApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class AddActivity {

    private TimeApp timeApp;

    public AddActivity(TimeApp timeApp) {
        this.timeApp = timeApp;
    }

    @Then("the user creates {string} in {string}")
    public void the_user_creates_in(String activityName, String projectName) {


    }
}
