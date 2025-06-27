package org.example.entities;

import org.example.entities.enums.Genere;

public class Videogioco extends Gioco {
    private String piattaforma;
    private int durataOre;
    private Genere genere;

    public Videogioco(String titolo, int annoPubblicazione, int prezzo, int id, String piattaforma, int durataOre, Genere genere) {
        super(titolo, annoPubblicazione, prezzo, id);
        this.piattaforma = piattaforma;
        this.durataOre = durataOre;
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public int getDurataOre() {
        return durataOre;
    }

    public void setDurataOre(int durataOre) {
        this.durataOre = durataOre;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Videogioco{" +
                "piattaforma=" + this.getPiattaforma() +
                ", durataOre=" + this.getDurataOre() +
                ", prezzo=" + this.getPrezzo() +
                ", annoPubblicazione=" + this.getAnnoPubblicazione() +
                ", titolo='" + this.getTitolo() + '\'' +
                ", id=" + this.getId() +
                ", genere=" + this.getGenere() +
                '}';
    }
}
