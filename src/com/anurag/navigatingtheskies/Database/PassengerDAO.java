/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anurag.navigatingtheskies.Database;

import java.sql.*;
import com.anurag.navigatingtheskies.models.Passenger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author guler
 */
public class PassengerDAO {
    private DatabaseConnector databaseConnector;
    private Connection connection;
    
    public PassengerDAO(){
//        databaseConnector = new DatabaseConnector();
    }
    
    public int createPassenger(Passenger passenger) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        try {
            String sql = "INSERT INTO passenger (user_name, passenger_name, mail, tel, age, gender ,password) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, passenger.getUserName());
            preparedStatement.setString(2, passenger.getName());
            preparedStatement.setString(3, passenger.getMail());
            preparedStatement.setString(4, passenger.getTel());
            preparedStatement.setInt(5,passenger.getAge());
            preparedStatement.setString(6, passenger.getGender());
            final String hashedPass = BCrypt.hashpw(passenger.getPassword(), BCrypt.gensalt(10));
            preparedStatement.setString(7, hashedPass);
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected>0) {
                System.out.println("passenger registered");
                return 1;
            }
        }
        catch(SQLIntegrityConstraintViolationException ex){
            return 1062;
        }
        finally{
            connection.close();
        }
        return 0;
    }
    
    public String fetchHashedPass(String user_name) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT password FROM passenger where user_name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_name);
            rs = preparedStatement.executeQuery();
            
            if(rs.next()){
                return rs.getString("password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null){
                rs.close();
            }
            if (preparedStatement!=null) {
                preparedStatement.close();
            }
            if (connection!=null) {
                connection.close();
            }
        }
        return null;
    }
    
    public String fetchRole(String user_name)throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement preparedStatement= null;
        ResultSet rs = null;
        try{
            String sql = "SELECT role FROM passenger WHERE user_name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_name);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                return rs.getString("role");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(rs!=null){
                rs.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
        return null;
    }
    
    public String fetchName(String user_name) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT passenger_name FROM passenger WHERE user_name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user_name);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                return rs.getString("passenger_name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null){
                rs.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
        return null;
    }
    
    public Passenger fetchPassengerDetails(String userName) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT passenger_name,mail,tel,age FROM passenger WHERE user_name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            rs = preparedStatement.executeQuery();
            Passenger passenger = new Passenger();
            if(rs.next()){
                passenger.setUserName(userName);
                passenger.setName(rs.getString("passenger_name"));
                passenger.setMail(rs.getString("mail"));
                passenger.setTel(rs.getString("tel"));
                passenger.setAge(rs.getInt("age"));
                return passenger;
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
    
    public void updatePassenger(Passenger passenger) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE passenger SET passenger_name=?,mail=?,tel=?,age=? WHERE user_name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passenger.getName());
            preparedStatement.setString(2, passenger.getMail());
            preparedStatement.setString(3, passenger.getTel());
            preparedStatement.setInt(4, passenger.getAge());
            preparedStatement.setString(5, passenger.getUserName());
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
    
    public void updateUserPass(String pass,String username) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE passenger SET password=? WHERE user_name=?";
            preparedStatement = connection.prepareStatement(sql);
            String hashedPass = BCrypt.hashpw(pass, BCrypt.gensalt(10));
            preparedStatement.setString(1, hashedPass);
            preparedStatement.setString(2, username);
            int rs = preparedStatement.executeUpdate();
            if(rs!=0){
                System.out.println("pass updated");
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
    
    public void updateLoginDate(String user_name) throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement prepsPreparedStatement = null;
        try {
            String sql = "UPDATE passenger set login_date=CURDATE() WHERE user_name=?";
            prepsPreparedStatement = connection.prepareStatement(sql);
            prepsPreparedStatement.setString(1, user_name);
            prepsPreparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(prepsPreparedStatement!=null){
                prepsPreparedStatement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
    }
    
    public boolean deletePassenger() throws SQLException{
        this.connection = new DatabaseConnector().getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM passenger WHERE login_date<CURDATE()-INTERVAL 6 MONTH";
            ps = connection.prepareStatement(sql);
            int passengerDeleted = ps.executeUpdate();
            return passengerDeleted>0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ps!=null){
                ps.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
        return false;
    }
}    
