package fri.wof.prostredie;

import fri.wof.npc.Npc;
import fri.wof.predmety.IPredmet;

public interface IMiestnost {
    void vypisMiestnost();

    IMiestnost getMiestnostVSmere(String smer);

    void vlozPredmet(IPredmet predmet);

    IPredmet odstranPredmet(String nazovPredmetu);

    Npc getNpc(String meno);
}
