package dtu.timeregistering.app;

import java.util.ArrayList;

public class Project {
    public Project(String projectName, int projectNumber){
        this.projectName=projectName;
        this.projectNumber=projectNumber;
    }
    private int projectNumber;
    private String projectName;
    private ArrayList<String> activities;
    private boolean isPublicProject;
    private boolean isEmployeeProjectManager;
    private boolean hasProjectManager;

    public void addActivity(String employeeInitials, String name) {
        // tjek om der er pm
    }
    public void addTimeFrame(String activityName) {
    }
    public void addEmployee(String employeeInitials, String activityName){
    }
    public void addProjectManager(String employee){
    }
    public void isEmployeeOnProject(String employee){
    }


}
