package dtu.timeregistering.ui;
import dtu.timeregistering.app.TimeApp;

import java.util.*;

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
        int startWeek;
        int endWeek;
        int hoursWorked;
        String employeeToAdd;
        String chosenProject;
        String activityName;
        String chosenEmployee;
        String loggedInEmployee;
        // Scanner
        Scanner console = new Scanner(System.in);

        // Program Starting
        timeapp.initializeEmployees();

        // Log In
        System.out.println("Chose an employee to login as:");
        timeapp.displayAllEmployees();
        chosenEmployee = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
        timeapp.logIn(chosenEmployee);
        loggedInEmployee = chosenEmployee;
        System.out.println("Welcome " + chosenEmployee + "!");

        // List of Actions
        do {
            System.out.println("\nPlease enter the corresponding number to pick the action");
            System.out.println("Main menu: ");
            System.out.println("0. Exit program");
            System.out.println("1. Create a project");
            System.out.println("2. Select a project");
            System.out.println("3. Manage employees");
            System.out.println("4. Project manager settings");

            //1 create project(made)
            //2 select project(made)
                //2.1 create activities(made)
                //2.2 manage activity(made)
                    //2.2.1 add timeframe(made)
                    //2.2.2 assign employee(made)
                    //2.2.3 register hours (made)
                //2.3 select project manager (virker ikke endnu)
                //2.4 edit project(virker ikke endnu)
                //(2.5) add employee to project(virker ikke endnu)
            //3 manage employees (made)
                //3.1 see employee data(virker ikke)
                //3.2 register unavailable(virker ikke)
                //3.3 assign employee(made)
                //3.4 register hours(made)
                //3.5 edit hours(virker ikke
            //4 project Manager
                //4.1 available employees(virker ikke)
                //4.2 assign Employees(virker ikke)
                //4.3 get hours spent on project (total hours on activities) (virker ikke)
                //4.4 set budgeted hours on activities(virker ikke)
                //4.5 see employee data(virker ikke)
            //
            nr = timeapp.getInt(console,"Enter a number from the list above: ", 0, 4);
            console.nextLine();

            // Create project
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
            // Select a project
            if (nr == 2) {
                if (timeapp.isEmptyProjectList()){
                    System.out.println("There is currently no projects to chose from. Create a project first.");
                }
                else {
                    System.out.println("\nChoose a project: ");
                    System.out.println("List of all current projects: ");
                    timeapp.displayAllProjectNames();
                    chosenProject = timeapp.getValidProjectName(console,"Enter a valid project name: ");
                    console.nextLine(); // (Skal være her for at det virker, men gør i princippet ingenting)

                    // 2.
                    do {
                        System.out.println("\nProject management menu:");
                        System.out.println("0. To go back to main menu");
                        System.out.println("1. Create a new activity in project");
                        System.out.println("2. Manage an activity");
                        System.out.println("3. Select a projectManager(virker ikke)");
                        System.out.println("4. Edit project(virker ikke)");
                        nr2 = timeapp.getInt(console,"Enter a number from the list above: ", 0, 4);
                        console.nextLine(); // (Skal være her for at det virker, men gør i princippet ingenting)
                        //2.1
                        if (nr2 == 1) { // Create a new activity in project
                            System.out.println("To create new activity, please enter activity name: ");
                            activityName = console.nextLine();

                            timeapp.createActivity(activityName, chosenProject);
                            System.out.println("The activity " + activityName + " was successfully created!");
                            System.out.println("Here is a list of all current activities in project " + chosenProject + ": ");
                            timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
                            System.out.println();
                        }

                        // 2.2
                        if (nr2 == 2){ // Manage an activity
                            if (timeapp.isEmptyActivitylist(chosenProject)) {
                                System.out.println("There are currently no activities in project " + chosenProject + ".");
                            }
                            else{
                            System.out.println("Choose an activity: ");
                            timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
                            activityName = timeapp.getValidActivityName(console,"Enter a valid activity name: ", chosenProject);

                            do{
                                System.out.println("\nActivity management menu:");
                                System.out.println("0. To go back to project management menu");
                                System.out.println("1. Add timeframe to activity");
                                System.out.println("2. Add Employee to activity");
                                System.out.println("3. Register Hours in activity");
                                nr3 = timeapp.getInt(console,"Enter a number from the list above: ", 0, 3);

                                //2.2.1
                                if (nr3 == 1){ // Add timeframe to activity
                                    System.out.println("Start week for activity " + activityName + ": ");
                                    startWeek = timeapp.getInt(console, "Enter a valid week number: ", 1, 52);
                                    System.out.println("End week for activity " + activityName + ": ");
                                    endWeek = timeapp.getInt(console, "Enter a valid week number: ", 1, 52);
                                    timeapp.setTimeFrame(activityName,chosenProject, startWeek, endWeek);
                                    System.out.println("Timeframe has successfully been added to activity " + activityName + " in project " + chosenProject);
                                    System.out.println("Start week: " + startWeek + ", End week: " + endWeek);
                                    System.out.println();
                                }
                                //2.2.2
                                if (nr3 == 2){ // Add Employee to activity
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
                                //2.2.3
                                if (nr3 == 3){ // Register Hours in activity
                                    System.out.println("Please enter hours worked on activity "+activityName);
                                    hoursWorked = console.nextInt();
                                    console.nextLine();
                                    timeapp.addHoursToActivityAndEmployee(activityName, chosenEmployee, chosenProject, hoursWorked);
                                    System.out.println(hoursWorked + " hours added to activity " + activityName + " in project " + chosenProject);
                                    System.out.println(hoursWorked + " hours added to " + chosenEmployee + " worked hours");
                                    System.out.println("Your total hours worked are: "+ timeapp.getEmployee(chosenEmployee).getHoursWorked());
                                }
                            } while(nr3 != 0);// Back to project management menu
                            }
                        }

                        if (nr2 == 3){ // Select a projectManager
                            // Skal laves om
                            System.out.println("\nPlease choose an employee to assign as project manager: ");
                            System.out.println("List of all employees: ");
                            timeapp.displayAllEmployees();
                            chosenEmployee = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
                            timeapp.assignProjectmanager(chosenEmployee);
                            System.out.println(chosenEmployee + " has successfully been assigned as project manager ");
                            System.out.println();
                        }
                        if(nr2 == 4){ // Edit project
                            // edit peoject
                            // ændre activiteter
                            // ændre allerede tilføjet ting
                        }
                        if (nr2 == 5){ // Assign employee to project
                            //assign employee to project
                        }

                    } while (nr2 !=0); // Back to main menu
                }
            }

            if (nr == 3){ // Manage employees
                System.out.println("Chose an employee to manage ");
                System.out.println("List of all employees: ");
                timeapp.displayAllEmployees();
                employeeToAdd = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
                do{
                    System.out.println("\nEmployee management menu:");
                    System.out.println("0. To go back to main menu");
                    System.out.println("1. Display employee details(virker ikke)");
                    System.out.println("2. Register unavailable(virker ikke)");
                    System.out.println("3. Assign employee to activity");
                    System.out.println("4. Register Hours in activity");
                    System.out.println("5. Edit hours(virker ikke)");
                    nr2 = timeapp.getInt(console,"Enter a number from the list above: ", 0, 5);
                    if (nr2 == 1){ // Display employee details


                    }
                    if (nr2 == 2){ // Register unavailable


                    }
                    if (nr2 == 3){ // Assign employee to activity
                        System.out.println("\nTo assign an employee to activity, first choose a project: ");
                        System.out.println("List of all current projects: ");
                        timeapp.displayAllProjectNames();
                        chosenProject = timeapp.getValidProjectName(console,"Enter a valid project name: ");
                        System.out.println("You have chosen project " + chosenProject + ".");
                        System.out.println("Which activity do you wish to assign an employee to: ");
                        System.out.println("List of all current activities in project " + chosenProject + ": ");
                        timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
                        activityName = timeapp.getValidActivityName(console,"Enter a valid activity name: ", chosenProject);
                        timeapp.addEmployeeToActivity(activityName,employeeToAdd,chosenProject);
                        System.out.println("Employee " + employeeToAdd + " was successfully added to activity " + activityName + " in project " + chosenProject);
                        System.out.println(employeeToAdd + " is now assigned to current activities: ");
                        timeapp.displayMyActivityList(employeeToAdd);
                        System.out.println();
                    }
                    if (nr2 == 4){ // Register Hours in activity
                        System.out.println("\nTo add " + employeeToAdd + "s hours, first chose a project.");
                        System.out.println("List of all current projects: ");
                        timeapp.displayAllProjectNames();
                        chosenProject = timeapp.getValidProjectName(console, "Enter a valid project name: ");
                        System.out.println("You have chosen project " + chosenProject + ".");
                        System.out.println("Which activity would you like to add hours worked to?");
                        timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
                        activityName = timeapp.getValidActivityName(console, "Enter a valid activity name: ", chosenProject);
                        System.out.println("Please enter hours worked on activity ");
                        hoursWorked = console.nextInt();
                        console.nextLine();
                        timeapp.addHoursToActivityAndEmployee(activityName, employeeToAdd, chosenProject, hoursWorked);
                        System.out.println(hoursWorked + " hours added to activity " + activityName + " in project " + chosenProject);
                        System.out.println(hoursWorked + " hours added to " + employeeToAdd + " worked hours");
                        System.out.println("Your total hours worked are: "+ timeapp.getEmployee(employeeToAdd).getHoursWorked());
                    }
                    if (nr2 == 5){ // Edit hours

                    }


                } while(nr2 !=0); // Back to main menu

            }

            if (nr == 4){ // Project manager settings
                if (!timeapp.isProjectManager(loggedInEmployee)) {
                    System.out.println(loggedInEmployee + ", You do not have access to project manager settings.");
                    System.out.println("You are now being sent back to main menu.");
                }
                else{
                do{
                    System.out.println("\nProject manager settings: ");
                    System.out.println("0. To go back to main menu");
                    System.out.println("1. Available employees (virker ikke)");
                    System.out.println("2. Assign employees (virker ikke)");
                    System.out.println("3. Get hours spent on project (virker ikke)");
                    System.out.println("4. Set budgeted hours on activities (virker ikke)");
                    System.out.println("5. See employee data (virker ikke)");
                    nr2 = timeapp.getInt(console,"Enter a number from the list above: ", 0, 5);
                    if (nr2 == 1){ // Available employees

                    }
                    if (nr2 == 2){ // Assign employees

                    }
                    if (nr2 == 3){ // Get hours spent on project (total hours on activities)

                    }
                    if (nr2 == 4){ // Set budgeted hours on activities

                    }
                    if (nr2 == 5){ // See employee data

                    }

                } while(nr2 !=0); // Back to main menu
                }
            }

            // gammel kode nedenfor
            // 4. Assign Employee to activity
            if (nr == 99) {
                System.out.println("\nTo assign an employee to activity, first choose a project: ");
                System.out.println("List of all current projects: ");
                timeapp.displayAllProjectNames();
                chosenProject = timeapp.getValidProjectName(console,"Enter a valid project name: ");
                System.out.println("You have chosen project " + chosenProject + ".");
                System.out.println("Which activity do you wish to assign an employee to: ");
                System.out.println("List of all current activities in project " + chosenProject + ": ");
                timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
                activityName = timeapp.getValidActivityName(console,"Enter a valid activity name: ", chosenProject);
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
                System.out.println(chosenEmployee + " has successfully been assigned as project manager ");
                System.out.println();
            }
            if (nr == 7) {
                System.out.println("\nTo add your hours, first chose a project.");
                System.out.println("List of all current projects: ");
                timeapp.displayAllProjectNames();
                chosenProject = timeapp.getValidProjectName(console, "Enter a valid project name: ");
                System.out.println("You have chosen project " + chosenProject + ".");
                System.out.println("Which activity would you like to add hours worked to?");
                timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
                activityName = timeapp.getValidActivityName(console, "Enter a valid activity name: ", chosenProject);
                System.out.println("Please enter hours worked on activity ");
                hoursWorked = console.nextInt();
                console.nextLine();
                timeapp.addHoursToActivityAndEmployee(activityName, chosenEmployee, chosenProject, hoursWorked);
                System.out.println(hoursWorked + " hours added to activity " + activityName + " in project " + chosenProject);
                System.out.println(hoursWorked + " hours added to " + chosenEmployee + " worked hours");
                System.out.println("Your total hours worked are: "+ timeapp.getEmployee(chosenEmployee).getHoursWorked());
            }
        } while(nr!=0);
        System.out.println("Exiting program as per your request");
    }
}
