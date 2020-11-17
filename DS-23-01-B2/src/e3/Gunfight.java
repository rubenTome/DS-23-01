package e3;

public class Gunfight {
    public void duel(Gunslinger g1, Gunslinger g2) {
        GunslingerAction ga1;
        GunslingerAction ga2;

        int MAX = 25;
        int counter = 1;
        while (counter <= MAX) {
            ga1 = g1.action(g1);
            ga2 = g2.action(g2);
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
