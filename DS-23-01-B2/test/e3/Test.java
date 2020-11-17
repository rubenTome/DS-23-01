package e3;

import e3.behaviors.DS_23_01;
import e3.behaviors.testBehavior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestClass {

    DS_23_01 be = new DS_23_01();

    @Test
    void TestDuel() {
        testBehavior tBe = new testBehavior();
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        g1.setBehavior(be);
        g2.setBehavior(tBe);
        Gunfight g = new Gunfight();
        g.duel(g1, g2);//
        assertTrue(true);
    }

    @Test
    void testRivalLoad() {
        Gunslinger g11 = new Gunslinger();
        g11.setBehavior(be);
        g11.rivalAction(GunslingerAction.RELOAD);
        g11.rivalAction(GunslingerAction.SHOOT);
        g11.rivalAction(GunslingerAction.RELOAD);//3 acciones del rival
        assertEquals(g11.getRivalLoads(), 1);
    }

    @Test
    void testDS() {
        Gunslinger g1 = new Gunslinger();
        g1.setBehavior(be);
        g1.action(g1);
        g1.rivalAction(GunslingerAction.RELOAD);
        g1.rivalAction(GunslingerAction.RELOAD);
        g1.rivalAction(GunslingerAction.RELOAD);//cargas bien guardadas
        assertEquals(g1.action(g1), GunslingerAction.SHOOT);
    }
}