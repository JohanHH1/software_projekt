package dtu.timeregistering.domain;

public class Employee {
    private String initials;
    private boolean isVacation;
    private boolean isSick;
    private final int maxNumberOfActivities = 20;

    public boolean isAvailable(){

        return false;
    }
    public int registerTime(int hours, String initials){

        return hours;
    }

}
