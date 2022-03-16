package fri.wof.prostredie;

import fri.wof.predmety.IPredmet;

public class Labak implements IMiestnost {
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
}
