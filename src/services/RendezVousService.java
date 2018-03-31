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
        String req="INSERT INTO rendez_vous (idUser,idPediatre,dateRendezVous,nom,prenom) VALUES(?,?,?,?,?)" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            ste.setInt(1,r.getIdUser()) ; 
            ste.setInt(2,r.getIdPediatre()) ; 
            ste.setDate(3, (Date) r.getDateRendezVous());
            ste.setString(4,r.getNom());
            ste.setString(5,r.getPrenom());
            
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
            System.out.println("probleme d'ajout");
        }
    }
    public int getdate(int idPediatre,Date DateRendezVous) throws SQLException
    {
        int d=0;
        String req="select count(id) from rendez_vous where idPediatre="+idPediatre+" && dateRendezVous='"+DateRendezVous+" ";
        PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
        ResultSet result =ste.executeQuery() ; 
        while(result.next())
        {
            d=result.getInt(1);
        }
        return d;
        
    }
     
    
}
