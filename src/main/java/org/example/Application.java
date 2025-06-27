package org.example;

import org.example.entities.Collezione;
import org.example.entities.GiocoDaTavolo;
import org.example.entities.Videogioco;
import org.example.entities.enums.Genere;
import org.example.exceptions.ErroreMain;

import java.util.Scanner;


public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Videogioco vg1 = new Videogioco("God of war", 2005,
                50, 1, "playstation", 35, Genere.ACTION);
        Videogioco vg2 = new Videogioco("The last of us", 2013,
                60, 2, "playstation", 25, Genere.HORROR);
        Videogioco vg3 = new Videogioco("Halo", 2011,
                50, 3, "xbox", 20, Genere.ADVENTURE);
        Videogioco vg4 = new Videogioco("Doom", 1993,
                40, 4, "computer", 20, Genere.SHOOTER);
        Videogioco vg5 = new Videogioco("Pokemon", 2018,
                35, 5, "gameboy", 70, Genere.RPG);

        GiocoDaTavolo gt1 = new GiocoDaTavolo("monopoli", 1935,
                20, 6, 8, 180);
        GiocoDaTavolo gt2 = new GiocoDaTavolo("cluedo", 1949,
                20, 7, 6, 60);
        GiocoDaTavolo gt3 = new GiocoDaTavolo("uno", 1971,
                10, 8, 10, 30);
        GiocoDaTavolo gt4 = new GiocoDaTavolo("risiko", 1957,
                25, 9, 6, 180);
        GiocoDaTavolo gt5 = new GiocoDaTavolo("azul", 2017,
                30, 10, 4, 45);


        Collezione c1 = new Collezione();
        //c1.aggiungiACollezione(vg1);
        //c1.aggiungiACollezione(gt1);
        //c1.aggiungiACollezione(vg4);
        //c1.aggiungiACollezione(gt3);

        //System.out.println(c1.getListaCollezione());

        // c1.aggiungiACollezione(vg1);

        //System.out.println(c1.ricercaPerId(4));

        //c1.rimuoviDallaCollezione(3);

        //System.out.println(c1.getListaCollezione());

        //c1.aggiornaGioco(gt1.getId());

        // System.out.println("gioco per prezzo");
        //System.out.println(c1.cercaPerPrezzo(40));

        //System.out.println(c1.cercaPerPrezzo(1));
        //System.out.println(c1.cercaPerNumeroGiocatori(8));
        //System.out.println(c1.cercaPerNumeroGiocatori(3));

        //c1.statisticheCollezione();


        System.out.println("crea una collezione di giochi!");
        Collezione userCollection = new Collezione();
        int userInputMetodo;
        System.out.println("una collezione e stata create per te");
        do {
            System.out.println("ecco le azioni possibili: 1 per aggiungere un gioco alla collezione con id, " +
                    "2 per rimuovere un gioco dalla collezione con id," +
                    "3 per cercare un gioco con id" +
                    "4 per cercare con il prezzo" +
                    "5 per cercare con il numer giocatori(ricerca solo giochi da tavolo)" +
                    "6 per aggiornare un gioco" +
                    "7 per le statistiche della collezione" +
                    "0 per uscire");
            userInputMetodo = Integer.parseInt(scanner.nextLine());

            switch (userInputMetodo) {
                case (1):
                    System.out.println("crea un gioco, 1 per videogiochi 2 per gichi da taavol");
                    int userInput = Integer.parseInt(scanner.nextLine());
                    if (userInput == 1) {
                        System.out.println("per creare un videogioco ho bisogno di un titolo");
                        String userTitolo = scanner.nextLine();
                        System.out.println("anno di pubblicazione ?");
                        int userAP = Integer.parseInt(scanner.nextLine());
                        System.out.println("prezzo (numero inter)?");
                        int userPrezzo = Integer.parseInt(scanner.nextLine());
                        System.out.println("id ?");
                        int userId = Integer.parseInt(scanner.nextLine());
                        System.out.println("piattaforma ?");
                        String userPiatt = scanner.nextLine();
                        System.out.println("durata in ore ?");
                        int userDurata = Integer.parseInt(scanner.nextLine());
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

                        Videogioco newVideogame = new Videogioco(userTitolo, userAP, userPrezzo, userId, userPiatt, userDurata, userGenere);
                        userCollection.aggiungiACollezione(newVideogame);
                    }
                    if (userInput == 2) {
                        System.out.println("per creare un gioco da tavolo ho bisogno di un titolo");
                        String userTitolo = scanner.nextLine();
                        System.out.println("anno di pubblicazione ?");
                        int userAP = Integer.parseInt(scanner.nextLine());
                        System.out.println("prezzo (numero inter)?");
                        int userPrezzo = Integer.parseInt(scanner.nextLine());
                        System.out.println("id ?");
                        int userId = Integer.parseInt(scanner.nextLine());
                        System.out.println("durata in minuti ?");
                        int userDurata = Integer.parseInt(scanner.nextLine());
                        System.out.println("numero giocatori");
                        int userNG = Integer.parseInt(scanner.nextLine());
                        GiocoDaTavolo newGiocoDaTavolo = new GiocoDaTavolo(userTitolo, userAP, userPrezzo, userId, userNG, userDurata);
                        userCollection.aggiungiACollezione(newGiocoDaTavolo);
                    }
                    break;
                case (2):
                    System.out.println("id del gioco da rimuovere");
                    int idDaRimuovere = Integer.parseInt(scanner.nextLine());
                    userCollection.rimuoviDallaCollezione(idDaRimuovere);
                    break;
                case (3):
                    System.out.println("id del gioco da cercare");
                    int idDaCercare = Integer.parseInt(scanner.nextLine());
                    System.out.println(userCollection.ricercaPerId(idDaCercare));
                    break;
                case (4):
                    System.out.println("prezzo da cercare");
                    int prezzoRicerca = Integer.parseInt(scanner.nextLine());
                    System.out.println(userCollection.cercaPerPrezzo(prezzoRicerca));
                    break;
                case (5):
                    System.out.println("numero giocatori da cercare");
                    int nRicerca = Integer.parseInt(scanner.nextLine());
                    System.out.println(userCollection.cercaPerNumeroGiocatori(nRicerca));
                    break;
                case (6):
                    System.out.println("id del gioco da aggiornare");
                    int idUpdate = Integer.parseInt(scanner.nextLine());
                    userCollection.aggiornaGioco(idUpdate);
                    break;
                case (7):
                    System.out.println("vedi statistiche");
                    userCollection.statisticheCollezione();
                    break;
                default:
                    throw new ErroreMain("il parametro che mi hai fornito non va bene, uscirai dal programma");
            }


        } while (userInputMetodo != 0);


    }
}
