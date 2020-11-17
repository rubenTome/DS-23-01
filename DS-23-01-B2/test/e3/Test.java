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
        g11.rivalAction(GunslingerAction.SHOOT);//2 acciones del rival
        assertEquals(g11.getRivalLoads(), 1);
    }

    @Test
    void testRound4Protect() {
        Gunslinger g11 = new Gunslinger();
        Gunslinger g1 = new Gunslinger();
        g11.setBehavior(be);
        g1.setBehavior(be);
        g11.rivalAction(GunslingerAction.RELOAD);//ronda 1
        g11.rivalAction(GunslingerAction.RELOAD);//ronda 2
        g11.rivalAction(GunslingerAction.PROTECT);//ronda 3
        assertEquals(g11.action(g11), GunslingerAction.PROTECT);
    }

    @Test
    void testRound4Reload() {
        Gunslinger g11 = new Gunslinger();
        g11.setBehavior(be);
        g11.rivalAction(GunslingerAction.RELOAD);//ronda 1
        g11.rivalAction(GunslingerAction.RELOAD);//ronda 2
        assertEquals(g11.action(g11), GunslingerAction.PROTECT);
        g11.rivalAction(GunslingerAction.RELOAD);//ronda 3
        assertEquals(g11.action(g11), GunslingerAction.RELOAD);
    }

    @Test
    void testRound5Shoot() {
        Gunslinger g11 = new Gunslinger();
        g11.setBehavior(be);
        g11.action(g11);//recarga
        g11.rivalAction(GunslingerAction.RELOAD);
        g11.rivalAction(GunslingerAction.RELOAD);
        g11.rivalAction(GunslingerAction.RELOAD);
        g11.rivalAction(GunslingerAction.RELOAD);//4 recargas del rival
        assertEquals(g11.action(g11), GunslingerAction.SHOOT);
    }

    @Test
    void test5Reload() {
        Gunslinger g11 = new Gunslinger();
        g11.setBehavior(be);
        g11.rivalAction(GunslingerAction.RELOAD);
        g11.rivalAction(GunslingerAction.RELOAD);
        g11.rivalAction(GunslingerAction.RELOAD);
        g11.rivalAction(GunslingerAction.RELOAD);//4 recargas del rival
        assertEquals(g11.action(g11), GunslingerAction.RELOAD);//?
    }
}