package fri.intraky;

import javax.swing.*;

public class HlavneOkno {
    private final DefaultListModel<UbytovanyStudent> zoznamStudentov;
    private JList<UbytovanyStudent> list1;
    private JPanel panel1;
    private JTextField meno;
    private JTextField priezvisko;
    private JTextField izba;
    private JButton pridajButton;
    private JButton odstranButton;
    private JButton vyhladajButton;
    private JButton upravButton;

    public HlavneOkno() {
        this.zoznamStudentov = new DefaultListModel<UbytovanyStudent>();
        this.zoznamStudentov.addElement(new UbytovanyStudent("Jozko", "Mrkvicka", "C123"));
        this.zoznamStudentov.addElement(new UbytovanyStudent("Ferko", "Mrkvicka", "C123"));
        this.zoznamStudentov.addElement(new UbytovanyStudent("Arnold", "Neviemaky", "F100"));
    }

    public void zobraz() {
        this.list1.setModel(this.zoznamStudentov);
        JFrame okno = new JFrame("Intraky IS");
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        okno.add(this.panel1);
        okno.pack();
        okno.setVisible(true);
    }

}
