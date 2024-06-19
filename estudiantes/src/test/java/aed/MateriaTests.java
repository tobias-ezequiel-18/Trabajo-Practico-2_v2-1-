package aed;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MateriaTests {

    ParCarreraMateria[] equivalentes;

    @BeforeEach
    void init(){
        equivalentes = new ParCarreraMateria[] {
            new ParCarreraMateria("Ciencias de la Computación", "Análisis II"),
            new ParCarreraMateria("Ciencias de Datos", "Análisis I"),
            new ParCarreraMateria("Ciencias Físicas", "Matemática 1"),
            new ParCarreraMateria("Ciencias Químicas", "Análisis Matemático 1"),
            new ParCarreraMateria("Ciencias Matemáticas", "Análisis I"),
        };
    }

    @Test
    void crear_materia(){
        Materia materia = new Materia(equivalentes);

        assertEquals("[0, 0, 0, 0]", materia.PlantelDocente().toString()); // Verifico que no hayan docentes. int[] inicializa todas las posiciones en 0.
    }
    
    @Test
    void agregar_docentes_y_estudiantes(){
        Materia materia = new Materia(equivalentes);

        // Agregamos 1 profesor al plantel
        materia.Agregardocente("PROFE");
        assertEquals("[1, 0, 0, 0]", materia.PlantelDocente().toString());

        // Agregamos 3 jtp al plantel
        for (int i=0; i < 3; i++){
            materia.Agregardocente("JTP");
        }
        assertEquals("[1, 3, 0, 0]", materia.PlantelDocente().toString());

        // Agregamos 13 ay1 al plantel
        for (int i=0; i < 13; i++){
            materia.Agregardocente("AY1");
        }
        assertEquals("[1, 3, 13, 0]", materia.PlantelDocente().toString());

        // Agregamos 9 ay2 al plantel
        for (int i=0; i < 9; i++){
            materia.Agregardocente("AY2");
        }
        assertEquals("[1, 3, 13, 9]", materia.PlantelDocente().toString());


        ArrayList<String> estudiantes = new ArrayList<String>();
        for (int i = 0; i < 250; i++){
            estudiantes.add(Integer.toString(i));
        }

        // Agregamos los estudiantes.
        materia.InscribirEstudiantes(estudiantes);
        assertFalse(materia.ExcedeCupo());

        // Agregamos estudiantes para exceder el cupo.
        ArrayList<String> estudiantes2 = new ArrayList<String>();
        for (int i = 250; i < 303; i++){
            estudiantes2.add(Integer.toString(i));
        }
        materia.InscribirEstudiantes(estudiantes2);

        assertTrue(materia.ExcedeCupo());

        // Lo solucionamos agregando un profesor más.

        materia.Agregardocente("PROFE");
        assertEquals("[2, 3, 13, 9]", materia.PlantelDocente().toString());
        assertFalse(materia.ExcedeCupo());

    }
}
