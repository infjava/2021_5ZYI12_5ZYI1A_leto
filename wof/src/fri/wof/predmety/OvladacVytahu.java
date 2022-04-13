package fri.wof.predmety;

import fri.wof.hra.Hrac;
import fri.wof.prostredie.Vytah;

import java.io.Serializable;

public class OvladacVytahu implements IPredmet, Serializable {
    @Override
    public String getNazov() {
        return "ovladac";
    }

    @Override
    public void pouzi(Hrac hrac) {
        if (hrac.getAktualnaMiestnost() instanceof Vytah vytah) {
            vytah.posunVytah();
            vytah.vypisMiestnost();
        } else {
            System.out.println("Nie si vo vytahu!");
        }
    }
}
