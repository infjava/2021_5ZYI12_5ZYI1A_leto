package fri.wof.predmety;

import fri.wof.hra.Hrac;

import java.io.Serializable;

public class Predmet implements IPredmet, Serializable {
    private final String nazov;

    public Predmet(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void pouzi(Hrac hrac) {
        System.out.printf("%s sa neda pouzit%n", this.nazov);
    }
}
