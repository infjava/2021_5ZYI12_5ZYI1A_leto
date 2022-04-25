package fri.zoo;

public class Klietka {
    private Zviera zviera;

    public void vlozZviera(Zviera zviera) {
        this.zviera = zviera;
    }

    public void kukni() {
        System.out.printf("V klietke si nasiel zviera: %s%n", this.zviera);
    }
}
