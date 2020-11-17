package e3.behaviors;

import e3.Behavior;
import e3.Gunslinger;
import e3.GunslingerAction;

import java.util.List;
import java.util.Random;

public class DS_23_01 implements Behavior {
    Random random = new Random();

    public GunslingerAction action(Gunslinger g) {
        List<GunslingerAction> rivalList = g.getRivalActions();
        int listLength = rivalList.size();
        if (listLength != 0) {
            --listLength;
            if (listLength == 0)//round 2
                return GunslingerAction.SHOOT;
            if (listLength == 1) //round 3
                return GunslingerAction.PROTECT;
            if (listLength == 2) {//round 4
                if (rivalList.get(listLength).equals(GunslingerAction.PROTECT))
                    return GunslingerAction.PROTECT;
                else
                    return GunslingerAction.RELOAD;
            }
            if (listLength == 3) {//round 5
                if (g.getLoads() > 0)
                    return GunslingerAction.SHOOT;
                else
                    return GunslingerAction.RELOAD;
            } else
                return GunslingerAction.RELOAD;//temporal, hay que modificar a partir de aqui
        } else return GunslingerAction.RELOAD;//round 1
    }
}
