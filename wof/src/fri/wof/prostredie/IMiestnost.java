package fri.wof.prostredie;

import fri.wof.npc.Npc;
import fri.wof.predmety.IPredmet;

public interface IMiestnost {
    void vypisMiestnost();

    String getNazov();

    IMiestnost getMiestnostVSmere(String smer) throws NeexistujuciVychodException;

    void vlozPredmet(IPredmet predmet);

    IPredmet odstranPredmet(String nazovPredmetu);

    Npc getNpc(String meno);
}
