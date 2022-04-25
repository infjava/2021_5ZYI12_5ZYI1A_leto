package fri.zoo;

public class Main {

    public static void main(String[] args) {
	    Lev lev = new Lev("Alex");
        Klietka<Lev> klietkaNaLeva = new Klietka<Lev>();
        klietkaNaLeva.vlozZviera(lev);
        klietkaNaLeva.nakrm(new Mys());
        klietkaNaLeva.kukni();
        Klietka<Mys> klietkaNaMys = new Klietka<Mys>();
        klietkaNaMys.vlozZviera(new Mys());
        klietkaNaMys.nakrm(new Syr());
        klietkaNaMys.kukni();
        System.out.println(klietkaNaMys.getMenoZvierata());
//        Klietka<Integer> klietkaNaCisla = new Klietka<Integer>();
//        klietkaNaCisla.vlozZviera(5);
//        klietkaNaCisla.kukni();
//        System.out.println(klietkaNaCisla.getMenoZvierata());
    }
}
