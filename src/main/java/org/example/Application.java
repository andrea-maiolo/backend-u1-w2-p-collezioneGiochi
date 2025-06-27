package org.example;

import com.github.javafaker.Faker;
import org.example.entities.GiocoDaTavolo;
import org.example.entities.Videogioco;
import org.example.entities.enums.Genere;

import java.util.Locale;

public class Application {

    public static void main(String[] args) {
        Faker faker = new Faker(Locale.ITALY);
        String f = faker.beer().hop();
        System.out.println(f);


        Videogioco g = new Videogioco("godOfWar", 2018,
                30, "playstation", 4, Genere.ACTION);

        GiocoDaTavolo g2 = new GiocoDaTavolo("monopoli", 1900, 40, 4, 30);

        System.out.println(g.toString());
        System.out.println(g2.toString());


    }
}
