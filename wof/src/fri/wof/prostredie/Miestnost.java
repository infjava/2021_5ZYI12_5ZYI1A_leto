package fri.wof.prostredie;

import fri.wof.npc.Npc;
import fri.wof.predmety.IPredmet;

import java.util.HashMap;
import java.util.Set;

public class Miestnost implements IMiestnost {
    private final String popisMiestnosti;
    private final HashMap<String, IPredmet> predmety;
    private final HashMap<String, Npc> npccka;

    public Miestnost(String popis) {
        this.popisMiestnosti = popis;
        this.predmety = new HashMap<>();
        this.npccka = new HashMap<>();
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
        this.vypisKluce("Predmety", this.predmety.keySet());
        this.vypisKluce("NPC", this.npccka.keySet());
    }

    protected void vypisKluce(String nadpis, Set<String> kluce) {
        if (!kluce.isEmpty()) {
            System.out.printf("%s: ", nadpis);
            for (String nazov : kluce) {
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

    @Override
    public Npc getNpc(String meno) {
        return this.npccka.get(meno);
    }

    public void postavNpc(Npc npc) {
        this.npccka.put(npc.getMeno(), npc);
    }
}
