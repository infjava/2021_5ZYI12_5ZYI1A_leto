package fri.zoo;

public class Main {

    public static void main(String[] args) {
	    Lev lev = new Lev("Alex");
        Klietka<Lev> klietkaNaLeva = new Klietka<Lev>();
        klietkaNaLeva.vlozZviera(lev);
        klietkaNaLeva.kukni();
        Klietka<Mys> klietkaNaMys = new Klietka<Mys>();
        klietkaNaMys.vlozZviera(new Mys());
        klietkaNaMys.kukni();
        System.out.println(klietkaNaMys.getMenoZvierata());
    }
}
