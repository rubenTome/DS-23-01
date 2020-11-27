package e3;

import e3.behaviors.DS_23_01;
import e3.behaviors.testBehavior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestClass {
    @Test
    void TestDuel() {
        DS_23_01 be = new DS_23_01();

        testBehavior tBe = new testBehavior();
        Gunslinger g1 = new Gunslinger();
        Gunslinger g2 = new Gunslinger();
        g1.setBehavior(be);
        g2.setBehavior(tBe);
        Gunfight g = new Gunfight();
        g.duel(g1, g2);
        assertTrue(true);//solo usado para ver salida de gunfight
    }

    @Test
    void testRivalLoad() {
        DS_23_01 be = new DS_23_01();

        Gunslinger g11 = new Gunslinger();
        g11.setBehavior(be);
        g11.rivalAction(GunslingerAction.RELOAD);
        g11.rivalAction(GunslingerAction.SHOOT);
        g11.rivalAction(GunslingerAction.RELOAD);//3 acciones del rival, 1 carga
        assertEquals(g11.getRivalLoads(), 1);
    }

    @Test
    void testDS() {
        DS_23_01 be = new DS_23_01();
        DS_23_01 be2 = new DS_23_01();

        Gunslinger g1 = new Gunslinger();
        g1.setBehavior(be);
        g1.action(g1);//recargamos en primer turno
        g1.rivalAction(GunslingerAction.RELOAD);
        g1.rivalAction(GunslingerAction.RELOAD);
        g1.rivalAction(GunslingerAction.RELOAD);
        assertEquals(g1.action(g1), GunslingerAction.SHOOT);
        assertNotEquals(g1.action(g1), GunslingerAction.SHOOT);//no puede disparar, no tiene balas

        /*
        en esta secuencia, el test se hace suponiendo que el rival
        nunca recarga para no modificar los intervalos de probabilidades
        que corresponden a cada acccion. Ademas se utiliza la semilla 2 en la clase Random,
        que nos dara la secuencia: 8(RELOAD SIEMPRE AL COMIENZO)-2(SHOOT)-0(NO SHOOT: NO HAY BALAS)-7(PROTECT)
        */
        g1 = new Gunslinger();
        g1.setBehavior(be2);
        assertEquals(g1.action(g1), GunslingerAction.RELOAD);
        g1.rivalAction(GunslingerAction.PROTECT);
        assertEquals(g1.action(g1), GunslingerAction.SHOOT);
        g1.rivalAction(GunslingerAction.PROTECT);
        assertNotEquals(g1.action(g1), GunslingerAction.PROTECT);
        g1.rivalAction(GunslingerAction.PROTECT);
        assertEquals(g1.action(g1), GunslingerAction.PROTECT);
    }
}