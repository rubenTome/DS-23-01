package e1;

import org.junit.jupiter.api.Test;

class TermostatoTest {

    @Test
    void test() {
        Termostato termostato = new Termostato();
        Off modoO = new Off();
        Manual modoM = new Manual();
        Program modoP = new Program();
        Timer modoT = new Timer();//tiempos que sean multiplos de 5 siempre,
        termostato.setModo(modoT);
                //sucesos en termostato
        //TIMER
        termostato.newTemperature(10);
        termostato.getModo().funcionar(termostato, 9);//de 5 en 5 minutos
        termostato.screenInfo();

        termostato.newTemperature(13);
        termostato.getModo().funcionar(termostato, 9);
        termostato.screenInfo();

        termostato.newTemperature(17);
        termostato.getModo().funcionar(termostato, 9);
        termostato.screenInfo();

        termostato.newTemperature(16);
        termostato.getModo().funcionar(termostato, 16);
        termostato.screenInfo();

                //fin sucesos en termostato

        System.out.println(termostato.getLog());
    }
}