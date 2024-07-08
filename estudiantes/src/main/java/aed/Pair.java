package aed;

public class Pair<T, F> {

    /* Invariante de Representación

        ~ Ninguna de las componentes puede ser null (para que sea una instancia válida en nuestra implementación)

    */

    private T first;
    private F second;

    public Pair(T first, F second) { //O(1) porque todas las operaciones son elementales
        this.first = first;
        this.second = second;
    }

    public T getFirst() {   //O(1) porque todas las operaciones son elementales
        return first;
    }

    public F getSecond() {  //O(1) porque todas las operaciones son elementales
        return second;
    }
}