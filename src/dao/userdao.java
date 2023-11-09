package dao;
import Connection.Myconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class userdao {
    Connection con=Myconnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    public int getmaxrowj()
    {
        int row=0;
        try {
            st=con.createStatement();
            rs=st.executeQuery("select max(id) from jseeker");
            while(rs.next())
            {
                row=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row+1;  
    }
    public int getmaxrowr()
    {
        int row=0;
        try {
            st=con.createStatement();
            rs=st.executeQuery("select max(rid) from recruiter");
            while(rs.next())
            {
                row=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row+1;  
    }
    public boolean isEmailexist(String email)
    {
        try {
            ps=con.prepareStatement("select * from jseeker where semail = ?");
            ps.setString(1, email);
            rs=ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }
    public boolean isPhnexist(String phn)
    {
        try {
            ps=con.prepareStatement("select * from jseeker where sphn = ?");
            ps.setString(1, phn);
            rs=ps.executeQuery();
            if(rs.next())
            {
                return true;
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
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }
    public boolean isPhnexistr(String phn)
    {
        try {
            ps=con.prepareStatement("select * from recruiter where rphn = ?");
            ps.setString(1, phn);
            rs=ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }
    public boolean isjid(int id)
    {
        try {
            ps=con.prepareStatement("select * from jseeker where id = ?");
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }
    public boolean isrid(int id)
    {
        try {
            ps=con.prepareStatement("select * from recruiter where rid = ?");
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next())
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;  
    }
    public void insert(int id,String mail,String fname,String pass,String phn,String add,String dob,String gen)
    {
        String sql = "insert into jseeker (id, semail, sname, spass, sphn, sadd, sdob, sgender) values(?,?,?,?,?,?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, mail);
            ps.setString(3, fname);
            ps.setString(4, pass);
            ps.setString(5, phn);
            ps.setString(6, add);
            ps.setString(7, dob);
            ps.setString(8, gen);
            if(ps.executeUpdate()>0)
            {
                JOptionPane.showMessageDialog(null, "Registration Successful! Welcome to CareerPathX!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insertr(int id,String mail,String fname,String pass,String phn,String add,String dob,String gen)
    {
        String sql = "insert into recruiter (rid, remail, rname, rpass, rphn, radd, rdob, rgender) values(?,?,?,?,?,?,?,?)";
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, mail);
            ps.setString(3, fname);
            ps.setString(4, pass);
            ps.setString(5, phn);
            ps.setString(6, add);
            ps.setString(7, dob);
            ps.setString(8, gen);
            if(ps.executeUpdate()>0)
            {
                JOptionPane.showMessageDialog(null, "Registration Successful! Welcome to CareerPathX!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
