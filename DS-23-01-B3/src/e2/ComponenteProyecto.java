package e2;

import java.util.List;

public abstract class ComponenteProyecto {
    private String name;
    public ComponenteProyecto(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int totalHours(String projectName);

    public abstract int totalSalary(String projectName);

    public abstract void printComponents(String projectName);

    public abstract void addProjectEntry(String projectName);
}
