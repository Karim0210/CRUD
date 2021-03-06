/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.RendezVous;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import static services.PediatreService.ds;
import util.DataSource;

/**
 *
 * @author Karim
 */
public class RendezVousService {
    
    static DataSource ds =DataSource.getInstance(); 
    
    public void AjouterRendezVous( RendezVous r) throws SQLException
    {
        String req="INSERT INTO rendez_vous (idUser,idPediatre,dateRendezVous,nom,prenom,heure) VALUES(?,?,?,?,?,?)" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            ste.setInt(1,r.getIdUser()) ; 
            ste.setInt(2,r.getIdPediatre()) ; 
            ste.setDate(3, (Date) r.getDateRendezVous());
            ste.setString(4,r.getNom());
            ste.setString(5,r.getPrenom());
            ste.setTime(6,r.getHeure());
            
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
            System.out.println("probleme d'ajout");
        }
    }
    public int getdate(int idPediatre,Date DateRendezVous,LocalTime heure) throws SQLException
    {
        Time timemax = java.sql.Time.valueOf(heure);
        timemax.setMinutes(timemax.getMinutes() +30);
        Time timemin = java.sql.Time.valueOf(heure);
        timemin.setMinutes(timemin.getMinutes() -30);
        
        
       
        int d=0;
        String req="select count(id) from rendez_vous where (idPediatre="+idPediatre+" AND dateRendezVous='"+DateRendezVous+"' AND heure BETWEEN '"+timemin+"' AND '"+timemax+"' )";
        PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
        ResultSet result =ste.executeQuery() ; 
        while(result.next())
        {
            d=result.getInt(1);
        }
        return d;
        
    }
     
    
}
