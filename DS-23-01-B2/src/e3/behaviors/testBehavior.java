package e3.behaviors;

import e3.Behavior;
import e3.Gunslinger;
import e3.GunslingerAction;

import java.util.Random;

public class testBehavior implements Behavior {//solo para los test
    Random r = new Random();

    public GunslingerAction action(Gunslinger g) {
        if (g.getLoads() == 5)
            return GunslingerAction.MACHINE_GUN;
        else
            return GunslingerAction.RELOAD;
    }
}