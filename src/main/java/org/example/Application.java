package org.example;

import org.example.entities.Collezione;
import org.example.entities.GiocoDaTavolo;
import org.example.entities.Videogioco;
import org.example.entities.enums.Genere;


public class Application {

    public static void main(String[] args) {


        Videogioco vg1 = new Videogioco("God of war", 2005,
                50, "playstation", 35, Genere.ACTION);
        Videogioco vg2 = new Videogioco("The last of us", 2013,
                60, "playstation", 25, Genere.HORROR);
        Videogioco vg3 = new Videogioco("Halo", 2011,
                50, "xbox", 20, Genere.ADVENTURE);
        Videogioco vg4 = new Videogioco("Doom", 1993,
                40, "computer", 20, Genere.SHOOTER);
        Videogioco vg5 = new Videogioco("Pokemon", 2018,
                35, "gameboy", 70, Genere.RPG);

        GiocoDaTavolo gt1 = new GiocoDaTavolo("monopoli", 1935,
                20, 8, 180);
        GiocoDaTavolo gt2 = new GiocoDaTavolo("cluedo", 1949,
                20, 6, 60);
        GiocoDaTavolo gt3 = new GiocoDaTavolo("uno", 1971,
                10, 10, 30);
        GiocoDaTavolo gt4 = new GiocoDaTavolo("risiko", 1957,
                25, 6, 180);
        GiocoDaTavolo gt5 = new GiocoDaTavolo("azul", 2017,
                30, 4, 45);


        Collezione c1 = new Collezione();
        c1.aggiungiACollezione(vg1);
        c1.aggiungiACollezione(gt1);
        c1.aggiungiACollezione(vg4);
        c1.aggiungiACollezione(gt3);

        System.out.println(c1.getListaCollezione());

        //c1.aggiungiACollezione(vg1);

        int idRicerca = vg1.getId();

        System.out.println(c1.ricercaPerId(idRicerca));
        //System.out.println(c1.ricercaPerId(4));

        c1.rimuoviDallaCollezione(idRicerca);

        //c1.rimuoviDallaCollezione(3);

        System.out.println(c1.getListaCollezione());

    }
}
