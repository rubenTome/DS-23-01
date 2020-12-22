package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TermostatoTest {

    @Test
    void test() {
        Termostato termostato = new Termostato();
                //sucesos en termostato
        //TIMER
        termostato.setModo(Timer.getInstancia());
        termostato.getModo().funcionar(termostato, 11);
        termostato.screenInfo();
        termostato.newTemperature(10);

        termostato.getModo().funcionar(termostato, 11);
        termostato.screenInfo();
        termostato.newTemperature(10);

        termostato.setModo(Program.getInstancia());//no se puede
        termostato.getModo().funcionar(termostato, (float) 20);

        termostato.getModo().funcionar(termostato, 11);
        termostato.screenInfo();
        termostato.newTemperature(10);

        termostato.getModo().funcionar(termostato, 11);
        termostato.screenInfo();

        termostato.getModo().funcionar(termostato);
        termostato.screenInfo();


        System.out.println(termostato.getLog());

        //PROGRAM
        System.out.println("------------------------------\n");
        termostato = new Termostato();
        termostato.newTemperature(15);

        termostato.setModo(Program.getInstancia());
        termostato.getModo().funcionar(termostato, (float) 20);
        termostato.screenInfo();

        termostato.newTemperature(17);
        termostato.getModo().funcionar(termostato, (float) 20);
        termostato.screenInfo();

        termostato.newTemperature(21);
        termostato.getModo().funcionar(termostato, (float) 20);
        termostato.screenInfo();

        termostato.setModo(Timer.getInstancia());//no se puede
        termostato.getModo().funcionar(termostato, 10);

        System.out.println(termostato.getLog());
                //fin sucesos en termostato
    }
}