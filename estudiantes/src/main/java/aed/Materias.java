package aed;

public class Materias {

    /*  Invariante de Representación

        ~ dict cumple InvRep de Trie
        ~ Para toda materia dentro de un nodo, se cumple InvRep Materia
        ~ Todos los TADs de la clase Materia a los que se llegó por una palabra, tiene que tener contenido a esa palabra en materiasEquivalentes

    */

    private Trie<Materia> dict;

    // Constructor de la clase ~ O(1)
    public Materias(){
        dict = new Trie<>();
    }

    // Inserta y define una nueva materia ~ O(|materia|)
    public Materia Insertar(String materia, Materia nuevaMateria){
        dict.Definir(materia, nuevaMateria);
        return nuevaMateria;
    }

    // Inserta una materia, sin pasarle una definición como parámetro ~ O(|materia|)
    public Materia InsertarSimple(String materia){
        return Insertar(materia, new Materia());
    }

    // Borra una materia y su información asociada. Asumimos que la materia está definida ~ O(|materia|)
    public void Borrar(String materia){
        dict.Borrar(materia);
    }
    
    // Busca una materia y devuelve su significado ~ O(|materia|)
    public Materia BuscarMateria(String materia){
        return dict.Buscar(materia);
    }
    
    // Devuelve un ArrayList con los nombres de todas las claves definidas ~ O(n)
    public String[] listarMaterias(){
        return dict.listarClaves();
    }
}