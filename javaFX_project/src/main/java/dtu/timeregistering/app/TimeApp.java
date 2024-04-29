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
    private ArrayList<Employee> listOfAvailableEmployees = new ArrayList<>();

    private ArrayList<Project> lisOfManagersListOfProjects = new ArrayList<>();
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
    public void initializeProjectsAndActivities() {
        for (int i = 1; i <= 5; i++) {  // Creating 5 projects
            Project project = new Project("Project" + i);
            listOfProjects.add(project);
            for (int j = 1; j <= 3; j++) { // Adding 3 activities to each of the 5 projects
                Activity activity = new Activity("Activity" + j);
                project.addActivity(activity.getActivityName());
                for (Employee employee : listOfEmployees) {     // assigning all employees to all activities
                    addEmployeeToActivity(activity.getActivityName(), employee.getInitials(), project.getProjectName());
                }
            }
        }
    }

    //--------------------------------------------------------------------------------
    //Booleans:
    public boolean isInProjectList(String projectName) throws IllegalArgumentException {
        String normalizedProjectName = projectName.toLowerCase(); // Convert project name to lowercase
        for (Project project : listOfProjects) {
            if (project.getProjectName().toLowerCase().equals(normalizedProjectName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInActivityList(String activityName, String projectName) throws Exception {
        String normalizedActivityName = activityName.toLowerCase(); // Convert activity name to lowercase
        String normalizedProjectName = projectName.toLowerCase(); // Convert project name to lowercase
        Project gottenProject = listOfProjects.stream().filter(project -> project.getProjectName().toLowerCase().equals(normalizedProjectName)).findFirst().orElseThrow(() -> new Exception("Activity not in project"));
        return gottenProject.getListOfActivities().stream().anyMatch(activity -> activity.getActivityName().toLowerCase().equals(normalizedActivityName));
    }


    public boolean isEmptyActivityList(String projectName) throws Exception {
        Project gottenProject = listOfProjects.stream().filter(project->project.getProjectName().equalsIgnoreCase(projectName)).findFirst().orElseThrow(()-> new Exception("Project " + projectName + " doesn't exist"));
        return gottenProject.getListOfActivities().isEmpty();
    }
    public boolean isEmptyProjectList() throws IllegalArgumentException {
        return listOfProjects.isEmpty();
    }

    public boolean isInEmployeeList(String initials) throws IllegalArgumentException {
        String normalizedInitials = initials.toLowerCase(); // Convert initials to lowercase
        for (Employee employee : listOfEmployees) {
            if (employee.getInitials().toLowerCase().equals(normalizedInitials)) {
                return true;
            }
        }
        return false;
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
         getProject(projectName).addActivity(activityName);
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

    public void assignProjectmanager(String initials) {
        getEmployee(initials).setProjectManager((true));
    }

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
    public void displayMyActivityList(String initials, String projectName) {
        for (Activity i : getEmployee(initials).getMyActivityList()){
            System.out.println(i.getActivityName() + "in project " + projectName);
        }
    }
    public void displayMyProjectList(String initials) {
        for (Project i : getEmployee(initials).getMyProjectList()){
            System.out.println(i.getProjectName());
        }
    }
    public void displayMyHoursWorked(String initials) {
        System.out.println("Your total hours worked are: " + getEmployee(initials).getHoursWorked());
    }
    public void displayListOfEmployeesInActivity(String activityName, String projectName) {
        for (Employee i : getProject(projectName).getActivity(activityName).getListOfEmployeesInActivity()){
            System.out.println(i.getInitials());
        }
    }
    public void displayListOfEmployeesInProject(String projectName) {
        for (Employee i : getProject(projectName).getListOfEmployeesInProject()){
            System.out.println(i.getMyProjectList());
        }
    }
    public void displayLisOfManagersListOfProjects(String initials){
        for (Project i : getEmployee(initials).getLisOfManagersListOfProjects()){
            System.out.println(i.getProjectName());
        }
    }
    public void displayAllMyInformation(String initials, String projectName){
        Employee employee = getEmployee(initials);
        System.out.println("Name: "+ employee.getInitials());
        System.out.print("My projects: ");
        displayMyProjectList(initials);
        System.out.println("Max number of activities: "+ employee.getMaxNumberOfActivities());
        System.out.println("My number of activities: " + employee.getMyActivityList().size());
        System.out.print("My activities: ");
        displayMyActivityList(initials, projectName);
        displayMyHoursWorked(initials);
        System.out.println("My unavailable weeks are: " + employee.getUnavailableWeeks());
        System.out.println("ProjectManager:" + employee.isProjectManager());
        if (employee.isProjectManager()){
            displayLisOfManagersListOfProjects(initials);
        }
    }
    public void displayActivityInformation(String activityName, String projectName) {
        Activity activity = getProject(projectName).getActivity(activityName);
        System.out.println("Activity name: "+ activity.getActivityName());
        System.out.println("Employees in " + activityName + ": ");
        displayListOfEmployeesInActivity(activityName,projectName);
        System.out.println("Hours spent on activity: " + activity.getHoursSpentOnActivity());
        System.out.println("Budget hours: " + activity.getBudgetTime());
        System.out.println("Start week: " + activity.getStartWeek());
        System.out.println("End week: " + activity.getEndWeek());
        System.out.println("Activity " + activityName + " is in project: " + activity.getProjectName());
    }
    public void displayListOfAvailableEmployees(Integer startWeek, Integer endWeek) {
        try {
            ArrayList<Employee> listOfAvailableEmployees = getListOfAvailableEmployees(startWeek, endWeek);
            System.out.println("Available Employees:");
            for (Employee employee : listOfAvailableEmployees) {
                System.out.println(employee.getInitials());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void displayTotalHoursOnProject(String projectName) {
        int i = 0;
        for (Activity activity : getProject(projectName).getListOfActivities()){
            i+=activity.getHoursSpentOnActivity();
        }
        System.out.println(i);
    }
    //--------------------------------------------------------------------------------
    // Getters:
    //This method ensures the user prompt is an integer (long)
    public int getInt(Scanner console, String prompt, int min, int max) {
        int input;
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
        String normalizedProjectName = projectName.toLowerCase(); // Convert project name to lowercase
        for (Project project : listOfProjects) {
            if (project.getProjectName().toLowerCase().equals(normalizedProjectName)) {
                return project;
            }
        }
        return null;
    }

    public Employee getEmployee(String initials) {
        String normalizedInitials = initials.toLowerCase(); // Convert initials to lowercase
        for (Employee employee : listOfEmployees) {
            if (employee.getInitials().toLowerCase().equals(normalizedInitials)) {
                return employee;
            }
        }
        System.out.println("ERROR - Employee with initials " + initials + " not found");
        return null;
    }


    public ArrayList<Employee> getListOfAvailableEmployees(Integer startWeek, Integer endWeek) throws Exception {
        for (Employee employee : listOfEmployees) {
            if (!employee.getUnavailableWeeks().contains(startWeek) && !employee.getUnavailableWeeks().contains(endWeek)) {
                listOfAvailableEmployees.add(employee);
            }
        }
        if(listOfAvailableEmployees.isEmpty()){
            throw new Exception("There are no available employees in your requested timeframe");
        }
        return listOfAvailableEmployees;
    }

    public ArrayList<Project> getLisOfManagersListOfProjects(String initials, String projectName) {
        return lisOfManagersListOfProjects;
    }

    //--------------------------------------------------------------------------------
    // Setters:
    public void setTimeFrame(String activityName, String projectName, Integer startWeek, Integer endWeek) throws Exception {
        Project gottenProject = listOfProjects.stream().filter(project->project.getProjectName().equalsIgnoreCase(projectName)).findFirst().orElseThrow(()-> new Exception("Activity not in project"));
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
        getEmployee(initials).getLisOfManagersListOfProjects().add(getProject(projectName));
        getProject(projectName).setHasProjectManager(true);
    }

    public boolean employeeIsAvailable(String initials, Integer startWeek, Integer endWeek){
        if(!getEmployee(initials).getUnavailableWeeks().contains(startWeek) && !getEmployee(initials).getUnavailableWeeks().contains(endWeek)) {
            getEmployee(initials).setAvailable(true);
            return getEmployee(initials).isAvailable();
        }
        return false;
    }

    public void setLisOfManagersListOfProjects(ArrayList<Project> lisOfManagersListOfProjects) {
        this.lisOfManagersListOfProjects = lisOfManagersListOfProjects;
    }




    //--------------------------------------------------------------------------------
}