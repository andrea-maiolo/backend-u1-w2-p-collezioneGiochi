package org.example.entities;

import org.example.exceptions.GiocoInCollezioneException;

import java.util.HashMap;
import java.util.Map;

public class Collezione {
    private Map<Integer, Gioco> listaCollezione = new HashMap<>();

    public void aggiungiACollezione(Gioco gioco) {
        if (listaCollezione.containsKey(gioco.getId())) {
            throw new GiocoInCollezioneException("gioco gia presente nella collezione");
        }
        listaCollezione.put(gioco.getId(), gioco);
    }

    public Map<Integer, Gioco> getListaCollezione() {
        return listaCollezione;
    }

    public Gioco ricercaPerId(int id) {
        return listaCollezione.get(id);
    }
}
