package aed;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarrerasTests {
    String[] materiasCompu;
    String[] materiasQuimica;
    Materias materiasComp;
    Materias materiasQuim;
    
    @BeforeEach
    void init(){
        materiasCompu = new String[5];
        materiasQuimica = new String[5];
        materiasCompu[0] = "Introducción a la Programación";
        materiasCompu[1] = "Álgebra I";
        materiasCompu[2] = "Algoritmos y Estructuras de Datos";
        materiasCompu[3] = "Análisis I";
        materiasCompu[4] = "Paradigmas de Programación";
        materiasQuimica[0] = "Química General";
        materiasQuimica[1] = "Análisis Matemático 1";
        materiasQuimica[2] = "Química Inorgánica 1";
        materiasQuimica[3] = "Análisis Matemático 2";
        materiasQuimica[4] = "Física 1";
    }

    @Test
    void nuevo_trie_carreras(){
        Carreras carreras = new Carreras();

        assertFalse(carreras.Definida("Ciencias de la Computación"));
        assertFalse(carreras.Definida("Ciencias Químicas"));
    }

    @Test
    void agregar_carreras(){

        Materias materiasComp = new Materias();
        Materias materiasQuim = new Materias();

        for (int i = 0; i < materiasCompu.length; i++){
            materiasComp.Definir(materiasCompu[i], new Materia(new ParCarreraMateria[0]));
            materiasQuim.Definir(materiasQuimica[i], new Materia(new ParCarreraMateria[0]));
        }

        Carreras carreras = new Carreras();
        carreras.Definir("Ciencias de la Computación", materiasComp);
        assertTrue(carreras.Definida("Ciencias de la Computación"));
        carreras.Definir("Ciencias Químicas", materiasQuim);
        assertTrue(carreras.Definida("Ciencias Químicas"));
    }
}
