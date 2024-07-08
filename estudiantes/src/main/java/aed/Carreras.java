package aed;

public class Carreras{

    /*  Invariante de Representación

        ~ Es un árbol (null es un árbol, y una tupla que contiene un elemento de T y una secuencia de árboles<T>, es un árbol<T>)
        ~ Para todo objeto de la clase Materias dentro de un nodo, se cumple InvRep Materias
        ~ No hay nodos inútiles o (bien dicho) los nodos, si no tienen significado, tienen hijos (o sea, para cada nodo: al menos un elemento del ArrayList siguientes != null o materias != null)
        ~ La longitud de siguientes de cada nodo es 256
        ~ Para todos los tries Materias a los que se llegó por una carrera: los objetos de la clase Materia que contienen, tienen que incluir un puntero hacia su respectiva clase "materias" en materiasEquivalentes junto al nombre de la materia por la que se llego a ese objeto
        ~ Para todo objeto Materia a los que se puede llegar partiendo de este trie, se tiene que poder acceder a partir de materiasEquivalentes a una tupla (que contenga en la primer componente un trie Materias (contenido en Carreras) que puede llegar a este objeto recorriendolo en base a la segunda componente de la tupla)

    */

    private Trie<Materias> dict;

    // Constructor de la clase.
    public Carreras(){
        dict = new Trie<>();
    }

    // Define un par (carrera,materias).
    public Materias InsertarCarrera(String carrera){
        if (dict.Definido(carrera)){
            return dict.Buscar(carrera);
        } else {
            Materias nueva = new Materias();
            dict.Definir(carrera, nueva);
            return nueva;
        }
    }

    // Busca una carrera y devuelve su significado.
    public Materias BuscarCarrera(String carrera){
        return dict.Buscar(carrera);
    }

    // Devuelve un Array con los nombres de todas las carreras definidas.
    public String[] listarCarreras(){
        return dict.listarClaves();
    }
}