package e2;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ProyectoTest {

    Random rand = new Random();

    Proyecto p1 = new Proyecto("BITCOIN GENERATOR");
    Proyecto p2 = new Proyecto("HACKING DESIGN");

    Equipo eq1 = new Equipo("BITCOINNERS");
    Equipo eq2 = new Equipo("RECHEA");
    Equipo eq3 = new Equipo("JAVA MASTERS");
    Equipo seq1 = new Equipo("JAVA PROS");

    Trabajador David = new Trabajador("David", 15);
    Trabajador Jandro = new Trabajador("Jandro", 10);
    Trabajador Ruben = new Trabajador("Ruben", 25);
    Trabajador Mauro = new Trabajador("Mauro", 25);
    Trabajador Abel = new Trabajador("Abel", 20);
    Trabajador Anxo = new Trabajador("Anxo", 20);
    Trabajador Carla = new Trabajador("Carla", 15);
    Trabajador Marcos = new Trabajador("Marcos", 10);
    Trabajador Jacobo = new Trabajador("Jacobo", 35);

    @Test
    void test(){
        eq1.insertar(David);
        eq1.insertar(Jandro);
        eq2.insertar(Ruben);
        eq2.insertar(Abel);
        eq2.insertar(Mauro);
        eq3.insertar(Jacobo);
        eq3.insertar(Marcos);
        seq1.insertar(Anxo);
        seq1.insertar(Carla);
        eq1.insertar(seq1);

        p1.addTeam(eq1);
        p1.addTeam(eq2);
        p2.addTeam(eq2);
        p2.addTeam(eq3);

        //Imprimir componentes de un proyecto

        System.out.println(p1.getName() + "\n");
        p1.printProyect();

        System.out.println("--------------");

        System.out.println(p2.getName() + "\n");
        p2.printProyect();


        // Paso de varias jornadas
        System.out.println("--------------\n\n");
        for(ComponenteProyecto comp : p1.getTeams()){
            comp.endJourney(p1.getName(), 10);
        }

        for(ComponenteProyecto comp : p2.getTeams()){
            comp.endJourney(p2.getName(), 10);
        }

        for(int i = 0; i < 6; i++){
            Carla.endJourney(p1.getName(), rand.nextInt(15));
            Anxo.endJourney(p1.getName(), rand.nextInt(15));
            Abel.endJourney(p1.getName(), rand.nextInt(15));
            Jandro.endJourney(p1.getName(), rand.nextInt(15));
            Ruben.endJourney(p1.getName(), rand.nextInt(15));
            Mauro.endJourney(p1.getName(), 5);
            Abel.endJourney(p2.getName(), rand.nextInt(15));
            Ruben.endJourney(p2.getName(), rand.nextInt(15));
            Mauro.endJourney(p2.getName(), rand.nextInt(5));
            Jacobo.endJourney(p2.getName(), 5 + rand.nextInt(5));
        }

        System.out.println(p1.getName() + "\n");
        p1.printProyect();
        System.out.println("--------------\n\n");
        System.out.println(p2.getName() + "\n");
        p2.printProyect();


        //Imprimir información de un trabajador sobre un proyecto concreto

        System.out.println("--------------\n\n");

        String abelp1 = Abel.printWorkerInfo(p1.getName());
        String abelp2 = Abel.printWorkerInfo(p2.getName());
        System.out.println(abelp1);
        System.out.println(abelp2);

        String infoMauro = ("Worker " + Mauro.getName() + ": " + Mauro.totalHours(p1.getName()) +
                " hours, " + Mauro.totalSalary(p1.getName()) + " €");
        String infoMauro2 = Mauro.printWorkerInfo(p1.getName());
        String infoJacobo = Jacobo.printWorkerInfo(p1.getName());

        assertEquals(infoMauro2, infoMauro);
        assertEquals(infoJacobo, "This worker does not belong to this project\n");

        //Obtener Cotrabajadores de un equipo
        System.out.println("--------------");
        System.out.println("\nCOTRABAJADORES DE " + eq1.getName() + " en " + p1.getName());
        List<ComponenteProyecto> coworkers1 = p1.obtainCoworkers(eq1);
        for(ComponenteProyecto comp : coworkers1){
            comp.printComponents(p1.getName());
        }
    }
}