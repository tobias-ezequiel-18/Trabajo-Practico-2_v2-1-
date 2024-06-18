package aed;

import java.util.ArrayList;

public class Carreras{

    /*
     * Invariante de representación:
     */

    private class Nodo{
        ArrayList<Nodo> siguientes;
        Materias materias; // Este es el siginificado de un nodo.
        
        Nodo(){
            siguientes = new ArrayList<Nodo>(256);
            for (int i = 0; i < 255; i++){
                siguientes.add(null);
            }
            materias = null;
        }
    }

    private Nodo raiz;

    // Constructor de la clase.
    public Carreras(){
        raiz = new Nodo();
    }

    // Decide si una carrera está definida.
    public boolean Definida(String carrera){
        if (raiz == null){
            return false;
        }
        Nodo actual = raiz;
        int[] carreraASCII = ConvertirAASCII(carrera);
        int i = 0;
        while (i < carrera.length()){
            if (actual.siguientes.get(carreraASCII[i]) == null){
                return false;
            } else {
                actual = actual.siguientes.get(carreraASCII[i]);
            }
            i++;
        }
        // Si salimos del while, vemos si el nodo actual tiene significado.
        if (actual.materias == null) {
            return false;
        } else {
            return true;
        }
    }

    // Define un par (carrera,materias). Si ya está definida, actualiza su valor.
    public void Definir(String carrera, Materias materias){
        if (raiz == null){
            raiz = new Nodo();
        }
        Nodo actual = raiz;
        int[] carreraASCII = ConvertirAASCII(carrera);
        int i = 0;
        while (i < carrera.length()){  
            if (actual.siguientes.get(carreraASCII[i]) == null){
                Nodo nuevo = new Nodo();
                actual.siguientes.set(carreraASCII[i],nuevo);
                actual = nuevo;
            }else{
                actual = actual.siguientes.get(carreraASCII[i]);
            }
            i++;
        }
        actual.materias = materias;
    }

    public Materias Buscar(String carrera){
        Nodo actual = raiz;
        int[] materiaASCII = ConvertirAASCII(carrera);
        int i = 0;
        while (i != carrera.length()){  
            actual = actual.siguientes.get(materiaASCII[i]);
            i++;
        }
        return actual.materias;
    }

    // Convierte una cadena de caracteres en una secuencia de enteros (según ASCII).
    private int[] ConvertirAASCII(String carrera){
        int[] carreraASCII = new int[carrera.length()];
        for (int i = 0; i < carrera.length(); i++){
            carreraASCII[i] = (int) carrera.charAt(i);
        }
        return carreraASCII;
    }
}