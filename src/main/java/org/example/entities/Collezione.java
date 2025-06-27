package org.example.entities;

import org.example.exceptions.ErroreRicerca;
import org.example.exceptions.ErroreRimozioneException;
import org.example.exceptions.GiocoInCollezioneException;
import org.example.exceptions.RicercaFallitaException;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

public class Collezione {
    private Map<Integer, Gioco> listaCollezione = new HashMap<>();

    public void aggiungiACollezione(Gioco gioco) {
        if (listaCollezione.containsKey(gioco.getId())) {
            throw new GiocoInCollezioneException("gioco gia presente nella collezione");
        }
        listaCollezione.put(gioco.getId(), gioco);
        System.out.println("gioco aggiunto");
        //da capire come farlo fare all utente
    }

    public Map<Integer, Gioco> getListaCollezione() {
        return listaCollezione;
    }

    public Gioco ricercaPerId(int id) {
        if (!listaCollezione.containsKey(id)) {
            throw new RicercaFallitaException("l' id fornito e sbagliato o il gioco non e presente nella collezione");
        }
        return listaCollezione.get(id);
    }

    public void rimuoviDallaCollezione(int id) {
        if (!listaCollezione.containsKey(id)) {
            throw new ErroreRimozioneException("l' id fornito e sbagliato");
        }
        listaCollezione.remove(id);
        System.out.println("gioco rimosso");
    }

    public void aggiornaGioco(int id) {
        System.out.println("il gioco cercato e: " + listaCollezione.get(id));
        //da finire

    }

    public List<Gioco> cercaPerPrezzo(int prezzoDiRicerca) {
        List<Gioco> listaDiRitorno = listaCollezione.values().stream()
                .filter(gioco -> gioco.getPrezzo() < prezzoDiRicerca)
                .toList();
        if (listaDiRitorno.isEmpty()) {
            throw new ErroreRicerca("nessun gioco corrisponde al prezzo inserito");
        }

        return listaDiRitorno;
    }

    public List<Gioco> cercaPerNumeroGiocatori(int numeroGiocatori) {
        List<Gioco> listaDiRitorno = listaCollezione.values().stream()
                .filter(gioco -> gioco instanceof GiocoDaTavolo)
                .filter(giocoT -> ((GiocoDaTavolo) giocoT).getNumGiocatori() <= numeroGiocatori)
                .toList();
        if (listaDiRitorno.isEmpty()) {
            throw new ErroreRicerca("nessun gioco trovato con il parametro numero giocatori");
        }

        return listaDiRitorno;
    }

    public IntSummaryStatistics statisticheCollezione() {
        IntSummaryStatistics stats = listaCollezione.values().stream()
                .mapToInt(gioco -> gioco.getPrezzo()).summaryStatistics();
        System.out.println(stats);
        return stats;
    }


}
