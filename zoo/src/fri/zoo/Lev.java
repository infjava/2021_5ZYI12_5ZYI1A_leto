package fri.zoo;

public class Lev extends Zviera {
    private final String meno;

    public Lev(String meno) {
        this.meno = meno;
    }

    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public String toString() {
        return "lev " + this.meno;
    }
}
