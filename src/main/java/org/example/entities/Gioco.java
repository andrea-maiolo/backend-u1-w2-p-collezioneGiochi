package org.example.entities;

import java.util.Random;

public abstract class Gioco {
    protected int id;
    protected String titolo;
    protected int annoPubblicazione;
    protected int prezzo;

    public Gioco(String titolo, int annoPubblicazione, int prezzo) {
        Random random = new Random();
        this.id = random.nextInt(1, 10000);
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }
}
