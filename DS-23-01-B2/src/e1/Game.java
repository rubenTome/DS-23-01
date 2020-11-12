package e1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public void comprobarLuchadores(ArrayList<? extends Heroes> heroes, ArrayList<? extends Bestias> bestias,
                                    List<String> turnos){
        for(Heroes h : heroes){
            if(h.getLife() <= 0){
                heroes.remove(h);
                turnos.add(h.getClass() + h.getName() + "dies");
            }
        }
        for(Bestias b : bestias){
            if(b.getLife() <= 0){
                bestias.remove(b);
                turnos.add(b.getClass() + b.getName() + "dies");
            }
        }
    }

    public List<String> batalla(ArrayList< ? extends Heroes> heroes, ArrayList<? extends Bestias> bestias){

        Dados dadoH1 = new Dados();
        Dados dadoH2 = new Dados();
        Dados dadoB = new Dados();
        Random num = new Random();
        dadoH1.setAtaque(num.nextInt(100));
        dadoH2.setAtaque(num.nextInt(100));
        dadoB.setAtaque(num.nextInt(90));
        List<String> turnos = new ArrayList<>();
        int ataqueHeroe, ataqueBestia;
        int j = 1;

        while(heroes.size() != 0 && bestias.size() != 0){
            turnos.add("Turn " + j + ":");
            for(int i = 0; i < heroes.size() && i < bestias.size(); i++){
                if(heroes.get(i) != null && bestias.get(i) != null){
                    turnos.add("Fight between " + heroes.get(i).getName() + "(Energy =" + heroes.get(i).getLife()
                    + ")" + "and " + bestias.get(i).getName() + "(Energy =" + bestias.get(i).getLife() + ")");

                    ataqueHeroe = heroes.get(i).decidirAtaque(dadoH1.getAtaque(),dadoH2.getAtaque());
                    ataqueBestia = bestias.get(i).decidirAtaque(dadoB.getAtaque());

                    heroes.get(i).Atacar(ataqueHeroe, bestias.get(i));
                    bestias.get(i).Atacar(ataqueBestia, heroes.get(i));
                }
                comprobarLuchadores(heroes, bestias, turnos);
            }
            j++;
        }

        if(heroes.size() == 0) turnos.add("BESTIAS WIN !!");
        else turnos.add("HEROES WIN !!");

        return turnos;
    }

    public String toString(List<String> turnos) {
        return turnos.toString();
    }
}
