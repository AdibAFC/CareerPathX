/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package drawer1;

import Connection.Myconnection;
import java.security.Timestamp;
import menubar.Snotification;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Jnotification extends javax.swing.JFrame {

    /**
     * Creates new form Jnotification
     */
    String smail = "";
    ArrayList<String> s;

    public Jnotification() {
        initComponents();
        s = new ArrayList<>();
        //setNumbers();
    }

    public void getsmail(String mail) {
        smail = mail;
    }

    public void onNotificationDeleted() {
        refreshNotifications(); // Implement this method to refresh the notifications
    }

    private void refreshNotifications() {
        jPanel1.removeAll();
        setNumbers();
        verticalScrollBar.revalidate();
        verticalScrollBar.repaint();
    }

    public void create_noti(String str) {
        Snotification x = new Snotification();

        x.setlabel(str);
        //x.setNotificationDeletedListener((Snotification.NotificationDeletedListener) this); // Set the listener
        x.gets(s);
        jPanel1.add(x);
        verticalScrollBar.revalidate();
        verticalScrollBar.repaint();
    }

    Connection con = Myconnection.getConnection();

    public void setNumbers() {
        try {

            String sql = "SELECT * FROM interviewnotifications WHERE semail = ? and is_read=0";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, smail);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String rmail = rs.getString("remail");
                String msg = rs.getString("message");

                java.sql.Timestamp time = rs.getTimestamp("notification_timestamp");
                String str1 = rmail + " : " + msg + "           (" + time + ")";
                s.add(rmail);
                s.add(smail);
                create_noti(str1);
            }
        } catch (Exception e) {
            e.printStackTrace();
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

        verticalScrollBar = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        verticalScrollBar.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(verticalScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(verticalScrollBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jnotification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jnotification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jnotification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jnotification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jnotification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane verticalScrollBar;
    // End of variables declaration//GEN-END:variables
}
