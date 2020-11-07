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
public class PaymentDetails {
    private PaymentConcept paymentConcept;
    private String paymentType;

    public PaymentDetails(PaymentConcept paymentConcept, String paymentType) {
        this.paymentConcept = paymentConcept;
        this.paymentType = paymentType;
    }

    public PaymentConcept getPaymentConcept() {
        return paymentConcept;
    }

    public String getPaymentType() {
        return paymentType;
    }
    
}
