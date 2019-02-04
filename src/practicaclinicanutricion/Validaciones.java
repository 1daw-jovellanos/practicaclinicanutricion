/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclinicanutricion;

/**
 *
 * @author victor
 */
public class Validaciones {

    public static boolean validarDni(String dni) {
        String dniMayuscula = dni.toUpperCase();
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        if (!dniMayuscula.matches("\\d{7,8}[" + letras + "]")) {
            return false;
        }
        int modulo = Integer.parseInt(dniMayuscula.substring(0, dniMayuscula.length() - 1)) % 23;
        System.err.println(letras.charAt(modulo));
        return letras.charAt(modulo) == dniMayuscula.charAt(dniMayuscula.length()-1);
    }

    public static boolean validarTarjetaCredito(String tarjeta) {
        if (!tarjeta.matches("(\\d{4}\\s?){3}\\d{4}" )){
            return false;
        }
        String numero = tarjeta.replaceAll("\\s","");
        int suma = 0;
        for (int i = 0; i < numero.length(); i++) {
            int cifra = numero.charAt(i) - '0';
            if (i % 2 == 0) {
                cifra *= 2;
                suma += cifra / 10 + cifra % 10;
            } else {
                suma += cifra;
            }
        }
        return suma % 10 == 0;
    }

    public static void main(String[] args) {
        System.out.println(Validaciones.validarTarjetaCredito("4332949399123743"));
    }
}
