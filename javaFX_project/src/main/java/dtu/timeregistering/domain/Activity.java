package dtu.timeregistering.domain;

import java.util.ArrayList;
import java.util.Calendar;

public class Activity {

    private String activityName;
    private int budgetTime;
    private int startWeek;
    private int endWeek;
    private ArrayList<Employee> employeeOnActivity;
    private int budgetedHours;

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
}
