/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.anurag.navigatingtheskies.gui;

import com.anurag.navigatingtheskies.Database.FlightDAO;
import com.anurag.navigatingtheskies.Database.PassengerDAO;
import com.anurag.navigatingtheskies.Database.TicketDAO;
import com.anurag.navigatingtheskies.models.ExtendedTicket;
import com.anurag.navigatingtheskies.models.Flight;
import com.anurag.navigatingtheskies.models.Passenger;
import com.mysql.cj.util.SearchMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author guler
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    private static String userName;
    private static List<Flight> flights;
    
    public HomePage(String loggedInUserName) {
        initComponents();
        userName = loggedInUserName;
        PassengerDAO passengerDAO = new PassengerDAO();
        String passengerName="";
        try {
            passengerName = passengerDAO.fetchName(userName);
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        usernameLabel.setText("Hello, "+passengerName.toUpperCase());
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        editProfileBtn = new com.anurag.navigatingtheskies.gui.customComponents.RButton();
        usernameLabel = new javax.swing.JLabel();
        logOutBtn = new com.anurag.navigatingtheskies.gui.customComponents.RButton();
        changePassBtn = new com.anurag.navigatingtheskies.gui.customComponents.RButton();
        viewBookingsBtn = new com.anurag.navigatingtheskies.gui.customComponents.RButton();
        flightSource = new com.anurag.navigatingtheskies.gui.customComponents.CustomComboBox();
        flightDestination = new com.anurag.navigatingtheskies.gui.customComponents.CustomComboBox();
        searchFlightBtn = new com.anurag.navigatingtheskies.gui.customComponents.RButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Navigating The Skies");
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/iconImage.jpg")));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        editProfileBtn.setText("Edit Profile");
        editProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfileBtnActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("Segoe UI Symbol", 0, 22)); // NOI18N

        logOutBtn.setText("Log Out");
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });

        changePassBtn.setText("Change Password");
        changePassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassBtnActionPerformed(evt);
            }
        });

        viewBookingsBtn.setText("View Bookings");
        viewBookingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBookingsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewBookingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changePassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewBookingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        flightSource.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chandigarh", "Delhi", "Ahemdabad", "Jaipur", "Hyderabad", "Indore", "Mumbai", "Pune", "Bangalore", "Chennai" }));
        flightSource.setSelectedIndex(-1);
        flightSource.setLabeText("Select Source");

        flightDestination.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Chandigarh", "Delhi", "Ahemdabad", "Jaipur", "Hyderabad", "Indore", "Mumbai", "Pune", "Bangalore", "Chennai" }));
        flightDestination.setSelectedIndex(-1);
        flightDestination.setLabeText("Select Destination");

        searchFlightBtn.setBackground(new java.awt.Color(204, 204, 204));
        searchFlightBtn.setText("Search");
        searchFlightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFlightBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(flightSource, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(flightDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(searchFlightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(flightSource, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(flightDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(searchFlightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to log out?",
                "Logout Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        if(choice == JOptionPane.YES_OPTION){
            this.dispose();
            new LoginPage().setVisible(true);
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void searchFlightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFlightBtnActionPerformed
        try {
            // TODO add your handling code here:
            FlightDAO flightDAO = new FlightDAO();
            if(flightSource.getSelectedItem()==null || flightDestination.getSelectedItem()==null){
                JOptionPane.showMessageDialog(null,"Source/Destination cannot be empty","Alert",JOptionPane.INFORMATION_MESSAGE);
            }
            else if((flightSource.getSelectedItem()).equals(flightDestination.getSelectedItem())){
                JOptionPane.showMessageDialog(null,"Source and Destination cannot be same","Alert",JOptionPane.INFORMATION_MESSAGE);
            }
            flights = new ArrayList<>();
            flights = flightDAO.fetchFlights(flightSource.getSelectedItem().toString(),flightDestination.getSelectedItem().toString());
            if(flights!=null && !flights.isEmpty()){
                new FlightsPage(userName, flights).setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "No flights available","Info",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_searchFlightBtnActionPerformed

    private void editProfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfileBtnActionPerformed
        try {
            // TODO add your handling code here:
            PassengerDAO passengerDAO = new PassengerDAO();
            Passenger passenger = passengerDAO.fetchPassengerDetails(userName);
            new EditPassengerForm(passenger).setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_editProfileBtnActionPerformed

    private void changePassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassBtnActionPerformed
        // TODO add your handling code here:
        new ChangePassForm(userName).setVisible(true);
    }//GEN-LAST:event_changePassBtnActionPerformed

    private void viewBookingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBookingsBtnActionPerformed
        // TODO add your handling code here:
        List<ExtendedTicket> tickets = new ArrayList<>();
        TicketDAO ticketDAO = new TicketDAO();
        
        try {
            tickets = ticketDAO.fetchTickets(userName);
        } catch (SQLException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(tickets!=null || !tickets.isEmpty()){
            new ViewBookings(tickets).setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "You have no tickets booked","Info",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_viewBookingsBtnActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage(userName).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.anurag.navigatingtheskies.gui.customComponents.RButton changePassBtn;
    private com.anurag.navigatingtheskies.gui.customComponents.RButton editProfileBtn;
    private com.anurag.navigatingtheskies.gui.customComponents.CustomComboBox flightDestination;
    private com.anurag.navigatingtheskies.gui.customComponents.CustomComboBox flightSource;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private com.anurag.navigatingtheskies.gui.customComponents.RButton logOutBtn;
    private com.anurag.navigatingtheskies.gui.customComponents.RButton searchFlightBtn;
    private javax.swing.JLabel usernameLabel;
    private com.anurag.navigatingtheskies.gui.customComponents.RButton viewBookingsBtn;
    // End of variables declaration//GEN-END:variables
}
