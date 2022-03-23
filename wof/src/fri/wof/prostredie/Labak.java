package fri.wof.prostredie;

import fri.wof.hra.Hrac;
import fri.wof.predmety.Navleky;

public class Labak extends StandardnaMiestnost implements IKontrolaVstupu {
    public Labak(Miestnost von) {
        super("Labak - miestnost plna pocitacov");

        this.nastavVychod("von", von);
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
