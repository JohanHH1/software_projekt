package dtu.timeregistering.domain;

import java.util.ArrayList;

public class Employee {

    //--------------------------------------------------------------------------------
    // Fields:
    private String initials;
    private final int maxNumberOfActivities = 20;
    private boolean loggedIn;
    private boolean isProjectManager;
    private int hoursWorked;
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
    public int registerTime(int hours, String initials){
        return hours;
    }
    public int getHoursWorked() {return hoursWorked;}

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
    public void setMyProjectList(ArrayList<Project> myProjectList) {
        this.myProjectList = myProjectList;
    }
    public void setMyActivityList(ArrayList<Activity> myActivityList) {
        this.myActivityList = myActivityList;
    }
    public void setInitials(String initials) {
        this.initials = initials;
    }
    public void setHoursWorked(int hoursWorked) {this.hoursWorked = hoursWorked;}

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public void setUnavailableWeeks(ArrayList<Integer> unavailableWeeks) {
        this.unavailableWeeks = unavailableWeeks;
    }
    public void setLisOfManagersListOfProjects(ArrayList<Project> lisOfManagersListOfProjects) {
        this.lisOfManagersListOfProjects = lisOfManagersListOfProjects;
    }

    //--------------------------------------------------------------------------------
    }