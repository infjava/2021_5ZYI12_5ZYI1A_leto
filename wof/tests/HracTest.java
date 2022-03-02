import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
class HracTest {
    @Test
    void ziskanieAktualnejMiestnosti() {
        Miestnost miestnostHraca = new Miestnost("startovacia miestnost");
        Miestnost susednaMiestnost = new Miestnost("susedna miestnost");
        miestnostHraca.nastavVychody(susednaMiestnost, null, null, null);
        Hrac hrac = new Hrac(miestnostHraca);

        assertSame(miestnostHraca, hrac.getAktualnaMiestnost());
    }

    @Test
    void posunSaSpravne() {
        Miestnost miestnostHraca = new Miestnost("startovacia miestnost");
        Miestnost susednaMiestnost = new Miestnost("susedna miestnost");
        miestnostHraca.nastavVychody(susednaMiestnost, null, null, null);
        Hrac hrac = new Hrac(miestnostHraca);

        hrac.posunSa("sever");

        assertSame(susednaMiestnost, hrac.getAktualnaMiestnost());
    }

    @Test
    void posunSaNespravne() {
        Miestnost miestnostHraca = new Miestnost("startovacia miestnost");
        Miestnost susednaMiestnost = new Miestnost("susedna miestnost");
        miestnostHraca.nastavVychody(susednaMiestnost, null, null, null);
        Hrac hrac = new Hrac(miestnostHraca);

        hrac.posunSa("juh");

        assertSame(miestnostHraca, hrac.getAktualnaMiestnost());
    }

    @Test
    void posunSaDoChybnehoSmeru() {
        Miestnost miestnostHraca = new Miestnost("startovacia miestnost");
        Miestnost susednaMiestnost = new Miestnost("susedna miestnost");
        miestnostHraca.nastavVychody(susednaMiestnost, null, null, null);
        Hrac hrac = new Hrac(miestnostHraca);

        hrac.posunSa("chyba");

        assertSame(miestnostHraca, hrac.getAktualnaMiestnost());
    }
}
