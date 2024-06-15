package aed;

import java.util.ArrayList;

public class Carreras{

    private class Nodo{
        ArrayList<Nodo> siguientes;
        Materias materias;
        
        Nodo(){
            siguientes = new ArrayList<Nodo>(256);
            materias = null;
        }
    }

    private Nodo raiz;

    public Carreras(){
        raiz = new Nodo();
    }

    public boolean Pertenece(String carrera){
        Nodo actual = raiz;
        if (raiz == null){
            return false;
        }
        int[] carreraASCII = ConvertirAASCII(carrera);
        int i = 0;
        while (i != carrera.length()){
            if (actual.siguientes.get(carreraASCII[i]) == null){
                return false;
            } else {
                actual = actual.siguientes.get(carreraASCII[i]);
            }
        }
        return true;
    }

    public void Insertar(String carrera, Materias materias){
        if (raiz == null){
            raiz = new Nodo();
        }
        int[] carreraASCII = ConvertirAASCII(carrera);
        int i = 0;
        Nodo actual = this.raiz;
        while (i != carrera.length()){  
            if (actual.siguientes.get(carreraASCII[i]) == null){
                Nodo nuevo = new Nodo();
                actual.siguientes.set(carreraASCII[i],nuevo);
            }else{
                actual = actual.siguientes.get(carreraASCII[i]);
            }
            i++;
        }
        actual.materias = materias;
    }

    private int[] ConvertirAASCII(String carrera){
        int[] nuevo = new int[carrera.length()];
        for (int i = 0; i < carrera.length(); i++){
            nuevo[i] = (int) carrera.charAt(i);
        }
        return nuevo;
    }
}