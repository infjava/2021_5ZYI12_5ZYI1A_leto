import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: janik
 * Date: 23. 2. 2022
 * Time: 10:25
 */
public class Pozicovna {
    private final Flotila flotila;
    private final Scanner scanner;

    public Pozicovna() {
        this.flotila = new Flotila();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Pozicovna.vytvorTestovaciuPozicovnu().hlavneMenu();
    }

    public void hlavneMenu() {

    }

    public static Pozicovna vytvorTestovaciuPozicovnu() {
        return new Pozicovna();
    }
}
