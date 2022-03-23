package fri.wof.prostredie;

import fri.wof.predmety.IPredmet;

import java.util.HashMap;

public class Miestnost implements IMiestnost {
    private final String popisMiestnosti;
    private final HashMap<String, IPredmet> predmety;

    public Miestnost(String popis) {
        this.popisMiestnosti = popis;
        this.predmety = new HashMap<>();
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
        this.vypisMozneVychody();
        if (!this.predmety.isEmpty()) {
            System.out.print("Predmety: ");
            for (String nazov : this.predmety.keySet()) {
                System.out.printf("%s ", nazov);
            }
            System.out.println();
        }
    }

    public void vypisMozneVychody() {
    }

    @Override
    public IMiestnost getMiestnostVSmere(String smer) {
        return null;
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
