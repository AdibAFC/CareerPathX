/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connection.Myconnection;
import details.recruiter_info;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class recruiterdao {

    Connection con = Myconnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    public void insert(int id, String mail, String name, String pass, String phn, String address, String dob, String gen, InputStream imageStream) {
        String sql;
        try {
            if (imageStream != null) {
                // Include the image insertion
                sql = "insert into recruiter values(?,?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setBinaryStream(9, imageStream);
            } else {
                // Exclude the image insertion
                sql = "insert into recruiter (rid, remail, rname, rpass, rphn, radd, rdob, rgender) values(?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
            }
            ps.setInt(1, id);
            ps.setString(2, mail);
            ps.setString(3, name);
            ps.setString(4, pass);
            ps.setString(5, phn);
            ps.setString(6, address);
            ps.setString(7, dob);
            ps.setString(8, gen);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Information Added", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(recruiterdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getmaxrowj() {
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(rid) from recruiter");
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(recruiterdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }

    public ArrayList<recruiter_info> BindTable() {
        ArrayList<recruiter_info> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM recruiter");
            recruiter_info x;
            while (rs.next()) {
                x = new recruiter_info(
                        rs.getInt("rid"),
                        rs.getString("remail"),
                        rs.getString("rname"),
                        rs.getString("rpass"),
                        rs.getString("rphn"),
                        rs.getString("radd"),
                        rs.getString("rdob"),
                        rs.getString("rgender"),
                        rs.getBytes("rpic")
                );
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(recruiterdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete_row(int id) {
        try {
            String query = "DELETE FROM recruiter WHERE rid = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(recruiterdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void edit(int id, String mail, String name, String pass, String phn, String address, String dob, String gen, InputStream imageStream) {
        String sql;
        if (imageStream != null) {
            // Include the image update
            sql = "update recruiter set remail = ?, rname = ?, rpass = ?, rphn = ?, radd = ?, rdob = ?, rgender = ?, rpic = ? where rid = ?";
        } else {
            // Exclude the image update
            sql = "update recruiter set remail = ?, rname = ?, rpass = ?, rphn = ?, radd = ?, rdob = ?, rgender = ? where rid = ?";
        }
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mail);
            ps.setString(2, name);
            ps.setString(3, pass);
            ps.setString(4, phn);
            ps.setString(5, address);
            ps.setString(6, dob);
            ps.setString(7, gen);
            if (imageStream != null) {
                ps.setBinaryStream(8, imageStream);
                ps.setInt(9, id);
            } else {
                ps.setInt(8, id);
            }

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Updated");
            }
        } catch (SQLException ex) {
            Logger.getLogger(recruiterdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
