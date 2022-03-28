package fri.wof.predmety;

import fri.wof.hra.Hrac;
import fri.wof.prostredie.StandardnaMiestnost;

public class PortalGun implements IPredmet {
    private int indexNasledujucehoPortalu;
    private StandardnaMiestnost[] miestnostiSPortalom;

    public PortalGun() {
        this.indexNasledujucehoPortalu = 0;
        this.miestnostiSPortalom = new StandardnaMiestnost[2];
    }

    @Override
    public String getNazov() {
        return "portalgun";
    }

    @Override
    public void pouzi(Hrac hrac) {
        if (!(hrac.getAktualnaMiestnost() instanceof StandardnaMiestnost miestnostHraca)) {
            System.out.println("V tejto miestnosti sa neda otvorit portal");
            return;
        }

        for (StandardnaMiestnost miestnost : this.miestnostiSPortalom) {
            if (miestnost != null) {
                miestnost.odstranVychod("portal");
            }
        }

        this.miestnostiSPortalom[this.indexNasledujucehoPortalu] = miestnostHraca;
        this.indexNasledujucehoPortalu = 1 - this.indexNasledujucehoPortalu;

        if (this.miestnostiSPortalom[0] != null && this.miestnostiSPortalom[1] != null) {
            this.miestnostiSPortalom[0].nastavVychod("portal", this.miestnostiSPortalom[1]);
            this.miestnostiSPortalom[1].nastavVychod("portal", this.miestnostiSPortalom[0]);
        }
    }
}
