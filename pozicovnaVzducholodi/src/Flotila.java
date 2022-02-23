import java.util.ArrayList;

/**
 * 23. 2. 2022 - 10:25
 *
 * @author janik
 */
public class Flotila {
    private final ArrayList<Vzducholod> flotila;
    private int posledneId;

    public Flotila() {
        this.flotila = new ArrayList<Vzducholod>();
        this.posledneId = 0;
    }

    public Vzducholod najdiVzducholod(int pozadovanaNosnost, Konstrukcia pozadovanaKonstrukcia, boolean ibaDostupna) {
        for (Vzducholod vzducholod : this.flotila) {
            if (vzducholod.getNosnost() == pozadovanaNosnost && vzducholod.getKonstrukcia() == pozadovanaKonstrukcia && vzducholod.getStav() == Stav.VOLNA) {
                return vzducholod;
            }
        }
        return null;
    }

    public Vzducholod najdiVzducholod(int id) {
        for (Vzducholod vzducholod : this.flotila) {
            if (vzducholod.getId() == id) {
                return vzducholod;
            }
        }

        return null;
    }

    public void vypisVzducholode(Stav stav) {
        for (Vzducholod vzducholod : this.flotila) {
            if (vzducholod.getStav() == stav || stav == null) {
                System.out.println(vzducholod);
            }
        }
    }

    public void vytvorVzducholod(Konstrukcia konstrukcia, String nazov, int kapacita) {
        this.posledneId++;
        this.flotila.add(new Vzducholod(this.posledneId, konstrukcia, nazov, kapacita));
    }
}
