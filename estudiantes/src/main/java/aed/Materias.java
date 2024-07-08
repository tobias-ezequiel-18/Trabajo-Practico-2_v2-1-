package aed;

public class Materias {

    /*  Invariante de Representación

        ~ Es un árbol (null es un árbol, y una tupla que contiene un elemento de T y una secuencia de árboles<T>, es un árbol<T>)
        ~ Para toda materia dentro de un nodo, se cumple InvRep Materia
        ~ Para cada nodo: al menos un elemento del ArrayList siguientes != null o materia != null (No hay nodos inútiles)
        ~ cantHijos es igual a la cantidad de elementos en siguientes que != null
        ~ La longitud de siguientes de cada nodo es 256
        ~ Todos los TADs de la clase Materia a los que se llegó por una palabra, tiene que tener contenido a esa palabra en materiasEquivalentes

    */

    private Trie<Materia> dict;

    // Constructor de la clase.
    public Materias(){
        dict = new Trie<>();
    }

    // Inserta y define una nueva materia.
    public Materia Insertar(String materia, Materia nuevaMateria){
        dict.Definir(materia, nuevaMateria);
        return nuevaMateria;
    }

    // Inserta una materia, sin pasarle una definición como parámetro
    public Materia InsertarSimple(String materia){
        return Insertar(materia, new Materia());
    }

    // Borra una materia y su información asociada. Asumimos que la materia está definida.
    public void Borrar(String materia){
        dict.Borrar(materia);
    }
    
    // Busca una materia y devuelve su significado.
    public Materia BuscarMateria(String materia){
        return dict.Buscar(materia);
    }
    
    // Devuelve un ArrayList con los nombres de todas las claves definidas.
    public String[] listarMaterias(){
        return dict.listarClaves();
    }
}