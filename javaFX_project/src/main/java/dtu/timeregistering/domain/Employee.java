package dtu.timeregistering.domain;

import java.util.ArrayList;

public class Employee {

    //--------------------------------------------------------------------------------
    // Fields:
    private String initials;
    private boolean isVacation;
    private boolean isSick;
    private final int maxNumberOfActivities = 20;
    private boolean loggedIn;
    private boolean isProjectManager;
    private int hoursWorked;
    // Lists
    private ArrayList<Activity> myActivityList = new ArrayList<>();
    private ArrayList<Project> myProjectList = new ArrayList<>();
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
        return false;
    }
    public boolean isVacation() {
        return isVacation;
    }
    public boolean isSick() {
        return isSick;
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
    public void setVacation(boolean vacation) {
        isVacation = vacation;
    }
    public void setSick(boolean sick) {
        isSick = sick;
    }
    public void setHoursWorked(int hoursWorked) {this.hoursWorked = hoursWorked;}

    //--------------------------------------------------------------------------------
    }