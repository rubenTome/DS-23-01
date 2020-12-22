package e2;

import java.util.HashMap;
import java.util.List;

public class Trabajador extends ComponenteProyecto{
    private final float hourlySalary;
    private HashMap<String, Float> projectHours = new HashMap<>();

    public Trabajador(String name, float hourlySalary) {
        super(name);
        this.hourlySalary = hourlySalary;
    }

    private float getHours(String projectName){
        return projectHours.get(projectName);
    }

    public String printWorkerInfo(String projectName){
        if(projectHours.containsKey(projectName)){
            return ("Worker " + getName() + ": " + totalHours(projectName) + " hours, " +
                    totalSalary(projectName) + " €\n");
        }
        else return ("This worker does not belong to this project\n");
    }

    @Override
    public void endJourney(String projectName, float hoursInverted){
        float oldHours = getHours(projectName);
        if(projectHours.containsKey(projectName)){
            projectHours.replace(projectName, oldHours, oldHours + hoursInverted);
        }
        else throw new NullPointerException("This worker does not belong to this project\n");
    }

    @Override
    public void addProjectEntry(String projectName){
        if(!projectHours.containsKey(projectName)){
            projectHours.put(projectName, 0f);
        }
    }

    @Override
    public float totalHours(String projectName){
        return getHours(projectName);
    }

    @Override
    public float totalSalary(String projectName){
        return hourlySalary * projectHours.get(projectName);
    }

    @Override
    public String printComponents(String projectName, int indent){
        return printWorkerInfo(projectName);
    }

    @Override
    public List<String> coworkers(List<String> coworkers, Proyecto proyecto){
        if(projectHours.containsKey(proyecto.getName())){
            coworkers.add(this.printWorkerInfo(proyecto.getName()));
        }
        else throw new NullPointerException("This worker does not belong to this project\n");
        return coworkers;
    }


}
