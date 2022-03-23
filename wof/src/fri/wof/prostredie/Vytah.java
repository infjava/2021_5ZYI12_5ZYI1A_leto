package fri.wof.prostredie;

import fri.wof.hra.Hrac;
import fri.wof.predmety.OvladacVytahu;

import java.util.ArrayList;

public class Vytah extends Miestnost implements IKontrolaVstupu {
    private final ArrayList<Miestnost> poschodia;
    private int aktualnePoschodie;
    private int smer;

    public Vytah(String popis) {
        super(popis);

        this.poschodia = new ArrayList<Miestnost>();
        this.aktualnePoschodie = 0;
        this.smer = 1;

        this.vlozPredmet(new OvladacVytahu());
    }

    @Override
    public String getPopis() {
        return super.getPopis() + String.format(" - %d. poschodie", this.aktualnePoschodie);
    }

    public void pridajPoschodie(Miestnost poschodie) {
        this.poschodia.add(poschodie);
    }

    @Override
    public IMiestnost getMiestnostVSmere(String smer) {
        if (smer.equals("von")) {
            return this.poschodia.get(this.aktualnePoschodie);
        }
        return null;
    }

    @Override
    public void vypisMozneVychody() {
        System.out.println("Vychody: von");
    }

    public void posunVytah() {
        this.aktualnePoschodie += this.smer;
        if (this.aktualnePoschodie == 0 || this.aktualnePoschodie == this.poschodia.size() - 1) {
            this.smer = -this.smer;
        }
    }

    @Override
    public boolean mozeVstupit(Hrac hrac) {
        Miestnost moznyVychod = this.poschodia.get(this.aktualnePoschodie);
        return hrac.getAktualnaMiestnost() == moznyVychod;
    }
}
