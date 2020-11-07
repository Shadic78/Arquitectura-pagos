/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OpenPay;

import Model.CreditCard;
import Model.PaymentConcept;

/**
 *
 * @author Equipo1
 */
public class OpenPay {
    private OpenPayTokenizer tokenizer;
    private OpenPayPaymentProcess paymentProcess;

    public OpenPay() {
        this.tokenizer = new OpenPayTokenizer();
        this.paymentProcess = new OpenPayPaymentProcess();
    }
    
    public boolean pay(PaymentConcept paymentConcept, CreditCard card) {
        System.out.println("*** Realizando pago por OpenPay ***");
        boolean resultado = false;
        Response response = tokenizer.tokenizeCard(card);
        
        if(!response.getStatus().equals("Error")) {
            System.out.println("Token OpenPay creado: " + response.getToken().getId());
            
            CardCharge charge = new CardCharge(response.getToken().getId(), paymentConcept.getImporteDelServicio(), paymentConcept.getConceptoDePago());     
            resultado = paymentProcess.createCharge(charge);
        }
        else {
            System.out.println("-- Error de token --");
            System.out.println("- Descripcion: " + response.getDescription());
        }
                             
        return resultado;
    }
}
