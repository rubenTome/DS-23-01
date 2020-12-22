package e2;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<ComponenteProyecto> getListaTrabajadores(){
        return Collections.unmodifiableList(listcomp);
    }

    @Override
    public void endJourney(String projectName, int hoursInverted){
        for(ComponenteProyecto comp : listcomp){
            comp.endJourney(projectName, hoursInverted);
        }
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
    public String printComponents(String projectName, int indent){

        StringBuilder sb = new StringBuilder();

        sb.append("Team ").append(getName()).append(": ").append(totalHours(projectName)).append(" hours, ")
                .append(totalSalary(projectName)).append(" €\n");

        for(ComponenteProyecto comp : listcomp){
            for(int i = 0; i < indent; i++){
                sb.append("\t");
            }
            if(comp.getClass().equals(Equipo.class)){
                sb.append(comp.printComponents(projectName, indent + 1));
            }
            else sb.append(comp.printComponents(projectName, indent));
        }
        return sb.toString();
    }

}
