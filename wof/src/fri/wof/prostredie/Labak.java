package fri.wof.prostredie;

import fri.wof.hra.Hrac;
import fri.wof.predmety.IPredmet;
import fri.wof.predmety.Navleky;

public class Labak implements IMiestnost, IKontrolaVstupu {
    private final IMiestnost vychod;

    public Labak(IMiestnost vychod) {
        this.vychod = vychod;
    }

    @Override
    public void vypisMiestnost() {
        System.out.println("Si v labaku");
        System.out.println("Vychody: von");
    }

    @Override
    public IMiestnost getMiestnostVSmere(String smer) {
        if (smer.equals("von")) {
            return this.vychod;
        }
        return null;
    }

    @Override
    public void vlozPredmet(IPredmet predmet) {
        System.out.printf("Automaticka ochrana laboratoria laserovym delom odstranila predmet %s%n", predmet.getNazov());
    }

    @Override
    public IPredmet odstranPredmet(String nazovPredmetu) {
        return null;
    }

    @Override
    public boolean mozeVstupit(Hrac hrac) {
        Navleky navleky = (Navleky)hrac.getPredmet("navleky");
        if (navleky != null) {
            return navleky.suObute();
        }
        return false;
    }
}
