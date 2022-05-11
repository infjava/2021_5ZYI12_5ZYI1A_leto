package fri.intraky;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HlavneOkno {
    private final DefaultListModel<UbytovanyStudent> zoznamStudentov;
    private JList<UbytovanyStudent> zoznamStudentovList;
    private JPanel obsahOkna;
    private JTextField menoTextField;
    private JTextField priezviskoTextField;
    private JTextField izbaTextField;
    private JButton pridajButton;
    private JButton odstranButton;
    private JButton vyhladajButton;
    private JButton upravButton;

    public HlavneOkno() {
        this.zoznamStudentov = new DefaultListModel<UbytovanyStudent>();

        pridajButton.addActionListener(e -> this.pridajStudenta());
    }

    private void pridajStudenta() {
        this.zoznamStudentov.addElement(
            new UbytovanyStudent(
                this.menoTextField.getText(),
                this.priezviskoTextField.getText(),
                this.izbaTextField.getText()
            )
        );
    }

    public void zobraz() {
        this.zoznamStudentovList.setModel(this.zoznamStudentov);
        JFrame okno = new JFrame("Intraky IS");
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        okno.add(this.obsahOkna);
        okno.pack();
        okno.setVisible(true);
    }

}
