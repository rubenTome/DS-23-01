package e2;

import java.util.HashMap;

public class Trabajador extends ComponenteProyecto{
    private final int hourly_salary;
    private HashMap<String, Integer> projectHours = new HashMap<>();

    public Trabajador(String name, int hourly_salary) {
        super(name);
        this.hourly_salary = hourly_salary;
    }

    private int getHours(String projectName){
        return projectHours.get(projectName);
    }

    public String printWorkerInfo(String projectName){
        if(projectHours.containsKey(projectName)){
            return ("Worker " + getName() + ": " + totalHours(projectName) + " hours, " +
                    totalSalary(projectName) + " €");
        }
        else return ("This worker does not belong to this project\n");
    }

    @Override
    public void endJourney(String projectName, int hoursInverted){
        int oldHours = getHours(projectName);
        if(projectHours.containsKey(projectName)){
            projectHours.replace(projectName, oldHours, oldHours + hoursInverted);
        }
        else throw new NullPointerException("This worker does not belong to this project\n");
    }

    @Override
    public void addProjectEntry(String projectName){
        if(!projectHours.containsKey(projectName)){
            projectHours.put(projectName, 0);
        }
    }

    @Override
    public int totalHours(String projectName){
        return getHours(projectName);
    }

    @Override
    public int totalSalary(String projectName){
        return hourly_salary * projectHours.get(projectName);
    }

    @Override
    public String printComponents(String projectName, int indent){
        return ("Worker " + getName() + ": " + totalHours(projectName) + " hours, " +
                totalSalary(projectName) + " €\n");
    }


}
