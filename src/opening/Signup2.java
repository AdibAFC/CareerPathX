/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package opening;

import dao.userdao;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class Signup2 extends javax.swing.JFrame {

    /**
     * Creates new form Signup
     */
    userdao user = new userdao();
    Color notedit = new Color(204, 204, 204);

    public Signup2() {
        initComponents();
        init();
    }

    private void init() {
        uid.setEditable(false);
        //uid.setBackground(notedit);
        uid.setText(String.valueOf(user.getmaxrowr()));
        jLabel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Homapage frm = new Homapage();
                frm.setVisible(true);
                dispose();
            }
        });
        jLabel3.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                jLabel3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        close.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        close.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                close.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uid = new try__.TextField();
        fullname = new try__.TextField();
        emailsign = new try__.TextField();
        phonesign = new try__.TextField();
        jLabel2 = new javax.swing.JLabel();
        combobox1 = new try__.Combobox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        signpass = new careerpathx.PasswordField();
        textAreaScroll1 = new try__.TextAreaScroll();
        jTextArea1 = new try__.TextArea();
        jCheckBox2 = new try__.JCheckBoxCustom();
        jButton4 = new try__.ButtonGradient();
        jLabel3 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uid.setLabelText("UserID :");
        getContentPane().add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 310, -1));

        fullname.setLabelText("Full Name :");
        fullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fullnameKeyTyped(evt);
            }
        });
        getContentPane().add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 310, -1));

        emailsign.setLabelText("Email :");
        getContentPane().add(emailsign, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 310, -1));

        phonesign.setLabelText("Phone Number :");
        phonesign.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phonesignKeyPressed(evt);
            }
        });
        getContentPane().add(phonesign, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 310, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Date of Birth :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 80, 20));

        combobox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Female", "Male" }));
        combobox1.setSelectedIndex(-1);
        combobox1.setLabeText("Gender :");
        getContentPane().add(combobox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 310, 40));

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jDateChooser1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jDateChooser1FocusLost(evt);
            }
        });
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, 220, 50));

        signpass.setLabelText("Password");
        signpass.setShowAndHide(true);
        getContentPane().add(signpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 310, -1));

        textAreaScroll1.setLabelText("Address :");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        textAreaScroll1.setViewportView(jTextArea1);

        getContentPane().add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 310, 80));

        jCheckBox2.setText("I accept the privacy Policy");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, -1, -1));

        jButton4.setText("Sign up");
        jButton4.setColor1(new java.awt.Color(255, 153, 255));
        jButton4.setColor2(new java.awt.Color(0, 0, 153));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 310, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/icons8-back.gif"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/icons8-cross-30.png"))); // NOI18N
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 30, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/signup2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jDateChooser1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDateChooser1FocusGained

    }//GEN-LAST:event_jDateChooser1FocusGained

    private void jDateChooser1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDateChooser1FocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_jDateChooser1FocusLost

    private void phonesignKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phonesignKeyPressed
        // TODO add your handling code here:
        String phn = phonesign.getText();
        int l = phn.length();
        char c = evt.getKeyChar();
        if (c >= '0' && c <= '9') {
            if (l < 11) {
                phonesign.setEditable(true);
            } else {
                phonesign.setEditable(false);
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                phonesign.setEditable(true);
            } else {
                phonesign.setEditable(false);
            }
        }
    }//GEN-LAST:event_phonesignKeyPressed

    private void fullnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fullnameKeyTyped
        // TODO add your handling code here:
        char input = evt.getKeyChar();
        if (!(input < '0' || input > '9') && input != '\b') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Name doesn't contain any number!", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_fullnameKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (uid.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out the UserID", "Invalid", 2);
        } else if (fullname.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out the Full Name", "Invalid", 2);
        } else if (signpass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out the Password", "Invalid", 2);
        } else if (emailsign.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out the Email", "Invalid", 2);
        } else if (!emailsign.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(null, "Invalid Email Address", "Invalid", 2);
        } else if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please fill out the Date of Birth", "Invalid", 2);
        } else if (jTextArea1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill out the Address", "Invalid", 2);
        } else if (combobox1.getSelectedIndex()==-1) {
            JOptionPane.showMessageDialog(null, "Please,fill your Gender", "Invalid", 2);
        } else if (!jCheckBox2.isSelected()) {
            JOptionPane.showMessageDialog(null, "Sorry,you can not sign up", "Invalid", 2);
        } else {
            int id = Integer.parseInt(uid.getText());
            String fname = fullname.getText();
            String mail = emailsign.getText();
            String pass = signpass.getText();
            String phn = phonesign.getText();
            String add = jTextArea1.getText();
            String dob = "";
            Date selectedDate = jDateChooser1.getDate();
            if (selectedDate != null) {
                // Format the date in the desired format (you may need to adjust the format)
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dob = dateFormat.format(selectedDate);
            }
            String gen = "";

            String selectedGender = (String) combobox1.getSelectedItem();
            gen = selectedGender;

            if (!user.isEmailexistr(mail)) {
                if (!user.isPhnexistr(phn)) {
                    if (!user.isrid(id)) {
                        user.insertr(id, mail, fname, pass, phn, add, dob, gen);
                        Homapage hpage = new Homapage();
                        hpage.setVisible(true);
                        hpage.pack();
                        hpage.setLocationRelativeTo(null);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "This UserID already exists!", "Invalid", 2);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "This Phone number already exists!", "Invalid", 2);
                }
            } else {
                JOptionPane.showMessageDialog(null, "This Email Address already exists!", "Invalid", 2);
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Signup2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    private try__.Combobox combobox1;
    private try__.TextField emailsign;
    private try__.TextField fullname;
    private try__.ButtonGradient jButton4;
    private try__.JCheckBoxCustom jCheckBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private try__.TextArea jTextArea1;
    private try__.TextField phonesign;
    private careerpathx.PasswordField signpass;
    private try__.TextAreaScroll textAreaScroll1;
    private try__.TextField uid;
    // End of variables declaration//GEN-END:variables
}
