/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import Model.PaymentConcept;
import Model.PaymentDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Equipo1
 */
public class DatabaseManager {

    private Connection conexion;
    private Statement st;
    private final String TABLE_NAME = "Payments";

    public DatabaseManager() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/modulopagos", "root", "password");
            st = conexion.createStatement();
        } catch (SQLException exOb) {
            System.out.println("Error al conectar a la base de datos");
        }
    }

    public void savePayment(PaymentDetails paymentDetails) {
        String paymentType = paymentDetails.getPaymentType();
        PaymentConcept paymentConcept = paymentDetails.getPaymentConcept();
        /*
            *Guardar el pago en la base de datos*
         */
        try {
            st.executeUpdate("INSERT INTO " + TABLE_NAME + " (paymentType, IdDelEvento, ConceptoDePago, FechaDeAdjudicacion, HoraDeAdjudicacion, TipoDeBien, ImporteDelServicio) VALUES ('" + paymentType + "','" + paymentConcept.getIdDelEvento() + "','" + paymentConcept.getConceptoDePago() + "','" + paymentConcept.getFechaDeAdjudicacion() + "','" + paymentConcept.getHoraDeAdjudicacion() + "','" + paymentConcept.getTipoDeBien() + "','" + paymentConcept.getImporteDelServicio() + "' )");
        } catch (SQLException exOb) {
            System.out.println("Error al insertar los datos en la tabla");
        }
        System.out.println("\n--- Pago almacenado en la base de datos ---");
        System.out.println("Tipo de pago: " + paymentType);
        System.out.println("Detalles de la transaccion: ");
        System.out.println("- ID del evento: " + paymentConcept.getIdDelEvento());
        System.out.println("- Concepto de pago: " + paymentConcept.getConceptoDePago());
        System.out.println("- Fecha de adjudicacion: " + paymentConcept.getFechaDeAdjudicacion());
        System.out.println("- Hora de adjudicacion: " + paymentConcept.getHoraDeAdjudicacion());
        System.out.println("- Tipo de bien: " + paymentConcept.getTipoDeBien());
        System.out.println("- Importe pagado: " + paymentConcept.getImporteDelServicio());
        System.out.println("");
    }

    public void createTable() {
        try {
            st.executeUpdate("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (paymentType VARCHAR(40), IdDelEvento VARCHAR(40), PRIMARY KEY(IdDelEvento), ConceptoDePago VARCHAR(40), FechaDeAdjudicacion VARCHAR(40), HoraDeAdjudicacion VARCHAR(40), TipoDeBien VARCHAR(40), ImporteDelServicio VARCHAR(40))");
        } catch (SQLException exOb) {
            System.out.println("Error al crear la tabla en la base de datos");
        }
    }
}
