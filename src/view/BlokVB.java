package view;

import controller.Controller;
import javax.swing.JOptionPane;
import model.Petugas;
import model.Ruta;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */


/**
 *
 * @author Bara
 */
public class BlokVB extends javax.swing.JPanel {
    private Controller controller;

    /**
     * Creates new form BlokV_1
     */
    public BlokVB(Controller controller) {
        this.controller = controller;
        initComponents();
        Keluarga.setText("2");
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        noBTT = new javax.swing.JTextField();
        jumlahPetani = new javax.swing.JTextField();
        Keluarga = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        noUrutKeluarga = new javax.swing.JTextField();
        nik = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        namaKK = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));

        blokIII1.setFont(new java.awt.Font("Helvetica", 1, 18)); // NOI18N
        blokIII1.setForeground(new java.awt.Color(255, 255, 255));
        blokIII1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blokIII1.setText("BLOK VB. KETERANGAN KELUARGA / RUMAH TANGGA  (1-5) (Tambahan)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 897, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(blokIII1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(27, Short.MAX_VALUE)))
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
        jLabel2.setText("(1)   No. Urut Kelurga:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 432, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("(2)   Nama Kepala Keluarga (KK)/Nama Anggota Keluarga Lainnya:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 432, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        jLabel4.setText("(3)    Alamat:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 432, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        jLabel5.setText("(4)    No. Urut Bangunan Tempat Tinggal:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 432, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        jLabel6.setText("(4a)  Jumlah Petani Pemilik/Penggarap/Buruh");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 377, -1));

        jLabel7.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        jLabel7.setText("(5)    Keberadaan Keluarga:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 432, -1));
        add(noBTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 279, -1));
        add(jumlahPetani, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 279, -1));

        Keluarga.setEditable(false);
        add(Keluarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 279, -1));

        jButton1.setBackground(new java.awt.Color(0, 51, 153));
        jButton1.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 400, 94, 34));

        alamat.setColumns(20);
        alamat.setRows(5);
        jScrollPane1.setViewportView(alamat);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 279, 103));
        add(noUrutKeluarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 279, -1));
        add(nik, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 279, -1));

        jLabel8.setFont(new java.awt.Font("Helvetica", 0, 13)); // NOI18N
        jLabel8.setText("NIK");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 390, -1));
        add(namaKK, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 279, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Petugas currentPetugas = controller.getCurrentPetugas();
        Ruta ruta = new Ruta();
        ruta.setKodeSubsls(currentPetugas.getKodeSubSLS());
        if(noUrutKeluarga.getText().isEmpty() || namaKK.getText().isEmpty() || nik.getText().isEmpty() || alamat.getText().isEmpty() || noBTT.getText().isEmpty() || jumlahPetani.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Semua data harus terisi!", "Pesan", JOptionPane.WARNING_MESSAGE);
            return;
        }else{
            if(isNotInteger(noUrutKeluarga.getText())){
                JOptionPane.showMessageDialog(this, "Form no.(1) harus berupa angka!", "Pesan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(isNotInteger(nik.getText())){
                JOptionPane.showMessageDialog(this, "Form NIK harus berupa angka!", "Pesan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(isNotInteger(noBTT.getText())){
                JOptionPane.showMessageDialog(this, "Form no.(4) harus berupa angka!", "Pesan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if(isNotInteger(jumlahPetani.getText())){
                JOptionPane.showMessageDialog(this, "Form no.(4a) harus berupa angka!", "Pesan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            ruta.setUrutKk(Integer.parseInt(noUrutKeluarga.getText()));
            ruta.setNamakkLainnya(namaKK.getText());
            ruta.setNik(nik.getText());
            ruta.setAlamat(alamat.getText());
            ruta.setUrutBtt(Integer.parseInt(noBTT.getText()));
            ruta.setJlhPetani(Integer.parseInt(jumlahPetani.getText()));
            ruta.setKeberadaan("2");
            
            controller.showBlokV2b(ruta); 
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Keluarga;
    private javax.swing.JTextArea alamat;
    private javax.swing.JLabel blokIII1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahPetani;
    private javax.swing.JTextField namaKK;
    private javax.swing.JTextField nik;
    private javax.swing.JTextField noBTT;
    private javax.swing.JTextField noUrutKeluarga;
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
