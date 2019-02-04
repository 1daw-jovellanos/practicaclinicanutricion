/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclinicanutricion;

import java.time.LocalDate;

public class Visita {

    private java.time.LocalDate fecha;
    private String nombreMedico;
    private String comentario;
    private double peso;

    public Visita(LocalDate fecha, String nombreMedico, String comentario, double peso) {
        this.fecha = fecha;
        this.nombreMedico = nombreMedico;
        this.comentario = comentario;
        this.peso = peso;
    }

    public java.time.LocalDate getFecha() {
        return fecha;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public String getComentario() {
        return comentario;
    }

    public double getPeso() {
        return peso;
    }

 
}
