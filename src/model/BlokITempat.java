package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Bara
 */
public class BlokITempat {
    private String provinsi;
    private String kabupatenKota;
    private String kecamatan;
    private String desaKelurahan;
    private String klasifikasiDesKel;
    private String kodeSLSNonSLS;
    private String kodeSubSLS;
    private String namaSLSNonSLS;
    private boolean mengalamiPerubahanSLS;

    // Getters and Setters
    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKabupatenKota() {
        return kabupatenKota;
    }

    public void setKabupatenKota(String kabupatenKota) {
        this.kabupatenKota = kabupatenKota;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getDesaKelurahan() {
        return desaKelurahan;
    }

    public void setDesaKelurahan(String desaKelurahan) {
        this.desaKelurahan = desaKelurahan;
    }

    public String getKlasifikasi() {
        return klasifikasiDesKel;
    }

    public void setKlasifikasi(String klasifikasi) {
        this.klasifikasiDesKel = klasifikasi;
    }

    public String getKodeSLSNonSLS() {
        return kodeSLSNonSLS;
    }

    public void setKodeSLSNonSLS(String kodeSLSNonSLS) {
        this.kodeSLSNonSLS = kodeSLSNonSLS;
    }

    public String getKodeSubSLS() {
        return kodeSubSLS;
    }

    public void setKodeSubSLS(String kodeSubSLS) {
        this.kodeSubSLS = kodeSubSLS;
    }

    public String getNamaSLSNonSLS() {
        return namaSLSNonSLS;
    }

    public void setNamaSLSNonSLS(String namaSLSNonSLS) {
        this.namaSLSNonSLS = namaSLSNonSLS;
    }

    public boolean isMengalamiPerubahanSLS() {
        return mengalamiPerubahanSLS;
    }

    public void setMengalamiPerubahanSLS(boolean mengalamiPerubahanSLS) {
        this.mengalamiPerubahanSLS = mengalamiPerubahanSLS;
    }
}
