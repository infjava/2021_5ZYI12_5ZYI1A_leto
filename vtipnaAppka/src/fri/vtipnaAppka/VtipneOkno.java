package fri.vtipnaAppka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VtipneOkno {
    private final JFrame okno;

    public VtipneOkno() {
        this.okno = new JFrame("Vtipna aplikacia");
        this.okno.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.okno.add(new JLabel("Chces ukoncit uspesne predmet informatika?"), BorderLayout.NORTH);
        this.okno.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Si fakt myslis, ze som taky blby? Musis sa viac snazit.");
            }
        });
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
                anoTlacitko.grabFocus();
                anoTlacitko.setText("Ano");
                nieTlacitko.setText("Nie");
            }
        });
        anoTlacitko.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                anoTlacitko.setText("Ano");
                nieTlacitko.setText("Nie");
            }
        });
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
