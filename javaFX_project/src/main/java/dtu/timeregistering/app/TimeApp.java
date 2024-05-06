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
    private int counter = 0;
    private boolean b;
    String name;
    private ArrayList<Project> listOfProjects = new ArrayList<>();
    private ArrayList<Employee> listOfEmployees = new ArrayList<>();
    private ArrayList<Employee> listOfAvailableEmployees = new ArrayList<>();
    //--------------------------------------------------------------------------------

    // Constructor:
    public TimeApp() {
    }

    //--------------------------------------------------------------------------------
    // Initialize:
    //Johan - Initialize mock employees
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
    // Patrick - Initialize mock activities
    public void initializeProjectsAndActivities() {
        ArrayList<String> activityNames = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {  // Creating 10 activities
            activityNames.add("Activity" + i);
        }
        int activityIndex = 0;
        for (int k = 1; k <= 5; k++) {  // Creating 5 projects
            name = "Project" + k;
            addProject(name);
            for (int j = 0; j < 2; j++) { // Adding 2 activities to each of the 5 projects
                String activityName = activityNames.get(activityIndex++);
                Activity activity = new Activity(activityName);
                try {
                    getProject(name).addActivity(activityName);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                for (Employee employee : listOfEmployees) { // assigning all employees to all activities
                    addEmployeeToActivity(activityName, employee.getInitials(), getProject(name).getProjectName());
                }
            }
        }
    }


    //--------------------------------------------------------------------------------
    //Booleans:
    //Lizette - check if project is in list of project
    public boolean isInProjectList(String projectName) throws IllegalArgumentException {
        String normalizedProjectName = projectName.toLowerCase(); // Convert project name to lowercase
        for (Project project : listOfProjects) {
            if (project.getProjectName().toLowerCase().equals(normalizedProjectName)) {
                return true;
            }
        }
        return false;
    }

    //Joyce - check if activity is in list of activities in a project
    public boolean isInActivityList(String activityName, String projectName) throws Exception {
        String normalizedActivityName = activityName.toLowerCase(); // Convert activity name to lowercase
        String normalizedProjectName = projectName.toLowerCase(); // Convert project name to lowercase
        Project gottenProject = listOfProjects.stream().filter(project -> project.getProjectName().toLowerCase().equals(normalizedProjectName)).findFirst().orElseThrow(() -> new Exception("Activity not in project"));
        return gottenProject.getListOfActivities().stream().anyMatch(activity -> activity.getActivityName().toLowerCase().equals(normalizedActivityName));
    }

    //Johan - check if activity list is empty for a project
    public boolean isEmptyActivityList(String projectName) throws Exception {
        Project gottenProject = listOfProjects.stream().filter(project->project.getProjectName().equalsIgnoreCase(projectName)).findFirst().orElseThrow(()-> new Exception("Project " + projectName + " doesn't exist"));
        return gottenProject.getListOfActivities().isEmpty();
    }

    //Kajsa - check if list of projects is empty
    public boolean isEmptyProjectList() throws IllegalArgumentException {
        return listOfProjects.isEmpty();
    }

    //Kajsa - check if employee exists
    public boolean isInEmployeeList(String initials) throws IllegalArgumentException {
        String normalizedInitials = initials.toLowerCase(); // Convert initials to lowercase
        for (Employee employee : listOfEmployees) {
            if (employee.getInitials().toLowerCase().equals(normalizedInitials)) {
                return true;
            }
        }
        return false;
    }

    //Joyce - check if employee is logged in
    public boolean isLoggedIn(String initials) {
        return getEmployee(initials).isLoggedIn();
    }
    public boolean isInEmployeesListOfActivities(String activityName, String initials, String projectName) {
        return getEmployee(initials).getMyActivityList().contains(getProject(projectName).getActivity(activityName));
    }

    //Patrick - check if employee is in list of activities for a project
    public boolean isInActivityListOfEmployees(String activityName, String initials, String projectName) {
        return getProject(projectName).getActivity(activityName).getListOfEmployeesInActivity().contains(getEmployee(initials));
    }

    //Johan - check if employee is a project manager
    public boolean isProjectManager(String initials) {
        return getEmployee(initials).isProjectManager();
    }
    //--------------------------------------------------------------------------------
    // Methods:

    //Johan - add a project (method also gives project number with counter)
    public void addProject(String projectName) throws IllegalArgumentException {
        if (isInProjectList(projectName)) {
            throw new IllegalArgumentException("A project with this name already exists");
        }
        Project project = new Project(projectName);
        listOfProjects.add(project);
        counter +=1;
        project.setCount(counter);
        project.setProjectNumber();

    }
    //Patrick - create activity in project
    public void createActivity(String activityName, String projectName) throws Exception {
        try{
            getProject(projectName).addActivity(activityName);
        }
        catch (Exception e){
            System.out.println("Error : "+e.getMessage());
        }
    }
    //Kajsa - employee log in
    public void logIn(String initials) {
        getEmployee(initials).setLoggedIn(true);
    }

    //Lizette - add employee to activity
    public void addEmployeeToActivity(String activityName, String initials, String projectName) {
        if (getEmployee(initials).getMyActivityList().size()<20) {
            getProject(projectName).getActivity(activityName).getListOfEmployeesInActivity().add(getEmployee((initials)));
            getEmployee(initials).getMyActivityList().add(getProject(projectName).getActivity(activityName));
        } else {
            System.out.println(initials + " has the max limit of activities (20).");
        }
    }

    //Joyce - assign a projectManager
    public void assignProjectmanager(String initials) {
        getEmployee(initials).setProjectManager((true));
    }

    //Kajsa - add hours spent to activity, and sequentially add the hours to the employee worked hours
    public void addHoursToActivityAndEmployee(String activityName, String initials, String projectName,float hours) {
        addHoursToActivity(activityName, projectName, hours);
        addHoursToEmployee(initials, hours);
    }

    //Patrick - remove hours from activity, and sequentially remove them from the employee worked hours
    public void removeHoursInActiivtyAndEmployee(String activityName, String initials, String projectName, float updateHours) {
        addHoursToActivity(activityName, projectName, -updateHours);
        addHoursToEmployee(initials, -updateHours);
    }

    //Lizette - add hours to activity
    public void addHoursToActivity(String activityName, String projectName,float hours) {
        getProject(projectName).getActivity(activityName).setHoursSpentOnActivity(getProject(projectName).getActivity(activityName).getHoursSpentOnActivity()+hours);

    }

    //Lizette - add hours to an employees worked hours
    public void addHoursToEmployee(String initials,float hours) {
        getEmployee(initials).setHoursWorked(getEmployee(initials).getHoursWorked()+hours);
    }
    //--------------------------------------------------------------------------------
    // DISPLAY METHODS:

    //Joyce - display the employees not assigned to the activity
    public void displayEmployeesNotInActivity(String activityName, String projectName) {
        for (Employee employee : listOfEmployees) {
            if (!getProject(projectName).getActivity(activityName).getListOfEmployeesInActivity().contains(employee)) {
                System.out.println(employee.getInitials());
            }
        }
    }

    //Johan - display all the projects
    public void displayAllProjectNames() {
        for (Project listOfProject : listOfProjects) {
            System.out.println(listOfProject.getProjectName());
        }
    }

    //Kajsa - display all the activities in a given project
    public void displayAllActivitiesInProject(String projectName) {
        for (Activity listOfActivity : getProject(projectName).getListOfActivities()){
            System.out.println(listOfActivity.getActivityName());
        }
    }

    //Kajsa - display all employees
    public void displayAllEmployees() {
        for (Employee listOfEmployee : listOfEmployees){
            System.out.println(listOfEmployee.getInitials());
        }
    }

    //Patrick - display all activities an employee is assigned to
    public void displayMyActivityList(String initials) {
        // Denne metode kan måske/evt upgrades til at displaye hvilket projekt hver aktivitet hører til
        for (Activity i : getEmployee(initials).getMyActivityList()){
            System.out.println(i.getActivityName());
        }
    }

    //Lizette - display all projects an employee is assign to
    public void displayMyProjectList(String initials) {
        for (Project i : getEmployee(initials).getMyProjectList()){
            System.out.println(i.getProjectName());
        }
    }

    //Joyce - display total hours worked for an employee
    public void displayMyHoursWorked(String initials) {
        System.out.println(initials + "'s total hours worked are: " + getEmployee(initials).getHoursWorked());
    }

    //Patrick - display all employees assigned to a certain activity
    public void displayListOfEmployeesInActivity(String activityName, String projectName) {
        for (Employee i : getProject(projectName).getActivity(activityName).getListOfEmployeesInActivity()){
            System.out.println(i.getInitials());
        }
    }

    //Johan - display all project managers
    public void displayLisOfManagersListOfProjects(String initials){
        for (Project i : getEmployee(initials).getLisOfManagersListOfProjects()){
            System.out.println(i.getProjectName());
        }
    }

    //Kajsa - display all information for an employee
    public void displayAllMyInformation(String initials){
        Employee employee = getEmployee(initials);
        System.out.println("Name: "+ employee.getInitials());
        System.out.println("Projects: ");
        displayMyProjectList(initials);
        System.out.println("Max number of activities: "+ employee.getMaxNumberOfActivities());
        System.out.println("Number of activities: " + employee.getMyActivityList().size());
        System.out.println("Activities: ");
        displayMyActivityList(initials);
        displayMyHoursWorked(initials);
        System.out.println("Unavailable weeks are: " + employee.getUnavailableWeeks());
        System.out.println("ProjectManager: " + employee.isProjectManager());
        if (employee.isProjectManager()){
            displayLisOfManagersListOfProjects(initials);
        }
    }

    //Joyce - display all information for an activity
    public void displayActivityInformation(String activityName, String projectName) {
        Activity activity = getProject(projectName).getActivity(activityName);
        System.out.println("Activity name: "+ activity.getActivityName());
        System.out.println("Employees in " + activityName + ": ");
        displayListOfEmployeesInActivity(activityName,projectName);
        System.out.println("Hours spent on activity: " + activity.getHoursSpentOnActivity());
        System.out.println("Budget hours: " + activity.getBudgetedHours());
        System.out.println("Start week: " + activity.getStartWeek());
        System.out.println("End week: " + activity.getEndWeek());
        System.out.println("Activity " + activityName + " is in project: " + activity.getProjectName() + ": " + getProject(activity.getProjectName()).getProjectNumber());
    }

    //Patrick - display list of all available employees for a given timeframe (startweek, endweek)
    public void displayListOfAvailableEmployees(int startWeek, int endWeek) {
        try {
            listOfAvailableEmployees.clear();
            ArrayList<Employee> listOfAvailableEmployees = getListOfAvailableEmployees(startWeek, endWeek);
            System.out.println("Available Employees from week " + startWeek + " to week " + endWeek);
            for (Employee employee : listOfAvailableEmployees) {
                System.out.println(employee.getInitials());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Lizette - display total hours spent on project
    public void displayTotalHoursOnProject(String projectName) {
        float i = 0;
        for (Activity activity : getProject(projectName).getListOfActivities()){
            i+=activity.getHoursSpentOnActivity();
        }
        System.out.println(i);
    }
    //--------------------------------------------------------------------------------
    // Getters:

    public ArrayList<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    //Patrick - this method ensures the user prompt is an int
    public int getInt(Scanner console, String prompt, int min, int max) {
        int input;
        while (true) {
            while (!console.hasNextInt()) {
                console.next();
                System.out.println("Error - Please enter an integer between " + min + " and " + max + ": ");
                System.out.println(prompt);
            }
            input = console.nextInt();
            if (input >= min && input <= max) {
                break;
            } else {
                System.out.println("Error - Please enter an integer between " + min + " and " + max + ": ");
                System.out.println(prompt);
            }
        }
        return input;
    }

    //Johan - this makes sure user inputs a number (can be a float)
    public float getFloat(Scanner console, String prompt) {
        float input;
        while (!console.hasNextFloat() && console.nextFloat()>=0) {
            console.next();
            System.out.println("Error - Please enter an number");
            System.out.println(prompt);
        }
        input = console.nextFloat();
        return input;
    }

    //Patrick - makes sure input is a valid project name
    public String getValidProjectName(Scanner console, String prompt) {
        while (true) {
            String projectName = console.next();
            if (isInProjectList(projectName)) {
                return projectName;
            } else {
                System.out.println("Error - Please enter a valid project name: ");
                System.out.println(prompt);
            }
        }
    }

    //Lizette - makes sure input is a valid activity name
    public String getValidActivityName(Scanner console, String prompt, String projectName) throws Exception {
        while (true) {
            String activityName = console.next();
            if (isInActivityList(activityName, projectName)) {
                return activityName;
            } else {
                System.out.println("Error - Please enter a valid activity name: ");
                System.out.println(prompt);
            }
        }
    }

    //Kajsa - makes sure input is a valid employee name
    public String getValidEmployeeName(Scanner console, String prompt) {
        while (true) {
            String employeeName = console.next();
            if (isInEmployeeList(employeeName)) {
                return employeeName;
            } else {
                System.out.println("Error - Please enter a valid employee name: ");
                System.out.println(prompt);
            }
        }
    }

    //Joyce - gets the correct project name (manually coded stream)
    public Project getProject(String projectName) {
        String normalizedProjectName = projectName.toLowerCase(); // Convert project name to lowercase
        for (Project project : listOfProjects) {
            if (project.getProjectName().toLowerCase().equals(normalizedProjectName)) {
                return project;
            }
        }
        System.out.println("ERROR - Project with project Name " + projectName + " not found");
        return null;
    }

    //Johan - gets the correct employee (manually coded stream)
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

    //Lizette - gets the list of available employees in a certain timeframe
    public ArrayList<Employee> getListOfAvailableEmployees(int startWeek, int endWeek) throws Exception {
        for (Employee employee : listOfEmployees) {
            b=true;
            for (int i = startWeek; i<=endWeek; i++){
                if (employee.getUnavailableWeeks().contains(i)) {
                    b=false; // b is a boolean that catches of an employee is unavailable for even one week during the period
                }}
            if (b){
                listOfAvailableEmployees.add(employee);
            }}
        if(listOfAvailableEmployees.isEmpty()){
            throw new Exception("There are no available employees in your requested timeframe");
        }
        return listOfAvailableEmployees;
    }
    //--------------------------------------------------------------------------------
    // Setters:

    //Patrick - sets a time frame for activity with startweek and endweek
    public void setTimeFrame(String activityName, String projectName, int startWeek, int endWeek) throws Exception {
        Project gottenProject = listOfProjects.stream().filter(project->project.getProjectName().equalsIgnoreCase(projectName)).findFirst().orElseThrow(()-> new Exception("Activity not in project"));
        gottenProject.getActivity(activityName).setStartWeek(startWeek);
        gottenProject.getActivity(activityName).setEndWeek(endWeek);
    }

    //Joyce - marks employee unavailable for a week
    public void markEmployeeUnavailableSingleWeek(String initials, int unavailableWeek) {
        getEmployee(initials).getUnavailableWeeks().add(unavailableWeek);

    }

    //Johan - marks employee unavailable for multiple weeks
    public void markEmployeeUnavailableSeveralWeeks(String initials, int startWeekUnavailable, int endWeekUnavailable) {
        for (int i = startWeekUnavailable; i <= endWeekUnavailable; i++) {
            getEmployee(initials).getUnavailableWeeks().add(i);
        }
    }

    //Lizette - checks if an employee is a project manager for a certain project
    public boolean isProjectManagerOnProject(String initials, String projectName) {
        return (getProject(projectName).getProjectManager()==getEmployee(initials));
    }

    //Joyce - assigns project manager to project
    public void assignProjectManagerToProject(String initials, String projectName) {
        getProject(projectName).setProjectManager(getEmployee(initials));
        getEmployee(initials).getMyProjectList().add(getProject(projectName));
        getEmployee(initials).getLisOfManagersListOfProjects().add(getProject(projectName));
        getProject(projectName).setHasProjectManager(true);
    }

    //Kajsa - checks if employee is available in a certain timeframe (startweek, endweek)
    public boolean employeeIsAvailable(String initials, int startWeek, int endWeek){
        if(!getEmployee(initials).getUnavailableWeeks().contains(startWeek) && !getEmployee(initials).getUnavailableWeeks().contains(endWeek)) {
            getEmployee(initials).setAvailable(true);
            return getEmployee(initials).isAvailable();
        }
        return false;
    }

    //Lizette - removes employee from an activity in a project
    public void removeEmployeeFromActivity(String initials, String activityName, String projectName) {
        Activity activity = getProject(projectName).getActivity(activityName);
        activity.getListOfEmployeesInActivity().removeIf(i -> i.equals(getEmployee(initials)));
        Employee employee = getEmployee(initials);
        employee.getMyActivityList().removeIf(i -> i.equals(activity));
    }

    //Johan - sets budgeted hours for an activity
    public void setBudgetedHoursForActivity(int budgetedHours, String activityName, String projectName) {
        getProject(projectName).getActivity(activityName).setBudgetedHours(budgetedHours);
    }

    //Joyce - checks if project has a project manager
    public boolean projectHasProjectManager(String projectName) {
        return getProject(projectName).getHasProjectManager();
    }

    //Kajsa - sets the project as having a projectmanager as true
    public void setHasProjectManager(String chosenProject, boolean b) {
        getProject(chosenProject).setHasProjectManager(b);
    }

    //Kajsa - gets hours worked for employee
    public float employeeHoursWorked(String initials) {
        return getEmployee(initials).getHoursWorked();
    }

    //--------------------------------------------------------------------------------
}