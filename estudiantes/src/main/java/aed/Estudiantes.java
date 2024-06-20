package aed;

import java.util.*;
public class Estudiantes {
    private Nodo raiz;

    private class Nodo {
        int inscripciones ;
        ArrayList<Nodo> siguientes;

        Nodo (){
            inscripciones = 0;
            siguientes = new ArrayList<Nodo>(10);
        }
    }

    public Estudiantes(){
        raiz = new Nodo();
    }

    public void InsertarAlumno(String alumno){
        if (raiz == null){
            raiz = new Nodo();
        }
        int[] alumnoASCII = ConvertirAASCII(alumno);
        int i = 0;
        Nodo actual = this.raiz;
        while (i != alumno.length()){
            if (actual.siguientes.get(alumnoASCII[i]) == null){
                Nodo nuevo = new Nodo();
                actual.siguientes.set(alumnoASCII[i],nuevo);
            }else{
                actual = actual.siguientes.get(alumnoASCII[i]);
            }
            i++;
        }
    }

    public void Inscribir (String alumno){
        int[] alumnoASCII = ConvertirAASCII(alumno);
        int i = 0;
        Nodo actual = this.raiz;
        while (i != alumno.length()){
            actual = actual.siguientes.get(alumnoASCII[i]);
            i++;
        }
        actual.inscripciones++;
    }

    public void Desinscribir(String alumno){
        int[] alumnoASCII = ConvertirAASCII(alumno);
        int i = 0;
        Nodo actual = this.raiz;
        while (i != alumno.length()){
            actual = actual.siguientes.get(alumnoASCII[i]);
            i++;
        }
        actual.inscripciones--;
    }

    public int Inscripciones (String alumno){
        int[] alumnoASCII = ConvertirAASCII(alumno);
        int i = 0;
        Nodo actual = this.raiz;
        while (i != alumno.length()){
            actual = actual.siguientes.get(alumnoASCII[i]);
            i++;
        }
        return actual.inscripciones;    
    }

    private int[] ConvertirAASCII(String alumno){
        int[] nuevo = new int[alumno.length()];
        for (int i = 0; i < alumno.length(); i++){
            nuevo[i] = (int) alumno.charAt(i);
        }
        return nuevo;
    } 
    
}