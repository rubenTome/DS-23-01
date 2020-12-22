package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermostatoTest {

    @Test
    void test() {//test basico que prueba la salida
        Termostato termostato = new Termostato();
        //TIMER
        termostato.timer(11);
        System.out.println(termostato.screenInfo());
        termostato.newTemperature(10);

        termostato.timer(11);
        System.out.println(termostato.screenInfo());
        termostato.newTemperature(10);

        termostato.program(22);//no se puede

        termostato.timer(11);
        System.out.println(termostato.screenInfo());
        termostato.newTemperature(10);

        termostato.timer(11);
        System.out.println(termostato.screenInfo());

        System.out.println(termostato.getLog());

        //PROGRAM
        System.out.println("------------------------------\n");
        termostato = new Termostato();
        termostato.newTemperature(15);

        termostato.program(20);
        System.out.println(termostato.screenInfo());

        termostato.newTemperature(17);
        termostato.program(20);
        System.out.println(termostato.screenInfo());

        termostato.timer(10);//no se puede

        termostato.newTemperature(21);
        termostato.program(20);
        System.out.println(termostato.screenInfo());

        System.out.println(termostato.getLog());
    }

    @Test
    void test2() {
        Termostato termostato2 = new Termostato();

        //variable encendido
        termostato2.timer(10);
        assertTrue(termostato2.getEncendido());

        termostato2.apagar();
        assertFalse(termostato2.getEncendido());

        termostato2.manual();
        assertTrue(termostato2.getEncendido());

        termostato2.program(20);
        assertTrue(termostato2.getEncendido());

        //variable time
        termostato2 = new Termostato();
        termostato2.manual();
        assertEquals(0, termostato2.getTime());
        termostato2.timer(10);
        assertEquals(10, termostato2.getTime());
        termostato2.newTemperature(21);
        assertEquals(5, termostato2.getTime());
        termostato2.newTemperature(22);
        assertEquals(0, termostato2.getTime());
        termostato2.manual();
        assertEquals(0, termostato2.getTime());


    }
}