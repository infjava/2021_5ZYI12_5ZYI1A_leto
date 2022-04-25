package fri.zoo;

public class Main {

    public static void main(String[] args) {
	    Lev lev = new Lev("Alex");
        Main.<Lev, Mys>vyskusajKlietku(lev, new Mys());
        Main.<Mys, Syr>vyskusajKlietku(new Mys(), new Syr());
    }

    /**
     * @param <T> Typ zvierata
     * @param <S> Typ potravy
     */
    public static <T extends Zviera<T>, S extends IPotrava<T>> void vyskusajKlietku(T zviera, S potrava) {
        Klietka<T> klietkaNaMys = new Klietka<T>();
        klietkaNaMys.vlozZviera(zviera);
        klietkaNaMys.nakrm(potrava);
        //klietkaNaMys.nakrm(new Mys());
        klietkaNaMys.kukni();
    }
}
