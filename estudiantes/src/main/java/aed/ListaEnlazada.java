package aed;

import java.util.*;

public class ListaEnlazada<T,F> {

    /*  Invariante de Representación

        ~ No hay ciclos
        ~ Size tiene que representar la cantidad de nodos en la lista
        ~ Todos los nodos tienen que poder ser accedidos recorriendo la lista desde la cabeza
        ~ El último nodo tiene que apuntar a null
        ~ Si primero != null -> primero.anterior == null
     
    */

    private Nodo primero;
    private int size;
    private class Nodo {
        T listaMaterias;
        F nombreMateria;
        Nodo siguiente;
        Nodo anterior;
        Nodo (F nombre,T materias){ // O(1) unicamente operaciones elementales
            this.anterior = null;
            this.siguiente = null;
            this.listaMaterias = materias;
            this.nombreMateria = nombre;

        }
    }

    // Constructor de la clase.
    public ListaEnlazada() {    // O(1)
        this.primero =null;
    }
    

    // Agrega un elemento al principio de la lista.
    public void agregarAdelante(T lista, F materia) { //O(1) porque todas las operaciones son elementales
        Nodo nuevo = new Nodo(materia,lista);
        if (primero == null){
            primero = nuevo;
        }else {
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo ;
            nuevo.anterior = null;
        }

        size++;
    }
    
    private class ListaIterador implements Iterador<T, F> {
        Nodo actual;
        Nodo previo;

        public ListaIterador(Nodo primerNodo) { //O(1) porque todas las operaciones son elementales
            this.actual = primerNodo;
            this.previo = null;
        }

        public boolean haySiguiente() { //O(1) porque todas las operaciones son elementales
            return actual != null;
        }

        public boolean hayAnterior() {  //O(1) porque todas las operaciones son elementales
            return previo != null;
        }

        public Pair<T, F> siguiente() { //O(1) porque todas las operaciones son elementales
            if (!haySiguiente()) {
                throw new NoSuchElementException();
            }
            previo = actual;
            actual = actual.siguiente;
            return new Pair<>(previo.listaMaterias, previo.nombreMateria);
        }

        public Pair<T, F> anterior() {  //O(1) porque todas las operaciones son elementales
            if (!hayAnterior()) {
                throw new NoSuchElementException();
            }
            actual = previo;
            previo = actual.anterior;
            return new Pair<>(actual.listaMaterias, actual.nombreMateria);
        }
    }

    // Devuelve un iterador de la lista.
    public Iterador<T, F> iterador() {  //O(1) porque todas las operaciones son elementales
        return new ListaIterador(primero);
    }
}
