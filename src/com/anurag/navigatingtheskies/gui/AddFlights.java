/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.anurag.navigatingtheskies.gui;

import com.anurag.navigatingtheskies.Database.FlightDAO;
import com.anurag.navigatingtheskies.models.Flight;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author guler
 */
public class AddFlights extends javax.swing.JFrame {

    /**
     * Creates new form AddFlights
     */
    public AddFlights() {
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

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        flightIdTF = new com.anurag.navigatingtheskies.gui.customComponents.CustomTextField();
        submitBtn = new com.anurag.navigatingtheskies.gui.customComponents.RButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        departureTimeTF = new com.anurag.navigatingtheskies.gui.customComponents.CustomTextField();
        arrivalTimeTF = new com.anurag.navigatingtheskies.gui.customComponents.CustomTextField();
        priceTF = new com.anurag.navigatingtheskies.gui.customComponents.CustomTextField();
        backBtn = new javax.swing.JLabel();
        flightSource = new com.anurag.navigatingtheskies.gui.customComponents.CustomComboBox();
        flightDestination = new com.anurag.navigatingtheskies.gui.customComponents.CustomComboBox();
        seatsTF = new com.anurag.navigatingtheskies.gui.customComponents.CustomTextField();
        departureDateChooser = new com.toedter.calendar.JDateChooser();
        arrivalDateChooser = new com.toedter.calendar.JDateChooser();
        airlinesNameTF = new com.anurag.navigatingtheskies.gui.customComponents.CustomComboBox();
        flightCodeTF = new com.anurag.navigatingtheskies.gui.customComponents.CustomTextField();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Navigating The Skies");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/iconImage.jpg")));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 22)); // NOI18N
        jLabel1.setText("Add Flights");

        flightIdTF.setLabelText("Flight Id :");

        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Departure Date :");

        jLabel3.setText("Arrival Date :");

        departureTimeTF.setLabelText("Departure Time :");
        departureTimeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departureTimeTFActionPerformed(evt);
            }
        });

        arrivalTimeTF.setLabelText("Arrival Time :");
        arrivalTimeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrivalTimeTFActionPerformed(evt);
            }
        });

        priceTF.setLabelText("Price :");
        priceTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTFActionPerformed(evt);
            }
        });

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.jpg"))); // NOI18N
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        flightSource.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chandigarh", "Delhi", "Ahemdabad", "Jaipur", "Hyderabad", "Indore", "Mumbai", "Pune", "Bangalore", "Chennai" }));
        flightSource.setSelectedIndex(-1);
        flightSource.setLabeText("Source :");

        flightDestination.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chandigarh", "Delhi", "Ahemdabad", "Jaipur", "Hyderabad", "Indore", "Mumbai", "Pune", "Bangalore", "Chennai" }));
        flightDestination.setSelectedIndex(-1);
        flightDestination.setLabeText("Destination :");

        seatsTF.setLabelText("Seats Available :");
        seatsTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seatsTFActionPerformed(evt);
            }
        });

        airlinesNameTF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Air India", "Indigo", "SpiceJet", "GoAir", "Vistara", "Akasa Air" }));
        airlinesNameTF.setSelectedIndex(-1);
        airlinesNameTF.setLabeText("Airlines Name :");
        airlinesNameTF.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                airlinesNameTFItemStateChanged(evt);
            }
        });

        flightCodeTF.setEditable(false);
        flightCodeTF.setBackground(new java.awt.Color(255, 255, 255));
        flightCodeTF.setLabelText("Code :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(departureTimeTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(arrivalTimeTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(priceTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seatsTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(departureDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(arrivalDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(flightCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(flightIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(flightSource, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                        .addComponent(flightDestination, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(airlinesNameTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flightIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(flightCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(airlinesNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flightSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(flightDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(departureDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arrivalDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(departureTimeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(arrivalTimeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(seatsTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(priceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        if(verifyInput()){
            try {
                // TODO add your handling code here:
                //System.out.println(jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                Flight flight = new Flight();
                FlightDAO flightDAO = new FlightDAO();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

                flight.setFlightId(flightCodeTF.getText()+flightIdTF.getText());
                flight.setAirlinesName(airlinesNameTF.getSelectedItem().toString());
                flight.setSource(flightSource.getSelectedItem().toString());
                flight.setDestination(flightDestination.getSelectedItem().toString());
                flight.setDepartureDate(departureDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                flight.setArrivalDate(arrivalDateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                flight.setDepartureTime(LocalTime.parse(departureTimeTF.getText(),formatter));
                flight.setArrivalTime(LocalTime.parse(arrivalTimeTF.getText(),formatter));
                flight.setSeats(Integer.parseInt(seatsTF.getText()));
                flight.setPrice(Integer.parseInt(priceTF.getText()));

                flightDAO.addFlight(flight);
                JOptionPane.showMessageDialog(null, "Flight added");
                this.dispose();
                new AdminPanel().setVisible(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_submitBtnActionPerformed
    
    private boolean verifyInput() {
        
        String flightId = flightIdTF.getText();
        if (flightId.isEmpty() || flightId.length() != 3) {
            JOptionPane.showMessageDialog(this, "Flight ID should contain exactly 3 digits.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        try {
            int flightIdNumber = Integer.parseInt(flightId);
        // Additional checks if needed for the flightIdNumber
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Flight ID should be a valid integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (airlinesNameTF.getSelectedItem() == null || airlinesNameTF.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select an airline.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (flightSource.getSelectedItem() == null || flightSource.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a source.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (flightDestination.getSelectedItem() == null || flightDestination.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a destination.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (departureDateChooser.getDate() == null || arrivalDateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please select departure and arrival dates.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (departureTimeTF.getText().isEmpty() || arrivalTimeTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter departure and arrival times.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (seatsTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the number of seats.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            int seats = Integer.parseInt(seatsTF.getText());
            if (seats <= 0) {
                JOptionPane.showMessageDialog(this, "Number of seats must be greater than 0.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for seats.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (priceTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the price.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            int price = Integer.parseInt(priceTF.getText());
            if (price <= 0) {
                JOptionPane.showMessageDialog(this, "Price must be greater than 0.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for price.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // If all checks pass, return true
        return true;
    } 
    
    private void departureTimeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departureTimeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departureTimeTFActionPerformed

    private void arrivalTimeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrivalTimeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arrivalTimeTFActionPerformed

    private void priceTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTFActionPerformed

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new AdminPanel().setVisible(true);
    }//GEN-LAST:event_backBtnMouseClicked

    private void seatsTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seatsTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seatsTFActionPerformed

    private void airlinesNameTFItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_airlinesNameTFItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
        String selectedAirline = (String) airlinesNameTF.getSelectedItem();
        updateFlightCode(selectedAirline);
        }
    }//GEN-LAST:event_airlinesNameTFItemStateChanged
    
    private void updateFlightCode(String selectedAirline) {
        String flightCode;
        switch (selectedAirline) {
            case "Air India":
                flightCode = "AI";
                break;
            case "Indigo":
                flightCode = "6E";
                break;
            case "SpiceJet":
                flightCode = "SG";
                break;
            case "GoAir":
                flightCode = "G8";
                break;
            case "Vistara":
                flightCode = "UK";
                break;
            case "Akasa Air":
                flightCode = "QP";
                break;
            default:
                flightCode = "";
        }

        flightCodeTF.setText(flightCode);
    }
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
            java.util.logging.Logger.getLogger(AddFlights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFlights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFlights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFlights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFlights().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.anurag.navigatingtheskies.gui.customComponents.CustomComboBox airlinesNameTF;
    private com.toedter.calendar.JDateChooser arrivalDateChooser;
    private com.anurag.navigatingtheskies.gui.customComponents.CustomTextField arrivalTimeTF;
    private javax.swing.JLabel backBtn;
    private com.toedter.calendar.JDateChooser departureDateChooser;
    private com.anurag.navigatingtheskies.gui.customComponents.CustomTextField departureTimeTF;
    private com.anurag.navigatingtheskies.gui.customComponents.CustomTextField flightCodeTF;
    private com.anurag.navigatingtheskies.gui.customComponents.CustomComboBox flightDestination;
    private com.anurag.navigatingtheskies.gui.customComponents.CustomTextField flightIdTF;
    private com.anurag.navigatingtheskies.gui.customComponents.CustomComboBox flightSource;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private com.anurag.navigatingtheskies.gui.customComponents.CustomTextField priceTF;
    private com.anurag.navigatingtheskies.gui.customComponents.CustomTextField seatsTF;
    private com.anurag.navigatingtheskies.gui.customComponents.RButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
