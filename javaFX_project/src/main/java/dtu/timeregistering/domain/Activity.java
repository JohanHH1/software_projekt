package dtu.timeregistering.domain;

import java.util.ArrayList;
import java.util.Calendar;

public class Activity {

    //--------------------------------------------------------------------------------
    // Fields
    private String activityName;
    private String projectName;
    private int budgetedHours;
    private int startWeek;
    private int endWeek;
    private float hoursSpentOnActivity;
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

    public int getBudgetedHours() {
        return budgetedHours;
    }

    public String getProjectName() {
        return projectName;
    }

    public float getHoursSpentOnActivity() {
        return hoursSpentOnActivity;

    }
    //--------------------------------------------------------------------------------
    // Setters
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }
    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }
    public void setHoursSpentOnActivity(float hoursSpentOnActivity) {
        this.hoursSpentOnActivity = hoursSpentOnActivity;
    }
    public void setBudgetedHours(int budgetedHours) {
        this.budgetedHours = budgetedHours;
    }
    //--------------------------------------------------------------------------------

}
