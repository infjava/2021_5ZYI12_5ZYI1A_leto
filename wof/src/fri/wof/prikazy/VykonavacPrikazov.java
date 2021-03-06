package fri.wof.prikazy;

import fri.wof.hra.Hra;
import fri.wof.hra.Hrac;
import fri.wof.prostredie.NeexistujuciVychodException;
import fri.wof.hra.ZakazVstupuException;

import java.io.*;

/**
 * Trieda NazvyPrikazov udrzuje zoznam nazvov platnych prikazov hry. 
 * Za ulohu ma rozpoznavat platne prikazy.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */

public class VykonavacPrikazov {
    private static final int SAVE_MAGIC_NUMBER = 1456156;
    private static final int SAVE_VERZIA = 1;

    // konstantne pole nazvov prikazov
    private static final String[] PLATNE_PRIKAZY = {
        "chod", "ukonci", "pomoc", "zdvihni", "odhod", "pouzi", "oslov",
        "save", "load"
    };

    /**
     * Kontroluje, ci nazov v parametri je platny prikaz.
     *  
     * @return true ak je parameter platny prikaz,
     * false inak.
     */
    public boolean jePrikaz(String nazov) {
        for (int i = 0; i < VykonavacPrikazov.PLATNE_PRIKAZY.length; i++) {
            if (VykonavacPrikazov.PLATNE_PRIKAZY[i].equals(nazov)) {
                return true;
            }
        }
        // ak algoritmus dosiahne tento bod, parameter nie je platny prikaz
        return false;
    }

    /**
     * Ukonci hru.
     * Skotroluje cely prikaz a zisti, ci je naozaj koniec hry.
     * fri.wof.prikazy.Prikaz ukoncenia nema parameter.
     *
     * @return true, ak prikaz konci hru, inak false.
     * @param prikaz
     */
    boolean ukonciHru(Prikaz prikaz) {
        if (prikaz.maParameter()) {
            System.out.println("Ukonci, co?");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Vykona pokus o prechod do miestnosti urcenej danym smerom.
     * Ak je tym smerom vychod, hrac prejde do novej miestnosti.
     * Inak sa vypise chybova sprava do terminaloveho okna.
     * @param prikaz
     * @param hrac
     */
    void chodDoMiestnosti(Prikaz prikaz, Hrac hrac) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String smer = prikaz.getParameter();

        // Pokus o opustenie aktualnej miestnosti danym vychodom.
        try {
            hrac.posunSa(smer);
        } catch (NeexistujuciVychodException e) {
            System.out.println("Tym smerom sa neda ist");
        } catch (ZakazVstupuException e) {
            System.out.println("Neda sa vojst");
        }
    }

    /**
     * Vypise text pomocnika do terminaloveho okna.
     * Text obsahuje zoznam moznych prikazov.
     */
    void vypisNapovedu() {
        System.out.println("Zabludil si. Si sam. Tulas sa po fakulte.");
        System.out.println();
        System.out.println("Mozes pouzit tieto prikazy:");
        System.out.println("   chod ukonci pomoc");
    }

    /**
     * Prevezne prikaz a vykona ho.
     *
     * @param prikaz prikaz, ktory ma byt vykonany.
     * @param hrac
     * @param hra
     * @return true ak prikaz ukonci hru, inak vrati false.
     */
    public boolean vykonajPrikaz(Prikaz prikaz, Hrac hrac) {
        if (prikaz.jeNeznamy()) {
            System.out.println("Nerozumiem, co mas na mysli...");
            return false;
        }

        String nazovPrikazu = prikaz.getNazov();

        switch (nazovPrikazu) {
            case "pomoc":
                this.vypisNapovedu();
                return false;
            case "chod":
                this.chodDoMiestnosti(prikaz, hrac);
                return false;
            case "ukonci":
                return this.ukonciHru(prikaz);
            case "zdvihni":
                this.zdvihniPredmet(prikaz, hrac);
                return false;
            case "odhod":
                this.odhodPredmet(prikaz, hrac);
                return false;
            case "pouzi":
                this.pouziPredmet(prikaz, hrac);
                return false;
            case "oslov":
                this.oslovNpc(prikaz, hrac);
                return false;
            case "save":
                this.saveStav(prikaz, hrac);
                return false;
            case "load":
                this.loadStav(prikaz, hrac);
                return false;
            default:
                return false;
        }
    }

    private void loadStav(Prikaz prikaz, Hrac hrac) {
        File saveSubor = new File(prikaz.getParameter() + ".save");

        try (DataInputStream saveDataStream = new DataInputStream(new FileInputStream(saveSubor))) {
            if (saveDataStream.readInt() != VykonavacPrikazov.SAVE_MAGIC_NUMBER) {
                System.out.println("Asi mas chybny save");
                return;
            }

            int saveVerzia = saveDataStream.readInt();
            if (saveVerzia > VykonavacPrikazov.SAVE_VERZIA) {
                System.out.println("Pokusas sa nacitat save vytvoreny v novsej verzii WOF");
                return;
            }

            hrac.nacitajSa(saveDataStream, saveVerzia);

        } catch (IOException e) {
            System.out.println("Asi mas chybny save");
            e.printStackTrace();
        }
    }

    private void saveStav(Prikaz prikaz, Hrac hrac) {
        File saveSubor = new File(prikaz.getParameter() + ".save");

        try (DataOutputStream saveDataStream = new DataOutputStream(new FileOutputStream(saveSubor))) {
            saveDataStream.writeInt(VykonavacPrikazov.SAVE_MAGIC_NUMBER);
            saveDataStream.writeInt(VykonavacPrikazov.SAVE_VERZIA);

            hrac.ulozSa(saveDataStream);
        } catch (IOException e) {
            System.out.println("Je mi to velmi luto, ale save subory pre nieco nefunguju! Musis pokracovat v hre.");
            e.printStackTrace();
        }
    }

    private void oslovNpc(Prikaz prikaz, Hrac hrac) {
        if (!prikaz.maParameter()) {
            System.out.println("Koho to chces oslovit?");
            return;
        }

        String menoNpc = prikaz.getParameter();
        hrac.oslovNpc(menoNpc);
    }

    private void pouziPredmet(Prikaz prikaz, Hrac hrac) {
        if (!prikaz.maParameter()) {
            System.out.println("Aky predmet?");
            return;
        }

        String nazovPredmetu = prikaz.getParameter();
        hrac.pouziPredmet(nazovPredmetu);
    }

    private void odhodPredmet(Prikaz prikaz, Hrac hrac) {
        if (!prikaz.maParameter()) {
            System.out.println("Aky predmet?");
            return;
        }

        String nazovPredmetu = prikaz.getParameter();
        hrac.odhodPredmet(nazovPredmetu);
    }

    private void zdvihniPredmet(Prikaz prikaz, Hrac hrac) {
        if (!prikaz.maParameter()) {
            System.out.println("Aky predmet?");
            return;
        }

        String nazovPredmetu = prikaz.getParameter();
        hrac.zdvihniPredmet(nazovPredmetu);
    }
}
