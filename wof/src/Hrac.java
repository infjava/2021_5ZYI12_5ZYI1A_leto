/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Hrac {
    private Miestnost aktualnaMiestnost;

    public Hrac(Miestnost aktualnaMiestnost) {
        this.aktualnaMiestnost = aktualnaMiestnost;
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    void posunSa(String smer) {
        Miestnost novaMiestnost = null;
        switch (smer) {
            case "sever":
                novaMiestnost = this.getAktualnaMiestnost().getSevernyVychod();
                break;
            case "vychod":
                novaMiestnost = this.getAktualnaMiestnost().getVychodnyVychod();
                break;
            case "juh":
                novaMiestnost = this.getAktualnaMiestnost().getJuznyVychod();
                break;
            case "zapad":
                novaMiestnost = this.getAktualnaMiestnost().getZapadnyVychod();
                break;
        }

        if (novaMiestnost == null) {
            System.out.println("Tam nie je vychod!");
        } else {
            this.aktualnaMiestnost = novaMiestnost;
            this.getAktualnaMiestnost().vypisMiestnost();
        }
    }
}
