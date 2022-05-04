package fri.vtipnaAppka;

import javax.swing.*;

public class VtipneOkno {
    private final JFrame okno;

    public VtipneOkno() {
        this.okno = new JFrame("Vtipna aplikacia");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
