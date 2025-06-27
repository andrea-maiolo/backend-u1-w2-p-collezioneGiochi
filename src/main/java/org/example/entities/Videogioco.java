package org.example.entities;

import org.example.entities.enums.Genere;

public class Videogioco extends Gioco {
    private String piattaforma;
    private int durataOre;
    private Genere genere;

    public Videogioco(String titolo, int annoPubblicazione, int prezzo, String piattaforma, int durataOre, Genere genere) {
        super(titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durataOre = durataOre;
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Videogioco{" +
                "id=" + id +
                ", piattaforma='" + piattaforma + '\'' +
                ", durataOre=" + durataOre +
                ", genere='" + genere + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", prezzo=" + prezzo +
                '}';
    }
}
