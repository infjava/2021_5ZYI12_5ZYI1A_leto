package fri.zoo;

public class Mys extends Zviera<Mys> implements IPotrava<Lev> {
    @Override
    public String toString() {
        return "mys";
    }

    @Override
    public String getMeno() {
        return "Mickey";
    }

    @Override
    public void zjedz(IPotrava<Mys> potrava) {
        System.out.println("Mickey zhryzkal syr");
    }
}
