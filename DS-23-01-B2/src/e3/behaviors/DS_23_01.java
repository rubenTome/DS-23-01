package e3.behaviors;

import e3.Behavior;
import e3.Gunslinger;
import e3.GunslingerAction;

import java.util.List;
import java.util.Random;

/*
existen cambios respecto al pistolero del campeonato ademas de la semilla de random,
pero no se añaden porque seria necesario cambiar todo el test de esta clase
*/

public class DS_23_01 implements Behavior {
    private final Random r = new Random(2);
    private int prob, rivalLoads, limite;

    /**/public GunslingerAction action(Gunslinger g) {
        prob = r.nextInt(10);
        rivalLoads = g.getRivalLoads();
        limite = rivalLoads + 4;

        if (prob >= 8)
            prob = 8;

        if (g.getRivalActions().size() == 0)
            return GunslingerAction.RELOAD;

        if (prob < limite) {
            if (g.getLoads() > 0)
                return GunslingerAction.SHOOT;
        }

        if (prob >= limite && prob < 8)
            return GunslingerAction.PROTECT;

        else
            return GunslingerAction.RELOAD;
    }/**/
    /**/
}
