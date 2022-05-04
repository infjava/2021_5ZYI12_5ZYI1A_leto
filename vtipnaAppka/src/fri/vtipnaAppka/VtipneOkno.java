package fri.vtipnaAppka;

import javax.swing.*;

public class VtipneOkno {
    private final JFrame okno;

    public VtipneOkno() {
        this.okno = new JFrame("Vtipna aplikacia");
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
