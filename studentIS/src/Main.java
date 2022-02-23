public class Main {

    public static void main(String[] args) {
        Student janko = new Student("Jan", "Janech", "1001120");

        StudijnaSkupina skupina = new StudijnaSkupina("5ZYI1Z");
        skupina.pridajStudenta(janko);

        skupina.vypis();
    }
}
