package fri.wof.prostredie;

import fri.wof.predmety.Navleky;
import fri.wof.predmety.Predmet;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Mapa {
    private final IMiestnost startovaciaMiestnost;

    /**
     * Vytvori mapu hry - miestnosti.
     */
    public Mapa() {
        // vytvorenie miestnosti
        StandardnaMiestnost internaty = new StandardnaMiestnost("internaty - tu som doma");
        StandardnaMiestnost cesta = new StandardnaMiestnost("cesta - hej hou, hej hou, uz ideme ... na fri");
        StandardnaMiestnost telocvicna = new StandardnaMiestnost("telocvicna - divno to tu pachne, niekto sa zabudol osprchovat");
        StandardnaMiestnost schody = new StandardnaMiestnost("schody - uz sa tesim do skoly");
        StandardnaMiestnost chodba = new StandardnaMiestnost("chodba - vstupna chodba");
        StandardnaMiestnost vratnica = new StandardnaMiestnost("vratnica - tu byva pani vratnicka");
        StandardnaMiestnost b = new StandardnaMiestnost("b - temna chodba v budove b");
        Labak b2 = new Labak(b);
        StandardnaMiestnost a = new StandardnaMiestnost("a - chodba plna historickych artefaktov");
        StandardnaMiestnost c = new StandardnaMiestnost("c - chodba v podzemi");
        StandardnaMiestnost a2 = new StandardnaMiestnost("a2 - kniznica, tu treba byt ticho");
        StandardnaMiestnost wc = new StandardnaMiestnost("wc - radsej ani nejdem hovorit, co tu vidim");

        // inicializacia miestnosti = nastavenie vychodov
        internaty.nastavVychod("cesta", cesta);

        internaty.vlozPredmet(new Predmet("pero"));
        internaty.vlozPredmet(new Predmet("usbkluc"));
        internaty.vlozPredmet(new Predmet("kluc"));
        internaty.vlozPredmet(new Navleky());

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

    public IMiestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}
