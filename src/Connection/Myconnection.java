/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Myconnection {
    public static final String username = "root";
    public static final String password = "MySQL123@";
    public static final String url = "jdbc:mysql://localhost:3306/job";
    public static Connection con = null;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(); // Print the stack trace for debugging
            JOptionPane.showMessageDialog(null, "Driver not found", "Connection Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace(); // Print the stack trace for debugging
            JOptionPane.showMessageDialog(null, "Database connection error: " + ex.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
}

