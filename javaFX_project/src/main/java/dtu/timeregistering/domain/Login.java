package dtu.timeregistering.domain;

import java.util.ArrayList;

public class Login {
    // Fields
    private String initials;
    public ArrayList<String> employees;
    public ArrayList<String> projectManagers;

    // Constructor
    public Login(String initials) {
        this.initials = initials;
    }

    public boolean isEmployee (){
        return false;
    }
    public boolean isAvailable (){
        return false;
    }
    public void addEmployee (String employees){

    }
    public void deleteEmployee(){

    }
}