package fri.vtipnaAppka;

import javax.swing.*;
import java.awt.*;

public class VtipneOkno {
    private final JFrame okno;

    public VtipneOkno() {
        this.okno = new JFrame("Vtipna aplikacia");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(new JLabel("Chces ukoncit uspesne predmet informatika?"), BorderLayout.NORTH);
        JPanel tlacidla = new JPanel();
        tlacidla.setLayout(new GridLayout());

        JButton anoTlacitko = new JButton("Ano");
        anoTlacitko.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Tak by si sa mal zacat snazit");
            System.exit(0);
        });
        tlacidla.add(anoTlacitko);

        tlacidla.add(new JButton("Nie"));
        this.okno.add(tlacidla);
        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
