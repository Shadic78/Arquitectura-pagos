/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Equipo1
 */
public class PanelOxxoPayment extends javax.swing.JPanel {

    /**
     * Creates new form PanelOxxoPayment
     */
    public PanelOxxoPayment() {
        initComponents();
    }

    public JButton getBtnPagarOxxo() {
        return btnPagarOxxo;
    }

    public void setBtnPagarOxxo(JButton btnPagarOxxo) {
        this.btnPagarOxxo = btnPagarOxxo;
    }

    public JTextField getTxtNumeroTelefonico() {
        return txtNumeroTelefonico;
    }

    public void setTxtNumeroTelefonico(JTextField txtNumeroTelefonico) {
        this.txtNumeroTelefonico = txtNumeroTelefonico;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNumeroTelefonico = new javax.swing.JTextField();
        btnPagarOxxo = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Oxxo"));
        setPreferredSize(new java.awt.Dimension(555, 202));

        jLabel1.setText("Número telefonico");

        btnPagarOxxo.setText("Generar comprobante");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtNumeroTelefonico, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPagarOxxo))
                .addContainerGap(334, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroTelefonico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPagarOxxo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagarOxxo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtNumeroTelefonico;
    // End of variables declaration//GEN-END:variables
}