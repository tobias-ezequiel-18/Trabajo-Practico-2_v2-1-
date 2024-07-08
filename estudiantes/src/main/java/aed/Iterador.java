package aed;

public interface Iterador<T, F> {
    boolean haySiguiente();
    Pair<T, F> siguiente();
    boolean hayAnterior();
    Pair<T, F> anterior();
}
