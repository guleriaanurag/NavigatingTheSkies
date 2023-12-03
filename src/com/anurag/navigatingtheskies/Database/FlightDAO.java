/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anurag.navigatingtheskies.Database;

import java.sql.*;
import com.anurag.navigatingtheskies.models.Flight;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guler
 */
public class FlightDAO {
    private DatabaseConnector databaseConnector;
    private Connection connection;
    
    public FlightDAO(){
        databaseConnector = new DatabaseConnector();
    }
    
    public void addFlight(Flight flight) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO flight VALUES (?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, flight.getFlightId());
            preparedStatement.setString(2, flight.getAirlinesName());
            preparedStatement.setString(3, flight.getSource());
            preparedStatement.setString(4, flight.getDestination());
            preparedStatement.setDate(5, Date.valueOf(flight.getDepartureDate()));
            preparedStatement.setDate(6, Date.valueOf(flight.getArrivalDate()));
            preparedStatement.setTime(7, Time.valueOf(flight.getDepartureTime()));
            preparedStatement.setTime(8, Time.valueOf(flight.getArrivalTime()));
            preparedStatement.setInt(9, flight.getSeats());
            preparedStatement.setInt(10, flight.getPrice());
            preparedStatement.executeUpdate();
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
    
    public ArrayList<Flight> fetchFlights(String source,String destination) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM flight WHERE flight_source=? AND flight_destination=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, source);
            preparedStatement.setString(2, destination);
            rs = preparedStatement.executeQuery();
            ArrayList<Flight> flights = new ArrayList<>();
            if(rs.next()){
                Flight flight = new Flight();
                flight.setFlightId(rs.getString("flight_id"));
                flight.setSource(rs.getString("flight_source"));
                flight.setDestination(rs.getString("flight_destination"));
                flight.setDepartureDate(rs.getDate("departure_date").toLocalDate());
                flight.setDepartureTime(rs.getTime("departure_time").toLocalTime());
                flight.setArrivalDate(rs.getDate("arrival_date").toLocalDate());
                flight.setArrivalTime(rs.getTime("arrival_time").toLocalTime());
                flight.setSeats(rs.getInt("seats"));
                flight.setPrice(rs.getInt("price"));
                
                flights.add(flight);
            }
            return flights;
        } catch (Exception e) {
            e.printStackTrace();
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
    
    public Flight fetchFlightDetails(String flightId) throws SQLException{
        Flight flight = new Flight();
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM flight WHERE flight_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, flightId);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                flight.setFlightId(rs.getString("flight_id"));
                flight.setAirlinesName(rs.getString("airlines_name"));
                flight.setSource(rs.getString("flight_source"));
                flight.setDestination(rs.getString("flight_destination"));
                flight.setDepartureDate(rs.getDate("departure_date").toLocalDate());
                flight.setDepartureTime(rs.getTime("departure_time").toLocalTime());
                flight.setArrivalDate(rs.getDate("arrival_date").toLocalDate());
                flight.setArrivalTime(rs.getTime("arrival_time").toLocalTime());
                flight.setSeats(rs.getInt("seats"));
                flight.setPrice(rs.getInt("price"));
                                
                return flight;
            }
        } catch (Exception e) {
            e.printStackTrace();
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
    
    public List<Flight> fetchFlightsByAirlines(String airlinesName) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT flight_id,flight_source,flight_destination FROM flight WHERE airlines_name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,airlinesName);
            rs = preparedStatement.executeQuery();
            List<Flight> flights = new ArrayList<>();
            while(rs.next()){
                Flight flight = new Flight();
                flight.setFlightId(rs.getString("flight_id"));
                flight.setSource(rs.getString("flight_source"));
                flight.setDestination(rs.getString("flight_destination"));
                flights.add(flight);
                return flights;
            }
        } catch (Exception e) {
            e.printStackTrace();
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
    
//    Update Operation
    
    public boolean updateFlightDetails(Flight flight) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE flight SET departure_date=?,departure_time=?,arrival_date=?,arrival_time=?,price=? WHERE flight_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, flight.getDepartureDate());
            preparedStatement.setObject(2,flight.getDepartureTime());
            preparedStatement.setObject(3, flight.getArrivalDate());
            preparedStatement.setObject(4,flight.getArrivalTime());
            preparedStatement.setInt(5, flight.getPrice());
            preparedStatement.setString(6, flight.getFlightId());
            int flightUpdated = preparedStatement.executeUpdate();
            return 0<=flightUpdated;
        } catch (Exception e) {
            e.getMessage();
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
    
//    Delete Operation
    
    public boolean deleteFlight(LocalDate date) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement psTicket = null;
        PreparedStatement psFlight = null;
        try {
            String ticket_sql = "DELETE t FROM ticket t JOIN flight f on t.flight_id=f.flight_id WHERE f.arrival_date < ?";
            psTicket = connection.prepareStatement(ticket_sql);
            psTicket.setObject(1, date);
            int ticketsDeleted = psTicket.executeUpdate();
            
            String flight_sql = "DELETE from flight WHERE arrival_date=?";
            psFlight = connection.prepareStatement(flight_sql);
            psFlight.setObject(1,date);
            int flightsDeleted = psFlight.executeUpdate();
            
            return flightsDeleted>0 || ticketsDeleted>0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(psTicket!=null){
                psTicket.close();
            }
            if(psFlight!=null){
                psFlight.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
        return false;
    }
    
}
