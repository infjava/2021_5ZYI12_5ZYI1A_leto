package fri.zoo;

import java.util.Iterator;

public class NekonecnyKontajnerIterator implements Iterator<Integer> {
    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return 5;
    }
}
