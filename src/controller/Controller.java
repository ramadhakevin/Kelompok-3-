/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import view.*;
import model.*;


/**
 *
 * @author Bara
 */
public class Controller {
    private MainFrame mainFrame;
    private final Login loginPanel;
    private final DatabaseLogin dbLogin;
    private boolean isAdmin;
    private Petugas currentPetugas;  
    private final Insert adminDashboard;
    private final homePanel home;
    private final DatabasePetugas dbPetugas;
    private final InsertRuta pilihTempat;
    private final InsertRuta_2 insertRuta;
    private final ViewAdmin viewAdmin;
    private final DatabaseRuta dbRuta;
    private String kodeSubSLS;
    private final BlokI ketTempat;
    private final BlokII ketPetugas;
    private final BLOKIII rekapitulasi;
    private final BLOKIV catatan;
    private final BlokV daftarRuta;
    private final BlokV_A ketRuta;
    private final BlokVB rutaBaru;
    private final BlokV_2 identifikasi;
    private final BlokV_3 pertanian;
    private final BlokV_4 rutaPertanian;
    private Ruta rutaTerpilih;
    private Ruta dataRutaBaru;
    
    
    
    public Controller(){
        mainFrame = new MainFrame(this);
        loginPanel = new Login(this);
        dbLogin = new DatabaseLogin();
        dbPetugas = new DatabasePetugas();
        dbRuta = new DatabaseRuta();
        adminDashboard = new Insert(this);
        home = new homePanel(this);
        pilihTempat = new InsertRuta(this);
        insertRuta = new InsertRuta_2(this);
        viewAdmin = new ViewAdmin(this);
        ketTempat = new BlokI(this);
        ketPetugas = new BlokII(this);
        rekapitulasi = new BLOKIII(this);
        catatan = new BLOKIV(this);
        daftarRuta = new BlokV(this);
        ketRuta = new BlokV_A(this);
        rutaBaru = new BlokVB(this);
        identifikasi = new BlokV_2(this);
        pertanian = new BlokV_3(this);
        rutaPertanian = new BlokV_4(this);
    }
    
   public void start(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        mainFrame.setContentPanel(new Login(this));
    }
   
   public boolean isAdmin() {
        return isAdmin;
    }
   
   public void showLoginPanel() {
        mainFrame.setContentPanel(loginPanel);
    }
   
