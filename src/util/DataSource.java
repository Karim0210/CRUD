/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karim
 */
public class DataSource {
     private   String url="jdbc:mysql://localhost:3306/allkids" ; 
    private String user="root" ; 
   private String password =""; 
   static DataSource instance;
   
    Connection connection ; 
    
    public static DataSource getInstance(){
        if(instance==null){
            instance = new DataSource();
        }
        return instance;
    }
    
    
    private DataSource() {


      try { 
              Class.forName("com.mysql.jdbc.Driver");
          connection=DriverManager.getConnection(url, user, password) ;
      } catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    }

    public Connection getConnection() {
        return connection;
    }
    
}
