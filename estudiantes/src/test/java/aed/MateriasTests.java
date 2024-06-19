package aed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MateriasTests {
    String[] nombresMaterias;
    
    @BeforeEach
    void init(){
        nombresMaterias = new String[10];
        nombresMaterias[0] = "Álgebra I";
        nombresMaterias[1] = "Algoritmos I";
        nombresMaterias[2] = "Análisis I";
        nombresMaterias[3] = "Análisis II";
        nombresMaterias[4] = "Algoritmos II";
        nombresMaterias[5] = "Laboratorio de Datos";
        nombresMaterias[6] = "Análisis Avanzado";
        nombresMaterias[7] = "Álgebra Lineal Computacional";
        nombresMaterias[8] = "Probabilidad";
        nombresMaterias[9] = "Algoritmos III";
    }

    @Test
    void nuevo_trie_materias(){
        Materias materias = new Materias();

        // Comprobamos que ninguna de las materias de infoMaterias pertenece al Trie.
        for (int i = 0; i < nombresMaterias.length; i++){
            assertFalse(materias.Definida(nombresMaterias[i]));
            }
        }


    @Test
    void agregar_materias(){
        Materias materias = new Materias();

        for (int i = 0; i < nombresMaterias.length; i++){
            materias.Definir(nombresMaterias[i], new Materia(new ParCarreraMateria[0]));
            // Verificamos que esté definida.
            assertTrue(materias.Definida(nombresMaterias[i]));
            }
    }
    

    @Test
    void borrar_materias(){
        Materias materias = new Materias();

        // Definimos todas
        for (int i = 0; i < nombresMaterias.length; i++){
            materias.Definir(nombresMaterias[i], new Materia(new ParCarreraMateria[0]));
        }

        // Borramos todas
        
        for (int i = 0; i < nombresMaterias.length; i++){
            materias.Borrar(nombresMaterias[i]);
            // Verificamos que NO esté definida.
            assertFalse(materias.Definida(nombresMaterias[i]));
        }

    }
}
