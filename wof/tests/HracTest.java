import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
class HracTest {

    @Test
    void posunSaSpravne() {
        Miestnost miestnostHraca = new Miestnost("startovacia miestnost");
        Miestnost susednaMiestnost = new Miestnost("susedna miestnost");
        miestnostHraca.nastavVychody(susednaMiestnost, null, null, null);
        Hrac hrac = new Hrac(miestnostHraca);

        hrac.posunSa("sever");

        Assertions.assertSame(susednaMiestnost, hrac.getAktualnaMiestnost());
    }
}
