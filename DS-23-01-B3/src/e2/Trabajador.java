package e2;

import java.util.HashMap;
import java.util.Random;

public class Trabajador extends ComponenteProyecto{
    private final int hourly_salary;
    private HashMap<String, Integer> projectHours = new HashMap<>();
    Random rand= new Random();

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
    public void addProjectEntry(String projectName){
        if(!projectHours.containsKey(projectName)){
            projectHours.put(projectName, 15 + rand.nextInt(60));
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
    public void printComponents(String projectName){
        System.out.println("Worker " + getName() + ": " + totalHours(projectName) + " hours, " +
                totalSalary(projectName) + " €");
    }


}
