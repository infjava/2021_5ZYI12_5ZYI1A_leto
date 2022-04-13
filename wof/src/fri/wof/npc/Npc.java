package fri.wof.npc;

import java.io.Serializable;

public class Npc implements Serializable {
    private final String meno;

    public Npc(String meno) {
        this.meno = meno;
    }

    public String getMeno() {
        return this.meno;
    }

    public void oslov() {

    }
}
