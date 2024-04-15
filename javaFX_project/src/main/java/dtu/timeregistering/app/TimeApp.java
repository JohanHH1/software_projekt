package dtu.timeregistering.app;

import dtu.timeregistering.domain.Project;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TimeApp {

    Project project;

    ArrayList<String> listOfProjects = new ArrayList<>();
    public TimeApp() {
    }

    public void addProject(String projectName) {
        listOfProjects.add(projectName);
    }

    public void isIn(String projectName) throws IllegalArgumentException{
        if(listOfProjects.contains(projectName)){
            System.out.println("HEJ");
            throw new IllegalArgumentException("Project already exists");
            }
        }
    }