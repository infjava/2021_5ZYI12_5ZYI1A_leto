package fri.zoo;

import java.util.Iterator;

public class NekonecnyKontajner implements Iterable<Integer> {
    @Override
    public Iterator<Integer> iterator() {
        return new NekonecnyKontajnerIterator();
    }
}
