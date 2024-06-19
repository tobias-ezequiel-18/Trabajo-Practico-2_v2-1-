package aed;

import java.util.*;

public class Materia {
    private int profesor;
    private int jtp;
    private int ay1;
    private int ay2;
    private int cantEstudiantes;
    private ArrayList<String> listaEstudiantes;
    private ParCarreraMateria[] materiasEquivalentes; // Conviene usar un array de longitud fija, porque agregamos materias solo al iniciar un sistema nuevo.

    // Constructor de la clase.
    public Materia(ParCarreraMateria[] equivalentes){
        cantEstudiantes= 0;
        listaEstudiantes = new ArrayList<String>();
        materiasEquivalentes = new ParCarreraMateria[equivalentes.length];
        for (int i = 0; i < equivalentes.length; i++){
            materiasEquivalentes[i] = equivalentes[i];
        }
        profesor = 0;
        jtp = 0;
        ay1 = 0;
        ay2 = 0;
    }

    // Agrega un docente al plantel.
    public void Agregardocente(String docente){
        if (docente == "PROFE"){
            this.profesor++;
        }else{
            if (docente == "JTP"){
                this.jtp++;
            }else{
                if (docente == "AY1"){
                    this.ay1++;
                }else{
                    this.ay2++;
                }
            }
        }
    }

    // Devuelve el plantel docente de la materia.
    public ArrayList<Integer> PlantelDocente(){
        ArrayList<Integer> plantel = new ArrayList<Integer>(4);

        plantel.add(profesor);
        plantel.add(jtp);
        plantel.add(ay1);
        plantel.add(ay2);

        return plantel;
    }

    public void InscribirEstudiantes(ArrayList<String> estudiantes){
        for (int i = 0; i < estudiantes.size(); i++){
            InscribirEstudiante(estudiantes.get(i));
        }
    }

    public void InscribirEstudiante(String estudiante){
        cantEstudiantes++;
        listaEstudiantes.add(estudiante);
    }

    // Determina si la cantidad de inscriptos excede el cupo.
    public boolean ExcedeCupo(){
        if (this.cantEstudiantes/this.profesor > 250 &&
            this.cantEstudiantes/this.jtp > 100 && 
            this.cantEstudiantes/this.ay1 > 20 && 
            this.cantEstudiantes/this.ay2 > 30){
            return true;
        }else{
            return false;
        }
    }
}