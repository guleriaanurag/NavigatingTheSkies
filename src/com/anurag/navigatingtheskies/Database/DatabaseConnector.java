/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anurag.navigatingtheskies.Database;

import java.sql.*;

/**
 *
 * @author guler
 */
public class DatabaseConnector {
    
    private static final String driverClassName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "Add your connection url";
    private static final String user = "Add your username";
    private static final String pass = "Add your password";
    private Connection connection;
    
    public DatabaseConnector(){
        try{
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, user, pass);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
}
