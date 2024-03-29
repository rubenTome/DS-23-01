package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Proyecto {
    private List<ComponenteProyecto> Teams = new ArrayList<>();
    private final String name;

    public Proyecto(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public List<ComponenteProyecto> getTeams(){
        return Collections.unmodifiableList(Teams);
    }

    public void addTeam(ComponenteProyecto team){
        Teams.add(team);
        for(ComponenteProyecto comp : Teams){
            comp.addProjectEntry(this.name);
        }
    }

    public String printProyect() {
        StringBuilder sb = new StringBuilder();
        for(ComponenteProyecto team : Teams){
            sb.append(team.printComponents(this.name, 1));
        }
        return sb.toString();
    }

    public List<String> coworkers(ComponenteProyecto origen, List<String> listadestino){
        for(ComponenteProyecto team : this.getTeams()){
            team.coworkers(listadestino, this);
        }
        return listadestino;
    }

}
