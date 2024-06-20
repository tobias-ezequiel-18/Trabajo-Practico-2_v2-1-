package aed;

import java.util.*;

public class Materia {
   public enum CargoDocente{
        AY2(0),
        AY1(0),
        JTP(0),
        PROF(0);

        private int valor;

        CargoDocente(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }
        public void incrementarValor() {
            this.valor += 1;
        }
    }
    private int numerodealumnos;
    private ArrayList<String> listaalumnos;
    private ListaEnlazada materiasequivalentes;

    public Materia(){
        this.numerodealumnos= 0;
        this.listaalumnos = new ArrayList<String>();
        this.materiasequivalentes = new ListaEnlazada<>();
    }

    public void Agregardocente(String docente){
        CargoDocente cargoMateria = CargoDocente.valueOf(docente); // Convertir el String a CargoDocente
        cargoMateria.incrementarValor();
    }

    public ArrayList<Integer> PlantelDocente(){
        ArrayList<Integer> nuevo = new ArrayList<>(4);
    
        nuevo.add(CargoDocente.PROF.getValor());
        nuevo.add(CargoDocente.JTP.getValor());
        nuevo.add(CargoDocente.AY1.getValor());
        nuevo.add(CargoDocente.AY2.getValor());
        return nuevo;
    }
    

    public boolean ExcedeCupo(){
        if (this.numerodealumnos/CargoDocente.PROF.getValor() <= 250 && this.numerodealumnos/CargoDocente.JTP.getValor() <=100 && this.numerodealumnos/CargoDocente.AY1.getValor()<=20 && this.numerodealumnos/CargoDocente.AY2.getValor() <=30){
            return false;
        }else{
            return true;
        }
    }

    public void AgregarAlumno (String alumno){
        this.numerodealumnos++;
        this.listaalumnos.add(alumno);

    }

    public void AgregarMateriaEquivalente (Materias listamaterias, String materia){
        this.materiasequivalentes.agregarAtras(listamaterias,materia);
    }
}
