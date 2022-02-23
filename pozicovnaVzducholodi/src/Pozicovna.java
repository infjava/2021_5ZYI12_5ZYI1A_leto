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

    private void podmenuPozicanieVzducholode() {
        System.out.println("POZICANIE VZDUCHOLODE");

        System.out.print("Zadajte pozadovanu nosnost ");
        int nosnost = this.scanner.nextInt();

        System.out.println("Zadajte pozadovanu konstrukciu");
        for (Konstrukcia konstrukcia : Konstrukcia.values()) {
            System.out.println(String.format("\t%d: %s", konstrukcia.ordinal(), konstrukcia.toString()));
        }
        System.out.println("\tInak volba: nezalezi na konstrukcii");
        System.out.print("\nVasa volba: ");
        int typKonstrukcie = this.scanner.nextInt();
        Konstrukcia konstrukcia = typKonstrukcie >= 0 && typKonstrukcie < Konstrukcia.values().length ? Konstrukcia.values()[typKonstrukcie] : null;

        System.out.print("Iba dostupne vzducholode? (1 = ano, inak nie)");
        boolean ibaDostupna = this.scanner.nextInt() == 1;

        Vzducholod vzducholod = this.flotila.najdiVzducholod(nosnost, konstrukcia, ibaDostupna);
        if (vzducholod != null && vzducholod.pozicka()) {
            System.out.println(vzducholod.toString() + " uspesne pozicana!");
        } else {
            System.out.println(String.format("Vzducholod s pozadovanymi vlastnostami sa nepodarilo pozicat, lebo vzducholod s danymi vlastnostami nie je k dispozicii!"));
        }

        this.scanner.nextLine();
    }

    private void podmenuVratenieVzducholode() {
        System.out.println("VRATENIE VZDUCHOLODE");

        System.out.print("Zadajte ID vzducholode, ktore chcete vratit ");
        int id = this.scanner.nextInt();

        Vzducholod vzducholod = this.flotila.najdiVzducholod(id);
        if (vzducholod != null && vzducholod.navrat()) {
            System.out.println(vzducholod.toString() + " uspesne vratena!");
        } else {
            System.out.println(String.format("Vzducholod s pozadovanymi vlastnostami sa nepodarilo vratit, lebo %s!",
                    vzducholod == null ? "vzducholod s danym ID neexistuje" : "vzducholod nie je pozicana"));
        }

        this.scanner.nextLine();
    }

    private void podmenuOpravaVzducholode() {
        System.out.println("OPRAVA VZDUCHOLODE");

        System.out.print("Zadajte ID vzducholode, ktore chcete vratit ");
        int id = this.scanner.nextInt();

        Vzducholod vzducholod = this.flotila.najdiVzducholod(id);
        if (vzducholod != null && vzducholod.oprava()) {
            System.out.println(vzducholod.toString() + " uspesne vratena!");
        } else {
            System.out.println(String.format("Vzducholod s pozadovanymi vlastnostami sa nepodarilo opravit, lebo %s!",
                    vzducholod == null ? "vzducholod s danym ID neexistuje" : "vzducholod nie je potrebne opravit"));
        }

        this.scanner.nextLine();
    }

    private void podmenuVypisFlotily() {
        System.out.println("VYPIS FLOTILY");

        System.out.println("Zadajte pozadovany stav");
        for (Stav stav : Stav.values()) {
            System.out.println(String.format("\t%d: %s", stav.ordinal(), stav.toString()));
        }
        System.out.println("\tInak volba: nezalezi na stave");
        System.out.print("\nVasa volba: ");
        int typStavu = this.scanner.nextInt();
        Stav stav = typStavu >= 0 && typStavu < Stav.values().length ? Stav.values()[typStavu] : null;

        this.flotila.vypisVzducholode(stav);

        this.scanner.nextLine();
    }

    public void hlavneMenu() {
        String vstup;
        do {
            System.out.println("HLAVNE MENU\n" +
                    "P - pozicanie vzducholode\n" +
                    "V - vratenie vzducholode\n" +
                    "O - oprava vzducholode\n" +
                    "F - vypis flotily\n" +
                    "K - koniec");
            vstup = this.scanner.nextLine();
            switch (vstup) {
                case "P":
                    this.podmenuPozicanieVzducholode();
                    break;
                case "V":
                    this.podmenuVratenieVzducholode();
                    break;
                case "O":
                    this.podmenuOpravaVzducholode();
                    break;
                case "F":
                    this.podmenuVypisFlotily();
                    break;
            }
        } while (!vstup.equals("K"));
    }

    public static Pozicovna vytvorTestovaciuPozicovnu() {
        Pozicovna pozicovna = new Pozicovna();
        pozicovna.vytvorVzducholod(Konstrukcia.VYSTUZENA, "Imperator Altair", 100);
        pozicovna.vytvorVzducholod(Konstrukcia.VYSTUZENA, "Imperator Deneb", 85);
        for (int i = 0; i < 3; i++) {
            pozicovna.vytvorVzducholod(Konstrukcia.POLOVYSTUZENA, "Rex Antares", 20);
        }
        for (int i = 0; i < 5; i++) {
            pozicovna.vytvorVzducholod(Konstrukcia.NEVYSTUZENA, "Dux Regulus", 5);
        }
        pozicovna.vytvorVzducholod(Konstrukcia.HYBRIDNA, "Dominus Alcor", 150);
        pozicovna.vytvorVzducholod(Konstrukcia.HYBRIDNA, "Dominus Mizar", 100);
        return pozicovna;
    }

    private void vytvorVzducholod(Konstrukcia konstrukcia, String nazov, int kapacita) {
        this.flotila.vytvorVzducholod(konstrukcia, nazov, kapacita);
    }
}
