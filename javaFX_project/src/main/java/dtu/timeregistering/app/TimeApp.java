package dtu.timeregistering.app;

import dtu.timeregistering.domain.Project;
import dtu.timeregistering.ui.Start;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TimeApp {

    Project project;
    Start start;

    ArrayList<String> listOfProjects = new ArrayList<>();
    public TimeApp() {
    }

    public void addProject(String projectName) throws IllegalArgumentException {
        if(isIn(projectName)){
            throw new IllegalArgumentException("A project with this name already exists");
        }
        listOfProjects.add(projectName);
    }

    public boolean isIn(String projectName) throws IllegalArgumentException{
        return listOfProjects.contains(projectName);
        }

    public ArrayList<String> getProjects() {
        return listOfProjects;
    }
}