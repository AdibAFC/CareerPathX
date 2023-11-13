/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connection.Myconnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class companydao {

    Connection con = Myconnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    public boolean isCompanyExist(String cname) {
        try {
            String sql = "SELECT 1 FROM companies WHERE company = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cname);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(companydao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Close resources (ps and rs) here if needed
        }
        return false;
    }

    public void insert(String Cname, String Ctype, String Location, String Inds, String link, InputStream imageStream) {
        String sql;
        try {
            if (imageStream != null) {
                // Include the image insertion
                sql = "insert into companies (company, company_type, location, industry, website, company_logo) values(?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setBinaryStream(6, imageStream);
            } else {
                // Exclude the image insertion
                sql = "insert into companies (company, company_type, location, industry, website) values(?,?,?,?,?)";
                ps = con.prepareStatement(sql);
            }
            ps.setString(1, Cname);
            ps.setString(2, Ctype);
            ps.setString(3, Location);
            ps.setString(4, Inds);
            ps.setString(5, link);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Company Added", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("23505")) {
                // Handle uniqueness violation (company name already exists)
                JOptionPane.showMessageDialog(null, "Company with the same name already exists", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Logger.getLogger(companydao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public byte[] getIcon(String cname) {
        String sql = "SELECT company_logo FROM companies WHERE company = ?";
        InputStream iconStream = null;

        byte[] x = null;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cname);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    x = rs.getBytes("company_logo");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(companydao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    public String getwebsite(String cname) {
        String sql = "SELECT website FROM companies WHERE company = ?";
        String name = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cname);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    name = rs.getString("website");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(companydao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return name;
    }

}
