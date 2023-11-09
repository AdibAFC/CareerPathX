/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package drawer;

import dao.ImageIconCellRenderer;
import dao.applicantdao;
import details.applicant_info;
import java.awt.Image;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Hp
 */
public class Notification extends javax.swing.JFrame {

    /**
     * Creates new form Notification
     */
    DefaultTableModel model = new DefaultTableModel();
    applicantdao ai = new applicantdao();

    public Notification() {
        initComponents();
        populatetable();
    }

    public void populatetable() {
        ArrayList<applicant_info> list = ai.BindTable();
        String[] colname = {"Application_ID", "Recruiter_id", "Job Title", "Applicant name", "CV data", "Application Date", "Approval"};
        Object[][] rows = new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            rows[i][0] = list.get(i).getApp_id();
            rows[i][1] = list.get(i).getRid();
            rows[i][2] = list.get(i).getJt();
            rows[i][3] = list.get(i).getAn();
            rows[i][4] = list.get(i).getCv();
            rows[i][5] = list.get(i).getAd();
            rows[i][6] = list.get(i).getAp();
            if (list.get(i).getCv() != null) {
                ImageIcon img = new ImageIcon(new ImageIcon(list.get(i).getCv()).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
                rows[i][4] = img;
            } else {
                rows[i][4] = null;
            }
        }
        model = new DefaultTableModel(rows, colname) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4) { // Assuming the "Profile Picture" column is at index 8
                    return ImageIcon.class;
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jtable.setModel(model);
        jtable.setRowHeight(120);
        jtable.getColumnModel().getColumn(4).setCellRenderer(new ImageIconCellRenderer());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new rojeru_san.complementos.RSTableMetro();
        combobox1 = new try__.Combobox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtable.setFuenteFilas(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtable.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtable.setFuenteHead(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable);

        combobox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));
        combobox1.setSelectedIndex(-1);
        combobox1.setLabeText("Approval");

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(combobox1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combobox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMouseClicked
        // TODO add your handling code here:

        int selrow = jtable.getSelectedRow();
        if (model.getValueAt(selrow, 6).toString().equals("Yes")) {
            combobox1.setSelectedIndex(0);
        } else if (model.getValueAt(selrow, 6).toString().equals("No")) {
            combobox1.setSelectedIndex(1);
        } else {
            combobox1.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_jtableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selrow = jtable.getSelectedRow();
        if (selrow >= 0) {
            int aid = (int) model.getValueAt(selrow, 0);
            int rid = (int) model.getValueAt(selrow, 1);
            String jt = (String) model.getValueAt(selrow, 2);
            String aname = (String) model.getValueAt(selrow, 3);

            // Convert the date string to a Timestamp
            Timestamp adate = (Timestamp) model.getValueAt(selrow, 5);

            InputStream cv = null; // You need to obtain the InputStream for CV data from your model.
            if (model.getValueAt(selrow, 4) != null) {
                cv = (InputStream) model.getValueAt(selrow, 4);
            }

            // Assuming combobox1 is a JComboBox
            if (combobox1.getSelectedItem().equals("Yes")) {
                // Perform database insert
                ai.insert_in_jobapp(rid, jt, aname, adate, cv);
                // Perform database delete
                ai.delete_from_adminapp(aid);
                // Refresh the table
                populatetable();
            } else if (combobox1.getSelectedItem().equals("No")) {
                // Perform database delete
                ai.delete_from_adminapp(aid);
                populatetable();
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private try__.Combobox combobox1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.complementos.RSTableMetro jtable;
    // End of variables declaration//GEN-END:variables
}