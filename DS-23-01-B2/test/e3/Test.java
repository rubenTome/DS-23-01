package e3;

import e3.behaviors.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestClass {
    @Test
    void Test() {
        Gunfight g = new Gunfight();
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        g.duel(g1, g2);
        //
        g1 = new Gunslinger();
        g2 = new Gunslinger();
        testBehavior tB = new testBehavior();
        g1.setBehavior(tB);
        g2.setBehavior(tB);

        assertEquals(g1.action(g2), GunslingerAction.RELOAD);//DUDAS DE SI ESTA OK EL TEST
        g2.rivalAction(GunslingerAction.RELOAD);
        assertEquals(g2.getRivalLoads(), 1);
        assertEquals(g1.action(g2), GunslingerAction.RELOAD);
        g2.rivalAction(GunslingerAction.RELOAD);
        assertEquals(g2.getRivalLoads(), 2);
        assertEquals(g1.action(g2), GunslingerAction.RELOAD);
        g2.rivalAction(GunslingerAction.RELOAD);
        assertEquals(g2.getRivalLoads(), 3);
        assertEquals(g1.action(g2), GunslingerAction.RELOAD);
        g2.rivalAction(GunslingerAction.RELOAD);
        assertEquals(g2.getRivalLoads(), 4);
        assertEquals(g1.action(g2), GunslingerAction.RELOAD);
        g2.rivalAction(GunslingerAction.RELOAD);
        assertEquals(g2.getRivalLoads(), 5);
        assertEquals(g1.action(g2), GunslingerAction.MACHINE_GUN);



    }
}