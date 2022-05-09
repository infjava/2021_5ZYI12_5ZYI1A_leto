package fri.vtipnaAppka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VtipneOkno {
    private final JFrame okno;

    public VtipneOkno() {
        this.okno = new JFrame("Vtipna aplikacia");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(new JLabel("Chces ukoncit uspesne predmet informatika?"), BorderLayout.NORTH);
        JPanel tlacidla = new JPanel();
        tlacidla.setLayout(new GridLayout());

        JButton laveTlacitko = new JButton("Ano");
        JButton praveTlacitko = new JButton("Nie");

        pridajListenery(laveTlacitko, praveTlacitko);
        pridajListenery(praveTlacitko, laveTlacitko);

        tlacidla.add(laveTlacitko);
        tlacidla.add(praveTlacitko);

        this.okno.add(tlacidla);
        this.okno.pack();
    }

    private void pridajListenery(JButton anoTlacitko, JButton nieTlacitko) {
        anoTlacitko.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Tak by si sa mal zacat snazit");
            System.exit(0);
        });
        anoTlacitko.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                anoTlacitko.setText("Ano");
                nieTlacitko.setText("Nie");
            }
        });
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
