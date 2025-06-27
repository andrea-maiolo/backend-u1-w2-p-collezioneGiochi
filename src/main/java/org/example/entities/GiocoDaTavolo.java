package org.example.entities;

public class GiocoDaTavolo extends Gioco {
    private int numGiocatori;
    private int durataMinuti;

    public GiocoDaTavolo(String titolo, int annoPubblicazione, int prezzo, int numGiocatori, int durataMinuti) {
        super(titolo, annoPubblicazione, prezzo);
        this.durataMinuti = durataMinuti;
        this.numGiocatori = numGiocatori;
    }

    public int getNumGiocatori() {
        return numGiocatori;
    }

    public void setNumGiocatori(int numGiocatori) {
        this.numGiocatori = numGiocatori;
    }

    public int getDurataMinuti() {
        return durataMinuti;
    }

    public void setDurataMinuti(int durataMinuti) {
        this.durataMinuti = durataMinuti;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" +
                "numGiocatori=" + this.getNumGiocatori() +
                ", durataMinuti=" + this.getDurataMinuti() +
                ", prezzo=" + this.getPrezzo() +
                ", annoPubblicazione=" + this.getAnnoPubblicazione() +
                ", titolo='" + this.getTitolo() + '\'' +
                ", id=" + this.getId() +
                '}';
    }
}
