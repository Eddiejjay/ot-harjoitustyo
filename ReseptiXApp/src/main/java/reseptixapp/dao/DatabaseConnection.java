/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptixapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mazeero
 */

/**
 
 * Tietokantayhteyden sisältävä luokka
 */
public class DatabaseConnection {
    private String databaseName;
     
    public DatabaseConnection(String databaseName) {
        this.databaseName = databaseName;
    }
     
     /**
    * Tietokanta yhteyden luominen
    
    * @return tietokanta yhteys
    */
    public Connection connect() {
        Connection con = null;
        try { 
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + databaseName + "");
//            System.out.println("Connected");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + "");
        }
      
        return con;
    }
    
}
