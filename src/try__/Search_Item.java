/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package try__;

/**
 *
 * @author Hp
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author RAVEN
 */
public class Search_Item extends javax.swing.JPanel {

    public Search_Item(DataSearch data) {
        initComponents();
        setData(data);
    }

    private void setData(DataSearch data) {
        addEventMouse(this);
        addEventMouse(lbText);
        addEventMouse(lbRemove);
        lbText.setText(data.getText());
        if (data.isStory()) {
            lbText.setForeground(new Color(29, 106, 205));
            lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            lbRemove.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else {
            lbRemove.setText("");
        }
    }

    private void addEventMouse(Component com) {
        com.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(new Color(215, 216, 216));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(Color.WHITE);
            }

        });
    }

    private ActionListener eventClick;
    private ActionListener eventRemove;

    public void addEvent(ActionListener eventClick, ActionListener eventRemove) {
        this.eventClick = eventClick;
        this.eventRemove = eventRemove;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
private void lbRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRemoveMouseClicked
        if (!lbRemove.getText().trim().equals("")) {
            eventRemove.actionPerformed(null);
        }
    }//GEN-LAST:event_lbRemoveMouseClicked

    private void lbTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTextMouseClicked
        eventClick.actionPerformed(null);
    }//GEN-LAST:event_lbTextMouseClicked
    public String getText() {
        return lbText.getText();
    }

    public void setSelected(boolean act) {
        if (act) {
            setBackground(new Color(215, 216, 216));
        } else {
            setBackground(Color.WHITE);
        }
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbRemove;
    private javax.swing.JLabel lbText;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
