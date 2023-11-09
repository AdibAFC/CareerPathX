package dao;

import Connection.Myconnection;
import com.mysql.cj.jdbc.Blob;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class admindao {

    Connection con = Myconnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    public byte[] getIcon(int id) {
        String sql = "SELECT A_picture FROM admin WHERE A_ID = ?";
        InputStream iconStream = null;

        byte[] x = null;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    x = rs.getBytes("A_Picture");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(admindao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    public String getname(String ID) {
        String sql = "SELECT aname FROM admin WHERE A_ID = ?";
        String name = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ID);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    name = rs.getString("aname");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(admindao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return name;
    }

    public String getemail(String ID) {
        String sql = "SELECT email FROM admin WHERE A_ID = ?";
        String email = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ID);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    email = rs.getString("email");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(admindao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return email;
    }

    public void setInfo(String ID, String email, String name, InputStream imageStream) {
        String sql = "UPDATE admin SET aname = ?, email = ?, A_picture = ? WHERE A_ID = ?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setBinaryStream(3, imageStream);
            ps.setString(4, ID);

            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Name, Email, and Picture Successfully updated");
            }
        } catch (SQLException ex) {
            Logger.getLogger(admindao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
