package fri.zoo;

public class Lev {
    private final String meno;

    public Lev(String meno) {
        this.meno = meno;
    }

    @Override
    public String toString() {
        return "lev " + this.meno;
    }
}
