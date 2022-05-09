package fri.vtipnaAppka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VtipneOkno {
    private final JFrame okno;

    public VtipneOkno() {
        this.okno = new JFrame("Vtipna aplikacia");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(new JLabel("Chces ukoncit uspesne predmet informatika?"), BorderLayout.NORTH);
        JPanel tlacidla = new JPanel();
        tlacidla.setLayout(new GridLayout());

        JButton anoTlacitko = new JButton("Ano");
        JButton nieTlacitko = new JButton("Nie");

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

        nieTlacitko.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Tak by si sa mal zacat snazit");
            System.exit(0);
        });
        nieTlacitko.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                anoTlacitko.setText("Nie");
                nieTlacitko.setText("Ano");
            }
        });

        tlacidla.add(anoTlacitko);
        tlacidla.add(nieTlacitko);

        this.okno.add(tlacidla);
        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
