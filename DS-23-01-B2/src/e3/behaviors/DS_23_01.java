package e3.behaviors;

import e3.Behavior;
import e3.Gunslinger;
import e3.GunslingerAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DS_23_01 implements Behavior {
    Random random = new Random();

    public GunslingerAction action(Gunslinger g) {
        List<GunslingerAction> rivalList = g.getRivalActions();
        int listLength = rivalList.size();
        if (listLength != 0) {
            --listLength;
            if (listLength == 1)//round 2
                return GunslingerAction.SHOOT;
            if (listLength == 2) //round 3
                return GunslingerAction.PROTECT;
            if (listLength == 3) {//round 4
                if (rivalList.get(listLength).equals(GunslingerAction.PROTECT))
                    return GunslingerAction.PROTECT;
                else return GunslingerAction.RELOAD;
            }
            if (listLength == 4) {//round 5
                return GunslingerAction.SHOOT;
            } else {//ojo con esto
                if (g.getLoads() == 0)
                    return GunslingerAction.RELOAD;//temporal
                else if (random.nextInt(2) == 1)
                    return GunslingerAction.PROTECT;
                else return GunslingerAction.RELOAD;
            }
        } else return GunslingerAction.RELOAD;//round 1
    }
}
