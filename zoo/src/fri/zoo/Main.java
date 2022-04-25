package fri.zoo;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	    Lev lev = new Lev("Alex");
        Main.vyskusajKlietku(lev, new Mys());
        Main.vyskusajKlietku(new Mys(), new Syr());
        Main.vyskusajForEach();

//        for (Integer nieco : new NekonecnyKontajner()) {
//            System.out.println(nieco);
//        }
    }

    private static void vyskusajForEach() {
        ArrayList<Integer> cisla = new ArrayList<>();

        Iterator<Integer> iterator = cisla.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);
        }
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

        System.out.println("V klietke sa nachadzaju:");
        for (T prvok : klietkaNaMys) {
            System.out.println(prvok);
        }
    }
}
