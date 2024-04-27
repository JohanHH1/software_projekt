package dtu.timeregistering.domain;

import java.util.ArrayList;

public class Project {
    //--------------------------------------------------------------------------------
    // Fields
    private int projectNumber;
    private String projectName;
    // Lists
    private ArrayList<Activity> listOfActivities = new ArrayList<>();
    private ArrayList<Employee> listOfEmployeesInProject = new ArrayList<>();
    private Employee projectManager;
    //--------------------------------------------------------------------------------

    // Constructor
    public Project(String projectName) {
        this.projectName = projectName;
    }

    //--------------------------------------------------------------------------------
    // Initialize

    //--------------------------------------------------------------------------------
    // Booleans
    public Boolean hasTimeFrame(Activity activity){
        return activity.getStartWeek() != 0 && activity.getEndWeek() != 0;
    }
    //--------------------------------------------------------------------------------
    // Methods
    public void addActivity(String activityName){
        Activity activity = new Activity(activityName);
        activity.setProjectName(projectName);
        listOfActivities.add(activity);
    }
    //--------------------------------------------------------------------------------
    // Getters
    public String getProjectName() {
        return projectName;
    }
    public ArrayList<Activity> getListOfActivities() {
        return listOfActivities;
    }
    public Activity getActivity(String activityName) {
        for (Activity listOfActivity : listOfActivities) {
            if (activityName.equals(listOfActivity.getActivityName())) {
                return listOfActivity;
            }
        }
        return null;
    }
    public ArrayList<Employee> getListOfEmployeesInProject() {
        return listOfEmployeesInProject;
    }
    public Employee getProjectManager() {
        return projectManager;
    }
    //--------------------------------------------------------------------------------
    // Setters
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public void setListOfActivities(ArrayList<Activity> listOfActivities) {
        this.listOfActivities = listOfActivities;
    }
    public void setActivityStartWeek(int startWeek, Activity activity){
        activity.setStartWeek(startWeek);
    }
    public void setActivityEndWeek(int endWeek, Activity activity){
        activity.setEndWeek(endWeek);
    }
    public void setListOfEmployeesInProject(ArrayList<Employee> listOfEmployeesInProject) {
        this.listOfEmployeesInProject = listOfEmployeesInProject;
    }

    public void setProjectManager(Employee projectManager) {
        this.projectManager = projectManager;
    }
    //--------------------------------------------------------------------------------
}
