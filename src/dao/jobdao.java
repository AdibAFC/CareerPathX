/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connection.Myconnection;
import details.job_info;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class jobdao {

    Connection con = Myconnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    public ArrayList<job_info> BindTable() {
        ArrayList<job_info> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM jobs");
            job_info x;
            while (rs.next()) {
                x = new job_info(
                        rs.getString("company"),
                        rs.getString("job_title"),
                        rs.getString("location"),
                        rs.getString("job_description"),
                        rs.getString("qualification"),
                        rs.getString("deadline"),
                        rs.getBytes("Picture")
                );
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(jobdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getmaxrow() {
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(no) from jobs");
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(jobdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }

    public ArrayList<job_info> BindTable1(int id) {
        ArrayList<job_info> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM jobs WHERE rid = ?";
            var ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            //st = con.createStatement();
            //rs = st.executeQuery("SELECT * FROM jobs where rid like ?");
            job_info x;
            while (rs.next()) {
                x = new job_info(
                        rs.getInt("no"),
                        rs.getInt("rid"),
                        rs.getString("company"),
                        rs.getString("job_title"),
                        rs.getString("location"),
                        rs.getString("job_description"),
                        rs.getString("qualification"),
                        rs.getString("deadline"),
                        rs.getString("status"),
                        rs.getBytes("Picture")
                );
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(jobdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insert(int No, int r_id, String cmpny, String j_title, String location, String j_des, String qualifi, String Dl, String stat, InputStream imgStream) {
        String sql;
        String successMessage;
        try {
            if (imgStream != null) {
                // Include the image insertion
                sql = "insert into jobs values(?,?,?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setBinaryStream(10, imgStream);
                successMessage = "Job Added with Image Successfully!";
            } else {
                // Exclude the image insertion
                sql = "insert into jobs (no, rid, company, job_title, location, job_description, qualification, deadline, status) values(?,?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                successMessage = "Job Added Successfully!";
            }

            ps.setInt(1, No);
            ps.setInt(2, r_id);
            ps.setString(3, cmpny);
            ps.setString(4, j_title);
            ps.setString(5, location);
            ps.setString(6, j_des);
            ps.setString(7, qualifi);
            ps.setString(8, Dl);
            ps.setString(9, stat);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to Add Job", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(jobdao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occurred while adding the job", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void edit(int No, int r_id, String cmpny, String j_title, String location, String j_des, String qualifi, String Dl, String stat, InputStream imgStream) {
        String sql;
        try {
            if (imgStream != null) {
                // Include the image update
                sql = "update jobs set rid = ?, company = ?, job_title = ?, location = ?, job_description = ?, qualification = ?, deadline = ?, status = ?, Picture = ? where no = ?";
            } else {
                // Exclude the image update
                sql = "update jobs set rid = ?, company = ?, job_title = ?, location = ?, job_description = ?, qualification = ?, deadline = ?, status = ? where no = ?";
            }

            ps = con.prepareStatement(sql);
            ps.setInt(1, r_id);
            ps.setString(2, cmpny);
            ps.setString(3, j_title);
            ps.setString(4, location);
            ps.setString(5, j_des);
            ps.setString(6, qualifi);
            ps.setString(7, Dl);
            ps.setString(8, stat);

            if (imgStream != null) {
                ps.setBinaryStream(9, imgStream);
                ps.setInt(10, No);
            } else {
                ps.setInt(9, No);
            }

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Updated");
            }
        } catch (SQLException ex) {
            Logger.getLogger(jobdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
