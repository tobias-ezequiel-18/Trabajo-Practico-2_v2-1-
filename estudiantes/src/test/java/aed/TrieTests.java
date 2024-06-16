package aed;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TrieTests {

    @Test // Trie vacío
    void nuevo_trie(){
        @SuppressWarnings("rawtypes")
        Trie trie = new Trie<>();
        assertEquals(0, trie.Longitud());
    }
    
    @SuppressWarnings("unchecked")
    @Test // Agregar elementos
    void agregar_elementos(){
        Trie nuevo_trie = new Trie<>();
        assertEquals(0, nuevo_trie.Longitud());

        // Agrego
        assertFalse(nuevo_trie.Definido("she"));
        nuevo_trie.Definir("she", 0);
        assertEquals(1, nuevo_trie.Longitud());
        assertTrue(nuevo_trie.Definido("she"));

        assertFalse(nuevo_trie.Definido("sells"));
        nuevo_trie.Definir("sells", 1);
        assertEquals(2, nuevo_trie.Longitud());
        assertTrue(nuevo_trie.Definido("sells"));

        assertFalse(nuevo_trie.Definido("sea"));
        nuevo_trie.Definir("sea", 2);
        assertEquals(3, nuevo_trie.Longitud());
        assertTrue(nuevo_trie.Definido("sea"));

        assertFalse(nuevo_trie.Definido("shells"));
        nuevo_trie.Definir("shells", 3);
        assertEquals(4, nuevo_trie.Longitud());
        assertTrue(nuevo_trie.Definido("shells"));

        assertFalse(nuevo_trie.Definido("by"));
        nuevo_trie.Definir("by", 4);
        assertEquals(5, nuevo_trie.Longitud());
        assertTrue(nuevo_trie.Definido("by"));

        assertFalse(nuevo_trie.Definido("the"));
        nuevo_trie.Definir("the", 5);
        assertEquals(6, nuevo_trie.Longitud());
        assertTrue(nuevo_trie.Definido("the"));

        assertTrue(nuevo_trie.Definido("sea"));
        nuevo_trie.Definir("sea", 6);
        assertEquals(6, nuevo_trie.Longitud());

        assertFalse(nuevo_trie.Definido("shore"));
        nuevo_trie.Definir("shore", 7);
        assertEquals(7, nuevo_trie.Longitud());
        assertTrue(nuevo_trie.Definido("shore"));
    }

    @Test // Agregar y borrar elementos
    void agregar_y_borrar_elementos(){
        Trie nuevo_trie = new Trie<>();
        assertEquals(0, nuevo_trie.Longitud());

        // Agrego
        assertFalse(nuevo_trie.Definido("Hola"));
        nuevo_trie.Definir("Hola", 0);
        assertEquals(1, nuevo_trie.Longitud());
        assertTrue(nuevo_trie.Definido("Hola"));

        assertFalse(nuevo_trie.Definido("Holanda"));
        nuevo_trie.Definir("Holanda", 1);
        assertEquals(2, nuevo_trie.Longitud());
        assertTrue(nuevo_trie.Definido("Holanda"));

        assertFalse(nuevo_trie.Definido("Campo"));
        nuevo_trie.Definir("Campo", 2);
        assertEquals(3, nuevo_trie.Longitud());
        assertTrue(nuevo_trie.Definido("Campo"));

        assertFalse(nuevo_trie.Definido("Cambio"));
        nuevo_trie.Definir("Cambio", 3);
        assertEquals(4, nuevo_trie.Longitud());
        assertTrue(nuevo_trie.Definido("Cambio"));
        
        // Borro
        nuevo_trie.Borrar("Hola");
        assertEquals(3, nuevo_trie.Longitud());
        assertFalse(nuevo_trie.Definido("Hola"));

        assertTrue(nuevo_trie.Definido("Holanda"));
        nuevo_trie.Borrar("Holanda");
        assertEquals(2, nuevo_trie.Longitud());
        assertFalse(nuevo_trie.Definido("Holanda"));

        nuevo_trie.Borrar("Cambio");
        assertEquals(1, nuevo_trie.Longitud());
        assertFalse(nuevo_trie.Definido("Cambio"));

        assertTrue(nuevo_trie.Definido("Campo"));
        nuevo_trie.Borrar("Campo");
        assertEquals(0, nuevo_trie.Longitud());
        assertFalse(nuevo_trie.Definido("Campo"));
    }
}
