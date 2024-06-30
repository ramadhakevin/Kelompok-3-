package view;

import controller.Controller;
import database.DatabaseRuta;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author kevinramadha
 */
public class InsertRuta extends javax.swing.JPanel {
    private Controller controller;

    /**
     * Creates new form Insert
     */
    public InsertRuta(Controller controller) {
        this.controller = controller;
        initComponents();
        initListeners();
        loadProvinsiComboBox();
    }
    
    private void initListeners() {
        provinsiComboBox.addActionListener((ActionEvent e) -> updateKabupatenComboBox());
        kabupatenComboBox.addActionListener((ActionEvent e) -> updateKecamatanComboBox());
        kecamatanComboBox.addActionListener((ActionEvent e) -> updateDesaComboBox());
        desaComboBox.addActionListener((ActionEvent e) -> updateSLSComboBox());
        slsComboBox.addActionListener((ActionEvent e) -> updateSubSLSComboBox());
    }
    
    private void updateKabupatenComboBox() {
        String selectedProvinsi = (String) provinsiComboBox.getSelectedItem();
        if (selectedProvinsi != null) {
            try {
                DatabaseRuta dbRuta = new DatabaseRuta();
                String idProvinsi = dbRuta.getIdProvinsiByName(selectedProvinsi);
                List<String> kabupatenList = DatabaseRuta.getKabupatenByProvinsi(idProvinsi);
                kabupatenComboBox.setModel(new DefaultComboBoxModel<>(kabupatenList.toArray(new String[0])));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error retrieving data from database: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void updateKecamatanComboBox() {
        String selectedKabupaten = (String) kabupatenComboBox.getSelectedItem();
        if (selectedKabupaten != null) {
            try {
                DatabaseRuta dbRuta = new DatabaseRuta();
                String idKabupaten = dbRuta.getIdKabupatenByName(selectedKabupaten);
                List<String> kecamatanList = DatabaseRuta.getKecamatanByKabupaten(idKabupaten);
                kecamatanComboBox.setModel(new DefaultComboBoxModel<>(kecamatanList.toArray(new String[0])));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error retrieving data from database: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void updateDesaComboBox() {
        String selectedKecamatan = (String) kecamatanComboBox.getSelectedItem();
        if (selectedKecamatan != null) {
            try {
                DatabaseRuta dbRuta = new DatabaseRuta();
                String idKecamatan = dbRuta.getIdKecamatanByName(selectedKecamatan);
                List<String> desaList = DatabaseRuta.getDesaByKecamatan(idKecamatan);
                desaComboBox.setModel(new DefaultComboBoxModel<>(desaList.toArray(new String[0])));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error retrieving data from database: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void updateSLSComboBox() {
        String selectedDesa = (String) desaComboBox.getSelectedItem();
        if (selectedDesa != null) {
            try {
                DatabaseRuta dbRuta = new DatabaseRuta();
                String idDesa = dbRuta.getIdDesaByName(selectedDesa);
                List<String> slsList = DatabaseRuta.getSLSByDesa(idDesa);
                slsComboBox.setModel(new DefaultComboBoxModel<>(slsList.toArray(new String[0])));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error retrieving data from database: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void updateSubSLSComboBox() {
        String selectedSLS = (String) slsComboBox.getSelectedItem();
        if (selectedSLS != null) {
            try {
                DatabaseRuta dbRuta = new DatabaseRuta();
                String idSLS = dbRuta.getIdSLSByName(selectedSLS);
                List<String> subslsList = DatabaseRuta.getSubSLSBySLS(idSLS);
                subSLSComboBox.setModel(new DefaultComboBoxModel<>(subslsList.toArray(new String[0])));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error retrieving data from database: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void loadProvinsiComboBox() {
        try {
            List<String> provinsiList = DatabaseRuta.getAllProvinsi();
            provinsiComboBox.setModel(new DefaultComboBoxModel<>(provinsiList.toArray(new String[0])));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading provinsi data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
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

        AdminPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        MenuPanel = new javax.swing.JPanel();
        InsertButton3 = new javax.swing.JButton();
        tambahButton1 = new javax.swing.JButton();
        viewButton1 = new javax.swing.JButton();
        LogoutButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        AdminPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        MenuPanel1 = new javax.swing.JPanel();
        InsertButton2 = new javax.swing.JButton();
        tambahButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        viewButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        provinsiComboBox = new javax.swing.JComboBox<>();
        kabupatenComboBox = new javax.swing.JComboBox<>();
        kecamatanComboBox = new javax.swing.JComboBox<>();
        desaComboBox = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        slsComboBox = new javax.swing.JComboBox<>();
        subSLSComboBox = new javax.swing.JComboBox<>();
        nextButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(875, 537));

        AdminPanel.setBackground(new java.awt.Color(0, 51, 153));

        jLabel2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADMIN - INSERT RUTA");

        javax.swing.GroupLayout AdminPanelLayout = new javax.swing.GroupLayout(AdminPanel);
        AdminPanel.setLayout(AdminPanelLayout);
        AdminPanelLayout.setHorizontalGroup(
            AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminPanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                .addContainerGap())
        );
        AdminPanelLayout.setVerticalGroup(
            AdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
        );

        MenuPanel.setBackground(new java.awt.Color(0, 51, 153));
        MenuPanel.setPreferredSize(new java.awt.Dimension(131, 319));

        InsertButton3.setText("Insert/Save");
        InsertButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertButton3ActionPerformed(evt);
            }
        });

        tambahButton1.setText("Tambah Petugas");
        tambahButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButton1ActionPerformed(evt);
            }
        });

        viewButton1.setText("View");
        viewButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButton1ActionPerformed(evt);
            }
        });

        LogoutButton1.setText("Logout");
        LogoutButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButton1ActionPerformed(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectkelompok3/Logo (4).png"))); // NOI18N

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel14)
                        .addGap(21, 21, 21))
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tambahButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(viewButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LogoutButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(InsertButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(InsertButton3)
                .addGap(18, 18, 18)
                .addComponent(tambahButton1)
                .addGap(18, 18, 18)
                .addComponent(viewButton1)
                .addGap(18, 18, 18)
                .addComponent(LogoutButton1)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        AdminPanel1.setBackground(new java.awt.Color(0, 51, 153));

        jLabel3.setBackground(new java.awt.Color(51, 102, 255));
        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ADMIN DASHBOARD");

        javax.swing.GroupLayout AdminPanel1Layout = new javax.swing.GroupLayout(AdminPanel1);
        AdminPanel1.setLayout(AdminPanel1Layout);
        AdminPanel1Layout.setHorizontalGroup(
            AdminPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                .addContainerGap())
        );
        AdminPanel1Layout.setVerticalGroup(
            AdminPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
        );

        MenuPanel1.setBackground(new java.awt.Color(0, 51, 153));

        InsertButton2.setText("Insert/Save");
        InsertButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertButton2ActionPerformed(evt);
            }
        });

        tambahButton.setText("Tambahkan Ruta");
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectkelompok3/Logo (4).png"))); // NOI18N

        viewButton.setText("View");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        LogoutButton.setText("Logout");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuPanel1Layout = new javax.swing.GroupLayout(MenuPanel1);
        MenuPanel1.setLayout(MenuPanel1Layout);
        MenuPanel1Layout.setHorizontalGroup(
            MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InsertButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tambahButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LogoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(MenuPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuPanel1Layout.setVerticalGroup(
            MenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(InsertButton2)
                .addGap(18, 18, 18)
                .addComponent(tambahButton)
                .addGap(18, 18, 18)
                .addComponent(viewButton)
                .addGap(18, 18, 18)
                .addComponent(LogoutButton)
                .addContainerGap(260, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PILIH TEMPAT");

        jLabel9.setText("Provinsi");

        jLabel10.setText("Kabupaten/kota");

        jLabel11.setText("Kecamatan");

        jLabel13.setText("Desa/Kelurahan");

        jLabel15.setText("SLS");

        jLabel16.setText("Sub SLS");

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(MenuPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AdminPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nextButton)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(provinsiComboBox, 0, 322, Short.MAX_VALUE)
                                    .addComponent(kabupatenComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(kecamatanComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(desaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(slsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(subSLSComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(91, 91, 91))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(AdminPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(provinsiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(kabupatenComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(kecamatanComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(desaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(slsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(subSLSComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(nextButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AdminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void InsertButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InsertButton3ActionPerformed

    private void tambahButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButton1ActionPerformed
        // TODO add your handling code here:
        controller.showAdminDashboard();
    }//GEN-LAST:event_tambahButton1ActionPerformed

    private void viewButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButton1ActionPerformed
        // TODO add your handling code here:
        controller.showViewAdmin();
    }//GEN-LAST:event_viewButton1ActionPerformed

    private void LogoutButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButton1ActionPerformed
        // TODO add your handling code here:
        controller.logout();
    }//GEN-LAST:event_LogoutButton1ActionPerformed

    private void InsertButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InsertButton2ActionPerformed

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        String namaSLS = (String) slsComboBox.getSelectedItem();
        String kodeSubSLS = (String) subSLSComboBox.getSelectedItem();
    
        if (namaSLS != null && kodeSubSLS != null) {
            try {
                DatabaseRuta dbRuta = new DatabaseRuta();
                String kodeSLS = dbRuta.getIdSLSByName(namaSLS);
            
                if (kodeSLS != null) {
                    kodeSubSLS = kodeSLS + kodeSubSLS;
                    controller.setKodeSubSLS(kodeSubSLS);
                    controller.showInsertRuta();
                } else {
                    JOptionPane.showMessageDialog(this, "SLS code not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Unexpected error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select both SLS and Sub SLS", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_nextButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdminPanel;
    private javax.swing.JPanel AdminPanel1;
    private javax.swing.JButton InsertButton2;
    private javax.swing.JButton InsertButton3;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton LogoutButton1;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JPanel MenuPanel1;
    private javax.swing.JComboBox<String> desaComboBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> kabupatenComboBox;
    private javax.swing.JComboBox<String> kecamatanComboBox;
    private javax.swing.JButton nextButton;
    private javax.swing.JComboBox<String> provinsiComboBox;
    private javax.swing.JComboBox<String> slsComboBox;
    private javax.swing.JComboBox<String> subSLSComboBox;
    private javax.swing.JButton tambahButton;
    private javax.swing.JButton tambahButton1;
    private javax.swing.JButton viewButton;
    private javax.swing.JButton viewButton1;
    // End of variables declaration//GEN-END:variables
}
