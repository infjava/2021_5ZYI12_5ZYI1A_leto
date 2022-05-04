package fri.vtipnaAppka;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KliknutieNaAno implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Tak by si sa mal zacat snazit");
        System.exit(0);
    }
}
