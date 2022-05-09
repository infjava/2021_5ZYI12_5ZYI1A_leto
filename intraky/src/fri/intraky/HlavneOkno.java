package fri.intraky;

import javax.swing.*;

public class HlavneOkno {
    private JList list1;
    private JPanel panel1;

    public void zobraz() {
        JFrame okno = new JFrame("Intraky IS");
        okno.add(this.panel1);
        okno.pack();
        okno.setVisible(true);
    }

}
