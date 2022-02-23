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
        return null;
    }

    public Vzducholod najdiVzducholod(int id) {
        return null;
    }

    public void vypisVzducholode(Stav stav) {

    }

    public void vytvorVzducholod(Konstrukcia konstrukcia, String nazov, int kapacita) {
        this.posledneId++;
        this.flotila.add(new Vzducholod(this.posledneId, konstrukcia, nazov, kapacita));
    }
}
