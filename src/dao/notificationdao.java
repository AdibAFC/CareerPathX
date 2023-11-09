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
}
