package aed;

public class Carreras{

    /*  Invariante de Representación

        ~ dict cumple el InvRep de Trie.
        ~ Para todo objeto de la clase Materias dentro de un nodo, se cumple InvRep Materias
        ~ Para todos los tries Materias a los que se llegó por una carrera: los objetos de la clase Materia que contienen, tienen que incluir un puntero hacia su respectiva clase "materias" en materiasEquivalentes junto al nombre de la materia por la que se llego a ese objeto
        ~ Para todo objeto Materia a los que se puede llegar partiendo de este trie, se tiene que poder acceder a partir de materiasEquivalentes a una tupla (que contenga en la primer componente un trie Materias (contenido en Carreras) que puede llegar a este objeto recorriendolo en base a la segunda componente de la tupla)

    */

    private Trie<Materias> dict;

    // Constructor de la clase ~ O(1)
    public Carreras(){
        dict = new Trie<>();
    }

    // Define un par (carrera,materias) ~ O(|carrera|)
    public Materias InsertarCarrera(String carrera){
        if (dict.Definido(carrera)){ // O(|carrera|)
            return dict.Buscar(carrera); // // O(|carrera|)
        } else {
            Materias nueva = new Materias(); // O(1)
            dict.Definir(carrera, nueva); // O(|carrera|)
            return nueva;
        }
    }

    // Busca una carrera y devuelve su significado ~ O(|carrera|)
    public Materias BuscarCarrera(String carrera){
        return dict.Buscar(carrera);
    }

    // Devuelve un Array con los nombres de todas las carreras definidas ~ O(n)
    public String[] listarCarreras(){
        return dict.listarClaves();
    }
}