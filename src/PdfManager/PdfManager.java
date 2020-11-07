/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PdfManager;

import Model.PaymentConcept;
import Model.PaymentDetails;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Equipo1
 */
public class PdfManager {

    public void generateProofOfPayment(PaymentDetails paymentDetails) {
        PaymentConcept paymentConcept = paymentDetails.getPaymentConcept();
        String paymentType = paymentDetails.getPaymentType();
        
        try {
            Document doc = new Document();
            FileOutputStream fichPDF;
            String nombreArchivo = "Recibo " + paymentType + " " + paymentConcept.getIdDelEvento() + ".pdf";
            fichPDF = new FileOutputStream(nombreArchivo);
            PdfWriter.getInstance(doc, fichPDF);
            doc.open();
            Paragraph title = new Paragraph("Recibo de pago " + paymentType,
                    FontFactory.getFont("arial", 20, Font.BOLD)
            );
            title.setAlignment(Paragraph.ALIGN_CENTER);

            doc.add(title);

            Paragraph content = new Paragraph("\nConcepto de Pago: " + paymentConcept.getConceptoDePago()
                    + "\n" + "Fecha de adjudicacion: " + paymentConcept.getFechaDeAdjudicacion()
                    + "\n" + "Hora de Adjudicacion: " + paymentConcept.getHoraDeAdjudicacion()
                    + "\n" + "ID correspondiente: " + paymentConcept.getIdDelEvento()
                    + "\n" + "Tipo de Bien: " + paymentConcept.getTipoDeBien()
                    + "\n" + "El importe por el servicio es de: $" + paymentConcept.getImporteDelServicio() + "MXN",
                    FontFactory.getFont("arial", 16, Font.ITALIC)
            );
            content.setAlignment(Paragraph.ALIGN_CENTER);
            doc.add(content);
            doc.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PdfManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfManager.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
}
