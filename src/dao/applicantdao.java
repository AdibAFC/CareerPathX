/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connection.Myconnection;
import details.applicant_info;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
/**
 *
 * @author Hp
 */
public class applicantdao {

    Connection con = Myconnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    public ArrayList<applicant_info> BindTable() {
        ArrayList<applicant_info> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM admin_approve");
            applicant_info x;
            while (rs.next()) {
                x = new applicant_info(
                        rs.getInt("application_id"),
                        rs.getInt("rid"),
                        rs.getString("job_title"),
                        rs.getString("applicant_name"),
                        rs.getBytes("cv_data"),
                        rs.getTimestamp("application_date"),
                        rs.getString("approve")
                );
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(applicantdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int countRows() {
        int rowCount = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM admin_approve");
            if (rs.next()) {
                rowCount = rs.getInt(1); // The count will be in the first column of the result set.
            }
        } catch (SQLException ex) {
            Logger.getLogger(applicantdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowCount;
    }
    public void delete_from_adminapp(int aid){
        try {
            String query = "DELETE FROM admin_approve WHERE application_id = ? ";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, aid);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(jseekerdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insert_in_jobapp(int rid, String jt, String aname, Timestamp adate, InputStream cv) {
        String sql;
        try {
            if (cv != null) {
                sql = "insert into job_applications (rid, job_title, applicant_name, application_date,cv_data) values(?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setBinaryStream(5, cv);
            } else {
                sql = "insert into job_applications (rid, job_title, applicant_name, application_date) values(?,?,?,?)";
                ps = con.prepareStatement(sql);
            }

            ps.setInt(1, rid);
            ps.setString(2, jt);
            ps.setString(3, aname);
            ps.setTimestamp(4, adate);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Information Added", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
