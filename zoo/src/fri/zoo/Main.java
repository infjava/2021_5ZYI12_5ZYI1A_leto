package fri.zoo;

public class Main {

    public static void main(String[] args) {
	    Zviera zviera = new Lev("Alex");
        Klietka klietkaNaLeva = new Klietka();
        klietkaNaLeva.vlozZviera(zviera);
        klietkaNaLeva.kukni();
        Klietka klietkaNaMys = new Klietka();
        klietkaNaMys.vlozZviera(new Mys());
        klietkaNaMys.kukni();
    }
}
