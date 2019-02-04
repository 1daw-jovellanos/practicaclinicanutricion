/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclinicanutricion;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author victor
 */
public class ValidacionesTest {
    
    @Test
    public void testValidarDni() {
        assertEquals(true, Validaciones.validarDni("12345678z"));
        assertEquals(true, Validaciones.validarDni("12345678Z"));
        assertEquals(false, Validaciones.validarDni("12345678-Z"));
        assertEquals(false, Validaciones.validarDni("123456S"));
    }
    
    @Test
    public void testValidarTarjetaCredito() {
        assertEquals(true, Validaciones.validarTarjetaCredito("4597372408433948"));
        assertEquals(true, Validaciones.validarTarjetaCredito("4597 3724 0843 3948"));
        assertEquals("Guiones no", false, Validaciones.validarTarjetaCredito("4597-3724-0843-3948"));
        assertEquals("Espacios mal.", false, Validaciones.validarTarjetaCredito("4597 3724 084 33948"));
        assertEquals(true, Validaciones.validarTarjetaCredito("4921 3602 3889 3347"));
        assertEquals(false, Validaciones.validarTarjetaCredito("4857350571493689"));
        assertEquals(false, Validaciones.validarTarjetaCredito("4817539583560"));
    }    
}
