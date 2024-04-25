package dtu.timeregistering.ui;
import dtu.timeregistering.app.TimeApp;
import dtu.timeregistering.domain.Employee;
import dtu.timeregistering.domain.Project;

import java.util.*;
import java.io.*;
public class Start {
    TimeApp timeapp = new TimeApp();

    // MAIN
    public static void main(String[] args) throws Exception {
        new Start().start();
    }

    public void start() throws Exception {
        // Fields:
        int nr;
        int startWeek;
        int endWeek;
        String employeeToAdd;
        String chosenProject;
        String activityName;
        String chosenEmployee;
        // Scanner
        Scanner console = new Scanner(System.in);

        // Program Starting
        timeapp.initializeEmployees();

        // Log In
        System.out.println("Chose an employee to login as:");
        timeapp.displayAllEmployees();
        chosenEmployee = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
        timeapp.logIn(chosenEmployee);
        System.out.println("Welcome " + chosenEmployee + "!");

        // List of Actions
        do {
            System.out.println("Please enter the corresponding number to pick the action");
            System.out.println("0. Exit program");
            System.out.println("1. Create project");
            System.out.println("2. Create activity in project");
            System.out.println("3. Set timeframe for activity");
            System.out.println("4. Assign Employee to activity");
            System.out.println("5. Assign Employee to project");
            System.out.println("6. Assign a project manager");
            nr = timeapp.getInt(console,"Enter a number from the list above: ", 0, 10);
            console.nextLine();

            // 1. Create project
            if (nr == 1) {
                System.out.println("To create a new project, please enter project name: ");
                String projectName = console.nextLine();
                    try {
                        timeapp.addProject(projectName);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                System.out.println("Project " + projectName + " was created successfully!");
                System.out.println("List of all current projects: ");
                timeapp.displayAllProjectNames();
                System.out.println();
            }
            // 2. Create activity in project
            if (nr == 2) {
                System.out.println("\nChoose a project to add activity to: ");
                System.out.println("List of all current projects: ");
                timeapp.displayAllProjectNames();
                chosenProject = timeapp.getValidProjectName(console,"Enter a valid project name: ");
                console.nextLine(); // (Skal være her for at det virker, men gør i princippet ingenting)
                System.out.println("To create new activity, please enter activity name: ");
                activityName = console.nextLine();
                timeapp.createActivity(activityName, chosenProject);
                System.out.println("The activity " + activityName + " was successfully created!");
                System.out.println("Here is a list of all current activities in project " + chosenProject + ": ");
                timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
                System.out.println();
            }
            // 3. Set timeframe for activity
            if (nr == 3){
                System.out.println("\nTo add timeframe, first chose a project.");
                System.out.println("List of all current projects: ");
                timeapp.displayAllProjectNames();
                chosenProject = timeapp.getValidProjectName(console,"Enter a valid project name: ");
                System.out.println("You have chosen project " + chosenProject + ".");
                System.out.println("Which activity would you like to add timeframe to?");
                timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
                activityName = timeapp.getValidActivityName(console,"Enter a valid acvivity name: ", chosenProject);
                System.out.println("Start week for activity " + activityName + ": ");
                startWeek = timeapp.getInt(console, "Enter a valid week number: ", 1, 52);
                System.out.println("End week for activity " + activityName + ": ");
                endWeek = timeapp.getInt(console, "Enter a valid week number: ", 1, 52);
                timeapp.setTimeFrame(activityName,chosenProject, startWeek, endWeek);
                System.out.println("Timeframe has successfully been added to activity " + activityName + " in project " + chosenProject);
                System.out.println("Start week: " + startWeek + ", End week: " + endWeek);
                System.out.println();
            }
            // 4. Assign Employee to activity
            if (nr == 4) {
                System.out.println("\nTo assign an employee to activity, first choose a project: ");
                System.out.println("List of all current projects: ");
                timeapp.displayAllProjectNames();
                chosenProject = timeapp.getValidProjectName(console,"Enter a valid project name: ");
                System.out.println("You have chosen project " + chosenProject + ".");
                System.out.println("Which activity do you wish to assign an employee to: ");
                System.out.println("List of all current activities in project " + chosenProject + ": ");
                timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
                activityName = timeapp.getValidActivityName(console,"Enter a valid acvivity name: ", chosenProject);
                System.out.println("Chose an employee to add to activity " + activityName + ": ");
                System.out.println("List of all employees: ");
                timeapp.displayAllEmployees();
                employeeToAdd = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
                timeapp.addEmployeeToActivity(activityName,employeeToAdd,chosenProject);
                System.out.println("Employee " + employeeToAdd + " was successfully added to activity " + activityName + " in project " + chosenProject);
                System.out.println(employeeToAdd + " is now assigned to current activities: ");
                timeapp.displayMyActivityList(employeeToAdd);
                System.out.println();
            }
            // 5. Assign Employee to project
            if (nr == 5) {
                System.out.println("\nWhich project do you wish to assign an employee to?");
                System.out.println("List of all current projects: ");
                timeapp.displayAllProjectNames();
                chosenProject = timeapp.getValidProjectName(console,"Enter a valid project name: ");
                System.out.println("Chose an employee to assign to project " + chosenProject + ": ");
                System.out.println("List of all employees: ");
                timeapp.displayAllEmployees();
                employeeToAdd = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
                timeapp.addEmployeeToProject(employeeToAdd,chosenProject);
                System.out.println("Employee" + employeeToAdd + " was successfully added to project " + chosenProject);
                System.out.println(employeeToAdd + " is now assigned to these current projects: ");
                timeapp.displayMyProjectList(employeeToAdd);
                System.out.println();
            }
            // 6. Assign a project manager
            if (nr == 6) {
                System.out.println("\nPlease choose an employee to assign as project manager: ");
                System.out.println("List of all employees: ");
                timeapp.displayAllEmployees();
                chosenEmployee = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
                timeapp.assignProjectmanager(chosenEmployee);
                System.out.println(chosenEmployee + " has succesfully been assigned as project manager ");
                System.out.println();
            }
        } while(nr!=0);
        System.out.println("Exiting program as per your request");
    }
}