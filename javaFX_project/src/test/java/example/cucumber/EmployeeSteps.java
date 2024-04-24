package example.cucumber;

import dtu.timeregistering.app.TimeApp;
import dtu.timeregistering.domain.Project;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class EmployeeSteps {
    private TimeApp timeapp;
    private String errorMessage;

    public EmployeeSteps(TimeApp timeApp) {
        this.timeapp = timeApp;
    }

        @Given("employee {string} already exist")
        public void employee_already_exist (String initials){
            timeapp.initializeEmployees();
        }
        @When("I enter the initials {string}")
        public void i_enter_the_initials (String initials){
            timeapp.logIn(initials);
        }
        @Then("I am logged in as initials {string}")
        public void i_am_logged_in_as_initials (String initials){
            assertTrue(timeapp.isLoggedIn(initials));
        }




        @When("the user assigns initials {string} as project manager")
        public void the_user_assigns_initials_as_project_manager(String initials){
            timeapp.assignProjectmanager(initials);
        }
        @Then("the user initials {string} is project manager")
            public void the_user_initials_is_project_manager(String initials) {
            assertTrue(timeapp.isProjectManager(initials));
    }
    }
