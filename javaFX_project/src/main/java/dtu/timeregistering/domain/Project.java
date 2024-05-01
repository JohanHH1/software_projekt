package dtu.timeregistering.domain;
import java.time.YearMonth;
import java.util.ArrayList;

public class Project {
    //--------------------------------------------------------------------------------
    // Fields
    private int projectNumber;
    private String projectName;
    private boolean hasProjectManager;
    // Lists
    private ArrayList<Activity> listOfActivities = new ArrayList<>();
    private Employee projectManager;
    private int count = 0;
    private int serialNumber;

    //--------------------------------------------------------------------------------

    // Constructor
    public Project(String projectName) {
        this.projectName = projectName;
    }

    //--------------------------------------------------------------------------------
    // Initialize

    //--------------------------------------------------------------------------------
    // Booleans
    public Boolean hasTimeFrame(Activity activity){
        return activity.getStartWeek() != 0 && activity.getEndWeek() != 0;
    }
    //--------------------------------------------------------------------------------
    // Methods
    public void addActivity(String activityName){

        Activity activity = new Activity(activityName);
        activity.setProjectName(projectName);
        listOfActivities.add(activity);
    }
    //--------------------------------------------------------------------------------
    // Getters
    public String getProjectName() {
        return projectName;
    }
    public ArrayList<Activity> getListOfActivities() {
        return listOfActivities;
    }
    public Activity getActivity(String activityName) {
        String normalizedActivityName = activityName.toLowerCase(); // Convert activity name to lowercase
        for (Activity activity : listOfActivities) {
            if (activityName.equalsIgnoreCase(activity.getActivityName())) {
                return activity;
            }
        }
        return null;
    }

    public Employee getProjectManager() {
        return projectManager;
    }

    public boolean getHasProjectManager() {
        return hasProjectManager;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    //--------------------------------------------------------------------------------
    // Setters
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public void setListOfActivities(ArrayList<Activity> listOfActivities) {
        this.listOfActivities = listOfActivities;
    }
    public void setActivityStartWeek(int startWeek, Activity activity){
        activity.setStartWeek(startWeek);
    }
    public void setActivityEndWeek(int endWeek, Activity activity){
        activity.setEndWeek(endWeek);
    }

    public void setHasProjectManager(boolean hasProjectManager) {
        this.hasProjectManager = hasProjectManager;
    }

    public void setProjectManager(Employee projectManager) {
        this.projectManager = projectManager;
    }

    public void setProjectNumber() {
        int year = YearMonth.now().getYear();
        serialNumber = ++ count;
        this.projectNumber = (year - 2000) * 1000 + count;
    }
    //--------------------------------------------------------------------------------
}
