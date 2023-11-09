package dao;

import Connection.Myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class forgetPassDao {
    Connection con=Myconnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    public boolean isEmailexistj(String email)
    {
        try {
            ps=con.prepareStatement("select * from jseeker where semail = ?");
            ps.setString(1, email);
            rs=ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "This Email does not exits!", "Invalid", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean isEmailexistr(String email)
    {
        try {
            ps=con.prepareStatement("select * from recruiter where remail = ?");
            ps.setString(1, email);
            rs=ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "This Email does not exits!", "Invalid", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }
    public boolean getsphn(String email,String newans)
    {
        try {
            ps=con.prepareStatement("select * from jseeker where semail = ?");
            ps.setString(1, email);
            rs=ps.executeQuery();
            if(rs.next())
            {
                String oldans=rs.getString(5);
                if(newans.equals(oldans))
                {
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Phone Number", "Invalid", 2);
                    return false;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "This Email does not exits!", "Invalid", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }
    public boolean getrphn(String email,String newans)
    {
        try {
            ps=con.prepareStatement("select * from recruiter where remail = ?");
            ps.setString(1, email);
            rs=ps.executeQuery();
            if(rs.next())
            {
                String oldans=rs.getString(5);
                if(newans.equals(oldans))
                {
                    return true;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Phone Number", "Invalid", 2);
                    return false;
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "This Email does not exits!", "Invalid", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }
    public void newspass(String email,String pass)
    {
        String sql="update jseeker set spass = ? where semail = ?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, email);
            if(ps.executeUpdate()>0)
            {
                JOptionPane.showMessageDialog(null, "Password Successfully updated");
            }
        } catch (SQLException ex) {
            Logger.getLogger(forgetPassDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void newrpass(String email,String pass)
    {
        String sql="update recruiter set rpass = ? where remail = ?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, email);
            if(ps.executeUpdate()>0)
            {
                JOptionPane.showMessageDialog(null, "Password Successfully updated");
            }
        } catch (SQLException ex) {
            Logger.getLogger(forgetPassDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
