package aed;

public class SistemaSIU {

    private Carreras carreras;
    private Estudiantes estudiantes;

    enum CargoDocente{
        AY2,
        AY1,
        JTP,
        PROF
    }

    public SistemaSIU(InfoMateria[] infoMaterias, String[] libretasUniversitarias){
        this.carreras = new Carreras();//O(1)
        this.estudiantes = new Estudiantes();//O(1)
    
        this.CrearCarrerasYMaterias(infoMaterias);//la sumatoria de cada longitud de cada carrera multiplicado por la longitud del nombre de cada materia de cada carrera respectivamente, sumado a la sumatoria de la longitud de cada nombre de cada materia 
        this.CraerLibreta(libretasUniversitarias);//O(1) * la cantdidad de estudiantes

    }

    private void CraerLibreta(String[] libreta){
        for (int i = 0 ; i < libreta.length ; i++){//O(|alumnos|)
            this.estudiantes.InsertarAlumno(libreta[i]);//O(1)
        }
    }

    private void CrearCarrerasYMaterias(InfoMateria[] infoMaterias){
        for (int i = 0;i<infoMaterias.length;i++){//O(|infoMaterias|)
           ParCarreraMateria[] carreramateria = infoMaterias[i].getParesCarreraMateria();
            Materias carrera = this.carreras.InsertarCarrera(carreramateria[0].getCarrera());//O(|carrera|)
            Materia materia2 = new Materia();//O(1)
            Materia materia =carrera.InsertarSimple(carreramateria[0].getNombreMateria());//O(|materia|)
            materia = materia2;
            materia2.AgregarMateriaEquivalente(carrera,carreramateria[0].getNombreMateria());//O(1)
            for (int j = 1 ; j < infoMaterias[i].getParesCarreraMateria().length ; j++){//O(|infoMteria|)
                
                Materias carrera2 = this.carreras.InsertarCarrera(infoMaterias[i].getParesCarreraMateria()[j].getCarrera());//O(|carrera|)
                Materia materia3 =carrera2.Insertar(infoMaterias[i].getParesCarreraMateria()[j].getNombreMateria(),materia2);
                materia3.AgregarMateriaEquivalente(carrera2,infoMaterias[i].getParesCarreraMateria()[j].getNombreMateria());//O(|materia|)
            }
            }
        }

    }



    public void inscribir(String estudiante, String carrera, String materia){
        estudiantes.Inscribir(estudiante);//O(1)
        Materias carreraNodo = carreras.BuscarCarrera(carrera);//O(|carrera|)
        Materia materiaNodo = carreraNodo.BuscarMateria(materia);//O(|materia|)
        materiaNodo.AgregarAlumno(estudiante);;//O(1)
    }

    public void agregarDocente(CargoDocente cargo, String carrera, String materia){
        String cargostring = cargo.toString(); // Convertir el String a CargoDocente

        Materias carreraNodo = carreras.BuscarCarrera(carrera);//O(|carrera|)
        Materia materiaNodo = carreraNodo.BuscarMateria(materia);//O(|materia|)
        materiaNodo.Agregardocente(cargostring);//O(1)
    }

    public int[] plantelDocente(String materia, String carrera){
        Materias carreraNodo = carreras.BuscarCarrera(carrera);//O(|carrera|)
        Materia materiaNodo = carreraNodo.BuscarMateria(materia);//O(|materia|)
        materiaNodo.PlantelDocente();//O(1)  
    }

    public void cerrarMateria(String materia, String carrera){
        Materias carreraNodo = carreras.BuscarCarrera(carrera);//O(|carrera|)
        Materia materiaNodo = carreraNodo.BuscarMateria(materia);//O(|materia|)
        
        this.EliminarMaterias(materiaNodo);// sumatoria desde la primeras posiscion del arreglo al ultimo 
        this.DesinscribirEstudiantes(materiaNodo);// O(1) * cantidad de estudiantes inscriptos
    }

    private void EliminarMaterias(Materia materia2){
         while (materia2.materiasequivalentes != null;)  
        tad.materiasequivalentes[i][0].Borrar(tad.materiasequivalentes[i][1]);       	    
                  
    }

    private void DesinscribirEstudiantes(Materia materia2){
        for (int j = 0; j < materia2.listaalumnos.length() ; j++){
            this.estudiantes.Desinscribir(materia2.listaalumnos[i]);
        }
    }

    public int inscriptos(String materia, String carrera){
        Nodo carreraNodo = carreras.BuscarCarrera(carrera);//O(|carrera|)
        Materias materiatrie = carreraNodo.materia;//O(1)
        Nodo materiaNodo = materiatrie.BuscarMateria(materia);//O(|materia|)
        return materiaNodo.materia.numerodealumnos;//O(1)
    }

    public boolean excedeCupo(String materia, String carrera){
        Nodo carreraNodo = carreras.BuscarCarrera(carrera);//O(|carrera|)
        Materias materiatrie = carreraNodo.materia;//O(1)
        Nodo materiaNodo = materiatrie.BuscarMateria(materia);//O(|materia|)
        return materiaNodo.materia.ExecedeCupo()//O(1)
    }

    public String[] carreras(){
        return  SistemaSIU.carreras.listarCarreras();//sumatoria de las longitudes de las carreras 
    }

    public String[] materias(String carrera){
        Nodo carreraNodo = carreras.BuscarCarrera(carrera);//O(|carrera|)
        Materias materiatrie = carreraNodo.materia;//O(1)
        return materiatrie.listarMaterias();//O(sumatoria de las longitudes de las materias)
    }

    public int materiasInscriptas(String estudiante){
        return estudiantes.Inscripciones(estudiante);//O(1)
    }
}
