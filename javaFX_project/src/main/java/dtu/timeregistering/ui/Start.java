package dtu.timeregistering.ui;
import dtu.timeregistering.app.TimeApp;

import java.util.*;
import java.io.*;
public class Start {
    TimeApp timeapp = new TimeApp();
    public static void main(String[] args){
        new Start().start();
    }
    public void start() {
        int nr;
        System.out.println("Welcome");
        do {
            System.out.println("1. Create project");
            Scanner console = new Scanner(System.in);
            nr = console.nextInt();
            console.nextLine();
            if (nr == 1) {
                System.out.println("Please enter projectname");
                String projectName = console.nextLine();
                    try {
                        timeapp.addProject(projectName);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                System.out.println(timeapp.getProjects());
            }
        } while(nr!=0);
    }

    }

