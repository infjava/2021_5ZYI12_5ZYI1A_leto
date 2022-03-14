/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Mapa {
    private final Miestnost startovaciaMiestnost;

    /**
     * Vytvori mapu hry - miestnosti.
     */
    public Mapa() {
        // vytvorenie miestnosti
        Miestnost internaty = new Miestnost("internaty - tu som doma");
        Miestnost cesta = new Miestnost("cesta - hej hou, hej hou, uz ideme ... na fri");
        Miestnost telocvicna = new Miestnost("telocvicna - divno to tu pachne, niekto sa zabudol osprchovat");
        Miestnost schody = new Miestnost("schody - uz sa tesim do skoly");
        Miestnost chodba = new Miestnost("chodba - vstupna chodba");
        Miestnost vratnica = new Miestnost("vratnica - tu byva pani vratnicka");
        Miestnost b = new Miestnost("b - temna chodba v budove b");
        Miestnost b2 = new Miestnost("b2 - ako na dovolenke, pocut sum ... pocitacov");
        Miestnost a = new Miestnost("a - chodba plna historickych artefaktov");
        Miestnost c = new Miestnost("c - chodba v podzemi");
        Miestnost a2 = new Miestnost("a2 - kniznica, tu treba byt ticho");
        Miestnost wc = new Miestnost("wc - radsej ani nejdem hovorit, co tu vidim");

        // inicializacia miestnosti = nastavenie vychodov
        internaty.nastavVychod("cesta", cesta);

        internaty.vlozPredmet(new Predmet("pero"));
        internaty.vlozPredmet(new Predmet("usbkluc"));
        internaty.vlozPredmet(new Predmet("kluc"));
        internaty.vlozPredmet(new Predmet("navleky"));

        cesta.nastavVychod("internaty", internaty);
        cesta.nastavVychod("telocvicna", telocvicna);
        cesta.nastavVychod("c", c);
        cesta.nastavVychod("schody", schody);

        telocvicna.nastavVychod("cesta", cesta);

        schody.nastavVychod("cesta", cesta);
        schody.nastavVychod("chodba", chodba);

        chodba.nastavVychod("schody", schody);
        chodba.nastavVychod("vratnica", vratnica);
        chodba.nastavVychod("a", a);
        chodba.nastavVychod("b", b);

        b.nastavVychod("b2", b2);
        b.nastavVychod("chodba", chodba);

        b2.nastavVychod("b", b);

        vratnica.nastavVychod("chodba", chodba);

        a.nastavVychod("chodba", chodba);
        a.nastavVychod("a2", a2);
        a.nastavVychod("wc", wc);
        a.nastavVychod("c", c);

        a2.nastavVychod("a", a);

        wc.nastavVychod("a", a);

        c.nastavVychod("a", a);
        c.nastavVychod("cesta", cesta);

        this.startovaciaMiestnost = internaty;
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}
