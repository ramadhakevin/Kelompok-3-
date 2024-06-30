package view;

import controller.Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author kevinramadha
 */
public class BLOKIV extends javax.swing.JPanel {
    private Controller controller;

    /**
     * Creates new form BLOKIV
     */
    public BLOKIV(Controller controller) {
        this.controller = controller;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BlokIV = new javax.swing.JLabel();
        CatatanjScrollPane = new javax.swing.JScrollPane();
        CatatanjTextArea = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(0, 51, 153));
        setForeground(new java.awt.Color(255, 255, 255));

        BlokIV.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        BlokIV.setForeground(new java.awt.Color(255, 255, 255));
        BlokIV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BlokIV.setText("BLOK IV. CATATAN");

        CatatanjTextArea.setColumns(20);
        CatatanjTextArea.setRows(5);
        CatatanjScrollPane.setViewportView(CatatanjTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BlokIV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(CatatanjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BlokIV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CatatanjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BlokIV;
    private javax.swing.JScrollPane CatatanjScrollPane;
    private javax.swing.JTextArea CatatanjTextArea;
    // End of variables declaration//GEN-END:variables
}
