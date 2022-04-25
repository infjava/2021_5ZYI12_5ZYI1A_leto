package fri.zoo;

public class Klietka<E extends Zviera> {
    private E zviera;

    public void vlozZviera(E zviera) {
        this.zviera = zviera;
    }

    public void kukni() {
        System.out.printf("V klietke si nasiel zviera: %s%n", this.zviera);
    }

    public String getMenoZvierata() {
        return this.zviera.getMeno();
    }

    public void nakrm(IPotrava potrava) {
        this.zviera.zjedz(potrava);
    }
}
