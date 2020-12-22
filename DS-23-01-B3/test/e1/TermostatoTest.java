package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermostatoTest {

    @Test
    void test() {//test basico que prueba la salida
        Termostato termostato = new Termostato();
        //TIMER
        termostato.timer(11);
        termostato.screenInfo();
        termostato.newTemperature(10);

        termostato.timer(11);
        termostato.screenInfo();
        termostato.newTemperature(10);

        termostato.program(22);//no se puede

        termostato.timer(11);
        termostato.screenInfo();
        termostato.newTemperature(10);

        termostato.timer(11);
        termostato.screenInfo();

        System.out.println(termostato.getLog());

        //PROGRAM
        System.out.println("------------------------------\n");
        termostato = new Termostato();
        termostato.newTemperature(15);

        termostato.program(20);
        termostato.screenInfo();

        termostato.newTemperature(17);
        termostato.program(20);
        termostato.screenInfo();

        termostato.timer(10);//no se puede

        termostato.newTemperature(21);
        termostato.program(20);
        termostato.screenInfo();

        System.out.println(termostato.getLog());
    }

    @Test
    void test2() {

    }
}
