   public boolean validateAdmin(String username, String password) throws SQLException{
        try{
            boolean isValid = dbLogin.validateAdmin(username, password);
            if (isValid) {
                isAdmin = true;
            }
            return isValid;
        } catch(SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }    
    
    public boolean validatePetugas(String username, String password) throws SQLException{
        try{
            boolean isValid = dbLogin.validatePetugas(username, password);
            if (isValid) {
                isAdmin = false;
                currentPetugas = dbLogin.getPetugasByKode(username);
            }
            return isValid;
        } catch(SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }
    
    public Petugas getCurrentPetugas() {
        return currentPetugas;
    }
    
    public Petugas getPetugasByKode(String kode) throws SQLException {
        return dbLogin.getPetugasByKode(kode);
    }
    
    public void logout() {
        isAdmin = false;
        currentPetugas = null;
        showLoginPanel();
    }
    
    public void showAdminDashboard(){
        mainFrame.setContentPanel(adminDashboard);
    }
    
    public void showHomePanel(){
        mainFrame.setContentPanel(home);
    }
    
    public boolean addPetugas(Petugas petugas){
        return dbPetugas.addPetugas(petugas);
    }
    
    public void showPilihTempat(){
        mainFrame.setContentPanel(pilihTempat);
    }
    
    public void setKodeSubSLS(String kodeSubSLS) {
        this.kodeSubSLS = kodeSubSLS;
    }
    
    public String getKodeSubSLS() {
        return kodeSubSLS;
    }
    
    public void showInsertRuta(){
        mainFrame.setContentPanel(insertRuta);
    } 
    
    public boolean addRuta(Ruta ruta){
        return dbRuta.addRuta(ruta);
    }  
    
    public List<Petugas> getAllPetugas() {
        return dbPetugas.getAllPetugas();
    }
    
    public Petugas getRekapitulasi(String subsls){
        return dbPetugas.getRekapitulasi(subsls);
    }
    
    public void showViewAdmin(){
        viewAdmin.displayPetugas();
        mainFrame.setContentPanel(viewAdmin);
    }
    
    public void showKeteranganTempat(){
        ketTempat.setData();
        mainFrame.setContentPanel(ketTempat);
    }
    
    public void showKeteranganPetugas(){
        ketPetugas.setData();
        mainFrame.setContentPanel(ketPetugas);
    }
    
    public void showRekapitulasi(){
        rekapitulasi.setData();
        mainFrame.setContentPanel(rekapitulasi);
    }
    
    public void showCatatan(){
        mainFrame.setContentPanel(catatan);
    }
    
    public List<Ruta> getAllRutaBySubSLS(String subsls) {
        return dbRuta.getAllRutaBySubSLS(subsls);
    }
    
    public List<Ruta> getAllRutaBaruBySubSLS(String subsls) {
        return dbRuta.getAllRutaBaruBySubSLS(subsls);
    }
    
    public void showDaftarRuta(){
        daftarRuta.populateTable();
        mainFrame.setContentPanel(daftarRuta);
    }
    
    public void showKeteranganRuta(Ruta ruta){
        dataRutaBaru = null;
        this.rutaTerpilih = ruta;
        ketRuta.setRuta();
        mainFrame.setContentPanel(ketRuta);
    }
    
    public void showRutaBaru(){
        mainFrame.setContentPanel(rutaBaru);
    }
    
    public void showIdentifikasi(){
        mainFrame.setContentPanel(identifikasi);
    }
    
    public void showPertanian(){
        mainFrame.setContentPanel(pertanian);
    }
    
    public void showKRutaPertanian(){
        mainFrame.setContentPanel(rutaPertanian);
    }
    
    public void insertTanggalPetugas(Petugas petugas){
    if (dbPetugas.insertTanggal(petugas)) {
            JOptionPane.showMessageDialog(ketPetugas, "Data berhasil disimpan");
        } else {
            JOptionPane.showMessageDialog(ketPetugas, "Gagal menyimpan data");
        }
    }
    
    public Ruta getRutaTerpilih(){
        return rutaTerpilih;
    }
    
    public void setBlokVa(Ruta ruta){
        dbRuta.setBlokVa(ruta);
    }
    
    public void showBlokV2(Ruta ruta){
        this.rutaTerpilih = ruta;
        identifikasi.setIdentifikasi(rutaTerpilih);
        mainFrame.setContentPanel(identifikasi);
    }
    
    public void showBlokV3(Ruta ruta){
        this.rutaTerpilih = ruta;
        pertanian.setPertanian(rutaTerpilih);
        mainFrame.setContentPanel(pertanian);             
    }
    
    public void showBlokV4(Ruta ruta){
        this.rutaTerpilih = ruta;
        rutaPertanian.setRutaPertanian(rutaTerpilih);
        mainFrame.setContentPanel(rutaPertanian);             
    }
    
    public void setBlokVb(Ruta ruta){
        dbRuta.setBlokVb(ruta);
    }
    
    public void showBlokV2b(Ruta ruta){
        this.dataRutaBaru = ruta;
        mainFrame.setContentPanel(identifikasi);
    }
    
    public void showBlokV3b(Ruta ruta){
        this.dataRutaBaru = ruta;
        mainFrame.setContentPanel(pertanian);
    }
    
    public void showBlokV4b(Ruta ruta){
        this.dataRutaBaru = ruta;
        mainFrame.setContentPanel(rutaPertanian);
    }
    
    public Ruta getDataRutaBaru(){
        return dataRutaBaru;
    }
}

