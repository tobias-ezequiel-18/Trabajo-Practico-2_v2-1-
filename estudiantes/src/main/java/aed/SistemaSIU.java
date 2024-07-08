package aed;

public class SistemaSIU {

    // Todas las complejidades que hacen referencia a un metodo de otra clase están justificadas en los archivos de sus respectivas clases

    /* Invariante de Representación

        ~ InvRepCarreras(carreras) && InvRepEstudiantes(estudiantes)
        ~ La cantidad de veces que aparecen estudiantes inscriptos en los objetos de la clase Materia va a ser igual a las inscripciones de ese estudiante indicadas en el trie estudiantes.
    
    */

    private Carreras carreras;
    private Estudiantes estudiantes;

    enum CargoDocente{
        AY2,
        AY1,
        JTP,
        PROF
    }

    public SistemaSIU(InfoMateria[] infoMaterias, String[] libretasUniversitarias){//O( (la sumatoria de la longitud de todas carreras multiplicada por la cantidad de materias que tiene cada una) + (la sumatoria de la longitud de todos los nombres de cada materia) + E )
        this.carreras = new Carreras();//O(1)
        this.estudiantes = new Estudiantes();//O(1)
    
        CrearCarrerasYMaterias(infoMaterias);//la sumatoria de cada longitud de cada carrera multiplicado por la longitud del nombre de cada materia de cada carrera respectivamente, sumado a la sumatoria de la longitud de cada nombre de cada materia 
        CrearLibreta(libretasUniversitarias);//O(1) * la cantdidad de estudiantes

    }

    private void CrearLibreta(String[] libreta){//O(E), siendo E la cantidad de estudiantes
        for (int i = 0 ; i < libreta.length ; i++){//O(E) porque recorre todas las posiciones del arreglo libreta
            this.estudiantes.InsertarEstudiante(libreta[i]);//O(1)
        }
    }

    private void CrearCarrerasYMaterias(InfoMateria[] infoMaterias){ //O( (la sumatoria de la longitud de todas carreras multiplicada por la cantidad de materias que tiene cada una) + (la sumatoria de la longitud de todos los nombres de cada materia))
        for (int i = 0; i<infoMaterias.length; i++){//O(|infoMaterias|)
            ParCarreraMateria[] carreramateria = infoMaterias[i].getParesCarreraMateria(); //O(1)
            Materias carrera = this.carreras.InsertarCarrera(carreramateria[0].getCarrera());//O(|carrera|)
            Materia materia = carrera.InsertarSimple(carreramateria[0].getNombreMateria());//O(|materia|)
            materia.AgregarMateriaEquivalente(carrera,carreramateria[0].getNombreMateria());//O(1)
            for (int j = 1 ; j < infoMaterias[i].getParesCarreraMateria().length ; j++){//O( (la sumatoria de la longitud de todas carreras multiplicada por la cantidad de materias que tiene cada una) + (la sumatoria de la longitud de todos los nombres de cada materia)) 
                
                Materias carrera2 = this.carreras.InsertarCarrera(carreramateria[j].getCarrera());//O(|carrera|)
                Materia materia3 =carrera2.Insertar(carreramateria[j].getNombreMateria(),materia);
                materia3.AgregarMateriaEquivalente(carrera2,carreramateria[j].getNombreMateria());//O(|materia|)
            }
        }

    }

    public void inscribir(String estudiante, String carrera, String materia){ // O(|carrera|+|materia|)
        this.estudiantes.Inscribir(estudiante); //O(1)
        Materias carreraNodo = this.carreras.BuscarCarrera(carrera);//O(|carrera|)
        Materia materiaNodo = carreraNodo.BuscarMateria(materia);//O(|materia|)
        materiaNodo.AgregarEstudiante(estudiante);;//O(1)
    }

    public void agregarDocente(CargoDocente cargo, String carrera, String materia){ // O(|carrera|+|materia|)
        String cargostring = cargo.toString(); // Convertir el String a CargoDocente, O(1) porque sabemos que los cargos son acotados

        Materias carreraNodo = carreras.BuscarCarrera(carrera);//O(|carrera|)
        Materia materiaNodo = carreraNodo.BuscarMateria(materia);//O(|materia|)
        materiaNodo.AgregarDocente(cargostring);//O(1)
    }

    public int[] plantelDocente(String materia, String carrera){ // O(|carrera|+|materia|)
        Materias carreraNodo = carreras.BuscarCarrera(carrera);//O(|carrera|)
        Materia materiaNodo = carreraNodo.BuscarMateria(materia);//O(|materia|)
        return materiaNodo.PlantelDocente();//O(1)  
    }

    public void cerrarMateria(String materia, String carrera){ // O(|carrera| + |materia| + la sumatoria de los nombres de todas las materias equivalentes + E)
        Materias carreraNodo = carreras.BuscarCarrera(carrera);//O(|carrera|)
        Materia materiaNodo = carreraNodo.BuscarMateria(materia);//O(|materia|)
        
        this.EliminarMaterias(materiaNodo);// O(la sumatoria de los nombres de todas las materias equivalentes)
        this.DesinscribirEstudiantes(materiaNodo);// O(E) (siendo E la cantidad de estudiantes) porque es O(1) * cantidad de estudiantes inscriptos
    }
    
    private void EliminarMaterias(Materia materia2) { //// O(la sumatoria de los nombres de todas las materias equivalentes)
        ListaEnlazada<Materias, String> equivalentes = materia2.MateriasEquivalentes(); // O(1)
        Iterador<Materias, String> iterador = equivalentes.iterador(); // O(1)
        while (iterador.haySiguiente()) { // O(la sumatoria de los nombres de todas las materias equivalentes)
            Pair<Materias, String> par = iterador.siguiente(); // O(1)
            Materias materia = par.getFirst(); //O(1)
            String nombre = par.getSecond(); //O(1)
            materia.Borrar(nombre); //O(n), siendo n la longitud del string nombre
        }
    }

    private void DesinscribirEstudiantes(Materia materia2){ // O(E)
        for (int j = 0; j < materia2.ListarEstudiantes().size() ; j++){ // O(E), siendo E la cantidad de estudiantes que cursan la materia
            this.estudiantes.Desinscribir(materia2.ListarEstudiantes().get(j)); //O(1)
        }
    }

    public int inscriptos(String materia, String carrera){ //O(|carrera| + |materia|)
        Materias carreraNodo = carreras.BuscarCarrera(carrera);//O(|carrera|)
        Materia materiaNodo = carreraNodo.BuscarMateria(materia);//O(|materia|)
        return materiaNodo.CantidadEstudiantes();//O(1)
    }

    public boolean excedeCupo(String materia, String carrera){ //O(|carrera| + |materia|)
        Materias carreraNodo = carreras.BuscarCarrera(carrera);//O(|carrera|)
        Materia materiaNodo = carreraNodo.BuscarMateria(materia);//O(|materia|)
        return materiaNodo.ExcedeCupo();//O(1)
    }

    public String[] carreras(){ // O(la sumatoria de la longitud de todos los nombres de las carreras)
        return  this.carreras.listarCarreras();//sumatoria de las longitudes de las carreras 
    }

    public String[] materias(String carrera){ //O(la sumatoria de la longitud de todos los nombres de las materias de la carrera)
        Materias carreraNodo = carreras.BuscarCarrera(carrera);//O(|carrera|)
        return carreraNodo.listarMaterias();//O(sumatoria de las longitudes de las materias)
    }

    public int materiasInscriptas(String estudiante){ //O(1)
        return estudiantes.Inscripciones(estudiante);//O(1)
    }
}