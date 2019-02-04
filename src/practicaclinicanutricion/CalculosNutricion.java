package practicaclinicanutricion;
/*
/**
 *
 * @author victor
 */
public class CalculosNutricion {

    public static double calcularImc(double peso, double altura) {
        return peso / (altura * altura);
    }

    public static double calcularPesoMaximo(double altura) {
        return 24.99 * altura * altura;
    }

    public static double calcularPesoMinimo(double altura) {
        return 18.5 * altura * altura;
    }

    public static CategoriaOms calcularCategoriaOms(double imc) {
        if (imc < 18.5) {
            return CategoriaOms.INFRAPESO;
        } else if (imc < 25) {
            return CategoriaOms.NORMAL;
        } else if (imc < 30) {
            return CategoriaOms.SOBREPESO;
        } else {
            return CategoriaOms.OBESIDAD;
        }
    }

}
