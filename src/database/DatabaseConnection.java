/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bara
 */
public class DatabaseConnection implements Serializable {
    private static final String URL = "jdbc:mysql://localhost:3306/projectpbo3";
    private static final String USER = "root";
    private static final String PASSWORD = ""; 
    
    private static DatabaseConnection instance;
    
    // Private constructor to prevent instantiation
    public DatabaseConnection() throws SQLException {
        
    }
    
    // Method to get a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    // Synchronized method to get the singleton instance of DatabaseConnection
    public static synchronized DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
