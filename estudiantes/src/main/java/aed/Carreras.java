package aed;

import java.util.ArrayList;

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
        dict.Definir(carrera, new Materias());
    }
    /*
    

    

    // Define un par (carrera,materias). Si ya está definida, actualiza su valor.
    public Materias InsertarCarrera(String carrera){    //  O(n), n siendo la longitud del string carrera y el resto de operaciones son O(1)
        if (this.raiz == null){
            this.raiz = new Nodo();
        }
        Nodo actual = this.raiz;
        int[] carreraASCII = ConvertirAASCII(carrera);
        int i = 0;
        while (i < carrera.length()){  // O(n) ya que tiene que hacer una iteración por cada caracter del string carrera
            if (actual.siguientes.get(carreraASCII[i]) == null){
                Nodo nuevo = new Nodo();
                actual.siguientes.set(carreraASCII[i],nuevo);
                actual = actual.siguientes.get(carreraASCII[i]);
            }else{
                actual = actual.siguientes.get(carreraASCII[i]);
            }
            i++;
        }
        if (actual.materias == null){
            Materias materias2 = new Materias();
            actual.materias = materias2;   
        }
        return actual.materias;
    }

    // Busca una carrera y devuelve su significado.
    public Materias BuscarCarrera(String carrera){ // O(n), n siendo la longitud del string carrera y el resto de operaciones son O(1)
        Nodo actual = this.raiz;
        int[] carreraASCII = ConvertirAASCII(carrera);
        int i = 0;
        while (i < carrera.length()){  // O(n) ya que tiene que hacer una iteración por cada caracter del string carrera
                actual = actual.siguientes.get(carreraASCII[i]);
                i++;
            }
        return actual.materias;
    }

    // Devuelve un Array con los nombres de todas las carreras definidas.
    public String[] listarCarreras() { // O(n) porque listarCarrerasRecursivo es O(n) y el resto de operaciones son elementales
        ArrayList<String> resultado = new ArrayList<>();
        listarCarrerasRecursivo(raiz, "", resultado);
        return resultado.toArray(new String[0]);
    }
    
    private void listarCarrerasRecursivo(Nodo nodo, String prefijo, ArrayList<String> resultado) { // O(n), siendo n la longitud de la carrera más larga
        if (nodo == null) {
            return;
        }
        if (nodo.materias != null) {
            resultado.add(prefijo);
        }
        for (int i = 0; i < 255; i++) {
            if (nodo.siguientes.get(i) != null) {
                listarCarrerasRecursivo(nodo.siguientes.get(i), prefijo + (char) i, resultado); // O(n) porque tiene que hacer una recursión por cada nodo del trie
            }
        }
    }

    // Convierte una cadena de caracteres en una secuencia de enteros (según ASCII).
    private int[] ConvertirAASCII(String carrera){//  O(n), n siendo la longitud del string carrera
        int[] carreraASCII = new int[carrera.length()];
        for (int i = 0; i < carrera.length(); i++){ // O(n) porque tiene que hacer una iterción por cada caracter del string carrera
            carreraASCII[i] = (int) carrera.charAt(i);
        }
        return carreraASCII;
    }
*/
    }