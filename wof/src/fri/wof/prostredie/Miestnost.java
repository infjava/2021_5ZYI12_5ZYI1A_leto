package fri.wof.prostredie;

import fri.wof.predmety.IPredmet;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Trieda fri.wof.prostredie.Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. 
 * Vychody z miestnosti su oznacovane svetovymi stranami sever, vychod, juh
 * a zapad. Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost implements IMiestnost {
    private final String popisMiestnosti;
    private final TreeMap<String, IMiestnost> vychody;
    private final HashMap<String, IPredmet> predmety;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public Miestnost(String popis) {
        this.popisMiestnosti = popis;
        this.vychody = new TreeMap<>();
        this.predmety = new HashMap<>();
    }

    public void nastavVychod(String smer, IMiestnost miestnost) {
        if (miestnost != null) {
            this.vychody.put(smer, miestnost);
        }
    }

    /**
     * @return textovy popis miestnosti.
     */
    public String getPopis() {
        return this.popisMiestnosti;
    }

    @Override
    public void vypisMiestnost() {
        System.out.println("Teraz si v miestnosti " + this.getPopis());
        System.out.print("Vychody: ");
        for (String smer : this.vychody.keySet()) {
            System.out.printf("%s ", smer);
        }
        System.out.println();
        if (!this.predmety.isEmpty()) {
            System.out.print("Predmety: ");
            for (String nazov : this.predmety.keySet()) {
                System.out.printf("%s ", nazov);
            }
            System.out.println();
        }
    }

    @Override
    public IMiestnost getMiestnostVSmere(String smer) {
        return this.vychody.get(smer);
    }

    @Override
    public void vlozPredmet(IPredmet predmet) {
        this.predmety.put(predmet.getNazov(), predmet);
    }

    @Override
    public IPredmet odstranPredmet(String nazovPredmetu) {
        return this.predmety.remove(nazovPredmetu);
    }
}
