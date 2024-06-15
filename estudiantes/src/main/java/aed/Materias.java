package aed;

import java.util.ArrayList;

public class Materias {

    private class Nodo{
        ArrayList<Nodo> siguientes;
        Materia materia;
        
        Nodo(){
            siguientes = new ArrayList<Nodo>(256);
            materia = null;
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
        while (i != materia.length()){  
            if (actual.siguientes.get(materiaASCII[i]) == null){
                Nodo nuevo = new Nodo();
                actual.siguientes.set(materiaASCII[i],nuevo);
            }else{
                actual = actual.siguientes.get(materiaASCII[i]);
            }
            i++;
        }
        actual.materia = nueva_materia;
    }

    public void Eliminar(String materia){
        
    }

    private int[] ConvertirAASCII(String materia){
        int[] nuevo = new int[materia.length()];
        for (int i = 0; i < materia.length(); i++){
            nuevo[i] = (int) materia.charAt(i);
        }
        return nuevo;
    } 
    
}
