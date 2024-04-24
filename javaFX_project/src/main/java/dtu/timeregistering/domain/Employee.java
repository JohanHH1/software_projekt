package dtu.timeregistering.domain;

import java.util.ArrayList;

public class Employee {

    private String initials;
    private boolean isVacation;
    private boolean isSick;
    private final int maxNumberOfActivities = 20;

    private boolean loggedIn;

    private boolean isProjectManager;

    ArrayList<Activity> myActivityList = new ArrayList<>();
    public Employee(String initials) {
        this.initials = initials;
    }

    public boolean isAvailable(){

        return false;
    }
    public int registerTime(int hours, String initials){

        return hours;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public boolean isVacation() {
        return isVacation;
    }

    public void setVacation(boolean vacation) {
        isVacation = vacation;
    }

    public boolean isSick() {
        return isSick;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }

    public int getMaxNumberOfActivities() {
        return maxNumberOfActivities;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getName() {
        return initials;
    }

    public boolean isProjectManager() { return isProjectManager;}

    public void setProjectManager(boolean projectManager) {
        isProjectManager = projectManager;
    }
    public ArrayList<Activity> getMyActivityList() {
        return myActivityList;
    }

    public void setMyActivityList(ArrayList<Activity> myActivityList) {
        this.myActivityList = myActivityList;
    }
}

