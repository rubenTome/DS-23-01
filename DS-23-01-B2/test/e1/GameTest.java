package e1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;
    Game game2;

    List<String> batalla = new ArrayList<>();
    List<String> batalla2 = new ArrayList<>();

    ArrayList<Heroes> heroes = new ArrayList<>();
    ArrayList<Bestias> bestias = new ArrayList<>();
    ArrayList<Heroes> heroes2 = new ArrayList<>();
    ArrayList<Bestias> bestias2 = new ArrayList<>();

    Elfos elfos = new Elfos("Elfo", 150, 40);
    Humanos humanos = new Humanos("humano",50 , 60);
    Hobbits hobbits = new Hobbits("Hobbit", 100, 50 );
    Orcos orcos = new Orcos("Orco", 100, 50);
    Trasgos trasgos = new Trasgos("Trasgo", 50, 50);


    Elfos elfos2 = new Elfos("Elfo2", 50, 20);
    Humanos humanos2 = new Humanos("humano2",50 , 50);
    Hobbits hobbits2 = new Hobbits("Hobbit2", 50, 30 );
    Orcos orcos2 = new Orcos("Orco2", 100, 50);
    Trasgos trasgos2 = new Trasgos("Trasgo2", 50, 50);

    @Test
    void batalla() {
        Dados dadoH1 = new Dados();
        Dados dadoH2 = new Dados();
        Dados dadoB = new Dados();//modificado el tema de dados, revisar

        heroes.add(elfos);
        heroes.add(humanos);
        heroes.add(hobbits);
        bestias.add(orcos);
        bestias.add(trasgos);

        game = new Game();
        batalla = game.batalla(heroes, bestias, dadoH1, dadoH2, dadoB);

        for (String s : batalla) {
            System.out.println(s);
        }




        heroes2.add(elfos2);
        heroes2.add(humanos2);
        heroes2.add(hobbits2);
        bestias2.add(orcos2);
        bestias2.add(trasgos2);

        game2 = new Game();
        batalla2 = game2.batalla(heroes2, bestias2, dadoH1, dadoH2, dadoB);

        for (String s : batalla2) {
            System.out.println(s);
        }


    }
}