package e3.behaviors;

import e3.Behavior;
import e3.Gunslinger;
import e3.GunslingerAction;

public class testBehavior implements Behavior {
    private int count = -1;

    public GunslingerAction action(Gunslinger g) {
        ++count;
        if (count == 5)
            return GunslingerAction.MACHINE_GUN;
        else
            return GunslingerAction.RELOAD;
    }
}