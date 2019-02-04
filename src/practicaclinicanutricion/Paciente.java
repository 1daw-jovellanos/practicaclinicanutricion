/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclinicanutricion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 *
 * @author victor
 */
public class Paciente {

    private String nombre;
    private String apellidos;
    private String dni;
    private String tarjeta;
    private LocalDate fechaNacimiento;
    private double altura;
    private Visita[] visitas;
    private int cantidadVisitas;

    public Paciente(String nombre, String apellidos, String dni, LocalDate fechaNacimiento, double altura, Visita visitaInicial) {
        setNombre(nombre);
        setApellidos(apellidos);
        if (!Validaciones.validarDni(dni)) {
            throw new IllegalArgumentException("dni no es válido");
        }
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
        this.cantidadVisitas = 1;
        visitas = new Visita[100];
        visitas[0] = visitaInicial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.trim().toUpperCase();
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        if (apellidos.indexOf('.') >= 0) {
            throw new IllegalArgumentException("Apellidos no puede contener punto (.)");
        }
        this.apellidos = apellidos.trim().toUpperCase();
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getAltura() {
        return altura;
    }

    // TODO pruebas --------------------
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setTarjetaCredito(String tarjeta) {
        if (!Validaciones.validarTarjetaCredito(tarjeta)) {
            throw new IllegalArgumentException("Tarjeta no valida");
        }
    }

    public String getTarjetaCredito() {
        return tarjeta;
    }
    // ------------------
    public double getPeso() {
        return getUltimaVisita().getPeso();
    }

    public int getEdad(LocalDate fecha) {
        if (fecha.isBefore(getFechaNacimiento())) {
            return 0;
        } else {
            return (int) getFechaNacimiento().until(fecha, ChronoUnit.YEARS);
        }
    }

    public Visita getUltimaVisita() {
        return visitas[cantidadVisitas - 1];
    }

    public void annadirVisita(Visita v) {
        if (!v.getFecha().isAfter(getUltimaVisita().getFecha())) {
            throw new IllegalArgumentException("La fecha de la nueva visita debe ser posterior"
                    + "a la última"
            );
        }
        visitas[cantidadVisitas] = v;
        cantidadVisitas++;
    }

    public int getCantidadVisitas() {
        return cantidadVisitas;
    }

    public int getDuracion() {
        LocalDate primeraFecha = visitas[0].getFecha();
        LocalDate ultimaFecha = getUltimaVisita().getFecha();
        return (int) (ultimaFecha.toEpochDay() - primeraFecha.toEpochDay()) + 1;
    }

    ;
    
    public double getImc() {
        return CalculosNutricion.calcularImc(getPeso(), getAltura());
    }

    public CategoriaOms getCategoriaOms() {
        return CalculosNutricion.calcularCategoriaOms(getImc());
    }

    public double getPesoNormalMinimo() {
        return CalculosNutricion.calcularPesoMinimo(getAltura());
    }

    public double getPesoNormalMaximo() {
        return CalculosNutricion.calcularPesoMaximo(getAltura());
    }

    public String getInforme() {
        final String SEPARADOR = "----------------------------------------\n";
        StringBuilder sb = new StringBuilder();
        sb.append(
                String.format("%s %s, %.2f, %04d/%02d/%02d%n",
                        getNombre(), getApellidos(), getAltura(),
                        fechaNacimiento.getYear(),
                        fechaNacimiento.getMonthValue(),
                        fechaNacimiento.getDayOfMonth()
                )
        );
        sb.append(SEPARADOR);
        for (int i = 0; i < cantidadVisitas; i++) {
            Visita visita = visitas[i];
            LocalDate fechaVisita = visita.getFecha();
            sb.append(
                    String.format("%04d/%02d/%02d %s, %.1f Kg. %.2f%n",
                            fechaVisita.getYear(),
                            fechaVisita.getMonthValue(),
                            fechaVisita.getDayOfMonth(),
                            visita.getNombreMedico(),
                            visita.getPeso(),
                            CalculosNutricion.calcularImc(visita.getPeso(), getAltura())
                    )
            );
            sb.append(visita.getComentario());
            sb.append("\n");
            sb.append(SEPARADOR);
        }
        sb.append("FIN DEL INFORME");

        return sb.toString();
    }

}
