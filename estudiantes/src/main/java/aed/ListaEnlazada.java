package aed;

import java.util.*;

public class ListaEnlazada<T> {
    // Completar atributos privados
    private Nodo primero;
    private int size;
    private class Nodo {
        // Completar
        Materias listamaterias;
        String nombremateria;
        Nodo siguiente;
        Nodo anterior;
        Nodo (T valor){
            this.anterior = null;
            this.siguiente = null;
            this.listamaterias = listamaterias;
            this.nombremateria =nombremateria;

        }
    }

    public ListaEnlazada() {
        this.primero =null;
    }

    public int longitud() {
        return size;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
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

    public void agregarAtras(Materias lista , String materia) {
        Nodo nuevo = new Nodo(null);
        nuevo.listamaterias = lista;
        nuevo.nombremateria = materia;
        if (primero == null){
            primero = nuevo;
            size++;
            return;
        }
        Nodo last = primero;
        while (last.siguiente != null){
            last = last.siguiente;
        }
        last.siguiente=nuevo;
        nuevo.anterior = last;
        nuevo.siguiente = null;
        size++;
    }
   /*  public T obtener(int i) {
        Nodo actual = primero;
        int contador = 0;
        while (actual != null){
            if(contador == i){
                return actual.valor;
            }
            contador++;
            actual = actual.siguiente;
        }
        return null;
    } */
}