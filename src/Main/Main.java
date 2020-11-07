/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DBManager.DatabaseManager;
import Model.CreditCard;
import Model.PaymentConcept;
import Model.PaymentDetails;
import PdfManager.PdfManager;
import Transactions.ConcreteManager;
import Transactions.PaymentManager;
import View.PaymentForm;
import ViewController.PaymentFormController;

/**
 *
 * @author Equipo1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Concepto de pago para OpenPay
        PaymentConcept paymentConceptOpenPay = new PaymentConcept();
        paymentConceptOpenPay.setConceptoDePago("Realizacion de un evento de subasta");
        paymentConceptOpenPay.setFechaDeAdjudicacion("2020-11-04");
        paymentConceptOpenPay.setHoraDeAdjudicacion("6:00 PM");
        paymentConceptOpenPay.setIdDelEvento("MXN371699664762");
        paymentConceptOpenPay.setImporteDelServicio(35);
        paymentConceptOpenPay.setTipoDeBien("Correo");

        // Concepto de pago para OXXO
        PaymentConcept paymentConceptOxxo = new PaymentConcept();
        paymentConceptOxxo.setConceptoDePago("Publicacion de una casa");
        paymentConceptOxxo.setFechaDeAdjudicacion("2020-10-2");
        paymentConceptOxxo.setHoraDeAdjudicacion("17:34 PM");
        paymentConceptOxxo.setIdDelEvento("MXN942399614778");
        paymentConceptOxxo.setImporteDelServicio(25);
        paymentConceptOxxo.setTipoDeBien("Correo");

        PaymentManager paymentManager = new ConcreteManager();

        PaymentForm form = new PaymentForm();
        PaymentFormController paymentFormController = new PaymentFormController(form, paymentManager, paymentConceptOpenPay);
        form.setVisible(true);

    }

}
