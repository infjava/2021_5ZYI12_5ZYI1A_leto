package fri.wof.predmety;

import fri.wof.hra.Hrac;
import fri.wof.prostredie.StandardnaMiestnost;

public class PortalGun implements IPredmet {
    private static final String[] NAZVY_PORTALOV = { "modry", "cerveny" };

    private int indexNasledujucehoPortalu;
    private final StandardnaMiestnost[] miestnostiSPortalom;

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

        for (int i = 0; i < this.miestnostiSPortalom.length; i++) {
            if (this.miestnostiSPortalom[i] != null) {
                this.miestnostiSPortalom[i].odstranVychod(PortalGun.NAZVY_PORTALOV[i]);
            }
        }

        this.miestnostiSPortalom[this.indexNasledujucehoPortalu] = miestnostHraca;

        if (this.miestnostiSPortalom[0] != null && this.miestnostiSPortalom[1] != null) {
            this.miestnostiSPortalom[0].nastavVychod(PortalGun.NAZVY_PORTALOV[0], this.miestnostiSPortalom[1]);
            this.miestnostiSPortalom[1].nastavVychod(PortalGun.NAZVY_PORTALOV[1], this.miestnostiSPortalom[0]);
            System.out.printf("Otvoril si %s portal%n", PortalGun.NAZVY_PORTALOV[this.indexNasledujucehoPortalu]);
        } else {
            System.out.printf("Portal ma len %s koniec, neda sa do neho vojst%n", PortalGun.NAZVY_PORTALOV[this.indexNasledujucehoPortalu]);
        }

        this.indexNasledujucehoPortalu = 1 - this.indexNasledujucehoPortalu;
    }
}
