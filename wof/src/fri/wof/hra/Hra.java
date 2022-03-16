package fri.wof.hra;

import fri.wof.prikazy.Parser;
import fri.wof.prikazy.Prikaz;
import fri.wof.prikazy.VykonavacPrikazov;
import fri.wof.prostredie.IMiestnost;
import fri.wof.prostredie.Mapa;

/**
 * Trieda fri.wof.hra.Hra je hlavna trieda aplikacie "World of FRI".
 * "World of FRI" je velmi jednoducha textova hra - adventura. 
 * fri.wof.hra.Hrac sa moze prechadzat po niektorych priestoroch - miestnostiach fakulty.
 * To je v tejto verzii vsetko. Hru treba skutocne zancne rozsirit,
 * aby bola zaujimava.
 * 
 * Ak chcete hrat "World of FRI", vytvorte instanciu triedy fri.wof.hra.Hra (hra)
 * a poslite jej spravu hraj.
 * 
 * fri.wof.hra.Hra vytvori a inicializuje vsetky potebne objekty:
 * vytvori vsetky miestnosti, vytvori parser a zacne hru. fri.wof.hra.Hra tiez vyhodnocuje
 * a vykonava prikazy, ktore vrati parser.
 * 
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
*/
 
public class Hra  {
    private final Parser parser;
    private final Hrac hrac;
    @SuppressWarnings("FieldCanBeLocal")
    private final Mapa mapa;
    private final VykonavacPrikazov vykonavacPrikazov;

    /**
     * Vytvori a inicializuje hru.
     */
    public Hra() {
        this.mapa = new Mapa();
        IMiestnost startovaciaMiestnost = this.mapa.getStartovaciaMiestnost();
        this.vykonavacPrikazov = new VykonavacPrikazov();
        this.parser = new Parser(this.vykonavacPrikazov);
        this.hrac = new Hrac(startovaciaMiestnost);
    }

    /**
     *  Hlavna metoda hry.
     *  Cyklicky opakuje kroky hry, kym hrac hru neukonci.
     */
    public void hraj() {            
        this.vypisPrivitanie();

        // Vstupny bod hlavneho cyklu.
        // Opakovane nacitava prikazy hraca
        // vykonava ich kym hrac nezada prikaz na ukoncenie hry.
                
        boolean jeKoniec;
        
        do {
            Prikaz prikaz = this.parser.nacitajPrikaz();
            jeKoniec = this.vykonavacPrikazov.vykonajPrikaz(prikaz, this.hrac);
        } while (!jeKoniec);
        
        System.out.println("Maj sa fajn!");
    }

    /**
     * Vypise privitanie hraca do terminaloveho okna.
     */
    private void vypisPrivitanie() {
        System.out.println();
        System.out.println("Vitaj v hre World of FRI!");
        System.out.println("World of FRI je nova, neuveritelne nudna adventura.");
        System.out.println("Zadaj 'pomoc' ak potrebujes pomoc.");
        System.out.println();
        this.hrac.getAktualnaMiestnost().vypisMiestnost();
    }

}
