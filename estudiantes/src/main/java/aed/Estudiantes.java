package aed;

public class Estudiantes {

    /* Invariante de Representación

        ~ dict cumple el InvRep de Trie
        ~ Para cada nodo en la altura 7: nodo.inscripciones >= 0
        
    */

    private Trie<Integer> dict;

    // Constructor de la clase ~ O(1)
    public Estudiantes(){
        dict = new Trie<>();
    }

    // Define un Estudiante ~ O(1) Asumiendo que estudiante es acotado
    public void InsertarEstudiante(String estudiante){
        dict.Definir(estudiante, 0);
    }

    // Suma una inscripción a la cantidad de inscripciones de un estudiante ~ O(1)
    public void Inscribir(String estudiante){
        dict.Definir(estudiante, dict.Buscar(estudiante) + 1);
    }

    // Resta una inscripción a la cantidad de inscripciones de un estudiante ~ O(1)
    public void Desinscribir(String estudiante){
        dict.Definir(estudiante, dict.Buscar(estudiante) - 1);
    }

    // Devuelve la cantidad de inscripciones de un estudiante ~ O(1)
    public Integer Inscripciones(String estudiante){
        Integer inscripciones = dict.Buscar(estudiante);
        return inscripciones;
    }
}