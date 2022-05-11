package fri.intraky;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

        DocumentListener reakciaNaZmenu = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujOpravnenia();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujOpravnenia();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                HlavneOkno.this.aktualizujOpravnenia();
            }
        };

        this.menoTextField.getDocument().addDocumentListener(reakciaNaZmenu);
        this.priezviskoTextField.getDocument().addDocumentListener(reakciaNaZmenu);
        this.izbaTextField.getDocument().addDocumentListener(reakciaNaZmenu);

        this.aktualizujOpravnenia();
        zoznamStudentovList.addListSelectionListener(e -> this.aktualizujOpravnenia());
        odstranButton.addActionListener(e -> this.odstranStudentov());
    }

    private void aktualizujOpravnenia() {
        this.pridajButton.setEnabled(!this.menoTextField.getText().isEmpty()
                && !this.priezviskoTextField.getText().isEmpty()
                && !this.izbaTextField.getText().isEmpty());
        this.odstranButton.setEnabled(!this.zoznamStudentovList.isSelectionEmpty());
    }

    private void pridajStudenta() {
        this.zoznamStudentov.addElement(
            new UbytovanyStudent(
                this.menoTextField.getText(),
                this.priezviskoTextField.getText(),
                this.izbaTextField.getText()
            )
        );

        this.menoTextField.setText("");
        this.priezviskoTextField.setText("");
        this.izbaTextField.setText("");

        this.menoTextField.grabFocus();
    }

    private void odstranStudentov() {
        for (UbytovanyStudent student : this.zoznamStudentovList.getSelectedValuesList()) {
            this.zoznamStudentov.removeElement(student);
        }
    }

    public void zobraz() {
        this.zoznamStudentovList.setModel(this.zoznamStudentov);
        JFrame okno = new JFrame("Intraky IS");
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        okno.add(this.obsahOkna);
        okno.getRootPane().setDefaultButton(this.pridajButton);
        okno.pack();
        okno.setVisible(true);
    }

}
