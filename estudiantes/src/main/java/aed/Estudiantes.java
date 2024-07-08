package aed;

public class Estudiantes {

    /* Invariante de Representación

        ~ Es un árbol (null es un árbol, y una tupla que contiene un elemento de T y una secuencia de árboles<T>, es un árbol<T>)
        ~ No hay nodos inútiles o (bien dicho) los nodos, si no están en la longitud 7 (contando a la raíz), tienen hijos (o sea, para cada nodo: al menos un elemento de la ArrayList<Nodo> siguientes != null)
        ~ Para cada nodo en la altura 7: nodo.inscripciones >= 0
        ~ La longitud de siguientes de cada nodo es 256
        
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

    // Suma una inscripción a la cantidad de inscripciones de un estudiante.
    public void Inscribir(String estudiante){
        dict.Definir(estudiante, dict.Buscar(estudiante) + 1);
    }

    // Resta una inscripción a la cantidad de inscripciones de un estudiante.
    public void Desinscribir(String estudiante){ // O(n), n siendo la longitud del string estudiante y el resto de operaciones son O(1)
        dict.Definir(estudiante, dict.Buscar(estudiante) - 1);
    }

    // Devuelve la cantidad de inscripciones de un estudiante.
    public Integer Inscripciones(String estudiante){
        Integer inscripciones = dict.Buscar(estudiante);
        return inscripciones;
    }
}