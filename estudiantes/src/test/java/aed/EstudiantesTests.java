package aed;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EstudiantesTests {

    String[] libretas;
    
    @Test
    void definir_estudiantes(){

        libretas = new String[10];
        libretas[0] = "154/15";
        libretas[1] = "1704/16";
        libretas[2] = "2103/17";
        libretas[3] = "124/18";
        libretas[4] = "1111/19";
        libretas[5] = "3112/20";
        libretas[6] = "1007/21";
        libretas[7] = "1109/22";
        libretas[8] = "1209/23";
        libretas[9] = "248/24";

        Estudiantes estudiantes = new Estudiantes();

        for (int i = 0; i < libretas.length; i ++) {
            estudiantes.InsertarEstudiante(libretas[i]);
        }

        for (int i = 0; i < libretas.length; i++) {
            for (int j = 0; j < 4; j++){
                estudiantes.Inscribir(libretas[i]);
            }
            assertEquals(4, estudiantes.cantidadInscripciones(libretas[i]));
        }

        for (int i = 0; i < libretas.length; i++) {
            for (int j = 0; j < 4; j++){
                estudiantes.Desinscribir(libretas[i]);
            }
            assertEquals(0, estudiantes.cantidadInscripciones(libretas[i]));
        }
    }
    
}
