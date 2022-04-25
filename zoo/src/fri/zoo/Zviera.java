package fri.zoo;

/**
 * @param <T> Typ zvierata (tj. potomka)
 */
public abstract class Zviera<T> {
    public abstract String getMeno();

    public abstract void zjedz(IPotrava<T> potrava);
}
