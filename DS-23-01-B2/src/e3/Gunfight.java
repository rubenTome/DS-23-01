package e3;

import e3.behaviors.*;

public class Gunfight {
    public void duel(Gunslinger g1, Gunslinger g2) {
        DS_23_01 behavior = new DS_23_01();
        testBehavior behavior2 = new testBehavior();
        GunslingerAction ga1;
        GunslingerAction ga2;
        g1.setBehavior(behavior);
        g2.setBehavior(behavior2);//behavior2 es para pruebas, recarga hasta poder ametrallar

        int MAX = 25;
        int counter = 1;
        while (counter <= MAX) {
            ga1 =  g1.action(g2);
            ga2 = g2.action(g1);
            System.out.println("Round " + counter + "- - - - - - - - - - - - - - - - - - - - - - - - -\n");
            System.out.println("Gunslinger 1: " + ga1 + "\n");
            System.out.println("Gunslinger 2: " + ga2 + "\n");
            g1.rivalAction(ga2);
            g2.rivalAction(ga1);

            if (!ga1.equals(GunslingerAction.MACHINE_GUN) && !ga2.equals(GunslingerAction.MACHINE_GUN) &&
                    (
                            (ga1.equals(GunslingerAction.PROTECT) || ga2.equals(GunslingerAction.PROTECT)) ||
                                    (ga1.equals(GunslingerAction.RELOAD) && ga2.equals(GunslingerAction.RELOAD))
                    )
            )
                System.out.println("The duel continues . . .\n");
            else {
                System.out.println("\nThe duel has ended \n\n");
                System.out.println("Winner: ");//temporal
                if (ga1.equals(ga2) && (ga1.equals(GunslingerAction.MACHINE_GUN) || ga1.equals(GunslingerAction.SHOOT)))
                    System.out.println("tie");
                else {
                    if (ga1.equals(GunslingerAction.SHOOT))
                        System.out.println("GUNSLINGER 1");
                    else System.out.println("GUNSLINGER 2");
                }
                break;
            }
            counter++;
        }
    }
}
