/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclinicanutricion;

import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author victor
 */
public class VisitaTest {
    
    Visita v1;
    Visita v2;
    
    @Before
    public void setUp() {
        v1 = new Visita(LocalDate.of(2019, 1, 1), "Dr. Cito", "Esto es un comentario", 80);
        v2 = new Visita(LocalDate.of(2019, 6, 6), "Dr. Who", "Otro comentario", 90);
    }
    


    /**
     * Test of getFecha method, of class Visita.
     */
    @Test
    public void testGetFecha() {
        assertEquals(LocalDate.of(2019, 1, 1), v1.getFecha());
        assertEquals(LocalDate.of(2019, 6, 6), v2.getFecha());
    }

    /**
     * Test of getNombreMedico method, of class Visita.
     */
    @Test
    public void testGetNombreMedico() {
        assertEquals("Dr. Cito", v1.getNombreMedico());
        assertEquals("Dr. Who", v2.getNombreMedico());
    }

    /**
     * Test of getComentario method, of class Visita.
     */
    @Test
    public void testGetComentario() {
        assertEquals("Esto es un comentario", v1.getComentario());
        assertEquals("Otro comentario", v2.getComentario());
    }

    /**
     * Test of getPeso method, of class Visita.
     */
    @Test
    public void testGetPeso() {
        assertEquals(80.0, v1.getPeso(), 0.01);
        assertEquals(90.0, v2.getPeso(), 0.01);
    }
    
}
