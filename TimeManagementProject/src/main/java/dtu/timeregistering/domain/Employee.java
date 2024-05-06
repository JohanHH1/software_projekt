package dtu.timeregistering.domain;

import java.util.ArrayList;

public class Employee {

    //--------------------------------------------------------------------------------
    // Fields:
    private String initials;
    private final int maxNumberOfActivities = 20;
    private boolean loggedIn;
    private boolean isProjectManager;
    private float hoursWorked;
    private boolean isAvailable;
    // Lists
    private ArrayList<Activity> myActivityList = new ArrayList<>();
    private ArrayList<Project> myProjectList = new ArrayList<>();
    private ArrayList<Integer> unavailableWeeks = new ArrayList<>();
    private ArrayList<Project> lisOfManagersListOfProjects = new ArrayList<>();

    //--------------------------------------------------------------------------------
    // Constructor
    public Employee(String initials) {
        this.initials = initials;
    }
    //--------------------------------------------------------------------------------
    // Initialize

    //--------------------------------------------------------------------------------
    // Booleans
    public boolean isLoggedIn() {
        return loggedIn;
    }
    public boolean isProjectManager() {
        return isProjectManager;
    }
    public boolean isAvailable(){
        return isAvailable;
    }

    //--------------------------------------------------------------------------------
    // Methods


    //--------------------------------------------------------------------------------
    // Getters
    public String getInitials() {
        return initials;
    }
    public ArrayList<Activity> getMyActivityList() {
        return myActivityList;
    }
    public ArrayList<Project> getMyProjectList() {
        return myProjectList;
    }
    public int getMaxNumberOfActivities() {
        return maxNumberOfActivities;
    }
    public float getHoursWorked() {
        return hoursWorked;
    }
    public ArrayList<Integer> getUnavailableWeeks() {
        return unavailableWeeks;
    }
    public ArrayList<Project> getLisOfManagersListOfProjects() {
        return lisOfManagersListOfProjects;
    }

    //--------------------------------------------------------------------------------
    // Setters
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public void setProjectManager(boolean projectManager) {
        isProjectManager = projectManager;
    }
    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    //--------------------------------------------------------------------------------
    }