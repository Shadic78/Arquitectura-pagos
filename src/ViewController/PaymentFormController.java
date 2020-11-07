/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import DBManager.DatabaseManager;
import Model.CreditCard;
import Model.PaymentConcept;
import Model.PaymentDetails;
import PdfManager.PdfManager;
import Transactions.PaymentManager;
import View.PanelOpenPayPayment;
import View.PanelOxxoPayment;
import View.PaymentForm;
import View.themes.ViewThemeManager;
import View.themes.ViewThemes;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Equipo1
 */
public class PaymentFormController {

    private PaymentForm form;
    private PanelOxxoPayment panelOxxoPayment;
    private PanelOpenPayPayment panelOpenPayPayment;
    private PaymentManager paymentManager;
    private DatabaseManager dbManager;
    private PdfManager pdfManager;
    private PaymentConcept paymentConcept;
    private ViewThemes currentFormTheme;

    public PaymentFormController(PaymentForm form, PaymentManager paymentManager, PaymentConcept paymentConcept) {
        this.form = form;
        this.paymentManager = paymentManager;
        this.paymentConcept = paymentConcept;
        initComponents();
    }

    private void initComponents() {
        currentFormTheme = ViewThemes.DEFAULT_THEME;
        ViewThemeManager.changeViewTheme(form, currentFormTheme);
        
        dbManager = new DatabaseManager();
        dbManager.createTable();

        pdfManager = new PdfManager();

        panelOpenPayPayment = new PanelOpenPayPayment();
        panelOxxoPayment = new PanelOxxoPayment();

        form.getBtnMetodoOpenPay().addActionListener(this::setOpenPayForm);
        form.getBtnMetodoOxxo().addActionListener(this::setOxxoForm);

        form.getBtnCambiarEstilo().addActionListener(this::changeFormStyle);

        panelOpenPayPayment.getBtnPagarOpenPay().addActionListener(this::payWithOpenPay);
        panelOxxoPayment.getBtnPagarOxxo().addActionListener(this::payWithOxxo);

        loadPanel(panelOpenPayPayment);
        loadPaymentConcept(paymentConcept);
    }

    private void changeFormStyle(ActionEvent e) {
        switch (currentFormTheme) {
            case DEFAULT_THEME:
                currentFormTheme = ViewThemes.DARK_THEME;
                break;
            case DARK_THEME:
                currentFormTheme = ViewThemes.DEFAULT_THEME;
                break;
            default:
                System.out.println("Error choosing theme");
        }
        ViewThemeManager.changeViewTheme(form, currentFormTheme);
    }

    private void setOpenPayForm(ActionEvent e) {
        loadPanel(panelOpenPayPayment);
    }

    private void setOxxoForm(ActionEvent e) {
        loadPanel(panelOxxoPayment);
    }

    private void payWithOpenPay(ActionEvent e) {
        CreditCard card = createCardFromForm(panelOpenPayPayment);

        boolean pagoRealizadoOpenPay = paymentManager.payWithCreditCard(paymentConcept, card);

        if (pagoRealizadoOpenPay) {
            PaymentDetails paymentDetailsOpenPay = new PaymentDetails(paymentConcept, "OpenPay");

            // Generar comprobante en PDF
            pdfManager.generateProofOfPayment(paymentDetailsOpenPay);

            // Guardar el pago en la BD
            dbManager.savePayment(paymentDetailsOpenPay);

            JOptionPane.showMessageDialog(null, "Pago por OpenPay realizado correctamente");
        } else {
            System.out.println("Hubo un error al realizar el pago");
        }
    }

    private void payWithOxxo(ActionEvent e) {
        String phoneNumber = panelOxxoPayment.getTxtNumeroTelefonico().getText();

        boolean pagoRealizadoOxxo = paymentManager.payWithDeposit(paymentConcept, phoneNumber);

        if (pagoRealizadoOxxo) {
            PaymentDetails paymentDetailsOxxo = new PaymentDetails(paymentConcept, "Oxxo");

            // Generar comprobante en PDF
            pdfManager.generateProofOfPayment(paymentDetailsOxxo);

            // Guardar el pago en la BD
            dbManager.savePayment(paymentDetailsOxxo);

            JOptionPane.showMessageDialog(null, "Comprobante de pago por Oxxo generado correctamente");
        } else {
            System.out.println("Hubo un error al realizar el pago");
        }
    }

    private CreditCard createCard(String cardNumber, String anioExpiracion, String mesExpiracion, String cvc,
            String nombreTarjetahabiente, String numeroTelefonico) {

        CreditCard card = new CreditCard();
        card.setCardNumber(cardNumber);
        card.setAnioDeExpiracion(anioExpiracion);
        card.setMesDeExpiracion(mesExpiracion);
        card.setCvc(cvc);
        card.setNombreTarjetaHabiente(nombreTarjetahabiente);
        card.setNumeroTelefonico(numeroTelefonico);

        return card;
    }

    private CreditCard createCardFromForm(PanelOpenPayPayment panel) {
        String cardNumber = panel.getTxtNumTarjeta().getText();
        String anioExpiracion = panel.getTxtAnioExpiracion().getText();
        String mesExpiracion = panel.getTxtMesExpiracion().getText();
        String cvc = panel.getTxtCvc().getText();
        String nombreTarjetaHabiente = panel.getTxtNombre().getText();
        String numeroTelefonico = panel.getTxtNumeroTelefonico().getText();

        CreditCard card = createCard(cardNumber, anioExpiracion, mesExpiracion, cvc,
                nombreTarjetaHabiente, numeroTelefonico);

        return card;
    }

    private void loadPanel(JPanel panel) {
        form.getPanelPaymentForm().removeAll();
        form.getPanelPaymentForm().setLayout(new BorderLayout());
        form.getPanelPaymentForm().add(panel, BorderLayout.CENTER);
        form.getPanelPaymentForm().validate();
        form.getPanelPaymentForm().repaint();
        
        ViewThemeManager.changeViewTheme(form, currentFormTheme);
    }

    private void loadPaymentConcept(PaymentConcept paymentConcept) {
        String conceptoDePago = paymentConcept.getConceptoDePago();
        String tipoDeBien = paymentConcept.getTipoDeBien();
        String idDelEvento = paymentConcept.getIdDelEvento();
        String fechaDeAdjudicacion = paymentConcept.getFechaDeAdjudicacion();
        String horaDeAdjudicacion = paymentConcept.getHoraDeAdjudicacion();
        double importeDelServicio = paymentConcept.getImporteDelServicio();

        form.getLbConceptoDePago().setText(conceptoDePago);
        form.getLbTipoDeBien().setText(tipoDeBien);
        form.getLbIdDelEvento().setText(idDelEvento);
        form.getLbFecha().setText(fechaDeAdjudicacion);
        form.getLbHora().setText(horaDeAdjudicacion);
        form.getLbImporte().setText(Double.toString(importeDelServicio));
    }

}
