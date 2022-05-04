package fri.vtipnaAppka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VtipneOkno {
    private static class KliknutieNaAno implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Tak by si sa mal zacat snazit");
            System.exit(0);
        }
    }

    private final JFrame okno;

    public VtipneOkno() {
        this.okno = new JFrame("Vtipna aplikacia");
        this.okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.okno.add(new JLabel("Chces ukoncit uspesne predmet informatika?"), BorderLayout.NORTH);
        JPanel tlacidla = new JPanel();
        tlacidla.setLayout(new GridLayout());

        JButton anoTlacitko = new JButton("Ano");
        anoTlacitko.addActionListener(new KliknutieNaAno());
        tlacidla.add(anoTlacitko);

        tlacidla.add(new JButton("Nie"));
        this.okno.add(tlacidla);
        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
