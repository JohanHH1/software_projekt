package dtu.timeregistering.ui;
import dtu.timeregistering.app.TimeApp;
import dtu.timeregistering.domain.Employee;
import dtu.timeregistering.domain.Project;

import java.util.*;
import java.io.*;
public class Start {
    TimeApp timeapp = new TimeApp();

    public static void main(String[] args) throws Exception {
        new Start().start();
    }
    public void start() throws Exception {
        int nr;
        int n = 0;
        int m = 0;
        int o = 0;
        String employeeToAdd;
        String chosenProject;
        String activityName;
        int startWeek;
        int endWeek;
        String chosenEmployee;
        Scanner console = new Scanner(System.in);
        timeapp.initializeEmployees();
        System.out.println("Chose an employee:");
        timeapp.displayAllEmployees();
        chosenEmployee = console.nextLine();
        timeapp.logIn(chosenEmployee);
        System.out.println("Welcome " + chosenEmployee + " - please enter the corresponding number to pick the action");
        do {
            System.out.println("0. Exit");
            System.out.println("1. Create project");
            System.out.println("2. Create activity in project");
            System.out.println("3. Set timeframe for activity");
            System.out.println("4. Add Employee to activity");
            System.out.println("5. Assign a project manager");
            nr = console.nextInt();
            console.nextLine();
            if (nr == 1) {
                System.out.println("Please enter projectname");
                String projectName = console.nextLine();
                    try {
                        timeapp.addProject(projectName);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                timeapp.displayAllProjectNames();

            }
            if (nr == 2) {
                do {
                    if (n >= 0){
                        System.out.println("Please enter valid project name ");
                    }
                    System.out.println("Choose project to add activity to:");
                    timeapp.displayAllProjectNames();
                    chosenProject = console.nextLine();
                    n+=1;
                } while (!timeapp.isInProjectList(chosenProject));

                    System.out.println("Enter activity name");
                    activityName = console.nextLine();
                    timeapp.createActivity(activityName, chosenProject);
                    timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));

            }
            if (nr == 3){
                System.out.println("Choose project to add activity to:");
                timeapp.displayAllProjectNames();
                chosenProject = console.nextLine();
                System.out.println("Enter activity name");
                timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
                activityName = console.nextLine();
                System.out.println("Enter start week:");
                startWeek = console.nextInt();
                System.out.println("Enter end week:");
                endWeek = console.nextInt();
                timeapp.setTimeFrame(activityName,chosenProject, startWeek, endWeek);
                System.out.println("Timeframe has successfully been added to " + activityName + " in project " + chosenProject);
                System.out.println(startWeek + endWeek);
            }
            if (nr == 4) {
                do {
                    if (m >= 0){
                        System.out.println("Please enter valid project name ");
                    }
                    System.out.println("Choose a project: ");
                    timeapp.displayAllProjectNames();
                    chosenProject = console.nextLine();
                    m+=1;
                } while (!timeapp.isInProjectList(chosenProject));
                System.out.println("Enter activity name");
                timeapp.displayAllActivitiesInProject(timeapp.getProject(chosenProject));
                activityName = console.nextLine();
                System.out.println("Chose an employee:");
                timeapp.displayAllEmployees();
                employeeToAdd = console.nextLine();
                timeapp.addEmployeeToActivity(activityName,employeeToAdd,chosenProject);
                System.out.println("your activities are: ");
                timeapp.displayMyActivityList(employeeToAdd);
            }
            if (nr == 5) {
                do {
                    if (o >= 0) {
                        System.out.println("Please choose an employee as a project manager");
                    }
                    System.out.println("Choose an employee: ");
                    timeapp.displayAllEmployees();
                    chosenEmployee = console.nextLine();
                    o += 1;
                } while (!timeapp.isInEmployeeList(chosenEmployee));
                    timeapp.assignProjectmanager(chosenEmployee);
                    System.out.println(chosenEmployee + " has succesfully been assigned as project manager ");
            }
        } while(nr!=0);
    }

    }

