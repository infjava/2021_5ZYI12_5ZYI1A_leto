package fri.wof.prostredie;

import fri.wof.npc.Npc;

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
public class StandardnaMiestnost extends Miestnost {
    private final TreeMap<String, IMiestnost> vychody;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public StandardnaMiestnost(String popis) {
        super(popis);
        this.vychody = new TreeMap<>();
    }

    public void nastavVychod(String smer, IMiestnost miestnost) {
        if (miestnost != null) {
            this.vychody.put(smer, miestnost);
        }
    }

    @Override
    public void vypisMozneVychody() {
        this.vypisKluce("Vychody", this.vychody.keySet());
    }

    @Override
    public IMiestnost getMiestnostVSmere(String smer) {
        return this.vychody.get(smer);
    }

    public void odstranVychod(String nazov) {
        this.vychody.remove(nazov);
    }
}
