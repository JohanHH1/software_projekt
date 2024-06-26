package dtu.timeregistering.domain;
import java.time.YearMonth;
import java.util.ArrayList;

public class Project {
    //--------------------------------------------------------------------------------
    // Fields
    private int projectNumber;
    private String projectName;
    private boolean hasProjectManager;
    private int count;
    // Lists
    private ArrayList<Activity> listOfActivities = new ArrayList<>();
    private Employee projectManager;

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
    //Patrick - method to add activity - uses a manually coded stream
    public void addActivity(String activityName) throws Exception{
        for(Activity activityVariable : listOfActivities) {
            if (activityVariable.getActivityName().equals(activityName)) {
                throw new IllegalArgumentException("Activity already exists in this project");
            }
        }
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
    public void setHasProjectManager(boolean hasProjectManager) {
        this.hasProjectManager = hasProjectManager;
    }
    public void setProjectManager(Employee projectManager) {
        this.projectManager = projectManager;
    }
    public void setCount(int counter) {
        this.count = counter;
    }
    public void setProjectNumber() {
        int year = YearMonth.now().getYear();
        this.projectNumber = (year - 2000) * 1000 + count;

    }
    //--------------------------------------------------------------------------------
}