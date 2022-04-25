package fri.zoo;

public class Klietka<E> {
    private E zviera;

    public void vlozZviera(E zviera) {
        this.zviera = zviera;
    }

    public void kukni() {
        System.out.printf("V klietke si nasiel zviera: %s%n", this.zviera);
    }

    public String getMenoZvierata() {
        return ((Zviera)this.zviera).getMeno();
    }
}
