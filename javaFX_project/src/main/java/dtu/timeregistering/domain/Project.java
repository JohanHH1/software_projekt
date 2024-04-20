package dtu.timeregistering.domain;

import java.util.ArrayList;

public class Project {

    private String name;
    private ArrayList<Activity> listOfActivities = new ArrayList<>();
    private int projectNumber;


    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Activity> getListOfActivities() {
        return listOfActivities;
    }

    public void setListOfActivities(ArrayList<Activity> listOfActivities) {
        this.listOfActivities = listOfActivities;
    }
    public void addActivity(String activityName){
        Activity activity = new Activity(activityName);
        listOfActivities.add(activity);
    }


}
