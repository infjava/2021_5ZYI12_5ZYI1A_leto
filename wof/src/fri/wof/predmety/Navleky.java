package fri.wof.predmety;

public class Navleky implements IPredmet {
    private boolean obute;

    public Navleky() {
        this.obute = false;
    }

    @Override
    public String getNazov() {
        return "navleky";
    }

    @Override
    public void pouzi() {
        if (this.obute) {
            System.out.println("Vyzul si si navleky");
            this.obute = false;
        } else {
            System.out.println("Obul si si navleky");
            this.obute = true;
        }
    }
}
