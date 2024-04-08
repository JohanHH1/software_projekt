package dtu.timeregistering.ui;

import dtu.timeregistering.app.Project;

import java.util.ArrayList;

public class ProjectManager {
    private ArrayList<Project> projects;

    public void addProject(Project p){
        projects.add(p);
    }
}
