package aed;

import java.util.ArrayList;

public class Materias {

    private class Nodo{
        ArrayList<Nodo> siguientes;
        Nodo padre;
        Materia materia;
        int cantHijos;
        
        Nodo(){
            siguientes = new ArrayList<Nodo>(256);
            for (int i = 0; i < 255; i++){
                siguientes.add(null);
            }
            materia = null;
            padre = null;
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

    /*
    public void Insertar(String materia, Materia nueva_materia){
        if (raiz == null){
            raiz = new Nodo();
        }
        int[] materiaASCII = ConvertirAASCII(materia);
        int i = 0;
        Nodo actual = this.raiz;
        Nodo padre = new Nodo();
        while (i != materia.length()){
            if (actual.siguientes.get(materiaASCII[i]) == null){
                Nodo nuevo = new Nodo();
                actual.siguientes.set(materiaASCII[i],nuevo);
                nuevo.padre = actual;
            }else{
                actual.siguientes.get(materiaASCII[i]).padre = actual;
                actual = actual.siguientes.get(materiaASCII[i]);
            }
            i++;
        }
        actual.materia = nueva_materia;
    }
    */

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

    /*
    public void Eliminar(String materia){
        Nodo actual = Buscar(materia);
        actual.materia = null;
        int[] materiaASCII = ConvertirAASCII(materia);
        int i = materia.length() - 1;
        while (NoTieneHijos(actual.siguientes) || actual.materia != null){
            actual = actual.padre;
            actual.siguientes.set(i,null);
            i --;
        }
    }
    */

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

    private boolean NoTieneHijos(ArrayList<Nodo> hijos){
        for (int i = 0; i < hijos.size(); i++){
            if (hijos.get(i) != null){
                return false;
            }
        }
        return true;
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
    
}
