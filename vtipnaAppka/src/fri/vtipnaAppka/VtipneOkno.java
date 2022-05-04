package fri.vtipnaAppka;

import javax.swing.*;
import java.awt.*;

public class VtipneOkno {
    private final JFrame okno;

    public VtipneOkno() {
        this.okno = new JFrame("Vtipna aplikacia");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(new JLabel("Chces ukoncit uspesne predmet informatika?"), BorderLayout.NORTH);
        this.okno.add(new JButton("Ano"), BorderLayout.WEST);
        this.okno.add(new JButton("Nie"), BorderLayout.EAST);
        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
