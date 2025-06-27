package org.example;

import org.example.entities.Collezione;
import org.example.entities.GiocoDaTavolo;
import org.example.entities.Videogioco;
import org.example.entities.enums.Genere;


public class Application {

    public static void main(String[] args) {


        Videogioco vg1 = new Videogioco("God of war", 2005,
                50, 1, "playstation", 35, Genere.ACTION);
        Videogioco vg2 = new Videogioco("The last of us", 2013,
                60, 2, "playstation", 25, Genere.HORROR);
        Videogioco vg3 = new Videogioco("Halo", 2011,
                50, 3, "xbox", 20, Genere.ADVENTURE);
        Videogioco vg4 = new Videogioco("Doom", 1993,
                40, 4, "computer", 20, Genere.SHOOTER);
        Videogioco vg5 = new Videogioco("Pokemon", 2018,
                35, 5, "gameboy", 70, Genere.RPG);

        GiocoDaTavolo gt1 = new GiocoDaTavolo("monopoli", 1935,
                20, 6, 8, 180);
        GiocoDaTavolo gt2 = new GiocoDaTavolo("cluedo", 1949,
                20, 7, 6, 60);
        GiocoDaTavolo gt3 = new GiocoDaTavolo("uno", 1971,
                10, 8, 10, 30);
        GiocoDaTavolo gt4 = new GiocoDaTavolo("risiko", 1957,
                25, 9, 6, 180);
        GiocoDaTavolo gt5 = new GiocoDaTavolo("azul", 2017,
                30, 10, 4, 45);


        Collezione c1 = new Collezione();
        c1.aggiungiACollezione(vg1);
        c1.aggiungiACollezione(gt1);
        c1.aggiungiACollezione(vg4);
        c1.aggiungiACollezione(gt3);

        System.out.println(c1.getListaCollezione());

        //c1.aggiungiACollezione(vg1);

        System.out.println(c1.ricercaPerId(4));

        System.out.println(gt1.toString());
    }
}
