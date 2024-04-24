package dtu.timeregistering.domain;

import java.util.ArrayList;
import java.util.Calendar;

public class Activity {

    private String activityName;
    private int budgetTime;
    private int startWeek;
    private int endWeek;
    private int budgetedHours;
    ArrayList<Employee> listOfEmployeesInActivity = new ArrayList<>();

    private String myProject;

    public Activity(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getBudgetTime() {
        return budgetTime;
    }

    public void setBudgetTime(int budgetTime) {
        this.budgetTime = budgetTime;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }

    public String getMyProject() {
        return myProject;
    }

    public void setMyProject(String myProject) {
        this.myProject = myProject;
    }

    public ArrayList<Employee> getListOfEmployeesInActivity() {
        return listOfEmployeesInActivity;
    }

    public void setListOfEmployeesInActivity(ArrayList<Employee> listOfEmployeesInActivity) {
        this.listOfEmployeesInActivity = listOfEmployeesInActivity;
    }
}
