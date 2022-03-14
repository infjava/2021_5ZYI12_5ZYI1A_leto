public class Predmet implements IPredmet {
    private final String nazov;
    private boolean obute;

    public Predmet(String nazov) {
        this.nazov = nazov;
        this.obute = false;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void pouzi() {
        if (this.nazov.equals("navleky")) {
            if (this.obute) {
                System.out.println("Vyzul si si navleky");
                this.obute = false;
            } else {
                System.out.println("Obul si si navleky");
                this.obute = true;
            }
        } else {
            System.out.printf("%s sa neda pouzit%n", this.nazov);
        }
    }
}
