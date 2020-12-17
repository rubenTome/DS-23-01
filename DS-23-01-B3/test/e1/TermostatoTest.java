package e1;

import org.junit.jupiter.api.Test;

class TermostatoTest {

    @Test
    void test() {
        Termostato termostato = new Termostato();
        termostato.setModo(Off.getInstancia());
        termostato.newTemperature(10);
                //sucesos en termostato
        //TIMER
        termostato.screenInfo();
        termostato.setModo(Timer.getInstancia());
        termostato.getModo().funcionar(termostato, 21);
        termostato.screenInfo();
        termostato.getModo().funcionar(termostato, 21);
        termostato.screenInfo();
        termostato.newTemperature(16);
        termostato.getModo().funcionar(termostato, 21);
        termostato.screenInfo();
        termostato.getModo().funcionar(termostato, 21);
        termostato.screenInfo();
        termostato.getModo().funcionar(termostato, 21);
        termostato.screenInfo();
        termostato.getModo().funcionar(termostato, 40);
        termostato.screenInfo();
        termostato.getModo().funcionar(termostato);

        //PROGRAM
        System.out.println("----------\n");
        termostato = new Termostato();
        termostato.newTemperature(15);
        termostato.setModo(Program.getInstancia());
        termostato.getModo().funcionar(termostato, 20);
        termostato.screenInfo();

                //fin sucesos en termostato

        System.out.println(termostato.getLog());
    }
}