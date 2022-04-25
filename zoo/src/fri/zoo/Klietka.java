package fri.zoo;

public class Klietka {
    private Lev lev;

    public void vlozZviera(Lev lev) {
        this.lev = lev;
    }

    public void kukni() {
        System.out.printf("V klietke si nasiel zviera: %s%n", this.lev);
    }
}
