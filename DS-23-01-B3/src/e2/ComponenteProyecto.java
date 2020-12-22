package e2;


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

    public abstract String printComponents(String projectName, int indent);

    public abstract void addProjectEntry(String projectName);

    public abstract void endJourney(String projectName, int hoursInverted);
}
