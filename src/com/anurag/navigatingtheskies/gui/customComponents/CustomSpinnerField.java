/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anurag.navigatingtheskies.gui.customComponents;

/**
 *
 * @author guler
 */
import javax.swing.*;
import java.awt.*;

public class CustomSpinnerField extends JSpinner {
    
    public CustomSpinnerField() {
        // Call the super constructor
        super();
        
        // Customize the appearance
        customizeAppearance();
    }
    
    private void customizeAppearance() {
        // Remove the default border
        setBorder(null);
        
        // Remove the editor's background
        JComponent editor = getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JTextField textField = ((JSpinner.DefaultEditor) editor).getTextField();
            textField.setBackground(Color.WHITE); // Set your desired background color
            textField.setBorder(null);
        }
        
        // Remove the arrow button's background
        Component arrowButton = getComponent(0);
        if (arrowButton instanceof JButton) {
            ((JButton) arrowButton).setBorder(null);
            arrowButton.setBackground(Color.WHITE); // Set your desired background color
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Spinner Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Use your custom spinner
            JSpinner customSpinner = new CustomSpinnerField();
            frame.add(customSpinner);

            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}


