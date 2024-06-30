/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import model.Petugas;

/**
 *
 * @author louis
 */
public class DatabaseLogin {
    public boolean validateAdmin(String username, String password) throws SQLException {
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }
    
    public boolean validatePetugas(String username, String password) throws SQLException {
        String sql = "SELECT * FROM petugas WHERE kode = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }
    
    public Petugas getPetugasByKode(String kode) throws SQLException {
    String sql = "SELECT * FROM petugas WHERE kode = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, kode);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                Petugas petugas = new Petugas();
                petugas.setKode(rs.getString("kode"));
                petugas.setNama(rs.getString("nama"));
                petugas.setPassword(rs.getString("password"));

                // Mendapatkan nama provinsi
                String sqlProvinsi = "SELECT provinsi FROM provinsi WHERE kode = ?";
                try (PreparedStatement pstmtProvinsi = conn.prepareStatement(sqlProvinsi)) {
                    pstmtProvinsi.setString(1, rs.getString("kode_prov"));
                    try (ResultSet rsProvinsi = pstmtProvinsi.executeQuery()) {
                        if (rsProvinsi.next()) {
                            petugas.setNamaProvinsi(rsProvinsi.getString("provinsi"));
                        }
                    }
                }

                // Mendapatkan nama kabupaten
                String sqlKabupaten = "SELECT kabkota FROM kabkota WHERE kode = ?";
                try (PreparedStatement pstmtKabupaten = conn.prepareStatement(sqlKabupaten)) {
                    pstmtKabupaten.setString(1, rs.getString("kode_kabkota"));
                    try (ResultSet rsKabupaten = pstmtKabupaten.executeQuery()) {
                        if (rsKabupaten.next()) {
                            petugas.setNamaKabupaten(rsKabupaten.getString("kabkota"));
                        }
                    }
                }

                // Mendapatkan nama kecamatan
                String sqlKecamatan = "SELECT kecamatan FROM kecamatan WHERE kode = ?";
                try (PreparedStatement pstmtKecamatan = conn.prepareStatement(sqlKecamatan)) {
                    pstmtKecamatan.setString(1, rs.getString("kode_kecamatan"));
                    try (ResultSet rsKecamatan = pstmtKecamatan.executeQuery()) {
                        if (rsKecamatan.next()) {
                            petugas.setNamaKecamatan(rsKecamatan.getString("kecamatan"));
                        }
                    }
                }

                // Mendapatkan nama desa
                String sqlDesa = "SELECT desalurah FROM desalurah WHERE kode = ?";
                try (PreparedStatement pstmtDesa = conn.prepareStatement(sqlDesa)) {
                    pstmtDesa.setString(1, rs.getString("kode_desalurah"));
                    try (ResultSet rsDesa = pstmtDesa.executeQuery()) {
                        if (rsDesa.next()) {
                            petugas.setNamaDesa(rsDesa.getString("desalurah"));
                        }
                    }
                }

                // Mendapatkan nama SLS
                petugas.setKodeSLS(rs.getString("kode_sls"));
                String sqlSLS = "SELECT sls FROM sls WHERE kode = ?";
                try (PreparedStatement pstmtSLS = conn.prepareStatement(sqlSLS)) {
                    pstmtSLS.setString(1, rs.getString("kode_sls"));
                    try (ResultSet rsSLS = pstmtSLS.executeQuery()) {
                        if (rsSLS.next()) {
                            petugas.setNamaSLS(rsSLS.getString("sls"));
                        }
                    }
                }

                // Mendapatkan kode sub-SLS
                petugas.setKodeSubSLS(rs.getString("kode_subsls"));

                return petugas;
            } else {
                return null;
            }
        }
    }
}

}
