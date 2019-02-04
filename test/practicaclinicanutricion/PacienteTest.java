/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclinicanutricion;

import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author victor
 */
public class PacienteTest {

    Paciente p1;
    Paciente p2;
    Visita v1;

    @BeforeClass
    public static void beforeClass() {
        Locale.setDefault(Locale.ROOT);
    }

    @Before
    public void setUp() {
        v1 = new Visita(LocalDate.of(2019, 2, 2), "Dr. Cito", "Un comentario", 80);
        p1 = new Paciente(" Pepe Luis ", "PErEZ  LoPEZ ", "12345678Z", LocalDate.of(1970, 1, 1), 1.79, v1);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test constructor exception
     */
    @Test
    public void testConstructorExcepciones() {
        boolean hayExcepcion = false;
        try {
            Paciente p2 = new Paciente(" Pepe Luis ", "FDEZ.", "12345678Z", LocalDate.of(1970, 1, 1), 1.79, v1);
        } catch (IllegalArgumentException ex) {
            hayExcepcion = true;
        }
        assertEquals("Punto en apellido. Se debe lanzar excepcion.", true, hayExcepcion);
        hayExcepcion = false;
        try {
            Paciente p2 = new Paciente(" Pepe Luis ", "FerNandez", "1234567Z", LocalDate.of(1970, 1, 1), 1.79, v1);
        } catch (IllegalArgumentException ex) {
            hayExcepcion = true;
        }
        assertEquals("DNI no valido. Se debe lanzar excepcion.", true, hayExcepcion);
    }

    /**
     * Test of getNombre method, of class Paciente.
     */
    @Test
    public void testGetNombre() {
        assertEquals("PEPE LUIS", p1.getNombre());
    }

    /**
     * Test of setNombre method, of class Paciente.
     */
    @Test
    public void testSetNombre() {
        p1.setNombre(" Kim NaMjOOn   ");
        assertEquals("KIM NAMJOON", p1.getNombre());
    }

    /**
     * Test of getApellidos method, of class Paciente.
     */
    @Test
    public void testGetApellidos() {
        assertEquals("PEREZ  LOPEZ", p1.getApellidos());
    }

    /**
     * Test of setApellidos method, of class Paciente.
     */
    @Test
    public void testSetApellidos() {
        p1.setApellidos(" ChARLie  PutH");
        assertEquals("CHARLIE  PUTH", p1.getApellidos());
        boolean hayExcepcion = false;
        try {
            p1.setApellidos(" HarUkI.MurakAmi ");
        } catch (IllegalArgumentException ex) {
            hayExcepcion = true;
        }
        assertEquals("No puntos en apellido", true, hayExcepcion);
    }

    /**
     * Test of getFechaNacimiento method, of class Paciente.
     */
    @Test
    public void testGetFechaNacimiento() {
        assertEquals(LocalDate.of(1970, 1, 1), p1.getFechaNacimiento());
    }

    /**
     * Test of setFechaNacimiento method, of class Paciente.
     */
    @Test
    public void testSetFechaNacimiento() {
        p1.setFechaNacimiento(LocalDate.of(1980, 4, 20));
        assertEquals(LocalDate.of(1980, 4, 20), p1.getFechaNacimiento());
    }

    /**
     * Test of getAltura method, of class Paciente.
     */
    @Test
    public void testGetAltura() {
        assertEquals(1.79, p1.getAltura(), 0.01);
    }

    /**
     * Test of getPeso method, of class Paciente.
     */
    @Test
    public void testGetPeso() {
        assertEquals(80, p1.getPeso(), 0.01);
        p1.annadirVisita(new Visita(LocalDate.of(2019, 3, 4), "Dr. Cito", "Segunda visita", 81));
        assertEquals(81, p1.getPeso(), 0.01);
    }

    /**
     * Test of getEdad method, of class Paciente.
     */
    @Test
    public void testGetEdad() {
        assertEquals(49, p1.getEdad(LocalDate.of(2019, 1, 2)));
        p1.setFechaNacimiento(LocalDate.of(1970, 4, 20));
        assertEquals(48, p1.getEdad(LocalDate.of(2019, 4, 19)));
        assertEquals(49, p1.getEdad(LocalDate.of(2019, 4, 21)));
    }

    /**
     * Test of getUltimaVisita method, of class Paciente.
     */
    @Test
    public void testGetUltimaVisita() {
        assertEquals(v1, p1.getUltimaVisita());
    }

    /**
     * Test of annadirVisita method, of class Paciente.
     */
    @Test
    public void testAnnadirVisita() {
        Visita v2 = new Visita(LocalDate.of(2021, 3, 3), "Dr. Cito", "Un comentario", 80);
        p1.annadirVisita(v2);
        assertEquals(v2, p1.getUltimaVisita());
        Visita v3 = new Visita(LocalDate.of(2020, 4, 4), "Dr. Cito", "Un comentario", 82);
        boolean hayExcepcion = false;
        try {
            p1.annadirVisita(v2);
        } catch (IllegalArgumentException ex) {
            hayExcepcion = true;
        }
        assertEquals("Fecha anterior. Se espera excepcion", true, hayExcepcion);
    }

    /**
     * Test of getCantidadVisitas method, of class Paciente.
     */
    @Test
    public void testGetCantidadVisitas() {
        Visita v2 = new Visita(LocalDate.of(2021, 3, 3), "Dr. Cito", "Un comentario", 81);
        p1.annadirVisita(v2);
        assertEquals(v2, p1.getUltimaVisita());
        assertEquals(2, p1.getCantidadVisitas());
        Visita v3 = new Visita(LocalDate.of(2022, 4, 4), "Dr. Cito", "Un comentario", 82);
        p1.annadirVisita(v3);
        assertEquals(3, p1.getCantidadVisitas());
    }

    /**
     * Test of getDuracion method, of class Paciente.
     */
    @Test
    public void testGetDuracion() {
        assertEquals(1, p1.getDuracion());
        Visita v2 = new Visita(LocalDate.of(2021, 3, 3), "Dr. Cito", "Un comentario", 81);
        p1.annadirVisita(v2);
        assertEquals(761, p1.getDuracion());
        Visita v3 = new Visita(LocalDate.of(2022, 4, 4), "Dr. Cito", "Un comentario", 82);
        p1.annadirVisita(v3);
        assertEquals(1158, p1.getDuracion());
    }

    /**
     * Test of getImc method, of class Paciente.
     */
    @Test
    public void testGetImc() {
        assertEquals(24.96, p1.getImc(), 0.01);
        Visita v2 = new Visita(LocalDate.of(2021, 3, 3), "Dr. Cito", "Un comentario", 81);
        p1.annadirVisita(v2);
        assertEquals(25.28, p1.getImc(), 0.01);
        Visita v3 = new Visita(LocalDate.of(2022, 4, 4), "Dr. Cito", "Un comentario", 82);
        p1.annadirVisita(v3);
        assertEquals(25.59, p1.getImc(), 0.01);

    }

    /**
     * Test of getCategoriaOms method, of class Paciente.
     */
    @Test
    public void testGetCategoriaOms() {
        assertEquals(CategoriaOms.NORMAL, p1.getCategoriaOms());
        Visita v2 = new Visita(LocalDate.of(2021, 3, 3), "Dr. Cito", "Un comentario", 51);
        p1.annadirVisita(v2);
        assertEquals(CategoriaOms.INFRAPESO, p1.getCategoriaOms());
        Visita v3 = new Visita(LocalDate.of(2022, 4, 4), "Dr. Cito", "Un comentario", 102);
        p1.annadirVisita(v3);
        assertEquals(CategoriaOms.OBESIDAD, p1.getCategoriaOms());
    }

    /**
     * Test of getPesoNormalMinimo method, of class Paciente.
     */
    @Test
    public void testGetPesoNormalMinimo() {
        assertEquals(59.27, p1.getPesoNormalMinimo(), 0.01);
        Visita v2 = new Visita(LocalDate.of(2021, 3, 3), "Dr. Cito", "Un comentario", 51);
        p1.annadirVisita(v2);
        assertEquals(59.27, p1.getPesoNormalMinimo(), 0.01);
        p1.setAltura(1.92);
        assertEquals(68.19, p1.getPesoNormalMinimo(), 0.01);
    }

    /**
     * Test of getPesoNormalMaximo method, of class Paciente.
     */
    @Test
    public void testGetPesoNormalMaximo() {
        assertEquals(80.07, p1.getPesoNormalMaximo(), 0.01);
        Visita v2 = new Visita(LocalDate.of(2021, 3, 3), "Dr. Cito", "Un comentario", 51);
        p1.annadirVisita(v2);
        assertEquals(80.07, p1.getPesoNormalMaximo(), 0.01);
        p1.setAltura(1.92);
        assertEquals(92.12, p1.getPesoNormalMaximo(), 0.01);
    }

    
    /**
     * Calcula la diferencia entre dos cadenas, como un porcentaje, utilizando el algoritmo de
     * levenshtein, que obtiene la distanticia entre dos cadenas, entendida como la cantidad de
     * caracteres que hay que cambiar, eliminar o añadir en una para obtener la otra. Más info:
     * http://goo.gl/z3woFI
     *
     * @return un número entre o y 100, que indica el porcentaje de diferencia entre la cadena s1 y
     * la s2. 0=iguales 100=hay que cambiar el 100% de s1 para obtener s2
     * @param s1 La cadena de la que se parte
     * @param s2 La cadena con la que se quiere comparar
     */
    public static int levenshtein(String s1, String s2) {
        int coste = 0;
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] m = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            m[i][0] = i;
        }
        for (int i = 1; i <= n2; i++) {
            m[0][i] = i;
        }
        for (int i1 = 1; i1 <= n1; i1++) {
            for (int i2 = 1; i2 <= n2; i2++) {
                coste = (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) ? 0 : 1;
                m[i1][i2] = Math.min(
                        Math.min(
                                m[i1 - 1][i2] + 1,
                                m[i1][i2 - 1] + 1
                        ),
                        m[i1 - 1][i2 - 1] + coste
                );
            }
        }
        return m[n1][n2];
    }

    /**
     * Test of getInforme method, of class Paciente.
     */
    @Test
    public void testGetInforme() {
        final String esperado
                = "PEPE LUIS PEREZ  LOPEZ, 1.79, 1970/01/01\n"
                + "----------------------------------------\n"
                + "2019/02/02 Dr. Cito, 80.0 Kg. 24.97\n"
                + "Un comentario\n"
                + "----------------------------------------\n"
                + "2021/03/03 Dr. Who, 51.0 Kg. 15.92\n"
                + "Otro comentario\n"
                + "----------------------------------------\n"
                + "2022/04/04 Dra. Quinn, 102.0 Kg. 31.83\n"
                + "Otro comentario más\n"
                + "de dos líneas.\n"
                + "----------------------------------------\n"
                + "FIN DEL INFORME";
        Visita v2 = new Visita(LocalDate.of(2021, 3, 3), "Dr. Who", "Otro comentario", 51);

        p1.annadirVisita(v2);
        Visita v3 = new Visita(LocalDate.of(2022, 4, 4), "Dra. Quinn", "Otro comentario más\nde dos líneas.", 102);

        p1.annadirVisita(v3);

        String actual = p1.getInforme().replaceAll("\r", ""); //Elimina posibles LF introducidos en Windows
        
        int distancia =levenshtein(esperado, actual);
        System.out.format("ESPERADO:%n%s%nENCONTRADO:%n%s%n",esperado, p1.getInforme());
        
        if (distancia > 0) {
            fail(String.format("Diferencia de %d cambios respecto a lo esperado.", distancia));
        } 
    }
    
        @Test
    public void testSetAltura() {
        p1.setAltura(1.91);
            assertEquals(1.91, p1.getAltura(), 0.01);
    }    
    
        @Test
    public void testGetDni() {
        assertEquals("12345678Z", p1.getDni());
    }    

    public void testSetTarjetaCredito() {
        p1.setTarjetaCredito("4597372408433948");
        boolean hayExcepcion = false;
        try {
            p1.setTarjetaCredito("459737240843");
        } catch (IllegalArgumentException ex) {
            hayExcepcion = true;
        }
        assertEquals("Se espera excepcion en tarjeta erronea", true, hayExcepcion);
    }    

    public void testGetTarjetaCredito() {
        p1.setTarjetaCredito("4597372408433948");
        assertEquals("4597372408433948", p1.getTarjetaCredito());
    }
    



}
