package e3;

import java.util.ArrayList;
import java.util.List;

public class Gunslinger {
    private Behavior behavior;
    private int loads = 0;
    private final List<GunslingerAction> GunslingerActionList = new ArrayList<>();//lista de acciones del rival

    public GunslingerAction action(Gunslinger g) {
        GunslingerAction ga = behavior.action(g);
        if (ga.equals(GunslingerAction.RELOAD))
            ++loads;
        if (ga.equals(GunslingerAction.SHOOT))
            --loads;
        return ga;
    }

    public int getLoads() {
        return loads;
    }

    public void rivalAction(GunslingerAction action) {
        GunslingerActionList.add(action);
    }

    public List<GunslingerAction> getRivalActions() {
        return GunslingerActionList;
    }

    public int getRivalLoads() {
        int rivalReloads = 0;
        for (GunslingerAction ga : GunslingerActionList) {
            if (ga.equals(GunslingerAction.RELOAD))
                ++rivalReloads;
            if (ga.equals(GunslingerAction.SHOOT))
                --rivalReloads;
        }
        return rivalReloads;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

}
