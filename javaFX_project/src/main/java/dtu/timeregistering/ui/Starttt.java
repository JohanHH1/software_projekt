//package dtu.timeregistering.ui;
//import dtu.timeregistering.app.TimeApp;
//import dtu.timeregistering.domain.Employee;
//import dtu.timeregistering.domain.Project;
//
//import java.util.*;
//import java.io.*;

// dette er den gamle start. den gør ikke noget,
// og er her som en backup indtil vi er helt sikre på at den nye køre fejlfrit. ;)
 public class Starttt {
  //  TimeApp timeapp = new TimeApp();
//
//    // MAIN
    //public static void main(String[] args) throws Exception {
       // new Start().start();
    }

//
//    public void start() throws Exception {
//        // Fields:
//        int nr;
//        int startWeek;
//        int endWeek;
//        int hoursWorked;
//        String employeeToAdd;
//        String chosenProject;
//        String activityName;
//        String chosenEmployee;
//        // Scanner
//        Scanner console = new Scanner(System.in);
//
//        // Program Starting
//        timeapp.initializeEmployees();
//
//        // Log In
//        System.out.println("Chose an employee to login as:");
//        timeapp.displayAllEmployees();
//        chosenEmployee = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
//        timeapp.logIn(chosenEmployee);
//        System.out.println("Welcome " + chosenEmployee + "!");
//
//        // List of Actions
//        do {
//            System.out.println("Please enter the corresponding number to pick the action");
//            System.out.println("0. Exit program");
//            System.out.println("1. Create a project");
//            System.out.println("2. Select a project");
//            System.out.println("3. Manage employees");
//            System.out.println("4. Project manager settings");
//
//            //create project
//            //select project
//                //select project manager
//                //manage activity
//                    //create activities
//                    //add timeframe
//                    //assign employee
//                    //register hours
//                //edit project
//            //manage employees
//                //see employee data
//                //register unavailable
//                //assign employee
//                //register hours
//                //edit hours
//            //project Manager
//                //available employees
//                //assign Employees
//                //get hours spent on project (total hours on activities)
//                //set budgeted hours on activities
//                //see employee data
//
//            //
//            System.out.println("Please enter the corresponding number to pick the action");
//            System.out.println("0. Exit program");
//            System.out.println("1. Create project");
//            System.out.println("2. Create activity in project");
//            System.out.println("3. Set timeframe for activity");
//            System.out.println("4. Assign Employee to activity");
//            System.out.println("5. Assign Employee to project");
//            System.out.println("6. Assign a project manager");
//            System.out.println("7. Add hours worked on activities");
//            nr = timeapp.getInt(console,"Enter a number from the list above: ", 0, 10);
//            console.nextLine();
//
//            // 1. Create project
//            if (nr == 1) {
//                System.out.println("To create a new project, please enter project name: ");
//                String projectName = console.nextLine();
//                    try {
//                        timeapp.addProject(projectName);
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
//                System.out.println("Project " + projectName + " was created successfully!");
//                System.out.println("List of all current projects: ");
//                timeapp.displayAllProjectNames();
//                System.out.println();
//            }
//            // 2. Create activity in project
//            if (nr == 2) {
//                System.out.println("\nChoose a project to add activity to: ");
//                System.out.println("List of all current projects: ");
//                timeapp.displayAllProjectNames();
//                chosenProject = timeapp.getValidProjectName(console,"Enter a valid project name: ");
//                console.nextLine(); // (Skal være her for at det virker, men gør i princippet ingenting)
//                System.out.println("To create new activity, please enter activity name: ");
//                activityName = console.nextLine();
//                timeapp.createActivity(activityName, chosenProject);
//                System.out.println("The activity " + activityName + " was successfully created!");
//                System.out.println("Here is a list of all current activities in project " + chosenProject + ": ");
//                timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
//                System.out.println();
//            }
//            // 3. Set timeframe for activity
//            if (nr == 3){
//                System.out.println("\nTo add timeframe, first chose a project.");
//                System.out.println("List of all current projects: ");
//                timeapp.displayAllProjectNames();
//                chosenProject = timeapp.getValidProjectName(console,"Enter a valid project name: ");
//                System.out.println("You have chosen project " + chosenProject + ".");
//                System.out.println("Which activity would you like to add timeframe to?");
//                timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
//                activityName = timeapp.getValidActivityName(console,"Enter a valid activity name: ", chosenProject);
//                System.out.println("Start week for activity " + activityName + ": ");
//                startWeek = timeapp.getInt(console, "Enter a valid week number: ", 1, 52);
//                System.out.println("End week for activity " + activityName + ": ");
//                endWeek = timeapp.getInt(console, "Enter a valid week number: ", 1, 52);
//                timeapp.setTimeFrame(activityName,chosenProject, startWeek, endWeek);
//                System.out.println("Timeframe has successfully been added to activity " + activityName + " in project " + chosenProject);
//                System.out.println("Start week: " + startWeek + ", End week: " + endWeek);
//                System.out.println();
//            }
//            // 4. Assign Employee to activity
//            if (nr == 4) {
//                System.out.println("\nTo assign an employee to activity, first choose a project: ");
//                System.out.println("List of all current projects: ");
//                timeapp.displayAllProjectNames();
//                chosenProject = timeapp.getValidProjectName(console,"Enter a valid project name: ");
//                System.out.println("You have chosen project " + chosenProject + ".");
//                System.out.println("Which activity do you wish to assign an employee to: ");
//                System.out.println("List of all current activities in project " + chosenProject + ": ");
//                timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
//                activityName = timeapp.getValidActivityName(console,"Enter a valid activity name: ", chosenProject);
//                System.out.println("Chose an employee to add to activity " + activityName + ": ");
//                System.out.println("List of all employees: ");
//                timeapp.displayAllEmployees();
//                employeeToAdd = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
//                timeapp.addEmployeeToActivity(activityName,employeeToAdd,chosenProject);
//                System.out.println("Employee " + employeeToAdd + " was successfully added to activity " + activityName + " in project " + chosenProject);
//                System.out.println(employeeToAdd + " is now assigned to current activities: ");
//                timeapp.displayMyActivityList(employeeToAdd);
//                System.out.println();
//            }
//            // 5. Assign Employee to project
//            if (nr == 5) {
//                System.out.println("\nWhich project do you wish to assign an employee to?");
//                System.out.println("List of all current projects: ");
//                timeapp.displayAllProjectNames();
//                chosenProject = timeapp.getValidProjectName(console,"Enter a valid project name: ");
//                System.out.println("Chose an employee to assign to project " + chosenProject + ": ");
//                System.out.println("List of all employees: ");
//                timeapp.displayAllEmployees();
//                employeeToAdd = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
//                timeapp.addEmployeeToProject(employeeToAdd,chosenProject);
//                System.out.println("Employee" + employeeToAdd + " was successfully added to project " + chosenProject);
//                System.out.println(employeeToAdd + " is now assigned to these current projects: ");
//                timeapp.displayMyProjectList(employeeToAdd);
//                System.out.println();
//            }
//            // 6. Assign a project manager
//            if (nr == 6) {
//                System.out.println("\nPlease choose an employee to assign as project manager: ");
//                System.out.println("List of all employees: ");
//                timeapp.displayAllEmployees();
//                chosenEmployee = timeapp.getValidEmployeeName(console, "Enter a valid employee name: ");
//                timeapp.assignProjectmanager(chosenEmployee);
//                System.out.println(chosenEmployee + " has successfully been assigned as project manager ");
//                System.out.println();
//            }
//            if (nr == 7) {
//                System.out.println("\nTo add your hours, first chose a project.");
//                System.out.println("List of all current projects: ");
//                timeapp.displayAllProjectNames();
//                chosenProject = timeapp.getValidProjectName(console, "Enter a valid project name: ");
//                System.out.println("You have chosen project " + chosenProject + ".");
//                System.out.println("Which activity would you like to add hours worked to?");
//                timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
//                activityName = timeapp.getValidActivityName(console, "Enter a valid activity name: ", chosenProject);
//                System.out.println("Please enter hours worked on activity ");
//                hoursWorked = console.nextInt();
//                console.nextLine();
//                timeapp.addHoursToActivityAndEmployee(activityName, chosenEmployee, chosenProject, hoursWorked);
//                System.out.println(hoursWorked + " hours added to activity " + activityName + " in project " + chosenProject);
//                System.out.println(hoursWorked + " hours added to " + chosenEmployee + " worked hours");
//                System.out.println("Your total hours worked are: "+ timeapp.getEmployee(chosenEmployee).getHoursWorked());
//            }
//            } while(nr!=0);
//        System.out.println("Exiting program as per your request");
//    }
//}