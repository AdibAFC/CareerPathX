/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Connection.Myconnection;
import details.notification_info;
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
public class notificationdao {
    Connection con = Myconnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    public ArrayList<notification_info> BindTable() {
        ArrayList<notification_info> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM interviewnotifications");
            notification_info x;
            while (rs.next()) {
                x = new notification_info(
                        rs.getInt("notification_id"),
                        rs.getString("semail"),
                        rs.getString("remail"),
                        rs.getString("message"),
                        rs.getBoolean("is_read"),
                        rs.getTimestamp("notification_timestamp")
                );
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(notificationdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public void insert(String smail,String rmail,String msg)
    {
        String sql = "insert into interviewnotifications (semail, remail,message) values(?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, smail);
            ps.setString(2, rmail);
            ps.setString(3, msg);
            if(ps.executeUpdate()>0)
            {
                JOptionPane.showMessageDialog(null, "Applicant has been informed", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(notificationdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
