package e2;

import java.util.HashMap;
import java.util.List;

public class Trabajador extends ComponenteProyecto{
    private int hourly_salary;
    private int hours;
    private HashMap<String, Integer> projectHours = new HashMap<>();

    public Trabajador(String name, int salary, int hours) {
        super(name);
        this.hourly_salary = salary;
        this.hours = hours;
    }

    public int getHourly_salary(){
        return hourly_salary;
    }

    public int getHours(){
        return hours;
    }

    public void setHourly_salary(int hourly_salary){
        this.hourly_salary = hourly_salary;
    }

    public void setHours(int hours){
        this.hours = hours;
    }

    private void addProjectEntry(){

    }

    @Override
    public int totalHours(){
        return hours;
    }

    @Override
    public int totalSalary(){
        return hourly_salary * hours;
    }

    @Override
    public void printComponents(){
        System.out.print(" " + getName());
        System.out.println(" : " + getHours());
        System.out.println(" , " + totalSalary());
    }


}
