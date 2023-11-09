/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package careerpathx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class WatermarkTextFieldExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Watermark Text Field Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Create a custom JTextField with a watermark background
        CustomTextField textField = new CustomTextField("Enter your text here...");

        frame.add(textField);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }

    static class CustomTextField extends JTextField {
        private String watermark;

        public CustomTextField(String watermark) {
            this.watermark = watermark;
            setForeground(Color.GRAY);
            setText(watermark);
            addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (getText().equals(watermark)) {
                        setText("");
                        setForeground(Color.BLACK);
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (getText().isEmpty()) {
                        setText(watermark);
                        setForeground(Color.GRAY);
                    }
                }
            });
        }
    }
}

