package aed;

public class Materia {

    /*  Invariante de Representación

        ~ profesores, jtp, ay1, ay2, cantidadEstudiantes >= 0
        ~ listaEstudiantes cumple InvRep de Trie
        ~ No hay repetidos en listaEstudiantes
        ~ La longitud de listaEstudiantes tiene que ser igual a cantidadEstudiantes
        ~ No hay repetidos en materiasEquivalentes
        ~ La longitud de materiasEquivalentes tiene que ser >= 1
        ~ InvRep ListaEnlazada

    */

    private int profesores;
    private int jtp;
    private int ay1;
    private int ay2;
    private int cantidadEstudiantes;
    private Trie<String> listaEstudiantes;
    private ListaEnlazada<Materias,String> materiasEquivalentes;

    // Constructor de la clase.
    public Materia(){   // O(1) porque son todas operaciones elementales
        this.cantidadEstudiantes= 0;
        this.listaEstudiantes = new Trie<String>();
        this.materiasEquivalentes = new ListaEnlazada<>(); // O(1)
    }

    // Agrega a la materia un cargo del docente pasado como parámetro.
    public void AgregarDocente(String cargo){   //  O(1) porque son todas operaciones elementales
        if (cargo == "PROF"){
            this.profesores ++;
        }
        if (cargo == "AY1"){
            this.ay1 ++;
        }
        if (cargo == "AY2"){
            this.ay2 ++;
        }
        if (cargo == "JTP"){
            this.jtp ++;
        }
    }

    // Devuelve una secuencia donde cada posición muestra la cantidad de profesores,
    // jtp, ay1 y ay2 de la materia respectivamente.
    public int[] PlantelDocente() { //  O(1) porque son todas operaciones elementales
        int[] nuevo = new int[4];
        nuevo[0] = profesores;
        nuevo[1] = jtp;
        nuevo[2] = ay1;
        nuevo[3] = ay2;
        return nuevo;
    }

    // Verifica si la cantidad de inscriptos excede el cupo de la materia.
    public boolean ExcedeCupo(){    //  O(1) porque son todas operaciones elementales
        float div1 = (float) this.cantidadEstudiantes / this.profesores;
        float div2 = (float) this.cantidadEstudiantes / this.jtp;
        float div3 = (float) this.cantidadEstudiantes / this.ay1;
        float div4 = (float) this.cantidadEstudiantes / this.ay2;
        if (profesores == 0 || jtp == 0 || ay1 == 0 || ay2 == 0){
            return cantidadEstudiantes > 0;
        }
        // Verificar los límites de capacidad por cargo docente.
        if (div1 > 250 ||
            div2 > 100 ||
            div3 > 20 ||
            div4  > 30) {
            return true;
        }
        return false;
    }

    // Agrega un estudiante a la materia.
    public void AgregarEstudiante(String estudiante){   //  O(1)
        this.cantidadEstudiantes++;
        this.listaEstudiantes.Definir(estudiante, estudiante);
    }

    // Agrega una materia equivalente a la actual.
    public void AgregarMateriaEquivalente(Materias listamaterias, String materia){  //  agregarAdelante en una lista enlazada es O(1)
        this.materiasEquivalentes.agregarAdelante(listamaterias,materia);
    }

    // Devuelve un Array de Strings con los estudiantes inscriptos en la materia.
    public String[] ListarEstudiantes(){   //  O(n)
        return this.listaEstudiantes.listarClaves();
    }

    // Devuelve la cantidad de estudiantes inscriptos.
    public int CantidadEstudiantes(){   //  O(1) porque son todas operaciones elementales
        return this.cantidadEstudiantes;
    }

    // Devuelve una lista enlazada con las materias a la materia.
    public ListaEnlazada<Materias,String> MateriasEquivalentes() {  //  O(1) porque son todas operaciones elementales
        return this.materiasEquivalentes;
    }
}
