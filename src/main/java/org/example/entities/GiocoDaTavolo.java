package org.example.entities;

public class GiocoDaTavolo extends Gioco {
    private int numGiocatori;
    private int durataMinuti;

    public GiocoDaTavolo(String titolo, int annoPubblicazione, int prezzo, int numGiocatori, int durataMinuti) {
        super(titolo, annoPubblicazione, prezzo);
        this.durataMinuti = durataMinuti;
        this.numGiocatori = numGiocatori;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "numGiocatori=" + numGiocatori +
                ", durataMinuti=" + durataMinuti +
                ", prezzo=" + prezzo +
                ", annoPubblicazione=" + annoPubblicazione +
                ", titolo='" + titolo + '\'' +
                ", id=" + id +
                '}';
    }
}
