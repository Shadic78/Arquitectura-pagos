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
public class CreditCard {
    private String cardNumber;
    private String nombreTarjetaHabiente;
    private String mesDeExpiracion;
    private String anioDeExpiracion;
    private String cvc;
    private String numeroTelefonico;

    public CreditCard() {
    }

    public CreditCard(String cardNumber, String nombreTarjetaHabiente, String mesDeExpiracion, String anioDeExpiracion, String cvc, String numeroTelefonico) {
        this.cardNumber = cardNumber;
        this.nombreTarjetaHabiente = nombreTarjetaHabiente;
        this.mesDeExpiracion = mesDeExpiracion;
        this.anioDeExpiracion = anioDeExpiracion;
        this.cvc = cvc;
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNombreTarjetaHabiente() {
        return nombreTarjetaHabiente;
    }

    public void setNombreTarjetaHabiente(String nombreTarjetaHabiente) {
        this.nombreTarjetaHabiente = nombreTarjetaHabiente;
    }

    public String getMesDeExpiracion() {
        return mesDeExpiracion;
    }

    public void setMesDeExpiracion(String mesDeExpiracion) {
        this.mesDeExpiracion = mesDeExpiracion;
    }

    public String getAnioDeExpiracion() {
        return anioDeExpiracion;
    }

    public void setAnioDeExpiracion(String anioDeExpiracion) {
        this.anioDeExpiracion = anioDeExpiracion;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
    
    
}
