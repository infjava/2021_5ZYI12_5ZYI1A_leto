package fri.zoo;

public class Lev extends Zviera<Lev> {
    private final String meno;

    public Lev(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void zjedz(IPotrava<Lev> potrava) {
        System.out.println("Lev z hlasitym zarevanim zozram mys");
    }

    @Override
    public String toString() {
        return "lev " + this.meno;
    }
}
