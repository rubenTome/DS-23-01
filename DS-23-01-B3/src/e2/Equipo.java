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
    public int totalSalary(){
        int salario = 0;
        for(ComponenteProyecto comp : listcomp){
            salario += comp.totalSalary();
        }
        return salario;
    }

    @Override
    public int totalHours(){
        int horas = 0;
        for(ComponenteProyecto comp : listcomp){
            horas += comp.totalHours();
        }
        return horas;
    }

    @Override
    public void printComponents(){

        System.out.println(getName() + ": " + totalHours() + ", " + totalSalary());

        for(ComponenteProyecto comp : listcomp){
            System.out.println("\t");
            comp.printComponents();
        }
    }

}
