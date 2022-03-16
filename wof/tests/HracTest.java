import fri.wof.hra.Hrac;
import fri.wof.prostredie.IMiestnost;
import fri.wof.prostredie.Miestnost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
class HracTest {
    private Miestnost miestnostHraca;
    private IMiestnost susednaMiestnost;
    private Hrac hrac;

    @BeforeEach
    void setUp() {
        this.miestnostHraca = new Miestnost("startovacia miestnost");
        this.susednaMiestnost = new Miestnost("susedna miestnost");
        this.miestnostHraca.nastavVychod("sever", this.susednaMiestnost);
        this.hrac = new Hrac(this.miestnostHraca);
    }

    @Test
    void ziskanieAktualnejMiestnosti() {
        assertSame(this.miestnostHraca, this.hrac.getAktualnaMiestnost());
    }

    @Test
    void posunSaSpravne() {
        this.hrac.posunSa("sever");

        assertSame(this.susednaMiestnost, this.hrac.getAktualnaMiestnost());
    }

    @Test
    void posunSaNespravne() {
        this.hrac.posunSa("juh");

        assertSame(this.miestnostHraca, this.hrac.getAktualnaMiestnost());
    }

    @Test
    void posunSaDoChybnehoSmeru() {
        this.hrac.posunSa("chyba");

        assertSame(this.miestnostHraca, this.hrac.getAktualnaMiestnost());
    }
}
