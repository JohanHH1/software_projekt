package dtu.timeregistering.domain;

import java.util.ArrayList;
import java.util.Calendar;

public class Activity {
    private String activityName;
    private Calendar budgetTime;
    private Calendar startWeek;
    private Calendar endWeek;
    private ArrayList<Employee> employeeOnActivity;
    private int budgetedHours;
    public Activity(String name) {
        this.activityName = name;
    }
}
