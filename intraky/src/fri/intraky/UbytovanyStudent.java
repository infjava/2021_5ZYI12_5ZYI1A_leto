package fri.intraky;

public class UbytovanyStudent {
    private final String meno;
    private final String priezvisko;
    private final String izba;

    public UbytovanyStudent(String meno, String priezvisko, String izba) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.izba = izba;
    }

    @Override
    public String toString() {
        return "UbytovanyStudent{" +
                "meno='" + meno + '\'' +
                ", priezvisko='" + priezvisko + '\'' +
                ", izba='" + izba + '\'' +
                '}';
    }
}
