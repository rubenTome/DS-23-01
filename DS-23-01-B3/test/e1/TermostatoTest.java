package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermostatoTest {

    @Test
    void test() {//test que prueba la salida
        Termostato termostato = new Termostato();
        //TIMER
        termostato.timer(11);
        assertEquals("0.0 ON T 11\n", termostato.screenInfo());
        termostato.newTemperature(10);

        termostato.timer(11);
        assertEquals("10.0 ON T 6\n", termostato.screenInfo());
        termostato.newTemperature(10);

        termostato.program(22);//no se puede

        termostato.timer(11);
        assertEquals("10.0 ON T 1\n", termostato.screenInfo());
        termostato.newTemperature(10);

        termostato.timer(11);
        assertEquals("10.0 OFF O\n", termostato.screenInfo());

        String a = "Se activa el modo timer 11 minutos\n" +
                "10.0 Modo Timer (faltan 6 minutos) - calefacción encendida\n" +
                "No se puede cambiar a program\n" +
                "10.0 Modo Timer (faltan 1 minutos) - calefacción encendida\n" +
                "Se desactiva el modo timer\n" +
                "10.0 Modo Off - calefacción apagada\n";
        assertEquals(a, termostato.getLog().toString());

        //PROGRAM
        termostato = new Termostato();
        termostato.newTemperature(15);

        termostato.program(20);
        assertEquals("15.0 ON P 20.0\n", termostato.screenInfo());

        termostato.newTemperature(17);
        termostato.program(20);
        assertEquals("17.0 ON P 20.0\n", termostato.screenInfo());

        termostato.timer(10);//no se puede

        termostato.newTemperature(21);
        termostato.program(20);
        assertEquals("21.0 OFF O\n", termostato.screenInfo());

        String b = "Se activa el modo program a 20.0 grados\n" +
                "17.0 Modo program (a 20.0 grados) - Calefacción encendida\n" +
                "No se puede cambiar a timer\n" +
                "21.0 Modo program (a 20.0 grados) - Calefacción apagada\n" +
                "21.0 Modo Off - calefacción apagada\n";
        assertEquals(b, termostato.getLog().toString());
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