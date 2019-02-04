/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclinicanutricion;

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
public class CalculosNutricionTest {

    @Test
    public void testCalcularImc() {
        
        assertEquals(40, CalculosNutricion.calcularImc(90, 1.50), 0.01);
        assertEquals(26.84, CalculosNutricion.calcularImc(86, 1.79), 0.01);
        assertEquals(24.34, CalculosNutricion.calcularImc(78, 1.79), 0.01);
        assertEquals(19.35, CalculosNutricion.calcularImc(62, 1.79), 0.01);
    }

    /**
     * Test of calcularPesoMaximo method, of class CalculosNutricion.
     */
    @Test
    public void testCalcularPesoMaximo() {
        assertEquals(80.07, CalculosNutricion.calcularPesoMaximo(1.79), 0.01);
        assertEquals(56.22, CalculosNutricion.calcularPesoMaximo(1.50), 0.01);
    }

    /**
     * Test of calcularPesoMinimo method, of class CalculosNutricion.
     */
    @Test
    public void testCalcularPesoMinimo() {
        assertEquals(59.27 , CalculosNutricion.calcularPesoMinimo(1.79), 0.01);
        assertEquals(41.62 , CalculosNutricion.calcularPesoMinimo(1.50), 0.01);
    }

    /**
     * Test of calcularCategoriaOms method, of class CalculosNutricion.
     */
    @Test
    public void testCalcularCategoriaOms() {
        assertEquals(CategoriaOms.INFRAPESO , CalculosNutricion.calcularCategoriaOms(18.48));
        assertEquals(CategoriaOms.NORMAL , CalculosNutricion.calcularCategoriaOms(18.51));
        assertEquals(CategoriaOms.NORMAL , CalculosNutricion.calcularCategoriaOms(24.99));
        assertEquals(CategoriaOms.SOBREPESO , CalculosNutricion.calcularCategoriaOms(25.01));
        assertEquals(CategoriaOms.OBESIDAD , CalculosNutricion.calcularCategoriaOms(30.01));
    }

    
    
}
