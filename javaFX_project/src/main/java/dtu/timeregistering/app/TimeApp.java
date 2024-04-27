package dtu.timeregistering.app;

import dtu.timeregistering.domain.Activity;
import dtu.timeregistering.domain.Employee;
import dtu.timeregistering.domain.Project;
import dtu.timeregistering.ui.Start;


import java.util.ArrayList;
import java.util.Scanner;

public class TimeApp {

    //--------------------------------------------------------------------------------
    // Fields:
    private Project project;
    private Start start;
    private ArrayList<Project> listOfProjects = new ArrayList<>();
    private ArrayList<Employee> listOfEmployees = new ArrayList<>();
    //--------------------------------------------------------------------------------

    // Constructor:
    public TimeApp() {
    }

    //--------------------------------------------------------------------------------
    // Initialize:
    public void initializeEmployees(){
        Employee huba = new Employee("HUBA");
        listOfEmployees.add(huba);
        Employee joha = new Employee("JOHA");
        listOfEmployees.add(joha);
        Employee joma = new Employee("JOMA");
        listOfEmployees.add(joma);
        Employee paro = new Employee("PARO");
        listOfEmployees.add(paro);
        Employee lini = new Employee("LINI");
        listOfEmployees.add(lini);
        Employee kabe = new Employee("KABE");
        listOfEmployees.add(kabe);
    }
    //--------------------------------------------------------------------------------
    //Booleans:
    public boolean isInProjectList(String projectName) throws IllegalArgumentException {
        return listOfProjects.contains(getProject(projectName));
    }
    public boolean isInEmployeeList(String initials) throws IllegalArgumentException {
        return listOfEmployees.contains(getEmployee(initials));
    }
    public boolean isInActivityList(String activityName, String projectName) throws Exception {
        Project gottenProject = listOfProjects.stream().filter(project->project.getProjectName().equals(projectName)).findFirst().orElseThrow(()-> new Exception("Activity not in project"));
        return gottenProject.getListOfActivities().contains(gottenProject.getActivity(activityName));
    }
    public boolean isLoggedIn(String initials) {
        return getEmployee(initials).isLoggedIn();
    }
    public boolean isInEmployeesListOfActivities(String activityName, String initials, String projectName) {
        return getEmployee(initials).getMyActivityList().contains(getProject(projectName).getActivity(activityName));
    }
    public boolean isInEmployeesListOfProjects(String initials, String projectName) {
        return true;
        //return getEmployee(initials).getMyProjectList().contains(getProject(projectName));
    }
    public boolean isInActivityListOfEmployees(String activityName, String initials, String projectName) {
        return getProject(projectName).getActivity(activityName).getListOfEmployeesInActivity().contains(getEmployee(initials));
    }
    public boolean isInProjectListOfEmployees(String initials, String projectName) {
        return getProject(projectName).getListOfEmployeesInProject().contains(getEmployee(initials));
    }
    public boolean isProjectManager(String initials) {
        return getEmployee(initials).isProjectManager();
    }
    //--------------------------------------------------------------------------------
    // Methods:
    public void addProject(String projectName) throws IllegalArgumentException {
        if (isInProjectList(projectName)) {
            throw new IllegalArgumentException("A project with this name already exists");
        }
        Project project = new Project(projectName);
        listOfProjects.add(project);
    }
    public void createActivity(String activityName, String projectName) throws Exception {
        Project gottenProject = listOfProjects.stream().filter(project->project.getProjectName().equals(projectName)).findFirst().orElseThrow(()-> new Exception("Activity not in project"));
        gottenProject.addActivity(activityName);
    }
    public void logIn(String initials) {
        getEmployee(initials).setLoggedIn(true);
    }
    public void addEmployeeToActivity(String activityName, String initials, String projectName) {
        getProject(projectName).getActivity(activityName).getListOfEmployeesInActivity().add(getEmployee((initials)));
        getEmployee(initials).getMyActivityList().add(getProject(projectName).getActivity(activityName));
    }
    public void addEmployeeToProject(String initials, String projectName) {
        getProject(projectName).getListOfEmployeesInProject().add(getEmployee((initials)));
        getEmployee(initials).getMyProjectList().add(getProject(projectName));
    }
    public void assignProjectmanager(String initials) {getEmployee(initials).setProjectManager((true));}

