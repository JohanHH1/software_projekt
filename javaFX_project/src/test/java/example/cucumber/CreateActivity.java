package example.cucumber;
import dtu.timeregistering.app.TimeApp;
import dtu.timeregistering.domain.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;

public class CreateActivity {
    private final TimeApp timeApp;
    private String errorMessage;
    public CreateActivity(TimeApp timeApp) {
        this.timeApp = timeApp;
    }

    @When("{string} does not already exist")
    public void does_not_already_exist(String activityName) {
        assertFalse(timeApp.isIn(activityName));
        //throw new io.cucumber.java.PendingException();
    }

    @And("I add the activity {string}")
    public void i_add_the_activity(String activityName) {
        try { timeApp.addActivity(activityName);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
        //throw new io.cucumber.java.PendingException();
    }

    @Then("{string} is created")
    public void is_created(String activityName) {
    System.out.println("Activity" + activityName + "successfully created");;
       // throw new io.cucumber.java.PendingException();
    }
}
