package e2;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private List<ComponenteProyecto> Teams = new ArrayList<>();
    private final String name;

    public Proyecto(String name){
        this.name = name;
    }

    public void addTeam(ComponenteProyecto team){
        Teams.add(team);
    }

    public void printProyect() {
        for(ComponenteProyecto comp : Teams){
            comp.printComponents();
        }
    }
}
