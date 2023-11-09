/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package drawer1;

import Connection.Myconnection;
import dao.userdao;
import details.job_info;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import javax.imageio.ImageIO;
import javax.swing.Icon;

/**
 *
 * @author Hp
 */
public class job_view extends javax.swing.JPanel {

    /**
     * Creates new form job_view
     */
    job_info ji;
    static String name = "";
    int r_id = 0;
    Connection con = Myconnection.getConnection();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;

    public job_view(job_info ji) {

        initComponents();

        this.ji = ji;
        com.setText(ji.com);
        dl.setText(ji.Dl);
        jd.setText(ji.jobd);
        jt.setText(ji.jobt);
        loc.setText(ji.loc);
        qual.setText(ji.qual);
        if (ji.pp != null) {
            ImageIcon imageIcon = new ImageIcon(ji.pp);
            poster.setIcon(imageIcon);
        } else {
            poster.setIcon(null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        com = new javax.swing.JLabel();
        jt = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        dl = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        loc = new javax.swing.JTextField();
        apply = new rojeru_san.complementos.RSButtonHover();
        textAreaScroll1 = new try__.TextAreaScroll();
        jd = new try__.TextArea();
        textAreaScroll2 = new try__.TextAreaScroll();
        qual = new try__.TextArea();
        poster = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        com.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        com.setText("jLabel2");
        add(com, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 190, -1));

        jt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jt.setText("jLabel3");
        add(jt, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 190, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("deadline :");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, -1, 20));

        dl.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dl.setText("jLabel4");
        add(dl, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 190, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("location :");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, -1, 20));

        loc.setEditable(false);
        loc.setBackground(new java.awt.Color(255, 255, 255));
        loc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loc.setText("jTextField4");
        add(loc, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 200, -1));

        apply.setText("Apply");
        apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyActionPerformed(evt);
            }
        });
        add(apply, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 290, 120, -1));

        textAreaScroll1.setBackground(new java.awt.Color(255, 255, 255));
        textAreaScroll1.setLabelText("Description");

        jd.setEditable(false);
        jd.setBackground(new java.awt.Color(255, 255, 255));
        jd.setColumns(20);
        jd.setRows(5);
        textAreaScroll1.setViewportView(jd);

        add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 320, 110));

        textAreaScroll2.setLabelText("Qualification");
        textAreaScroll2.setOpaque(false);

        qual.setEditable(false);
        qual.setBackground(new java.awt.Color(255, 255, 255));
        qual.setColumns(20);
        qual.setRows(5);
        textAreaScroll2.setViewportView(qual);

        add(textAreaScroll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 310, 90));

        poster.setBackground(new java.awt.Color(255, 255, 255));
        poster.setForeground(new java.awt.Color(255, 255, 255));
        poster.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        add(poster, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 360));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/mic.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 200, 190));
    }// </editor-fold>//GEN-END:initComponents
public static void getname(String Name) {
        name = Name;
    }
    private void applyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyActionPerformed
        // TODO add your handling code here:

        try {
            ps = con.prepareStatement("SELECT rid FROM jobs WHERE company=? AND job_title=? AND location=? AND job_description=? AND qualification=? AND deadline=? AND status='ON' AND picture=?");
            ps.setString(1, ji.com);
            ps.setString(2, ji.jobt);
            ps.setString(3, ji.loc);
            ps.setString(4, ji.jobd);
            ps.setString(5, ji.qual);
            ps.setString(6, ji.Dl);
            ps.setBytes(7, ji.pp);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                r_id = rs.getInt("rid");
            }
        } catch (SQLException ex) {
            // Handle the exception appropriately, e.g., show an error message to the user.
            ex.printStackTrace(); // This is a simple way to log the exception for debugging.
        }
        jobseeker x = new jobseeker();
        Timestamp ada = new Timestamp(new Date().getTime());
        if (r_id == 0) {
            JOptionPane.showMessageDialog(this, name + ", We're extremely sorry,this job is not available! ", "Invalid", 2);
        } else {
            JOptionPane.showMessageDialog(this, name + ", your CV has been sent to Admin,you'll be informed soon");
            Icon icon = x.cv.getIcon();
            InputStream imgStream = null;
            if (icon != null) {
                BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics g = bi.createGraphics();
                icon.paintIcon(null, g, 0, 0);
                g.dispose();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    ImageIO.write(bi, "png", baos);
                } catch (IOException ex) {

                }
                imgStream = new ByteArrayInputStream(baos.toByteArray());
            }
            insert_in_adminaoo(r_id, ji.jobt, name, ada, imgStream);
        }

    }//GEN-LAST:event_applyActionPerformed
    public String getemail(int r_id) {
        try {
            ps = con.prepareStatement("select remail from recruiter where rid = ?");
            ps.setInt(1, r_id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("remail");
            }
        } catch (SQLException ex) {
            Logger.getLogger(jobseeker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return " ";
    }
    public void insert_in_adminaoo(int rid, String jt, String aname, Timestamp adate, InputStream cv) {
        String sql;
        try {
            if (cv != null) {
                sql = "insert into admin_approve (rid, job_title, applicant_name, application_date,approve,cv_data) values(?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setBinaryStream(6, cv);
            } else {
                sql = "insert into admin_approve (rid, job_title, applicant_name, application_date,approve) values(?,?,?,?,?)";
                ps = con.prepareStatement(sql);
            }

            ps.setInt(1, rid);
            ps.setString(2, jt);
            ps.setString(3, aname);
            ps.setTimestamp(4, adate);
            ps.setString(5, "No");

            if (ps.executeUpdate() > 0) {
                //JOptionPane.showMessageDialog(null, "Information Added", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userdao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public rojeru_san.complementos.RSButtonHover apply;
    public javax.swing.JLabel com;
    public javax.swing.JLabel dl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private try__.TextArea jd;
    public javax.swing.JLabel jt;
    public javax.swing.JTextField loc;
    public javax.swing.JLabel poster;
    private try__.TextArea qual;
    private try__.TextAreaScroll textAreaScroll1;
    private try__.TextAreaScroll textAreaScroll2;
    // End of variables declaration//GEN-END:variables
}