    public void addHoursToActivityAndEmployee(String activityName, String initials, String projectName,int hours) {
        addHoursToActivity(activityName, projectName, hours);
        addHoursToEmployee(initials, hours);
    }
    public void addHoursToActivity(String activityName, String projectName,int hours) {
        getProject(projectName).getActivity(activityName).setHoursSpentOnActivity(getProject(projectName).getActivity(activityName).getHoursSpentOnActivity()+hours);

    }
    public void addHoursToEmployee(String initials,int hours) {
        getEmployee(initials).setHoursWorked(getEmployee(initials).getHoursWorked()+hours);
    }
    //--------------------------------------------------------------------------------
    // DISPLAY METHODS:
    public void displayAllProjectNames() {
        for (Project listOfProject : listOfProjects) {
            System.out.println(listOfProject.getProjectName());
        }
    }
    public void displayAllActivitiesInProject(Project project) {
        for (Activity listOfActivity : project.getListOfActivities()){
            System.out.println(listOfActivity.getActivityName());
        }
    }
    public void displayAllEmployees() {
        for (Employee listOfEmployee : listOfEmployees){
            System.out.println(listOfEmployee.getInitials());
        }
    }
    public void displayMyActivityList(String initials) {
        for (Activity i : getEmployee(initials).getMyActivityList()){
            System.out.println(i.getActivityName());
        }
    }
    public void displayMyProjectList(String initials) {
        for (Project i : getEmployee(initials).getMyProjectList()){
            System.out.println(i.getProjectName());
        }
    }
    public void displayListOfEmployeesInActivity(String activityName, String projectName) {
        for (Employee i : getProject(projectName).getActivity(activityName).getListOfEmployeesInActivity()){
            System.out.println(i.getMyActivityList());
        }
    }
    public void displayListOfEmployeesInProject(String projectName) {
        for (Employee i : getProject(projectName).getListOfEmployeesInProject()){
            System.out.println(i.getMyProjectList());
        }
    }
    //--------------------------------------------------------------------------------
    // Getters:
    //This method ensures the user prompt is an integer (long)
    public int getInt(Scanner console, String prompt, int min, int max) {
        int input;
        System.out.print(prompt);
        while (true) {
            while (!console.hasNextInt()) {
                console.next();
                System.out.println("Error - Please enter an integer between " + min + " and " + max + ": ");
                System.out.print(prompt);
            }
            input = console.nextInt();
            if (input >= min && input <= max) {
                break;
            } else {
                System.out.println("Error - Please enter an integer between " + min + " and " + max + ": ");
                System.out.print(prompt);
            }
        }
        return input;
    }
    public String getValidProjectName(Scanner console, String prompt) {
        while (true) {
            String projectName = console.next();
            if (isInProjectList(projectName)) {
                return projectName;
            } else {
                System.out.println("Error - Please enter a valid project name: ");
                System.out.print(prompt);
            }
        }
    }
    public String getValidActivityName(Scanner console, String prompt, String projectName) throws Exception {
        while (true) {
            String activityName = console.next();
            if (isInActivityList(activityName, projectName)) {
                return activityName;
            } else {
                System.out.println("Error - Please enter a valid activity name: ");
                System.out.print(prompt);
            }
        }
    }
    public String getValidEmployeeName(Scanner console, String prompt) {
        while (true) {
            String employeeName = console.next();
            if (isInEmployeeList(employeeName)) {
                return employeeName;
            } else {
                System.out.println("Error - Please enter a valid employee name: ");
                System.out.print(prompt);
            }
        }
    }
    public ArrayList<Project> getProjects() {
        return listOfProjects;
    }

    public Project getProject(String projectName) {
        for (Project project : listOfProjects) {
            if (project.getProjectName().equals(projectName)) {
                return project;
            }
        }
        //System.out.println("Error - The project " + projectName + " does not exist.");
        return null;
    }
    public Employee getEmployee(String initials) {
        for (Employee employee : listOfEmployees) {
            if (employee.getInitials().equals(initials)) {
                return employee;
            }
        }
        return null;
    }
    //--------------------------------------------------------------------------------
    // Setters:
    public void setTimeFrame(String activityName, String projectName, Integer startWeek, Integer endWeek) throws Exception {
        Project gottenProject = listOfProjects.stream().filter(project->project.getProjectName().equals(projectName)).findFirst().orElseThrow(()-> new Exception("Activity not in project"));
        gottenProject.getActivity(activityName).setStartWeek(startWeek);
        gottenProject.getActivity(activityName).setEndWeek(endWeek);
    }

    public void markEmployeeUnavailableSingleWeek(String initials, Integer unavailableWeek) {
        getEmployee(initials).getUnavailableWeeks().add(unavailableWeek);

    }

    public void markEmployeeUnavailableSeveralWeeks(String initials, Integer startWeekUnavailable, Integer endWeekUnavailable) {
        for (int i = startWeekUnavailable; i <= endWeekUnavailable; i++) {
            getEmployee(initials).getUnavailableWeeks().add(i);
        }
    }

    public boolean isProjectManagerOnProject(String initials, String projectName) {
        return (getProject(projectName).getProjectManager()==getEmployee(initials));
    }

    public void assignProjectManagerToProject(String initials, String projectName) {
        getProject(projectName).setProjectManager(getEmployee(initials));
        getEmployee(initials).getMyProjectList().add(getProject(projectName));
    }
    //--------------------------------------------------------------------------------
}