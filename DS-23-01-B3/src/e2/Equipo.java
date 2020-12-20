package e2;

import java.util.ArrayList;
import java.util.List;

public class Equipo extends ComponenteProyecto{
    private List<ComponenteProyecto> listcomp = new ArrayList<>();

    public Equipo(String name){
        super(name);
    }

    public void insertar(ComponenteProyecto comp){
        listcomp.add(comp);
    }

    public void eliminar(ComponenteProyecto comp){
        listcomp.remove(comp);
    }

    public ComponenteProyecto getComponente(int index){
        return listcomp.get(index);
    }

    @Override
    public void addProjectEntry(String projectName){
        for(ComponenteProyecto comp : listcomp){
            comp.addProjectEntry(projectName);
        }
    }

    @Override
    public int totalSalary(String projectName){
        int salario = 0;
        for(ComponenteProyecto comp : listcomp){
            salario += comp.totalSalary(projectName);
        }
        return salario;
    }

    @Override
    public int totalHours(String projectName){
        int horas = 0;
        for(ComponenteProyecto comp : listcomp){
            horas += comp.totalHours(projectName);
        }
        return horas;
    }

    @Override
    public void printComponents(String projectName){

        System.out.println("Team " + getName() + ": " + totalHours(projectName) + " hours, " +
                totalSalary(projectName) + " €");

        for(ComponenteProyecto comp : listcomp){
            System.out.print("\t");
            comp.printComponents(projectName);
        }
    }

}
