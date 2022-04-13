package fri.wof.hra;

import fri.wof.npc.Npc;
import fri.wof.predmety.IPredmet;
import fri.wof.prostredie.IKontrolaVstupu;
import fri.wof.prostredie.IMiestnost;
import fri.wof.prostredie.NeexistujuciVychodException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Hrac {
    private IMiestnost aktualnaMiestnost;
    private final HashMap<String, IPredmet> inventar;

    public Hrac(IMiestnost aktualnaMiestnost) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.inventar = new HashMap<>();
    }

    public IMiestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    public void posunSa(String smer) throws NeexistujuciVychodException, ZakazVstupuException {
        IMiestnost novaMiestnost = this.aktualnaMiestnost.getMiestnostVSmere(smer);

        if (novaMiestnost instanceof IKontrolaVstupu kontrola && !kontrola.mozeVstupit(this)) {
            throw new ZakazVstupuException();
        } else {
            this.aktualnaMiestnost = novaMiestnost;
            this.getAktualnaMiestnost().vypisMiestnost();
        }
    }

    public void zdvihniPredmet(String nazovPredmetu) {
        IPredmet predmet = this.aktualnaMiestnost.odstranPredmet(nazovPredmetu);
        if (predmet != null) {
            this.inventar.put(predmet.getNazov(), predmet);
        } else {
            System.out.println("Taky predmet nevidis");
        }
    }

    public void odhodPredmet(String nazovPredmetu) {
        IPredmet predmet = this.inventar.remove(nazovPredmetu);
        if (predmet != null) {
            this.aktualnaMiestnost.vlozPredmet(predmet);
        } else {
            System.out.println("Taky predmet nemas");
        }
    }

    public void pouziPredmet(String nazovPredmetu) {
        IPredmet predmet = this.inventar.get(nazovPredmetu);
        if (predmet != null) {
            predmet.pouzi(this);
        } else {
            System.out.println("Taky predmet nemas");
        }
    }

    public IPredmet getPredmet(String nazov) {
        return this.inventar.get(nazov);
    }

    public void oslovNpc(String meno) {
        Npc npc = this.aktualnaMiestnost.getNpc(meno);
        if (npc != null) {
            npc.oslov();
        } else {
            System.out.printf("Npc %s nikde nevidis!%n", meno);
        }
    }

    public void ulozSa(DataOutputStream saveDataStream) throws IOException {
        saveDataStream.writeUTF(this.aktualnaMiestnost.getNazov());
    }

    public void nacitajSa(DataInputStream saveDataStream, int saveVerzia) throws IOException {
        String miestnost = saveDataStream.readUTF();
        // tu by bolo vyhladanie miestnosti v mape na zaklade nazvu
    }
}
