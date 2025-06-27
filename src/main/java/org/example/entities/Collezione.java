package org.example.entities;

import org.example.entities.enums.Genere;
import org.example.exceptions.*;

import java.util.*;


public class Collezione {
    Scanner scanner = new Scanner(System.in);
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
        Gioco currentGioco = listaCollezione.get(id);
        System.out.println("cosa vuoi modificare? 1 per titolo" +
                "2 per anno pubblicazione" +
                "3 per id" +
                "4 per prezzo" +
                "5 per durata" +
                "6 per genere" +
                "7 per piattaforma" +
                "8 per numero giocatori");
        int userInput = Integer.parseInt(scanner.nextLine());
        switch (userInput) {
            case (1):
                System.out.println("nuovo titolo");
                String userT = scanner.nextLine();
                currentGioco.setTitolo(userT);
                break;
            case (2):
                System.out.println("nuovo anno pubblicazione");
                int userAP = Integer.parseInt(scanner.nextLine());
                currentGioco.setAnnoPubblicazione(userAP);
                break;
            case (3):
                System.out.println("nuovo id");
                int userId = Integer.parseInt(scanner.nextLine());
                currentGioco.setId(userId);
                break;
            case (4):
                System.out.println("nuovo prezzo");
                int userP = Integer.parseInt(scanner.nextLine());
                currentGioco.setPrezzo(userP);
                break;
            case (5):
                //da controllare se in ore o minuti
                System.out.println("nuovo durata");
                int userD = Integer.parseInt(scanner.nextLine());
                if (currentGioco instanceof Videogioco) {
                    ((Videogioco) currentGioco).setDurataOre(userD);
                } else {
                    ((GiocoDaTavolo) currentGioco).setDurataMinuti(userD);
                }
                break;
            case (6):
                if (!(currentGioco instanceof Videogioco)) {
                    System.out.println("azione vietata");
                    break;
                } else {
                    System.out.println("scegli il genere, 1 per ACTION,2 per ADVENTURE,3 per RPG,4 per SHOOTER," +
                            "5 per HORROR, 6 per STRATEGY");
                    int userGenereInput = Integer.parseInt(scanner.nextLine());
                    Genere userGenere = switch (userGenereInput) {
                        case (1) -> Genere.ACTION;
                        case (2) -> Genere.ADVENTURE;
                        case (3) -> Genere.RPG;
                        case (4) -> Genere.SHOOTER;
                        case (5) -> Genere.HORROR;
                        case (6) -> Genere.STRATEGY;
                        default -> Genere.ACTION;
                    };
                    ((Videogioco) currentGioco).setGenere(userGenere);
                }
                break;
            case (7):
                if (currentGioco instanceof Videogioco) {
                    System.out.println("nuovo piattaforma");
                    String userPiat = scanner.nextLine();
                    ((Videogioco) currentGioco).setPiattaforma(userPiat);
                } else {
                    System.out.println("azione vietata");
                }
                break;
            case (8):
                if (currentGioco instanceof GiocoDaTavolo) {
                    System.out.println("nuovo numero giocatori");
                    int userNG = Integer.parseInt(scanner.nextLine());
                    ((GiocoDaTavolo) currentGioco).setNumGiocatori(userNG);
                } else {
                    System.out.println("azione vietata");
                }
                break;
            default:
                System.out.println("input invalido");
                throw new ErroreMain("errore nell input");
        }

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
//                .filter(gioco -> gioco instanceof GiocoDaTavolo)
//                .filter(giocoT -> ((GiocoDaTavolo) giocoT).getNumGiocatori() == numeroGiocatori)
                .filter(gioco -> gioco instanceof GiocoDaTavolo && ((GiocoDaTavolo) gioco).getNumGiocatori() == numeroGiocatori)
                .toList();
        if (listaDiRitorno.isEmpty()) {
            throw new ErroreRicerca("nessun gioco trovato con il parametro numero giocatori");
        }

        return listaDiRitorno;
    }

    public void statisticheCollezione() {
        IntSummaryStatistics stats = listaCollezione.values().stream()
                .mapToInt(gioco -> gioco.getPrezzo()).summaryStatistics();
        //da qui prendo maxprice e avarege
        //mi serve numoro giochi da tavolo e numero video
        long numVideo = listaCollezione.values().stream()
                .filter(gioco -> gioco instanceof Videogioco)
                .count();

        long numGioT = listaCollezione.values().stream()
                .filter(gioco -> gioco instanceof GiocoDaTavolo)
                .count();

        System.out.println("gioco piu costoso: " + stats.getMax() +
                "media costo giochi: " + stats.getAverage() +
                "numero videogiochi: " + numVideo +
                "numero giochi da tavolo: " + numGioT
        );
    }


}
