package aed;

import java.util.*;

public class Materia {
    private int profesor;
    private int jtp;
    private int ay1;
    private int ay2;
    private int cantAlumnos;
    private ArrayList<String> listaAlumnos;
    private ArrayList<ParCarreraMateria> materiasEquivalentes;

    // Constructor de la clase.
    public Materia(ArrayList<ParCarreraMateria> equivalentes){
        cantAlumnos= 0;
        listaAlumnos = new ArrayList<String>();
        for (int i = 0; i < equivalentes.size(); i++){
            materiasEquivalentes.add(equivalentes.get(i));
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

        plantel.set(0,this.profesor);
        plantel.set(1,this.jtp);
        plantel.set(2,this.ay1);
        plantel.set(3,this.ay2);

        return plantel;
    }

    // Determina si la cantidad de inscriptos excede el cupo.
    public boolean ExcedeCupo(){
        if (this.cantAlumnos/this.profesor > 250 &&
            this.cantAlumnos/this.jtp > 100 && 
            this.cantAlumnos/this.ay1 > 20 && 
            this.cantAlumnos/this.ay2 > 30){
            return true;
        }else{
            return false;
        }
    }
}