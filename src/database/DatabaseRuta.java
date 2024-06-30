/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.sql.Types;
import model.Ruta;

/**
 *
 * @author louis
 */
public class DatabaseRuta {
    public boolean addRuta(Ruta ruta) {

        String sql = "INSERT INTO ketruta (kode_subsls, urut_kk, namakk_lainnya, alamat) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ruta.getKodeSubsls());
            pstmt.setInt(2, ruta.getUrutKk());
            pstmt.setString(3, ruta.getNamakkLainnya());
            pstmt.setString(4, ruta.getAlamat());
            pstmt.executeUpdate();
        
            return true;
        } catch (SQLException e) {
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
    
    public String getIdSLSByName(String namaSLS) {
        String sql = "SELECT kode FROM sls WHERE sls = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, namaSLS);
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
    
    public static List<String> getSLSByDesa(String idDesa) throws SQLException {
        List<String> slsList = new ArrayList<>();
        String sql = "SELECT sls FROM sls WHERE kode_desalurah = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idDesa);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    slsList.add(rs.getString("sls"));
                }
            }
        }
        return slsList;
    }
    
    public static List<String> getSubSLSBySLS(String idSLS) throws SQLException {
        List<String> subslsList = new ArrayList<>();
        String sql = "SELECT kode FROM subsls WHERE kode_sls = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idSLS);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String kode = rs.getString("kode");
                    if (kode !=null && kode.length()>=2){
                        subslsList.add(kode.substring(kode.length()-2));
                    }
                }
            }
        }
        return subslsList;
    }
    
    public List<Ruta> getAllRutaBySubSLS(String subsls) {
        List<Ruta> rutas = new ArrayList<>();
        String sql = "SELECT * FROM ketruta WHERE kode_subsls = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, subsls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setId(rs.getInt("id"));
                ruta.setUrutKk(rs.getInt("urut_kk"));
                ruta.setNamakkLainnya(rs.getString("namakk_lainnya"));
                ruta.setAlamat(rs.getString("alamat"));
                ruta.setUrutBtt(rs.getInt("urut_btt"));
                ruta.setJlhPetani(rs.getInt("jlh_petani"));
                ruta.setKeberadaan(rs.getString("keberadaan"));
                ruta.setJlhPengelolaan(rs.getInt("jlh_pengelolaan"));
                ruta.setUrutRuta(rs.getInt("urut_ruta"));
                ruta.setIdenKkKrt(rs.getString("iden_kk_krt"));
                ruta.setNamaKrt(rs.getString("nama_krt"));
                ruta.setTanamanPangan(rs.getInt("tanaman_pangan"));
                ruta.setHortikultura(rs.getInt("hortikultura"));
                ruta.setPerkebunan(rs.getInt("perkebunan"));
                ruta.setPeternakan(rs.getInt("peternakan"));
                ruta.setPerikanan(rs.getInt("perikanan"));
                ruta.setKehutanan(rs.getInt("kehutanan"));
                ruta.setJasaPertanian(rs.getInt("jasa_pertanian"));
                ruta.setSubsektorUtama(rs.getString("subsektor_utama"));
                ruta.setJumlahArtPertanian(rs.getInt("jumlah_art_pertanian"));
                ruta.setUrutRutaPertanian(rs.getInt("urut_ruta_pertanian"));
                rutas.add(ruta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rutas;
    }
    
    public List<Ruta> getAllRutaBaruBySubSLS(String subsls) {
        List<Ruta> rutas = new ArrayList<>();
        String sql = "SELECT * FROM rutabaru WHERE kode_subsls = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, subsls);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Ruta ruta = new Ruta();
                ruta.setId(rs.getInt("id"));
                ruta.setUrutKk(rs.getInt("urut_kk"));
                ruta.setNamakkLainnya(rs.getString("namakk_lainnya"));
                ruta.setAlamat(rs.getString("alamat"));
                ruta.setUrutBtt(rs.getInt("urut_btt"));
                ruta.setJlhPetani(rs.getInt("jlh_petani"));
                ruta.setKeberadaan(rs.getString("keberadaan"));
                ruta.setJlhPengelolaan(rs.getInt("jlh_pengelolaan"));
                ruta.setUrutRuta(rs.getInt("urut_ruta"));
                ruta.setIdenKkKrt(rs.getString("iden_kk_krt"));
                ruta.setNamaKrt(rs.getString("nama_krt"));
                ruta.setTanamanPangan(rs.getInt("tanaman_pangan"));
                ruta.setHortikultura(rs.getInt("hortikultura"));
                ruta.setPerkebunan(rs.getInt("perkebunan"));
                ruta.setPeternakan(rs.getInt("peternakan"));
                ruta.setPerikanan(rs.getInt("perikanan"));
                ruta.setKehutanan(rs.getInt("kehutanan"));
                ruta.setJasaPertanian(rs.getInt("jasa_pertanian"));
                ruta.setSubsektorUtama(rs.getString("subsektor_utama"));
                ruta.setJumlahArtPertanian(rs.getInt("jumlah_art_pertanian"));
                ruta.setUrutRutaPertanian(rs.getInt("urut_ruta_pertanian"));
                rutas.add(ruta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rutas;
    }
    
    public void setBlokVa(Ruta ruta){
        String sql = "UPDATE ketruta SET urut_btt = ?, jlh_petani = ?, keberadaan = ?, jlh_pengelolaan = ?, urut_ruta = ?, iden_kk_krt = ?, nama_krt = ?, tanaman_pangan = ?, hortikultura = ?, perkebunan = ?, peternakan = ?, perikanan = ?, kehutanan = ?, jasa_pertanian = ?, subsektor_utama = ?, jumlah_art_pertanian = ?, urut_ruta_pertanian = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            if(ruta.getKeberadaan()=="0"){
                stmt.setInt(1, ruta.getUrutBtt());
                stmt.setInt(2, ruta.getJlhPetani());
                stmt.setString(3, ruta.getKeberadaan());
                stmt.setNull(4, Types.INTEGER);
                stmt.setNull(5, Types.INTEGER);
                stmt.setNull(6, Types.VARCHAR);
                stmt.setNull(7, Types.VARCHAR);
                stmt.setNull(8, Types.INTEGER);
                stmt.setNull(9, Types.INTEGER);
                stmt.setNull(10, Types.INTEGER);
                stmt.setNull(11, Types.INTEGER);
                stmt.setNull(12, Types.INTEGER);
                stmt.setNull(13, Types.INTEGER);
                stmt.setNull(14, Types.INTEGER);
                stmt.setNull(15, Types.VARCHAR);
                stmt.setNull(16, Types.INTEGER);
                stmt.setNull(17, Types.INTEGER);
                stmt.setInt(18, ruta.getId());
            }else{
                if(ruta.getJlhPengelolaan()==0){
                    stmt.setInt(1, ruta.getUrutBtt());
                    stmt.setInt(2, ruta.getJlhPetani());
                    stmt.setString(3, ruta.getKeberadaan());
                    stmt.setInt(4, ruta.getJlhPengelolaan());
                    stmt.setInt(5, ruta.getUrutRuta());
                    stmt.setString(6, ruta.getIdenKkKrt());
                    if(ruta.getIdenKkKrt()=="KK dan KRT"){
                        stmt.setNull(7, Types.VARCHAR);
                    }else{
                        stmt.setString(7, ruta.getNamaKrt());
                    }
                    stmt.setNull(8, Types.INTEGER);
                    stmt.setNull(9, Types.INTEGER);
                    stmt.setNull(10, Types.INTEGER);
                    stmt.setNull(11, Types.INTEGER);
                    stmt.setNull(12, Types.INTEGER);
                    stmt.setNull(13, Types.INTEGER);
                    stmt.setNull(14, Types.INTEGER);
                    stmt.setNull(15, Types.VARCHAR);
                    stmt.setNull(16, Types.INTEGER);
                    stmt.setNull(17, Types.INTEGER);
                    stmt.setInt(18, ruta.getId());
                }else{
                    if(ruta.getTanamanPangan() == 0 &&
                    ruta.getHortikultura() == 0 &&
                    ruta.getPerkebunan() == 0 &&
                    ruta.getPeternakan() == 0 &&
                    ruta.getPerikanan() == 0 &&
                    ruta.getKehutanan() == 0 &&
                    ruta.getJasaPertanian() == 0){
                        stmt.setInt(1, ruta.getUrutBtt());
                        stmt.setInt(2, ruta.getJlhPetani());
                        stmt.setString(3, ruta.getKeberadaan());
                        stmt.setInt(4, ruta.getJlhPengelolaan());
                        stmt.setInt(5, ruta.getUrutRuta());
                        stmt.setString(6, ruta.getIdenKkKrt());
                        if(ruta.getIdenKkKrt()=="KK dan KRT"){
                            stmt.setNull(7, Types.VARCHAR);
                        }else{
                            stmt.setString(7, ruta.getNamaKrt());
                        }
                        stmt.setInt(8, ruta.getTanamanPangan());
                        stmt.setInt(9, ruta.getHortikultura());
                        stmt.setInt(10, ruta.getPerkebunan());
                        stmt.setInt(11, ruta.getPeternakan());
                        stmt.setInt(12, ruta.getPerikanan());
                        stmt.setInt(13, ruta.getKehutanan());
                        stmt.setInt(14, ruta.getJasaPertanian());
                        stmt.setNull(15, Types.VARCHAR);
                        stmt.setNull(16, Types.INTEGER);
                        stmt.setNull(17, Types.INTEGER);
                        stmt.setInt(18, ruta.getId());
                    }else{
                        stmt.setInt(1, ruta.getUrutBtt());
                        stmt.setInt(2, ruta.getJlhPetani());
                        stmt.setString(3, ruta.getKeberadaan());
                        stmt.setInt(4, ruta.getJlhPengelolaan());
                        stmt.setInt(5, ruta.getUrutRuta());
                        stmt.setString(6, ruta.getIdenKkKrt());
                        if(ruta.getIdenKkKrt()=="KK dan KRT"){
                            stmt.setNull(7, Types.VARCHAR);
                        }else{
                            stmt.setString(7, ruta.getNamaKrt());
                        }
                        stmt.setInt(8, ruta.getTanamanPangan());
                        stmt.setInt(9, ruta.getHortikultura());
                        stmt.setInt(10, ruta.getPerkebunan());
                        stmt.setInt(11, ruta.getPeternakan());
                        stmt.setInt(12, ruta.getPerikanan());
                        stmt.setInt(13, ruta.getKehutanan());
                        stmt.setInt(14, ruta.getJasaPertanian());
                        stmt.setString(15, ruta.getSubsektorUtama());
                        stmt.setInt(16, ruta.getJumlahArtPertanian());
                        stmt.setInt(17, ruta.getUrutRutaPertanian());
                        stmt.setInt(18, ruta.getId());
                    }
                }
            }
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void setBlokVb(Ruta ruta){
        String sql = "INSERT INTO rutabaru (kode_subsls, urut_kk, namakk_lainnya, nik, alamat, urut_btt, jlh_petani, keberadaan, jlh_pengelolaan, urut_ruta, iden_kk_krt, nama_krt, tanaman_pangan, hortikultura, perkebunan, peternakan, perikanan, kehutanan, jasa_pertanian, subsektor_utama, jumlah_art_pertanian, urut_ruta_pertanian) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (ruta.getKeberadaan().equals("0")) {
                stmt.setString(1, ruta.getKodeSubsls());
                stmt.setInt(2, ruta.getUrutKk());
                stmt.setString(3, ruta.getNamakkLainnya());
                stmt.setString(4, ruta.getNik());
                stmt.setString(5, ruta.getAlamat());
                stmt.setInt(6, ruta.getUrutBtt());
                stmt.setInt(7, ruta.getJlhPetani());
                stmt.setString(8, ruta.getKeberadaan());
                stmt.setNull(9, Types.INTEGER);
                stmt.setNull(10, Types.INTEGER);
                stmt.setNull(11, Types.VARCHAR);
                stmt.setNull(12, Types.VARCHAR);
                stmt.setNull(13, Types.INTEGER);
                stmt.setNull(14, Types.INTEGER);
                stmt.setNull(15, Types.INTEGER);
                stmt.setNull(16, Types.INTEGER);
                stmt.setNull(17, Types.INTEGER);
                stmt.setNull(18, Types.INTEGER);
                stmt.setNull(19, Types.INTEGER);
                stmt.setNull(20, Types.VARCHAR);
                stmt.setNull(21, Types.INTEGER);
                stmt.setNull(22, Types.INTEGER);
            } else {
                if (ruta.getJlhPengelolaan() == 0) {
                    stmt.setString(1, ruta.getKodeSubsls());
                    stmt.setInt(2, ruta.getUrutKk());
                    stmt.setString(3, ruta.getNamakkLainnya());
                    stmt.setString(4, ruta.getNik());
                    stmt.setString(5, ruta.getAlamat());
                    stmt.setInt(6, ruta.getUrutBtt());
                    stmt.setInt(7, ruta.getJlhPetani());
                    stmt.setString(8, ruta.getKeberadaan());
                    stmt.setInt(9, ruta.getJlhPengelolaan());
                    stmt.setInt(10, ruta.getUrutRuta());
                    stmt.setString(11, ruta.getIdenKkKrt());
                    if (ruta.getIdenKkKrt().equals("KK dan KRT")) {
                        stmt.setNull(12, Types.VARCHAR);
                    } else {
                        stmt.setString(12, ruta.getNamaKrt());
                    }
                    stmt.setNull(13, Types.INTEGER);
                    stmt.setNull(14, Types.INTEGER);
                    stmt.setNull(15, Types.INTEGER);
                    stmt.setNull(16, Types.INTEGER);
                    stmt.setNull(17, Types.INTEGER);
                    stmt.setNull(18, Types.INTEGER);
                    stmt.setNull(19, Types.INTEGER);
                    stmt.setNull(20, Types.VARCHAR);
                    stmt.setNull(21, Types.INTEGER);
                    stmt.setNull(22, Types.INTEGER);
                } else {
                    if (ruta.getTanamanPangan() == 0 &&
                        ruta.getHortikultura() == 0 &&
                        ruta.getPerkebunan() == 0 &&
                        ruta.getPeternakan() == 0 &&
                        ruta.getPerikanan() == 0 &&
                        ruta.getKehutanan() == 0 &&
                        ruta.getJasaPertanian() == 0) {
                        
                        stmt.setString(1, ruta.getKodeSubsls());
                        stmt.setInt(2, ruta.getUrutKk());
                        stmt.setString(3, ruta.getNamakkLainnya());
                        stmt.setString(4, ruta.getNik());
                        stmt.setString(5, ruta.getAlamat());
                        stmt.setInt(6, ruta.getUrutBtt());
                        stmt.setInt(7, ruta.getJlhPetani());
                        stmt.setString(8, ruta.getKeberadaan());
                        stmt.setInt(9, ruta.getJlhPengelolaan());
                        stmt.setInt(10, ruta.getUrutRuta());
                        stmt.setString(11, ruta.getIdenKkKrt());
                        if (ruta.getIdenKkKrt().equals("KK dan KRT")) {
                            stmt.setNull(12, Types.VARCHAR);
                        } else {
                            stmt.setString(12, ruta.getNamaKrt());
                        }
                        stmt.setInt(13, ruta.getTanamanPangan());
                        stmt.setInt(14, ruta.getHortikultura());
                        stmt.setInt(15, ruta.getPerkebunan());
                        stmt.setInt(16, ruta.getPeternakan());
                        stmt.setInt(17, ruta.getPerikanan());
                        stmt.setInt(18, ruta.getKehutanan());
                        stmt.setInt(19, ruta.getJasaPertanian());
                        stmt.setNull(20, Types.VARCHAR);
                        stmt.setNull(21, Types.INTEGER);
                        stmt.setNull(22, Types.INTEGER);
                    } else {
                        stmt.setString(1, ruta.getKodeSubsls());
                        stmt.setInt(2, ruta.getUrutKk());
                        stmt.setString(3, ruta.getNamakkLainnya());
                        stmt.setString(4, ruta.getNik());
                        stmt.setString(5, ruta.getAlamat());
                        stmt.setInt(6, ruta.getUrutBtt());
                        stmt.setInt(7, ruta.getJlhPetani());
                        stmt.setString(8, ruta.getKeberadaan());
                        stmt.setInt(9, ruta.getJlhPengelolaan());
                        stmt.setInt(10, ruta.getUrutRuta());
                        stmt.setString(11, ruta.getIdenKkKrt());
                        if (ruta.getIdenKkKrt().equals("KK dan KRT")) {
                            stmt.setNull(12, Types.VARCHAR);
                        } else {
                            stmt.setString(12, ruta.getNamaKrt());
                        }
                        stmt.setInt(13, ruta.getTanamanPangan());
                        stmt.setInt(14, ruta.getHortikultura());
                        stmt.setInt(15, ruta.getPerkebunan());
                        stmt.setInt(16, ruta.getPeternakan());
                        stmt.setInt(17, ruta.getPerikanan());
                        stmt.setInt(18, ruta.getKehutanan());
                        stmt.setInt(19, ruta.getJasaPertanian());
                        stmt.setString(20, ruta.getSubsektorUtama());
                        stmt.setInt(21, ruta.getJumlahArtPertanian());
                        stmt.setInt(22, ruta.getUrutRutaPertanian());
                    }
                }
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
