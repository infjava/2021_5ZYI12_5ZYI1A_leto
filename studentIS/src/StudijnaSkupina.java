import java.util.ArrayList;

public class StudijnaSkupina {
    private final String cislo;
    private final ArrayList<Student> zoznamStudentov;

    public StudijnaSkupina(String cislo) {
        this.cislo = cislo;
        this.zoznamStudentov = new ArrayList<>();
    }

    public String getCislo() {
        return this.cislo;
    }

    public void pridajStudenta(Student student) {
        this.zoznamStudentov.add(student);
    }

    public void vypis() {
        if (this.zoznamStudentov.isEmpty()) {
            System.out.println("V studijnej skupine " + this.cislo + " nie su ziadny studenti");
        }

        for (Student student : this.zoznamStudentov) {
            System.out.println(student);
        }
    }
}
