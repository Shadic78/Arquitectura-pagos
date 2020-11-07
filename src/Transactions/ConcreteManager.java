/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transactions;

import Model.CreditCard;
import Model.PaymentConcept;
import OpenPay.OpenPay;
import Oxxo.OxxoPay;

/**
 *
 * @author Equipo1
 */
public class ConcreteManager implements PaymentManager {
    private OpenPay openPay;
    private OxxoPay oxxoPay;

    public ConcreteManager() {
        this.openPay = new OpenPay();
        this.oxxoPay = new OxxoPay();
    }

    @Override
    public boolean payWithCreditCard(PaymentConcept paymentConcept, CreditCard card) {
        boolean result = openPay.pay(paymentConcept, card);
        return result;
    }

    @Override
    public boolean payWithDeposit(PaymentConcept paymentConcept, String phoneNumber) {
        boolean result = oxxoPay.generateVoucher(paymentConcept, phoneNumber);
        return result;
    }
    
}
