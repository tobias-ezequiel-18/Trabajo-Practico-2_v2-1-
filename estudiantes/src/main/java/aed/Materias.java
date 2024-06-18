package aed;

import java.util.ArrayList;

public class Materias {

    private class Nodo{
        ArrayList<Nodo> siguientes;
        Materia materia;
        int cantHijos;
        
        Nodo(){
            siguientes = new ArrayList<Nodo>(256);
            for (int i = 0; i < 255; i++){
                siguientes.add(null);
            }
            materia = null;
            cantHijos = 0;
        }
    }

    private Nodo raiz;

    // Constructor de la clase.
    public Materias(){
        raiz = new Nodo();
    }

    // Decide si una materia está definida.
    public boolean Definida(String materia){
        if (raiz == null){
            return false;
        }
        Nodo actual = raiz;
        int[] materiaASCII = ConvertirAASCII(materia);
        int i = 0;
        while (i < materia.length()){
            if (actual.siguientes.get(materiaASCII[i]) == null){
                return false;
            } else {
                actual = actual.siguientes.get(materiaASCII[i]);
            }
            i++;
        }
        // Si salimos del while, vemos si la materia tiene un valor definido.
        if (actual.materia == null) {
            return false;
        } else {
            return true;
        }
    }

    // Define un par (materia, materia_info). Si ya está definida, actualiza su valor.
    public void Definir(String materia, Materia materia_info){
        if (raiz == null){
            raiz = new Nodo();
        }
        Nodo actual = raiz;
        int[] materiaASCII = ConvertirAASCII(materia);
        int i = 0;
        while (i < materia.length()){
            if (actual.siguientes.get(materiaASCII[i]) == null){
                Nodo nuevo = new Nodo();
                actual.siguientes.set(materiaASCII[i],nuevo);
                actual.cantHijos ++;
                actual = nuevo;
            }else{
                actual = actual.siguientes.get(materiaASCII[i]);
            }
            i++;
        }
        actual.materia = materia_info;
    }

    // Borra una materia y su información asociada. Asumimos que la materia está definida.
    public void Borrar(String materia){
        Nodo actual = raiz;
        Nodo ultimo_nodo = raiz;
        int ultimo_indice = 0;
        int i = 0;
        int[] materiaASCII = ConvertirAASCII(materia);
        while (i < materia.length()){
            if (actual.cantHijos > 1 || actual.materia != null){
                ultimo_nodo = actual;
                ultimo_indice = i;
            }
            actual = actual.siguientes.get(materiaASCII[i]);
            i++;
        }
        if (actual != ultimo_nodo){
            ultimo_nodo.siguientes.set(materiaASCII[ultimo_indice + 1], null);
            ultimo_nodo.cantHijos --;
        }
        actual.materia = null;
    }

    // Asumiendo que la materia está en el Trie.
    private Nodo Buscar(String materia){
        Nodo actual = raiz;
        int[] materiaASCII = ConvertirAASCII(materia);
        int i = 0;
        while (i != materia.length()){  
            actual = actual.siguientes.get(materiaASCII[i]);
            i++;
        }
        return actual;
    }

    private int[] ConvertirAASCII(String materia){
        int[] nuevo = new int[materia.length()];
        for (int i = 0; i < materia.length(); i++){
            nuevo[i] = (int) materia.charAt(i);
        }
        return nuevo;
    }


    /*              IDEA INORDER

    private ArrayList<StringBuffer> materiasInOrderAux (Nodo actual){
        return materiasInOrderAux(actual, "", []);
    }

    private ArrayList<StringBuffer> materiasInOrderAux (Nodo actual, StringBuffer palabra, ArrayList<StringBuffer> palabras){ // la función empezaría con los dos últimos parámetros vacios
        if (actual.cantHijos == 0) { //Cuando llega a un fin, devuelve el ArrayList que encontró
            palabras.add(palabra); //Añado la palabra en la que estoy porque sé que es una materia
            return palabras;
        }
        else { //Si tiene hijos:
            if (actual.materia != null) { //Si estoy parado en una materia, añado a palabras
                palabras.add(palabra);
            }
            int longitud_palabra = palabra.length();
            for (int i = 0; i<256; i++){ //Por cada rama posible:
                if (actual.siguientes.get(i) != null) { //Si efectivamente es una rama:
                    palabra.append((char)i); //Añado el carácter a palabra
                    palabras.addAll(materiasInOrderAux(actual.siguientes.get(i), palabra, palabras)); //Concateno con la recursión
                    palabra = new StringBuffer(palabra.substring(0, longitud_palabra)); //Reestablezco la palabra a como estaba antes de entrar a la recursión (creo que hace falta)
                } //El problema sería que (si funciona), por como está ahora, habrían repetidos (aunque las primeras apariciones estarían en orden)
            }
        }

        */
    
}
