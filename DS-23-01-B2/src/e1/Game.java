package e1;

import java.util.ArrayList;

public class Game {

    public void comprobarLuchadores(ArrayList<? extends Heroes> heroes, ArrayList<? extends Bestias> bestias){
        for(Heroes h : heroes){
            if(h.getLife() <= 0) heroes.remove(h);
        }
        for(Bestias b : bestias){
            if(b.getLife() <= 0) bestias.remove(b);
        }
    }

    public void batalla(ArrayList< ? extends Heroes> heroes, ArrayList<? extends Bestias> bestias, int dadoH1, int dadoH2,
                        int dadoB){
        while(heroes.size() != 0 && bestias.size() != 0){
            for(int i = 0; i < heroes.size() && i < bestias.size(); i++){
                if(heroes.get(i) != null && bestias.get(i) != null){
                    bestias.get(i).calcularDammage(heroes.get(i).decidirAtaque(dadoH1,dadoH2));
                    heroes.get(i).calcularDammage(bestias.get(i).decidirAtaque(dadoB));
                }
                comprobarLuchadores(heroes, bestias);
            }
        }
    }
}
