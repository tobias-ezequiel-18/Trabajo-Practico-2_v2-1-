// Implementación genérica de un Trie únicamente para usar como referencia.

package aed;

import java.util.ArrayList;

// Las claves del Trie siempre van a ser de tipo String.
public class Trie<T> {

    private class Nodo {
        ArrayList<Nodo> siguientes;
        T definicion;
        int cantHijos;

        Nodo(){
            siguientes = new ArrayList<Nodo>(256); // Puede tener 256 ramas: la longitud del alfabeto (ASCII).
            // Seteamos todas las posiciones en null, para evitar IndexOutOfBoundsException.
            for (int i = 0; i < 255; i++){
                siguientes.add(null);
            }
            definicion = null;
            cantHijos = 0;
        }
    }

    private Nodo raiz;
    private int size;

    // Constructor de la clase ~ O(1)
    public Trie(){
        raiz = new Nodo();
        size = 0;
    }

    // Devuelve la longitud de la instancia. ~ O(1)
    public int Longitud(){
        return size;
    }

    // Decide si una clave está definida en el Trie. ~ O(|clave|)
    public boolean Definido(String clave){
        if (raiz == null){
            return false;
        }
        else {
            Nodo actual = raiz;
            int i = 0;
            while(i < clave.length()){
                if (actual.siguientes.get((int) clave.charAt(i)) == null){
                    return false;
                } else {
                    actual = actual.siguientes.get((int) clave.charAt(i));
                }
                i++;
            }
            // Si salimos del while, vemos si la clave tiene un valor definido.
            if (actual.definicion == null) {
                return false;
            } else {
                return true;
            }
        }
    }

    // Define un par (clave,valor) en el Trie. Si ya está definido, actualiza el valor. ~ O(|clave|)
    public void Definir(String clave, T valor){
        if (raiz == null){
            raiz = new Nodo();
        }
        if (!Definido(clave)){
            size ++;
        }
        Nodo actual = raiz;
        int i = 0;
        while (i < clave.length()){
            if (actual.siguientes.get((int) clave.charAt(i)) == null){
                Nodo nuevo = new Nodo();
                actual.siguientes.set((int) clave.charAt(i), nuevo);
                actual.cantHijos ++;
                actual = nuevo;
            } else {
                actual = actual.siguientes.get((int) clave.charAt(i));
            }
            i++;
        }
        actual.definicion = valor;
    }

    // Borra una clave y su valor asociado del trie. Asumimos que la clave está definida. O(|clave|)
    public void Borrar(String clave){
        Nodo actual = raiz;
        Nodo ultimo_nodo = raiz;
        int ultimo_indice = 0;
        int i = 0;
        while (i < clave.length()){
            if (actual.cantHijos > 1 || actual.definicion != null){
                ultimo_nodo = actual;
                ultimo_indice = i;
            }
            actual = actual.siguientes.get((int) clave.charAt(i));
            i++;
        }
        if (actual != ultimo_nodo && actual.cantHijos == 0){
            ultimo_nodo.siguientes.set((int) clave.charAt(ultimo_indice + 1), null);
            ultimo_nodo.cantHijos --;
        }
        actual.definicion = null;
        size --;
    }

    // Busca el valor correspondiente a la clave. Asumimos que esta última está definida. O(|clave|)
    public T Buscar(String clave){
        Nodo actual = raiz;
        int i = 0;
        while (i < clave.length()){
            actual = actual.siguientes.get((int) clave.charAt(i));
            i++;
        }
        return actual.definicion;
    }

    // Devuelve un ArrayList con los nombres de todas las claves definidas.
    public String[] listarClaves() {  // O(n) porque listar claves es O(n) y el resto de operaciones son elementales
        ArrayList<String> resultado = new ArrayList<>();
        listarClavesRecursivo(raiz, "", resultado);
        return resultado.toArray(new String[0]);
    }

    private void listarClavesRecursivo(Nodo nodo, String prefijo, ArrayList<String> resultado) {  // O(n), siendo n la longitud de la materia más larga
        if (nodo == null) {
            return;
        }
        if (nodo.definicion != null) {
            resultado.add(prefijo);
        }
        for (int i = 0; i < 255; i++) {
            if (nodo.siguientes.get(i) != null) {
                listarClavesRecursivo(nodo.siguientes.get(i), prefijo + (char) i, resultado); // O(n) porque tiene que hacer una recursión por cada nodo del trie
            }
        }
    }
}