package dtu.timeregistering.domain;

import java.util.ArrayList;
import java.util.Calendar;

public class Activity {

    //--------------------------------------------------------------------------------
    // Fields
    private String activityName;
    private String projectName;
    private int budgetTime;
    private int startWeek;
    private int endWeek;
    private int hoursSpentOnActivity;
    // Lists
    private ArrayList<Employee> listOfEmployeesInActivity = new ArrayList<>();
    //--------------------------------------------------------------------------------
    // Constructor
    public Activity(String activityName) {
        this.activityName = activityName;
    }
    //--------------------------------------------------------------------------------
    // Booleans


    //--------------------------------------------------------------------------------
    // Methods


    //--------------------------------------------------------------------------------
    // Getters
    public int getStartWeek() {
        return startWeek;
    }
    public int getEndWeek() {
        return endWeek;
    }
    public String getActivityName() {
        return activityName;
    }
    public ArrayList<Employee> getListOfEmployeesInActivity() {
        return listOfEmployeesInActivity;
    }
    public int getHoursSpentOnActivity() {
        return hoursSpentOnActivity;
    }
    //--------------------------------------------------------------------------------
    // Setters
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }
    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }
    public void setListOfEmployeesInActivity(ArrayList<Employee> listOfEmployeesInActivity) {
        this.listOfEmployeesInActivity = listOfEmployeesInActivity;
    }
    public void setHoursSpentOnActivity(int hoursSpentOnActivity) {
        this.hoursSpentOnActivity = hoursSpentOnActivity;
    }

    //--------------------------------------------------------------------------------

}
