package aed;
import java.util.*;

public class Estudiantes {

    private class Nodo {
        int inscripciones; // Significado del nodo
        ArrayList<Nodo> siguientes;

        Nodo (){
            inscripciones = 0;
            siguientes = new ArrayList<Nodo>(10);
        }
    }

    private Nodo raiz;

    public Estudiantes(){
        raiz = new Nodo();
    }

    public Nodo Buscar(String estudiante){
        int[] estudianteASCII = ConvertirAASCII(estudiante);
        int i = 0;
        Nodo actual = raiz;
        while (i < estudiante.length()){
            actual = actual.siguientes.get(estudianteASCII[i]);
            i++;
        }
        return actual;
    }

    public void Insertar(String estudiante){
        if (raiz == null){
            raiz = new Nodo();
        }
        int[] estudianteASCII = ConvertirAASCII(estudiante);
        int i = 0;
        Nodo actual = raiz;
        while (i < estudiante.length()){
            if (actual.siguientes.get(estudianteASCII[i]) == null){
                Nodo nuevo = new Nodo();
                actual.siguientes.set(estudianteASCII[i],nuevo);
            }else{
                actual = actual.siguientes.get(estudianteASCII[i]);
            }
            i++;
        }
    }

    public void Inscribir (String estudiante){
        Nodo nodoEstudiante = Buscar(estudiante);
        nodoEstudiante.inscripciones++;
    }

    public void Desinscribir(String estudiante){
        Nodo nodoEstudiante = Buscar(estudiante);
        nodoEstudiante.inscripciones--;
    }

    private int[] ConvertirAASCII(String estudiante){
        int[] nuevo = new int[estudiante.length()];
        for (int i = 0; i < estudiante.length(); i++){
            nuevo[i] = (int) estudiante.charAt(i);
        }
        return nuevo;
    } 

}