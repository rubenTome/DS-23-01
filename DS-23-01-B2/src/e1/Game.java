package e1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Game {

    public void comprobarLuchadores(ArrayList<? extends Heroes> heroes, ArrayList<? extends Bestias> bestias,
                                    List<String> turnos){

        for(int i = 0; i < heroes.size(); i++){
            if(heroes.get(i).getLife() <= 0){
                turnos.add(heroes.get(i).getClass() + " " + heroes.get(i).getName() + " dies\n");
                heroes.remove(heroes.get(i));
            }
        }
        for(int j = 0; j < bestias.size(); j++){
            if(bestias.get(j).getLife() <= 0){
                turnos.add(bestias.get(j).getClass() + " " + bestias.get(j).getName() + " dies\n");
                bestias.remove(bestias.get(j));
            }
        }
    }

    public List<String> batalla(ArrayList< ? extends Heroes> heroes, ArrayList<? extends Bestias> bestias){

        Dados dadoH1 = new Dados();
        Dados dadoH2 = new Dados();
        Dados dadoB = new Dados();
        Random num = new Random(1);

        dadoH1.setAtaque(num.nextInt(101));
        dadoH2.setAtaque(num.nextInt(101));
        dadoB.setAtaque(num.nextInt(91));

        List<String> turnos = new ArrayList<>();
        int ataqueHeroe, ataqueBestia;
        int j = 1;

        while(heroes.size() != 0 && bestias.size() != 0){
            turnos.add("\nTurn " + j + ": \n");
            for(int i = 0; i < Math.min(heroes.size(),bestias.size()); i++){
                if(heroes.get(i) != null && bestias.get(i) != null){
                    turnos.add("Fight between " + heroes.get(i).getName() + "(Energy = " + heroes.get(i).getLife()
                    + ")" + " and " + bestias.get(i).getName() + "(Energy = " + bestias.get(i).getLife() + ")\n");

                    ataqueHeroe = heroes.get(i).decidirAtaque(dadoH1.getAtaque(),dadoH2.getAtaque());
                    ataqueBestia = bestias.get(i).decidirAtaque(dadoB.getAtaque());

                    heroes.get(i).Atacar(ataqueHeroe, bestias.get(i));
                    bestias.get(i).Atacar(ataqueBestia, heroes.get(i));
                }
                comprobarLuchadores(heroes, bestias, turnos);
            }
            j++;
        }

        if(heroes.size() == 0) turnos.add("BESTIAS WIN !!\n");
        else turnos.add("HEROES WIN !!\n");

        return turnos;
    }

    public String toString(List<String> turnos) {
        return turnos.toString();
    }
}
