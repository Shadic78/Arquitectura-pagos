/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Equipo1
 */
public class PaymentConcept {

    private String conceptoDePago;
    private String tipoDeBien;
    private String idDelEvento;
    private String fechaDeAdjudicacion;
    private String horaDeAdjudicacion;
    private double importeDelServicio;

    public PaymentConcept() {

    }

    public PaymentConcept(String conceptoDePago, String tipoDeBien, String idDelEvento, String fechaDeAdjudicacion, String horaDeAdjudicacion, double importeDelServicio) {
        this.conceptoDePago = conceptoDePago;
        this.tipoDeBien = tipoDeBien;
        this.idDelEvento = idDelEvento;
        this.fechaDeAdjudicacion = fechaDeAdjudicacion;
        this.horaDeAdjudicacion = horaDeAdjudicacion;
        this.importeDelServicio = importeDelServicio;
    }

    public String getConceptoDePago() {
        return conceptoDePago;
    }

    public double getImporteDelServicio() {
        return importeDelServicio;
    }

    public String getTipoDeBien() {
        return tipoDeBien;
    }

    public String getIdDelEvento() {
        return idDelEvento;
    }

    public String getFechaDeAdjudicacion() {
        return fechaDeAdjudicacion;
    }

    public String getHoraDeAdjudicacion() {
        return horaDeAdjudicacion;
    }

    public void setConceptoDePago(String conceptoDePago) {
        this.conceptoDePago = conceptoDePago;
    }

    public void setTipoDeBien(String tipoDeBien) {
        this.tipoDeBien = tipoDeBien;
    }

    public void setIdDelEvento(String idDelEvento) {
        this.idDelEvento = idDelEvento;
    }

    public void setFechaDeAdjudicacion(String fechaDeAdjudicacion) {
        this.fechaDeAdjudicacion = fechaDeAdjudicacion;
    }

    public void setHoraDeAdjudicacion(String horaDeAdjudicacion) {
        this.horaDeAdjudicacion = horaDeAdjudicacion;
    }

    public void setImporteDelServicio(double importeDelServicio) {
        this.importeDelServicio = importeDelServicio;
    }

    @Override
    public String toString() {
        return "PaymentConcept{" + "conceptoDePago=" + conceptoDePago + ", tipoDeBien=" + tipoDeBien + ", idDelEvento=" + idDelEvento + ", fechaDeAdjudicacion=" + fechaDeAdjudicacion + ", horaDeAdjudicacion=" + horaDeAdjudicacion + ", importeDelServicio=" + importeDelServicio + '}';
    }

}
