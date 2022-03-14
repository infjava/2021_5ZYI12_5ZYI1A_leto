import java.util.HashMap;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Hrac {
    private Miestnost aktualnaMiestnost;
    private final HashMap<String, IPredmet> inventar;

    public Hrac(Miestnost aktualnaMiestnost) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.inventar = new HashMap<>();
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    void posunSa(String smer) {
        Miestnost novaMiestnost = this.aktualnaMiestnost.getMiestnostVSmere(smer);

        if (novaMiestnost == null) {
            System.out.println("Tam nie je vychod!");
        } else {
            this.aktualnaMiestnost = novaMiestnost;
            this.getAktualnaMiestnost().vypisMiestnost();
        }
    }

    public void zdvihniPredmet(String nazovPredmetu) {
        IPredmet predmet = this.aktualnaMiestnost.odstranPredmet(nazovPredmetu);
        if (predmet != null) {
            this.inventar.put(predmet.getNazov(), predmet);
        } else {
            System.out.println("Taky predmet nevidis");
        }
    }

    public void odhodPredmet(String nazovPredmetu) {
        IPredmet predmet = this.inventar.remove(nazovPredmetu);
        if (predmet != null) {
            this.aktualnaMiestnost.vlozPredmet(predmet);
        } else {
            System.out.println("Taky predmet nemas");
        }
    }

    public void pouziPredmet(String nazovPredmetu) {
        IPredmet predmet = this.inventar.get(nazovPredmetu);
        if (predmet != null) {
            predmet.pouzi();
        } else {
            System.out.println("Taky predmet nemas");
        }
    }
}
