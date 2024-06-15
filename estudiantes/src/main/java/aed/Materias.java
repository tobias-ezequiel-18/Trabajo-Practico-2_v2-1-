package aed;

import java.util.ArrayList;

public class Materias {

    private class Nodo{
        ArrayList<Nodo> siguientes;
        Nodo padre;
        Materia materia;
        
        Nodo(){
            siguientes = new ArrayList<Nodo>(256);
            materia = null;
            padre = null;
        }
    }

    private Nodo raiz;

    public Materias(){
        raiz = new Nodo();
    }

    public boolean Pertenece(String materia){
        Nodo actual = raiz;
        if (raiz == null){
            return false;
        }
        int[] materiaASCII = ConvertirAASCII(materia);
        int i = 0;
        while (i != materia.length()){
            if (actual.siguientes.get(materiaASCII[i]) == null){
                return false;
            } else {
                actual = actual.siguientes.get(materiaASCII[i]);
            }
        }
        return true;
    }

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
