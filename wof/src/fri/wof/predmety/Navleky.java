package fri.wof.predmety;

import fri.wof.hra.Hrac;

import java.io.Serializable;

public class Navleky implements IPredmet, Serializable {
    private boolean obute;

    public Navleky() {
        this.obute = false;
    }

    @Override
    public String getNazov() {
        return "navleky";
    }

    @Override
    public void pouzi(Hrac hrac) {
        if (this.obute) {
            System.out.println("Vyzul si si navleky");
            this.obute = false;
        } else {
            System.out.println("Obul si si navleky");
            this.obute = true;
        }
    }

    public boolean suObute() {
        return this.obute;
    }
}
