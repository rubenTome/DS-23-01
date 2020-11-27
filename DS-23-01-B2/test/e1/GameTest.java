package e1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;

    List<String> batalla = new ArrayList<>();

    ArrayList<Heroes> heroes = new ArrayList<>();
    ArrayList<Bestias> bestias = new ArrayList<>();

    Elfos elfos = new Elfos("Elfo", 150, 40);
    Humanos humanos = new Humanos("humano",50 , 60);
    Hobbits hobbits = new Hobbits("Hobbit", 100, 50 );
    Orcos orcos = new Orcos("Orco", 100, 50);
    Trasgos trasgos = new Trasgos("Trasgo", 50, 50);

    @Test
    void batalla() {
        heroes.add(elfos);
        heroes.add(humanos);
        heroes.add(hobbits);
        bestias.add(orcos);
        bestias.add(trasgos);

        game = new Game();
        batalla = game.batalla(heroes, bestias);


    }
}