/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Napoleao Kazu Onaya
 */
public class ConnectionFactory {
    
    private static Connection connection;
    private static final String url ="jdbc:mysql://localhost:3306/agenda";
    private static final String user ="root";
    private static final String password ="162130";
    
    public static Connection getConnection(){
        
        try {
        
            connection = null;
            
            Class.forName("com.mysql.jdbc.Driver");
            
            connection = DriverManager.getConnection(url, user, password);
            
            System.out.println("Estou conectado no banco!");
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    
}
