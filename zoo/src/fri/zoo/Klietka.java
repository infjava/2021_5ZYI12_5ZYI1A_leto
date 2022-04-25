package fri.zoo;

import java.util.Iterator;

public class Klietka<E extends Zviera<E>> implements Iterable<E> {
    private E zviera;

    public void vlozZviera(E zviera) {
        this.zviera = zviera;
    }

    public void kukni() {
        System.out.printf("V klietke si nasiel zviera: %s%n", this.zviera);
    }

    public String getMenoZvierata() {
        return this.zviera.getMeno();
    }

    public void nakrm(IPotrava<E> potrava) {
        this.zviera.zjedz(potrava);
    }

    @Override
    public Iterator<E> iterator() {
        return new KlietkaIterator<E>(this.zviera);
    }
}
