/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author louis
 */
public class DatabasePetugas {
    public boolean addPetugas(Petugas petugas) {

        String idProvinsi = getIdProvinsiByName(petugas.getNamaProvinsi());
        if (idProvinsi == null) {
            System.out.println("Provinsi tidak ditemukan");
            return false;
        }
        
        String idKabupaten = getIdKabupatenByName(petugas.getNamaKabupaten());
        if (idKabupaten == null) {
            System.out.println("Kabupaten tidak ditemukan");
            return false;
        }
        
        String idKecamatan = getIdKecamatanByName(petugas.getNamaKecamatan());
        if (idKecamatan == null) {
            System.out.println("Kecamatan tidak ditemukan");
            return false;
        }
        
        String idDesa = getIdDesaByName(petugas.getNamaDesa());
        if (idDesa == null) {
            System.out.println("Desa tidak ditemukan");
            return false;
        }
        
        String kodeSLS = petugas.getKodeSLS();
        if (!checkAndAddSLSIfNotExist(kodeSLS, idDesa, petugas.getNamaSLS())) {
            System.out.println("Gagal menambah atau memverifikasi SLS");
            return false;
        }

        String kodeSubSLS = petugas.getKodeSubSLS();
        if (!checkAndAddSubSLSIfNotExist(kodeSubSLS, kodeSLS)) {
            System.out.println("Gagal menambah atau memverifikasi Sub SLS");
            return false;
        }

        String sql = "INSERT INTO petugas (kode, nama, password, kategori, kode_prov, kode_kabkota, kode_kecamatan, kode_desalurah, kode_sls, kode_subsls) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, petugas.getKode());
            pstmt.setString(2, petugas.getNama());
            pstmt.setString(3, petugas.getKode());
            pstmt.setString(4, "PPL");
            pstmt.setString(5, idProvinsi);
            pstmt.setString(6, idKabupaten);
            pstmt.setString(7, idKecamatan);
            pstmt.setString(8, idDesa);
            pstmt.setString(9, kodeSLS);
            pstmt.setString(10, kodeSubSLS);
            pstmt.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            if (e.getErrorCode() == 19) {
                System.out.println("Petugas sudah ada di database!");
            } else {
                e.printStackTrace();
            }
            return false;
        }
    }
    
    private boolean checkAndAddSLSIfNotExist(String kodeSLS, String kodeDesa, String namaSLS) {
        String sqlCheck = "SELECT kode FROM sls WHERE kode = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmtCheck = conn.prepareStatement(sqlCheck)) {
            pstmtCheck.setString(1, kodeSLS);
            try (ResultSet rs = pstmtCheck.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        String sqlInsert = "INSERT INTO sls (kode, kode_desalurah, sls) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmtInsert = conn.prepareStatement(sqlInsert)) {
            pstmtInsert.setString(1, kodeSLS);
            pstmtInsert.setString(2, kodeDesa);
            pstmtInsert.setString(3, namaSLS);
            pstmtInsert.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean checkAndAddSubSLSIfNotExist(String kodeSubSLS, String kodeSLS) {
        String sqlCheck = "SELECT kode FROM subsls WHERE kode = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmtCheck = conn.prepareStatement(sqlCheck)) {
            pstmtCheck.setString(1, kodeSubSLS);
            try (ResultSet rs = pstmtCheck.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        String sqlInsert = "INSERT INTO subsls (kode, kode_sls) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmtInsert = conn.prepareStatement(sqlInsert)) {
            pstmtInsert.setString(1, kodeSubSLS);
            pstmtInsert.setString(2, kodeSLS);
            pstmtInsert.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getIdProvinsiByName(String namaProvinsi) {
        String sql = "SELECT kode FROM provinsi WHERE provinsi = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, namaProvinsi);
            try (ResultSet rs = pstmt.executeQuery()){
                if (rs.next()) {
                    return rs.getString("kode");
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getIdKabupatenByName(String namaKabupaten) {
        String sql = "SELECT kode FROM kabkota WHERE kabkota = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, namaKabupaten);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("kode");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getIdKecamatanByName(String namaKecamatan) {
        String sql = "SELECT kode FROM kecamatan WHERE kecamatan = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, namaKecamatan);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("kode");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getIdDesaByName(String namaDesa) {
        String sql = "SELECT kode FROM desalurah WHERE desalurah = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, namaDesa);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("kode");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<String> getAllProvinsi() throws SQLException {
        List<String> provinsiList = new ArrayList<>();
        String sql = "SELECT provinsi FROM provinsi";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                provinsiList.add(rs.getString("provinsi"));
            }
        }
        return provinsiList;
    }

    public static List<String> getKabupatenByProvinsi(String idProvinsi) throws SQLException {
        List<String> kabupatenList = new ArrayList<>();
        String sql = "SELECT kabkota FROM kabkota WHERE kode_prov = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idProvinsi);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    kabupatenList.add(rs.getString("kabkota"));
                }
            }
        }
        return kabupatenList;
    }


    public static List<String> getKecamatanByKabupaten(String idKabupaten) throws SQLException {
        List<String> kecamatanList = new ArrayList<>();
        String sql = "SELECT kecamatan FROM kecamatan WHERE kode_kabkota = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idKabupaten);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    kecamatanList.add(rs.getString("kecamatan"));
                }
            }
        }
        return kecamatanList;
    }

    public static List<String> getDesaByKecamatan(String idKecamatan) throws SQLException {
        List<String> desaList = new ArrayList<>();
        String sql = "SELECT desalurah FROM desalurah WHERE kode_kecamatan = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idKecamatan);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    desaList.add(rs.getString("desalurah"));
                }
            }
        }
        return desaList;
    }
    
    
    public List<Petugas> getAllPetugas() {
        List<Petugas> petugasList = new ArrayList<>();
        String sql = "SELECT petugas.kode, petugas.nama, petugas.kategori, desalurah.desalurah FROM petugas JOIN desalurah ON petugas.kode_desalurah = desalurah.kode";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Petugas petugas = new Petugas();
                petugas.setKode(rs.getString("kode"));
                petugas.setNama(rs.getString("nama"));
                petugas.setKategori(rs.getString("kategori"));
                petugas.setNamaDesa(rs.getString("desalurah"));
                petugasList.add(petugas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return petugasList;
    }
    
    public Petugas getRekapitulasi(String subsls) {
        String sql = "SELECT * FROM rekapitulasi WHERE kode_subsls = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, subsls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Petugas petugas = new Petugas();
                petugas.setSebelum(rs.getInt("jumlah_sebelum"));
                petugas.setSesudah(rs.getInt("jumlah_hasil"));
                petugas.setTanamanPangan(rs.getInt("tanaman_pangan"));
                petugas.setHortikultura(rs.getInt("hortikultura"));
                petugas.setPerkebunan(rs.getInt("perkebunan"));
                petugas.setPeternakan(rs.getInt("peternakan"));
                petugas.setPerikanan(rs.getInt("perikanan"));
                petugas.setKehutanan(rs.getInt("kehutanan"));
                petugas.setJasaPertanian(rs.getInt("jasa_pertanian"));
                petugas.setJumlahArtPertanian(rs.getInt("jumlah_pengelola_pertanian"));
                petugas.setJlhRutaPertanian(rs.getInt("jumlah_ruta_pertanian"));
                petugas.setNoUrutTerbesar(rs.getInt("no_urut_terbesar"));
                petugas.setPerkiraanHasil(rs.getInt("perkiraan_hasil"));
                return petugas;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }  
    
    public boolean insertTanggal(Petugas petugas) {
        String sql = "UPDATE petugas SET tanggal = ? WHERE kode = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(petugas.getTanggal()));
            pstmt.setString(2, petugas.getKode()); // Menggunakan kode petugas untuk menentukan baris yang akan diupdate
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
