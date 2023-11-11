/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package panelB;

/**
 *
 * @author Hp
 */
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class AutocompleteComboBox extends JComboBox<String> {
    private List<String> data;

    public AutocompleteComboBox() {
        initializeData();

        setEditable(true);
        getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                JTextField textField = (JTextField) getEditor().getEditorComponent();
                String input = textField.getText().toLowerCase();
                autoComplete(input);
            }
        });
    }

    private void initializeData() {
        data = new ArrayList<>();
        data.add("Apple");
        data.add("Banana");
        data.add("Orange");
        data.add("Mango");
        data.add("Grapes");
    }

    private void autoComplete(String input) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (String item : data) {
            if (item.toLowerCase().startsWith(input)) {
                model.addElement(item);
            }
        }
        setModel(model);
        setSelectedItem(input);
        showPopup();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("AutocompleteComboBox Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            AutocompleteComboBox autocompleteComboBox = new AutocompleteComboBox();
            frame.getContentPane().add(autocompleteComboBox);

            frame.setVisible(true);
        });
    }
}
