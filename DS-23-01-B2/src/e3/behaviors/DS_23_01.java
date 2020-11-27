package e3.behaviors;

import e3.Behavior;
import e3.Gunslinger;
import e3.GunslingerAction;

import java.util.List;
import java.util.Random;

public class DS_23_01 implements Behavior {
    private final Random r = new Random(2);
    int prob, rivalLoads, limite;
    List<GunslingerAction> rivalActions;


    public GunslingerAction action(Gunslinger g) {
        prob = r.nextInt(10);
        rivalLoads = g.getRivalLoads();
        rivalActions = g.getRivalActions();
        limite = rivalLoads + 4;
        if (prob >= 8)
            prob = 8;

        if (g.getRivalActions().size() == 0)
            return GunslingerAction.RELOAD;

        if (rivalLoads >= 3 && g.getLoads() > 0)
            return GunslingerAction.SHOOT;


        if (prob < limite) {
            if (g.getLoads() > 0)
                return GunslingerAction.SHOOT;
        }

        if (prob >= limite && prob < 8)
            return GunslingerAction.PROTECT;

        else
            return GunslingerAction.RELOAD;
    }
}
