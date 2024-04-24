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
        activity.setMyProject(name);
        listOfActivities.add(activity);
    }

    public Activity getActivity(String activityName) {
        for (Activity listOfActivity : listOfActivities) {
            if (activityName.equals(listOfActivity.getActivityName())) {
                return listOfActivity;
            }
        }
        return null;
    }
    public void setActivityStartWeek(int startWeek, Activity activity){
        activity.setStartWeek(startWeek);
    }
    public void setActivityEndWeek(int endWeek, Activity activity){
        activity.setEndWeek(endWeek);
    }
     public Boolean hasTimeFrame(Activity activity){
         return activity.getStartWeek() != 0 && activity.getEndWeek() != 0;
     }

}
