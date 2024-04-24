package dtu.timeregistering.app;

import dtu.timeregistering.domain.Activity;
import dtu.timeregistering.domain.Employee;
import dtu.timeregistering.domain.Project;
import dtu.timeregistering.ui.Start;


import java.util.ArrayList;

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
        return getEmployee(initials).getMyProjectList().contains(getProject(projectName));
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
    public ArrayList<Project> getProjects() {
        return listOfProjects;
    }
    public Project getProject(String projectName) {
        for (Project listOfProject : listOfProjects) {
            if (listOfProject.getProjectName().equals(projectName)) {
                return listOfProject;
            }
        }
        return null;
    }

    public Employee getEmployee(String initials) {
        for (Employee listOfEmployee : listOfEmployees) {
            if (listOfEmployee.getInitials().equals(initials)) {
                return listOfEmployee;
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
    //--------------------------------------------------------------------------------
}