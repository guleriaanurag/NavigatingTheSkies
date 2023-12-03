/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anurag.navigatingtheskies.Database;
import java.sql.*;
import com.anurag.navigatingtheskies.models.Ticket;
import com.anurag.navigatingtheskies.models.ExtendedTicket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guler
 */
public class TicketDAO {
    private DatabaseConnector databaseConnector;
    private Connection connection;
    
    public TicketDAO(){
        databaseConnector = new DatabaseConnector();
    }
    
    public void createTicket(String userName,String flightId,int seats,int amount) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO ticket (user_name,flight_id,seats_booked,amount) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, flightId);
            preparedStatement.setInt(3, seats);
            preparedStatement.setInt(4, amount);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0){
                sql = "UPDATE flight SET seats=seats-? where flight_id=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, seats);
                preparedStatement.setString(2,flightId);
                preparedStatement.executeUpdate();
                System.out.println("ticket created");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
    }
    
//    Fetch Operations
    
    public List<ExtendedTicket> fetchTickets(String userName) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<ExtendedTicket> tickets = new ArrayList<>();
        try {
            String sql = "SELECT ticket.ticket_id,ticket.flight_id,flight.departure_date,flight.arrival_date,flight.flight_source,flight.flight_destination FROM ticket JOIN flight ON ticket.flight_id=flight.flight_id WHERE ticket.user_name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                ExtendedTicket et = new ExtendedTicket();
                et.setId(rs.getInt("ticket_id"));
                et.setFlightId(rs.getString("flight_id"));
                et.setDepartureDate(rs.getDate("departure_date").toLocalDate());
                et.setArrivalDate(rs.getDate("arrival_date").toLocalDate());
                et.setSource(rs.getString("flight_source"));
                et.setDestination(rs.getString("flight_destination"));
                
                tickets.add(et);
            }
            
            return tickets;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(rs!=null){
                rs.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
        return null;
    }
    
    public ExtendedTicket fetchTicketDetails(int ticketId,String flightId) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        ExtendedTicket et = new ExtendedTicket();
        try {
            String sql = "SELECT p.passenger_name,p.mail,p.tel,"
                       + "f.airlines_name,f.flight_source,f.flight_destination,f.departure_date,f.departure_time,f.arrival_date,f.arrival_time,"
                       + "t.seats_booked,t.amount FROM ticket t "
                       + "JOIN passenger p on t.user_name=p.user_name "
                       + "JOIN flight f on t.flight_id=f.flight_id "
                       + "WHERE t.ticket_id=? AND t.flight_id=? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ticketId);
            preparedStatement.setString(2, flightId);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                et.setPassengerName(rs.getString("passenger_name"));
                et.setMail(rs.getString("mail"));
                et.setTel(rs.getString("tel"));
                et.setFlightId(flightId);
                et.setAirlinesName(rs.getString("airlines_name"));
                et.setSource(rs.getString("flight_source"));
                et.setDestination(rs.getString("flight_destination"));
                et.setDepartureDate(rs.getDate("departure_date").toLocalDate());
                et.setDepartureTime(rs.getTime("departure_time").toLocalTime());
                et.setArrivalDate(rs.getDate("arrival_date").toLocalDate());
                et.setArrivalTime(rs.getTime("arrival_time").toLocalTime());
                et.setSeatsBooked(rs.getInt("seats_booked"));
                et.setAmount(rs.getInt("amount"));
                
                return et;
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(rs!=null){
                rs.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
        return null;
    }
    
    public int fetchSeatsBooked(int ticketId) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT seats_booked FROM ticket where ticket_id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, ticketId);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("seats_booked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ps!=null){
                ps.close();
            }
            if(rs!=null){
                rs.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
        return 0;
    }
    
//    DELETE OPERATION
    
    public boolean deleteTicket(int ticketId,String FlightId) throws SQLException{
        this.connection = null;
        PreparedStatement preparedStatement = null;
        try {
            int seatsBooked = fetchSeatsBooked(ticketId);
            this.connection = new DatabaseConnector().getConnection();
            String ticketDeleteSQL = "DELETE from ticket WHERE ticket_id=?";
            preparedStatement = connection.prepareStatement(ticketDeleteSQL);
            preparedStatement.setInt(1, ticketId);
            int ticketDeleted = preparedStatement.executeUpdate();
            
            String updateFlightSeatsSQL = "UPDATE flight SET seats=seats+? WHERE flight_id=?";
            preparedStatement = connection.prepareStatement(updateFlightSeatsSQL);
            preparedStatement.setInt(1, seatsBooked);
            preparedStatement.setString(2, FlightId);
            int flightSeatsUpdated = preparedStatement.executeUpdate();
                
            return ticketDeleted>0 || flightSeatsUpdated>0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
        return false;
    }
    
}
