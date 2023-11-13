/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package First;
import opening.Homapage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Hp
 */
public class WelcomePage extends javax.swing.JFrame {

    /**
     * Creates new form WelcomePage
     */
    public WelcomePage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadinglebel = new javax.swing.JLabel();
        loadingbar = new try__.ProgressBarCustom();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(900, 500));
        setMinimumSize(new java.awt.Dimension(900, 500));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loadinglebel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loadinglebel.setForeground(new java.awt.Color(255, 255, 255));
        loadinglebel.setText("Loading . . .");
        getContentPane().add(loadinglebel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 230, 30));
        getContentPane().add(loadingbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 900, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/CareerPathX_welcome2.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 900, 510));

        pack();
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(WelcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        WelcomePage sp = new WelcomePage();
        sp.setVisible(true);
        Homapage login = new Homapage();
        try {
            for (int i = 0; i <= 100; i++) {

                if (i == 10) {
                    sp.loadinglebel.setText("Turning On Modules ...");
                }
                if (i == 20) {
                    sp.loadinglebel.setText("Loading Modules ...");
                }
                if (i == 50) {
                    sp.loadinglebel.setText("Connecting to Database ...");
                }
                if (i == 70) {
                    sp.loadinglebel.setText("Connection Successful!");
                }
                if (i == 80) {
                    sp.loadinglebel.setText("Launching Application ...");
                }
                sp.loadingbar.setValue(i);
                Thread.sleep(5);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        sp.setVisible(false);
        login.setVisible(true);
        sp.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private try__.ProgressBarCustom loadingbar;
    private javax.swing.JLabel loadinglebel;
    // End of variables declaration//GEN-END:variables
}
