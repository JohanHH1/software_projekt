package dtu.timeregistering.app;

import dtu.timeregistering.domain.Activity;
import dtu.timeregistering.domain.Project;
import dtu.timeregistering.ui.Start;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimeApp {

    Project project;
    Start start;

    ArrayList<Project> listOfProjects = new ArrayList<>();


    public TimeApp() {
    }

    public void addProject(String projectName) throws IllegalArgumentException {
        if (isInProjectList(projectName)) {
            throw new IllegalArgumentException("A project with this name already exists");
        }
        Project project = new Project(projectName);
        listOfProjects.add(project);
    }

    public boolean isInProjectList(String projectName) throws IllegalArgumentException {
        return listOfProjects.contains(getProject(projectName));
    }
    public boolean isInActivityList(String activityName, String projectName) {
        Project gottenProject = listOfProjects.stream().filter(project->project.getName().equals(projectName)).findFirst().orElseThrow();
        return gottenProject.getListOfActivities().contains(gottenProject.getActivity(activityName));
    }

    public ArrayList<Project> getProjects() {
        return listOfProjects;
    }

    public void createActivity(String activityName, Project projectName) {
        projectName.addActivity(activityName);
    }

    public Project getProject(String projectName) {
        for (Project listOfProject : listOfProjects) {
            if (projectName.equals(listOfProject.getName())) {
                return listOfProject;
            }
        }
        return null;
    }

    public void displayAllProjectNames() {
        for (Project listOfProject : listOfProjects) {
            System.out.println(listOfProject.getName());
        }
    }
    public void displayAllActivitiesInProject(Project project) {
        for (Activity listOfActivity : project.getListOfActivities()){
            System.out.println(listOfActivity.getActivityName());
        }
    }

}