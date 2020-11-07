/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transactions;

import Model.CreditCard;
import Model.PaymentConcept;

/**
 *
 * @author Equipo1
 */
public interface PaymentManager {
    
    public boolean payWithCreditCard(PaymentConcept paymentConcept, CreditCard card);
    
    public boolean payWithDeposit(PaymentConcept paymentConcept, String phoneNumber);
    
}
