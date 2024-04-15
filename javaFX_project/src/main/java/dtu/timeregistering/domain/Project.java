package dtu.timeregistering.domain;

public class Project {

    private String name;
    private int projectNumber;

    private boolean internal;
    private boolean external;

    public Project(String name, int projectNumber, boolean internal, boolean external) {
        this.name = name;
        this.projectNumber = projectNumber;
        this.internal = internal;
        this.external = external;
    }

    public String getName() {
        return name;
    }
}
