package dao;

import Connection.Myconnection;
import details.jseeker_info;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class jseekerdao {

    Connection con = Myconnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    public void insert(int id, String mail, String name, String pass, String phn, String address, String dob, String gen, InputStream imageStream) {
        String sql;
        try {
            if (imageStream != null) {
                // Include the image insertion
                sql = "insert into jseeker (id, semail, sname, spass, sphn, sadd, sdob, sgender,Profile_Picture) values(?,?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setBinaryStream(9, imageStream);
            } else {
                // Exclude the image insertion
                sql = "insert into jseeker (id, semail, sname, spass, sphn, sadd, sdob, sgender) values(?,?,?,?,?,?,?,?)";
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
            Logger.getLogger(jseekerdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getmaxrowj() {
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(id) from jseeker");
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(jseekerdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }

    public ArrayList<jseeker_info> BindTable() {
        ArrayList<jseeker_info> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM jseeker");
            jseeker_info x;
            while (rs.next()) {
                x = new jseeker_info(
                        rs.getInt("id"),
                        rs.getString("semail"),
                        rs.getString("sname"),
                        rs.getString("spass"),
                        rs.getString("sphn"),
                        rs.getString("sadd"),
                        rs.getString("sdob"),
                        rs.getString("sgender"),
                        rs.getBytes("Profile_Picture")
                );
                list.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(jseekerdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete_row(int id) {
        try {
            String query = "DELETE FROM jseeker WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(jseekerdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void edit(int id, String mail, String name, String pass, String phn, String address, String dob, String gen, InputStream imageStream) {
        String sql;
        if (imageStream != null) {
            // Include the image update
            sql = "update jseeker set semail = ?, sname = ?, spass = ?, sphn = ?, sadd = ?, sdob = ?, sgender = ?, Profile_Picture = ? where id = ?";
        } else {
            // Exclude the image update
            sql = "update jseeker set semail = ?, sname = ?, spass = ?, sphn = ?, sadd = ?, sdob = ?, sgender = ? where id = ?";
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
            Logger.getLogger(jseekerdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void j_can_edit(int id, String mail, String name, String pass, String phn, String address, String dob, String gen, InputStream imageStream, InputStream cv) {
    String sql;
    
    if (imageStream != null && cv != null) {
        // Include the image and CV update
        sql = "update jseeker set semail = ?, sname = ?, spass = ?, sphn = ?, sadd = ?, sdob = ?, sgender = ?, Profile_Picture = ?, CV = ? where id = ?";
    } else if (imageStream != null) {
        // Include the image update
        sql = "update jseeker set semail = ?, sname = ?, spass = ?, sphn = ?, sadd = ?, sdob = ?, sgender = ?, Profile_Picture = ? where id = ?";
    } else if (cv != null) {
        // Include the CV update
        sql = "update jseeker set semail = ?, sname = ?, spass = ?, sphn = ?, sadd = ?, sdob = ?, sgender = ?, CV = ? where id = ?";
    } else {
        // Exclude both the image and CV update
        sql = "update jseeker set semail = ?, sname = ?, spass = ?, sphn = ?, sadd = ?, sdob = ?, sgender = ? where id = ?";
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
            if (cv != null) {
                ps.setBinaryStream(9, cv);
                ps.setInt(10, id);
            } else {
                ps.setInt(9, id);
            }
        } else if (cv != null) {
            ps.setBinaryStream(8, cv);
            ps.setInt(9, id);
        } else {
            ps.setInt(8, id);
        }

        if (ps.executeUpdate() > 0) {
            JOptionPane.showMessageDialog(null, "Information Updated");
        }
    } catch (SQLException ex) {
        Logger.getLogger(jseekerdao.class.getName()).log(Level.SEVERE, null, ex);
    }
}


}
