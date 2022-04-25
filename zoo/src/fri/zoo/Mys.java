package fri.zoo;

public class Mys extends Zviera implements IPotrava {
    @Override
    public String toString() {
        return "mys";
    }

    @Override
    public String getMeno() {
        return "Mickey";
    }

    @Override
    public void zjedz(IPotrava potrava) {
        System.out.println("Mickey zhryzkal syr");
    }
}
