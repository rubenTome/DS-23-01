package e3.behaviors;

import e3.Behavior;
import e3.Gunslinger;
import e3.GunslingerAction;

import java.util.List;
import java.util.Random;

public class DS_23_01 implements Behavior {
    Random random = new Random();
    int prob, rivalLoads;
    List <GunslingerAction> rivalActions;

    public GunslingerAction action(Gunslinger g) {
        Random r = new Random();
        prob = r.nextInt(10);
        rivalLoads = g.getRivalLoads();
        rivalActions = g.getRivalActions();

        if (g.getRivalActions().size() == 0)
            return GunslingerAction.RELOAD;

        if (rivalLoads == 3 && g.getLoads() > 0)
            return GunslingerAction.SHOOT;

        if (prob < 4) {
            if (g.getLoads() > 0)
                return GunslingerAction.SHOOT;
        }

        if (prob > 3 && prob < 8)
            return GunslingerAction.PROTECT;

        else
            return GunslingerAction.RELOAD;
    }
}
