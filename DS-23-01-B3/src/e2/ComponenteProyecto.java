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

    public abstract float totalHours(String projectName);

    public abstract float totalSalary(String projectName);

    public abstract String printComponents(String projectName, int indent);

    public abstract void addProjectEntry(String projectName);

    public abstract void endJourney(String projectName, float hoursInverted);

    public abstract List<String> coworkers(List<String> coworkers, Proyecto proyecto);
}
