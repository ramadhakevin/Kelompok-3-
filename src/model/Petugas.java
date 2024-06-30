package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDate;

public class Petugas {
    private String kode;
    private String nama;
    private String password;
    private String kategori;
    private LocalDate tanggal;
    private String namaProvinsi;
    private String namaKabupaten;
    private String namaKecamatan;
    private String namaDesa;
    private String kodeSLS;
    private String namaSLS;
    private String kodeSubSLS;
    private int sebelum;
    private int sesudah;
    private int tanamanPangan;
    private int hortikultura;
    private int perkebunan;
    private int peternakan;
    private int perikanan;
    private int kehutanan;
    private int jasaPertanian;
    private int jumlahArtPertanian;
    private int jlhRutaPertanian;
    private int noUrutTerbesar;
    private int perkiraanHasil;

    // Getters and Setters

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setKategori(String kategori){
        this.kategori = kategori;
    }
    
    public String getKategori(){
        return kategori;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public String getNamaProvinsi() {
        return namaProvinsi;
    }

    public void setNamaProvinsi(String namaProvinsi) {
        this.namaProvinsi = namaProvinsi;
    }

    public String getNamaKabupaten() {
        return namaKabupaten;
    }

    public void setNamaKabupaten(String namaKabupaten) {
        this.namaKabupaten = namaKabupaten;
    }

    public String getNamaKecamatan() {
        return namaKecamatan;
    }

    public void setNamaKecamatan(String namaKecamatan) {
        this.namaKecamatan = namaKecamatan;
    }

    public String getNamaDesa() {
        return namaDesa;
    }

    public void setNamaDesa(String namaDesa) {
        this.namaDesa = namaDesa;
    }

    public String getKodeSLS() {
        return kodeSLS;
    }

    public void setKodeSLS(String kodeSLS) {
        this.kodeSLS = kodeSLS;
    }

    public String getNamaSLS() {
        return namaSLS;
    }

    public void setNamaSLS(String namaSLS) {
        this.namaSLS = namaSLS;
    }

    public String getKodeSubSLS() {
        return kodeSubSLS;
    }

    public void setKodeSubSLS(String kodeSubSLS) {
        this.kodeSubSLS = kodeSubSLS;
    }
    
    public int getSebelum(){
        return sebelum;
    }
    
    public void setSebelum(int sebelum){
        this.sebelum = sebelum;
    }
    
    public int getSesudah(){
        return sesudah;
    }
    
    public void setSesudah(int sesudah){
        this.sesudah = sesudah;
    }
    
    public int getTanamanPangan() {
        return tanamanPangan;
    }

    public void setTanamanPangan(int tanamanPangan) {
        this.tanamanPangan = tanamanPangan;
    }

    public int getHortikultura() {
        return hortikultura;
    }

    public void setHortikultura(int hortikultura) {
        this.hortikultura = hortikultura;
    }

    public int getPerkebunan() {
        return perkebunan;
    }

    public void setPerkebunan(int perkebunan) {
        this.perkebunan = perkebunan;
    }

    public int getPeternakan() {
        return peternakan;
    }

    public void setPeternakan(int peternakan) {
        this.peternakan = peternakan;
    }

    public int getPerikanan() {
        return perikanan;
    }

    public void setPerikanan(int perikanan) {
        this.perikanan = perikanan;
    }

    public int getKehutanan() {
        return kehutanan;
    }

    public void setKehutanan(int kehutanan) {
        this.kehutanan = kehutanan;
    }

    public int getJasaPertanian() {
        return jasaPertanian;
    }

    public void setJasaPertanian(int jasaPertanian) {
        this.jasaPertanian = jasaPertanian;
    }

    public int getJumlahArtPertanian() {
        return jumlahArtPertanian;
    }

    public void setJumlahArtPertanian(int jumlahArtPertanian) {
        this.jumlahArtPertanian = jumlahArtPertanian;
    }
    
    public int getJlhRutaPertanian(){
        return jlhRutaPertanian;
    }
    
    public void setJlhRutaPertanian(int jlhRutaPertanian){
        this.jlhRutaPertanian = jlhRutaPertanian;
    }
    
    public int getNoUrutTerbesar(){
        return noUrutTerbesar;
    }
    
    public void setNoUrutTerbesar(int noUrutTerbesar){
        this.noUrutTerbesar = noUrutTerbesar;
    }
    
    public int getPerkiraanHasil(){
        return perkiraanHasil;
    }
    
    public void setPerkiraanHasil(int perkiraanHasil){
        this.perkiraanHasil = perkiraanHasil;
    }
}