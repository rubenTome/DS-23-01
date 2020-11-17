package e3;

import e3.behaviors.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void testRound4Protect() {
        Gunslinger g11 = new Gunslinger();
        Gunslinger g1 = new Gunslinger();
        g11.setBehavior(be);
        g1.setBehavior(be);
        g1.rivalAction(GunslingerAction.RELOAD);//ronda 1
        g1.rivalAction(GunslingerAction.RELOAD);//ronda 2
        g1.rivalAction(GunslingerAction.PROTECT);//ronda 3
        assertEquals(g11.action(g1), GunslingerAction.PROTECT);
    }

    @Test
    void testRound4Reload() {
        Gunslinger g11 = new Gunslinger();
        Gunslinger g1 = new Gunslinger();
        g11.setBehavior(be);
        g1.setBehavior(be);
        g1.rivalAction(GunslingerAction.RELOAD);//ronda 1
        g1.rivalAction(GunslingerAction.RELOAD);//ronda 2
        assertEquals(g11.action(g1), GunslingerAction.PROTECT);
        g1.rivalAction(GunslingerAction.RELOAD);//ronda 3
        assertEquals(g11.action(g1), GunslingerAction.RELOAD);
    }

    @Test
    void testRound5Shoot() {
        Gunslinger g11 = new Gunslinger();
        Gunslinger g1 = new Gunslinger();
        g11.setBehavior(be);
        g1.setBehavior(be);
        g1.rivalAction(GunslingerAction.RELOAD);
        g1.rivalAction(GunslingerAction.RELOAD);
        g1.rivalAction(GunslingerAction.RELOAD);
        g1.rivalAction(GunslingerAction.RELOAD);

    }
























}