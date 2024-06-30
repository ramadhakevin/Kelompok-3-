/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Ruta;

/**
 *
 * @author Bara
 */
public class BlokV_2 extends javax.swing.JPanel {
    private Controller controller;
    private Ruta rutaTerpilih = new Ruta();

    /**
     * Creates new form BlokV_2
     */
    public BlokV_2(Controller controller) {
        this.controller = controller;
        initComponents();
        
        keteranganKRT.setVisible(false);
        namaKRT.setVisible(false);
        identifikasiKkKrt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (identifikasiKkKrt.getSelectedItem().equals("Pilih identifikasi KK/KRT") || identifikasiKkKrt.getSelectedItem().equals("KK sekaligus KRT")) {
                    keteranganKRT.setVisible(false);
                    namaKRT.setVisible(false);
                }else{
                    keteranganKRT.setVisible(true);
                    namaKRT.setVisible(true);
                }
            }
        });
    }
    
    public void setIdentifikasi(Ruta ruta){
            this.rutaTerpilih = controller.getRutaTerpilih();
            jumlahPengPangan.setText(String.valueOf(rutaTerpilih.getJlhPengelolaan()));
            if(rutaTerpilih.getUrutRuta()!=0){
                noRUTA.setText(String.valueOf(rutaTerpilih.getUrutRuta()));
            }
            if(rutaTerpilih.getIdenKkKrt()!=null){
                if(rutaTerpilih.getIdenKkKrt().equals("KK")){
                    identifikasiKkKrt.setSelectedItem("Kepala Keluarga (KK)");
                    keteranganKRT.setVisible(true);
                    namaKRT.setVisible(true);
                    if(rutaTerpilih.getNamaKrt()!=null){
                        namaKRT.setText(rutaTerpilih.getNamaKrt());
                    }
                }
                if(rutaTerpilih.getIdenKkKrt().equals("KRT")){
                    identifikasiKkKrt.setSelectedItem("Kepala Rumah Tangga (KRT)");
                    keteranganKRT.setVisible(true);
                    namaKRT.setVisible(true);
                    if(rutaTerpilih.getNamaKrt()!=null){
                        namaKRT.setText(rutaTerpilih.getNamaKrt());
                    }
                }
                if(rutaTerpilih.getIdenKkKrt().equals("KK dan KRT")){
                    identifikasiKkKrt.setSelectedItem("KK sekaligus KRT");
                }
            }else{
                identifikasiKkKrt.setSelectedItem("Pilih identifikasi KK/KRT");
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        blokIII1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        keteranganKRT = new javax.swing.JLabel();
        jumlahPengPangan = new javax.swing.JTextField();
        noRUTA = new javax.swing.JTextField();
        namaKRT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        identifikasiKkKrt = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));

        blokIII1.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        blokIII1.setForeground(new java.awt.Color(255, 255, 255));
        blokIII1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blokIII1.setText("BLOK V. KETERANGAN KELUARGA / RUMAH TANGGA  (6-9)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 897, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(blokIII1, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(blokIII1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        jLabel2.setText("(6)    Jumlah Pengelolaan Makan/Minum dan Kebutuhan dalam Keluarga");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 62, 435, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        jLabel5.setText("(7)    No. Urut Rumah Tangga");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 102, 435, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        jLabel6.setText("(8)    Identifikasi KK/KRT");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 142, 435, -1));

        keteranganKRT.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        keteranganKRT.setText("(9)    Nama Kepala Rumah Tangga (KRT)");
        add(keteranganKRT, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 182, 435, -1));
        add(jumlahPengPangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 60, 246, -1));
        add(noRUTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 100, 246, -1));
        add(namaKRT, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 180, 246, -1));

        jButton1.setBackground(new java.awt.Color(0, 51, 153));
        jButton1.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 94, 34));

        identifikasiKkKrt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih identifikasi KK/KRT", "Kepala Keluarga (KK)", "Kepala Rumah Tangga (KRT)", "KK sekaligus KRT", " " }));
        identifikasiKkKrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identifikasiKkKrtActionPerformed(evt);
            }
        });
        add(identifikasiKkKrt, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 140, 246, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        if(jumlahPengPangan.getText().isEmpty() || noRUTA.getText().isEmpty() || identifikasiKkKrt.getSelectedItem().equals("Pilih identifikasi KK/KRT")){
            JOptionPane.showMessageDialog(this, "Semua data harus terisi!", "Pesan", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
            if(isNotInteger(jumlahPengPangan.getText())){
                JOptionPane.showMessageDialog(this, "Form no.(6) harus berupa angka!", "Pesan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(isNotInteger(noRUTA.getText())){
                JOptionPane.showMessageDialog(this, "Form no.(7) harus berupa angka!", "Pesan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(identifikasiKkKrt.getSelectedItem().equals("Kepala Keluarga (KK)") || identifikasiKkKrt.getSelectedItem().equals("Kepala Rumah Tangga (KRT)")){
                if(namaKRT.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, "Form no.(9) harus terisi!", "Pesan", JOptionPane.WARNING_MESSAGE);
                    return; 
                }
            }
            
            rutaTerpilih.setJlhPengelolaan(Integer.parseInt(jumlahPengPangan.getText()));
            rutaTerpilih.setUrutRuta(Integer.parseInt(noRUTA.getText()));
            if(identifikasiKkKrt.getSelectedItem().equals("Kepala Keluarga (KK)")) {
                rutaTerpilih.setIdenKkKrt("KK");
                rutaTerpilih.setNamaKrt(namaKRT.getText());
            } 
            if(identifikasiKkKrt.getSelectedItem().equals("Kepala Rumah Tangga (KRT)")) {
                rutaTerpilih.setIdenKkKrt("KRT");
                rutaTerpilih.setNamaKrt(namaKRT.getText());
            } 
            if(identifikasiKkKrt.getSelectedItem().equals("KK sekaligus KRT")) {
                rutaTerpilih.setIdenKkKrt("KK dan KRT");
                rutaTerpilih.setNamaKrt(null);
            }
 
            if(controller.getDataRutaBaru()!=null){    
                Ruta rutaBaru = controller.getDataRutaBaru();
                rutaBaru.setJlhPengelolaan(Integer.parseInt(jumlahPengPangan.getText()));
                rutaBaru.setUrutRuta(Integer.parseInt(noRUTA.getText()));
                if(identifikasiKkKrt.getSelectedItem().equals("Kepala Keluarga (KK)")) {
                    rutaBaru.setIdenKkKrt("KK");
                    rutaBaru.setNamaKrt(namaKRT.getText());
                } 
                if(identifikasiKkKrt.getSelectedItem().equals("Kepala Rumah Tangga (KRT)")) {
                    rutaBaru.setIdenKkKrt("KRT");
                    rutaBaru.setNamaKrt(namaKRT.getText());
                } 
                if(identifikasiKkKrt.getSelectedItem().equals("KK sekaligus KRT")) {
                    rutaBaru.setIdenKkKrt("KK dan KRT");
                    rutaBaru.setNamaKrt(null);
                }
                if(Integer.parseInt(jumlahPengPangan.getText()) == 0){
                    controller.setBlokVb(rutaBaru);
                    controller.showDaftarRuta();
                }else{
                    controller.showBlokV3b(rutaBaru);
                }
            }else{
                if(Integer.parseInt(jumlahPengPangan.getText()) == 0){
                    controller.setBlokVa(rutaTerpilih);
                    controller.showDaftarRuta();
                }else{
                    controller.showBlokV3(rutaTerpilih);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void identifikasiKkKrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identifikasiKkKrtActionPerformed
        
    }//GEN-LAST:event_identifikasiKkKrtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blokIII1;
    private javax.swing.JComboBox<String> identifikasiKkKrt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jumlahPengPangan;
    private javax.swing.JLabel keteranganKRT;
    private javax.swing.JTextField namaKRT;
    private javax.swing.JTextField noRUTA;
    // End of variables declaration//GEN-END:variables

    public boolean isNotInteger(String text) {
        try {
            Integer.parseInt(text);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}
