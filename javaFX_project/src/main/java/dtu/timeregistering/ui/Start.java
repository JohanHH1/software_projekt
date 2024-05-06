package dtu.timeregistering.ui;
import dtu.timeregistering.app.TimeApp;
import dtu.timeregistering.domain.Employee;

import java.util.*;
//___________________________________________________________________________________________________________________________//
// STRUKTUR IN START CLASS
//1 create project
//2 select project
    //2.1 Register hours
    //2.2 See activity data
    //2.3 select project manager
//3 My profile
    //3.1 see employee data
    //3.2 register unavailable
    //3.3 remove hours
//4 project Manager actions
    //4.1 create activities
    //4.2 manage activity
        //4.2.1 add timeframe
        //4.2.2 see available employees
        //4.2.3 assign employee to activity
        //4.2.4 set budgeted hours on activities
        //4.2.5 remove employee from activity
    //4.3 get hours spent on project
    //4.4 see selected employees data
//________________________________________________________________________________________________________________________//
public class Start {
    TimeApp timeapp = new TimeApp();

    // MAIN
    public static void main(String[] args) throws Exception {
        new Start().start();
    }

    public void start() throws Exception {
        // Fields:
        int nr;
        int nr2;
        int nr3;
        int unavailableWeek;
        int startWeek;
        int endWeek;
        float hoursWorked;
        int budgetHours;
        String employeeToAdd;
        String chosenProject;
        String activityName;
        String chosenEmployee;
        String loggedInEmployee;
        // Scanner
        Scanner console = new Scanner(System.in);

        // Program Starting
        timeapp.initializeEmployees();
        timeapp.initializeProjectsAndActivities();

        // Log In
        System.out.println("Chose an employee to login as:");
        timeapp.displayAllEmployees();
        chosenEmployee = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
        timeapp.logIn(chosenEmployee);
        loggedInEmployee = chosenEmployee;
        chosenEmployee =chosenEmployee.toUpperCase();
        System.out.println("Welcome " + chosenEmployee + "!");
        System.out.println("\nPlease enter the corresponding number to pick the action");

        // List of Actions
        do {
            System.out.println("Main menu: ");
            System.out.println("0. Exit program");
            System.out.println("1. Create a project");
            System.out.println("2. Select a project");
            System.out.println("3. My profile");
            System.out.println("4. Project manager actions");
            nr = timeapp.getInt(console,"Enter a number from the list above: ", 0, 4);
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
                System.out.println("project number is: " + timeapp.getProject(projectName).getProjectNumber());
                System.out.println("List of all current projects: ");
                timeapp.displayAllProjectNames();
                System.out.println();
            }
            if (nr == 2) {  // 2. Select a project
                if (timeapp.isEmptyProjectList()){
                    System.out.println("There is currently no projects to chose from. Create a project first.");
                }
                else {
                    System.out.println("\nChoose a project: ");
                    System.out.println("List of all current projects: ");
                    timeapp.displayAllProjectNames();
                    chosenProject = timeapp.getValidProjectName(console,"Enter a valid project name: ");
                    console.nextLine();
                    do {
                        System.out.println("\nProject management menu for project: " + chosenProject +": "+ timeapp.getProject(chosenProject).getProjectNumber());
                        System.out.println("0. To go back to main menu");
                        System.out.println("1. Register hours");
                        System.out.println("2. See activity data");
                        if ((!timeapp.projectHasProjectManager(chosenProject))){   // if no manager
                            System.out.println("3. Select a project manager");
                        }
                        nr2 = timeapp.getInt(console,"Enter a number from the list above: ", 0, 3);
                        console.nextLine();
                        if (nr2 == 1) { // 2.1 Register hours
                            if (timeapp.isEmptyActivityList(chosenProject)) {
                                System.out.println("There are currently no activities in project " + chosenProject + ".");
                            }
                            else {
                                System.out.println("Choose an activity: ");
                                timeapp.displayAllActivitiesInProject(chosenProject);
                                activityName = timeapp.getValidActivityName(console, "Enter a valid activity name: ", chosenProject);
                                System.out.println("Please enter hours worked on activity " + activityName);
                                hoursWorked = timeapp.getFloat(console,"Please enter the amount of hours worked: ");
                                console.nextLine();
                                timeapp.addHoursToActivityAndEmployee(activityName, chosenEmployee, chosenProject, hoursWorked);
                                System.out.println(hoursWorked + " hours added to activity " + activityName + " in project " + chosenProject);
                                System.out.println(hoursWorked + " hours added to " + chosenEmployee + " worked hours");
                                System.out.println("Your total hours worked are: " + timeapp.employeeHoursWorked(chosenEmployee));
                            }
                        }
                        if (nr2 == 2){ // 2.2 See Activity data
                            if (timeapp.isEmptyActivityList(chosenProject)) {    // If no activities in chosenProject
                                System.out.println("There are currently no activities in project " + chosenProject + ".");
                            }
                            else{   // If there is an activity in chosenProject
                                System.out.println("Choose an activity: ");
                                timeapp.displayAllActivitiesInProject(chosenProject);
                                activityName = timeapp.getValidActivityName(console,"Enter a valid activity name: ", chosenProject);
                                timeapp.displayActivityInformation(activityName, chosenProject);
                            }
                        }
                        if (!timeapp.projectHasProjectManager(chosenProject)){
                            if (nr2 == 3){ // 2.3 Select a projectManager
                                System.out.println("\nPlease choose an employee to assign as project manager: ");
                                System.out.println("List of all employees: ");
                                timeapp.displayAllEmployees();
                                employeeToAdd = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
                                employeeToAdd = employeeToAdd.toUpperCase();
                                timeapp.assignProjectmanager(employeeToAdd);
                                timeapp.setHasProjectManager(chosenProject,true);
                                System.out.println(employeeToAdd + " has successfully been assigned as project manager ");
                            }
                        }

                    } while (nr2 !=0); // Back to main menu
                }
            }
            // 3. My profile
            if (nr == 3){
                do{
                    System.out.println("\nMy profile menu:");
                    System.out.println("0. To go back to main menu");
                    System.out.println("1. Display my information");
                    System.out.println("2. Register unavailable");
                    System.out.println("3. Remove hours");
                    nr2 = timeapp.getInt(console,"Enter a number from the list above: ", 0, 5);
                    if (nr2 == 1){ // 3.1 Display my information
                        System.out.println(chosenEmployee + "'s informations are: ");
                        timeapp.displayAllMyInformation(chosenEmployee);
                    }
                    if (nr2 == 2) { // 3.2 Register unavailable
                        do {
                            System.out.println("\nChoose one of the options below :");
                            System.out.println("0. Go back to My profile menu:");
                            System.out.println("1. Register unavailable for a single week:");
                            System.out.println("2. Register unavailable for multiple weeks:");
                            nr3 = timeapp.getInt(console, "Enter a number from the list above: ", 0, 2);
                            if (nr3 == 1) {
                                System.out.println("Please enter week of your unavailability:");
                                unavailableWeek = timeapp.getInt(console, "Please enter a valid week.", 1, 1000);
                                timeapp.markEmployeeUnavailableSingleWeek(chosenEmployee, unavailableWeek);
                                System.out.println("You have successfully been marked unavailable in week " + unavailableWeek);
                            }
                            if (nr3 == 2) {
                                System.out.println("Please enter start week of your unavailability:");
                                startWeek = timeapp.getInt(console, "Please enter a valid week.", 1, 1000);
                                System.out.println("Please enter end week of your unavailability:");
                                endWeek = timeapp.getInt(console, "Please enter larger week number than the start week.", startWeek+1, 1000);
                                timeapp.markEmployeeUnavailableSeveralWeeks(chosenEmployee, startWeek, endWeek);
                                System.out.println("You have successfully been marked unavailable from week " + startWeek + " till week " + endWeek);
                            }
                        } while (nr3 != 0);
                    }
                    if (nr2 == 3){ // 3.3 remove hours
                        System.out.println("\nChoose a project: ");
                        System.out.println("List of all current projects: ");
                        timeapp.displayAllProjectNames();
                        chosenProject = timeapp.getValidProjectName(console,"Enter a valid project name: ");
                        console.nextLine();
                        if (timeapp.isEmptyActivityList(chosenProject)) {    // If no activities in chosenProject
                            System.out.println("There are currently no activities in project " + chosenProject + ".");
                        }
                        else {   // If there is an activity in chosenProject
                            System.out.println("Choose an activity to remove hours from: ");
                            timeapp.displayAllActivitiesInProject(chosenProject);
                            activityName = timeapp.getValidActivityName(console, "Enter a valid activity name: ", chosenProject);
                            System.out.println("Please enter the amount of hours you wish to remove: ");
                            hoursWorked = timeapp.getFloat(console, "Please enter the amount of hours you wish to remove: ");
                            console.nextLine();
                            timeapp.removeHoursInActiivtyAndEmployee(activityName, chosenEmployee, chosenProject, hoursWorked);
                            System.out.println(hoursWorked + " hours removed from activity " + activityName + " in project " + chosenProject);
                            System.out.println(hoursWorked + " hours removed from " + chosenEmployee + " worked hours");
                            System.out.println("Your total hours worked are: " + timeapp.employeeHoursWorked(chosenEmployee));
                        }
                    }
                } while(nr2 !=0); // Back to main menu
            }
            // 4. Project manager actions
            if (nr == 4){ // 4. Project manager settings
                System.out.println("Please pick a project to continue with ");
                System.out.println("List of all projects: ");
                timeapp.displayAllProjectNames();
                chosenProject = timeapp.getValidProjectName(console,"Enter a valid project name: ");
                if (!timeapp.isProjectManager(loggedInEmployee) && (timeapp.projectHasProjectManager(chosenProject))) {
                    System.out.println(loggedInEmployee + ", You do not have access to project manager settings.");
                    System.out.println("You are now being sent back to main menu.");
                } else{
                    do{ // choose a project to manage if more than one:
                        System.out.println("\nProject manager settings for project " + chosenProject + ": "+ timeapp.getProject(chosenProject).getProjectNumber());
                        System.out.println("0. Go back to main menu");
                        System.out.println("1. Create an activity");
                        System.out.println("2. Manage activity");
                        System.out.println("3. Get hours spent on project");
                        System.out.println("4. See employee data");
                        nr2 = timeapp.getInt(console,"Enter a number from the list above: ", 0, 5);
                        console.nextLine();
                        if (nr2 == 1){ // 4.1 Create activity
                            timeapp.displayLisOfManagersListOfProjects(chosenEmployee);
                            System.out.println("To create new activity, please enter activity name: ");
                            activityName = console.nextLine();
                            timeapp.createActivity(activityName, chosenProject);
                            System.out.println("Here is a list of all current activities in project " + chosenProject + ": ");
                            timeapp.displayAllActivitiesInProject(chosenProject);
                            System.out.println();
                        }
                        if (nr2 == 2) { //4.2 Manage activity
                            if (timeapp.isEmptyActivityList(chosenProject)) {
                                System.out.println("There are currently no activities in project " + chosenProject + ".");
                            }
                            else {
                                System.out.println("Which activity would you like to manage?");
                                timeapp.displayAllActivitiesInProject(chosenProject);
                                activityName = timeapp.getValidActivityName(console, "Enter a valid activity name: ", chosenProject);
                                do {
                                    System.out.println("\nManage activities menu for activity " + activityName);
                                    System.out.println("0. To go back to project manager settings menu");
                                    System.out.println("1. Add timeframe to activity");
                                    System.out.println("2. See available employees in chosen period");
                                    System.out.println("3. Assign employee to activity");
                                    System.out.println("4. Set budgeted hours on activities");
                                    System.out.println("5. Remove employee from activity");
                                    nr3 = timeapp.getInt(console, "Enter a number from the list above: ", 0, 5);
                                    if (nr3 == 1) {//4.2.1 add timeframe to activity
                                        System.out.println("Start week for activity " + activityName + ": ");
                                        startWeek = timeapp.getInt(console, "Enter a valid week number: ", 1, 1000);
                                        System.out.println("End week for activity " + activityName + ": ");
                                        endWeek = timeapp.getInt(console, "Enter a valid week number: ", startWeek+1, 1000);
                                        timeapp.setTimeFrame(activityName, chosenProject, startWeek, endWeek);
                                        System.out.println("Timeframe has successfully been added to activity " + activityName + " in project " + chosenProject);
                                        System.out.println("Start week: " + startWeek + ", End week: " + endWeek);
                                    }
                                    if (nr3 == 2) {// 4.2.2  See available employees in chosen period
                                        System.out.println("Enter the start week for the availability check");
                                        startWeek = timeapp.getInt(console, "Enter a valid week number: ", 1, 1000);
                                        System.out.println("Enter the end week for the availability check");
                                        endWeek = timeapp.getInt(console, "Enter a valid week number: ", startWeek+1, 1000);
                                        timeapp.displayListOfAvailableEmployees(startWeek, endWeek);
                                    }
                                    if (nr3 == 3) {// 4.2.3 assign employee to activity
                                        int i = 0;
                                        for (Employee employee : timeapp.getListOfEmployees()){
                                            if (timeapp.getProject(chosenProject).getActivity(activityName).getListOfEmployeesInActivity().contains(employee)) {
                                                i++;
                                            }}
                                        if (i < timeapp.getListOfEmployees().size()) {
                                            do {
                                                System.out.println("Chose an employee to add to activity " + activityName + ": ");
                                                System.out.println("List of all employees not in the Activity: ");
                                                timeapp.displayEmployeesNotInActivity(activityName, chosenProject);
                                                employeeToAdd = timeapp.getValidEmployeeName(console, "Enter an employee in the project: ");
                                                employeeToAdd = employeeToAdd.toUpperCase();
                                            } while (timeapp.isInActivityListOfEmployees(activityName, employeeToAdd, chosenProject));
                                            timeapp.addEmployeeToActivity(activityName, employeeToAdd, chosenProject);
                                        } else{
                                            System.out.println("All employees are already working on the activity " + activityName);
                                        }
                                    }

                                    if (nr3 == 4) {//4.2.4 set budgeted hours in activity
                                        System.out.println("Enter the hours budgeted for this activity:");
                                        budgetHours = timeapp.getInt(console, "Enter a valid number: ", 1, 10000);
                                        timeapp.setBudgetedHoursForActivity(budgetHours ,activityName, chosenProject);
                                        System.out.println("Hours budgeted for activity " + activityName + " is: " + budgetHours);
                                    }
                                    if (nr3 == 5) {//4.2.5 remove employee from activities
                                        if(!timeapp.getProject(chosenProject).getActivity(activityName).getListOfEmployeesInActivity().isEmpty()) {
                                            do {
                                                System.out.println("Chose an employee to remove from activity " + activityName + ": ");
                                                System.out.println("List of employees in activity: ");
                                                timeapp.displayListOfEmployeesInActivity(activityName, chosenProject);
                                                employeeToAdd = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
                                                employeeToAdd = employeeToAdd.toUpperCase();
                                            } while (!timeapp.isInActivityListOfEmployees(activityName, employeeToAdd, chosenProject));
                                            timeapp.removeEmployeeFromActivity(employeeToAdd, activityName, chosenProject);
                                            System.out.println("Employee " + employeeToAdd + " was successfully removed from activity " + activityName + " in project " + chosenProject);
                                        }
                                        else{
                                            System.out.println("No employees are working on the activity " + activityName);
                                        }
                                    }
                                } while (nr3 != 0);
                            }
                        }
                        if (nr2 == 3){ //4.3 Get hours spent on project (total hours on activities)
                            System.out.println("The total hours spent on project " + chosenProject + " is :");
                            timeapp.displayTotalHoursOnProject(chosenProject);
                        }
                        if (nr2 == 4){ //4.4 See employee data
                            System.out.println("Chose an employee: ");
                            System.out.println("List of all employees: ");
                            timeapp.displayAllEmployees();
                            employeeToAdd = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
                            employeeToAdd=employeeToAdd.toUpperCase();
                            timeapp.displayAllMyInformation(employeeToAdd);
                        }
                    } while(nr2 !=0); // Back to main menu
                }
            }
        } while(nr!=0);
        System.out.println("Exiting program as per your request");
    }
}