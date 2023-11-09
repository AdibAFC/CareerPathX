/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package careerpathx;

import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JTextField;

/**
 *
 * @author walisaalam
 */
public class MyTextField extends JTextField{

  
    public Icon getPrefixIcon() {
        return prefixIcon;
    }

   
    public void setPrefixIcon(Icon prefixIcon) {
        this.prefixIcon = prefixIcon;
    }

   
    public Icon getSuffixIcon() {
        return suffixIcon;
    }

    public void setSuffixIcon(Icon suffixIcon) {
        this.suffixIcon = suffixIcon;
    }

    
     private Icon prefixIcon;
     private Icon suffixIcon;
    public MyTextField(){
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
    }
    private void initBorder(){
        int left = 5;
        int right = 5;
        if( getPrefixIcon() != null){
            left = getPrefixIcon().getIconWidth();
        }
        if( getSuffixIcon() != null){
            right = getSuffixIcon().getIconWidth();
        }
        setBorder(javax.swing.BorderFactory.createEmptyBorder(5, left, 5, right));
    }
}
