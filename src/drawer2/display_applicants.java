/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package drawer2;

import Connection.Myconnection;
import careerpathx.ScrollBarCustom;
import details.applicant_info;
import java.sql.PreparedStatement;
import drawer1.JobView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JScrollBar;

/**
 *
 * @author Hp
 */
public class display_applicants extends javax.swing.JPanel {

    /**
     * Creates new form display_applicants
     */
    AppView jblist = null;
    static int r_id = 0;
    public static void getrid(int x) {
        r_id = x;
        System.out.println(r_id);
    }

    public display_applicants() {
        initComponents();
        JScrollBar verticalScrollBar = ScrollView.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20);
        verticalScrollBar.setBlockIncrement(200);
        ScrollView.setVerticalScrollBar(new ScrollBarCustom());
//        set_job_combo();
//        update_list();
    }

    public void set_job_combo(int r_id) {
        jt.removeAllItems();
        jt.addItem(""); // Assuming 'jt' is a JComboBox or similar component
        try {
            Connection con = Myconnection.getConnection();
            String sql = "SELECT DISTINCT job_title FROM job_applications where rid=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, r_id); // Set the value for the parameter 'rid'
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jt.addItem(rs.getString("job_title"));
            }
            con.close(); // Close the connection when you're done
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update_list(int r_id) {
        String JT = (String) (jt.getSelectedIndex() == -1 ? "" : jt.getItemAt(jt.getSelectedIndex()));
        var jobs = new ArrayList<applicant_info>();

        try {
            Connection con = Myconnection.getConnection();
            String query = "SELECT * FROM job_applications WHERE job_title LIKE ? AND rid=?  ORDER BY job_title ASC";
            var st = con.prepareStatement(query);
            st.setString(1, JT.equals("") ? "%" : "%" + JT + "%");
            st.setInt(2,r_id);
            var rs = st.executeQuery();
            while (rs.next()) {
                jobs.add(new applicant_info(rs));
            }
            update_res_panel(new AppView(jobs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update_res_panel(AppView bv) {
        if (jblist != null) {
            ScrollView.getViewport().remove(jblist);
        }
        ScrollView.getViewport().add(bv);
        this.validate();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jt = new try__.Combobox();
        materialButton1 = new necesario.MaterialButton();
        ScrollView = new javax.swing.JScrollPane();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jt.setLabeText("Job Title");

        materialButton1.setBackground(new java.awt.Color(38, 129, 47));
        materialButton1.setForeground(new java.awt.Color(255, 255, 255));
        materialButton1.setText("Search Applicants");
        materialButton1.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        materialButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(jt, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(materialButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(materialButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ScrollView, javax.swing.GroupLayout.PREFERRED_SIZE, 1528, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(ScrollView, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void materialButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialButton1ActionPerformed
        // TODO add your handling code here:
        update_list(r_id);
    }//GEN-LAST:event_materialButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollView;
    private javax.swing.JPanel jPanel1;
    private try__.Combobox jt;
    private necesario.MaterialButton materialButton1;
    // End of variables declaration//GEN-END:variables
}
