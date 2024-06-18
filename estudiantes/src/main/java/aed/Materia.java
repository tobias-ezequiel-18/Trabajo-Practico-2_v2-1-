package aed;

import java.util.*;

public class Materia {
    private int profesor;
    private int jtp;
    private int ay1;
    private int ay2;
    private int cantAlumnos;
    private ArrayList<String> listaAlumnos;
    private ListaEnlazada materiasEquivalentes;

    public Materia(){
        this.cantAlumnos= 0;
        this.listaAlumnos = new ArrayList<String>();
        this.materiasEquivalentes.raiz = null;
        this.profesor = 0;
        this.jtp = 0;
        this.ay1 = 0;
        this.ay2 = 0;
    }

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

    public ArrayList<Integer> PlantelDocente(){
        ArrayList<Integer> plantel = new ArrayList<Integer>(4);

        plantel.set(0,this.profesor);
        plantel.set(1,this.jtp);
        plantel.set(2,this.ay1);
        plantel.set(3,this.ay2);

        return plantel;
    }

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