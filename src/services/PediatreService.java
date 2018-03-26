/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Pediatre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DataSource;

/**
 *
 * @author Karim
 */
public class PediatreService {
    
    static DataSource ds =DataSource.getInstance(); 
    
    
    public void ajouterPediatre (Pediatre p)
    {
    String req="INSERT INTO pediatre (nom,prenom,email,specialite,rating,adresse,prix,demande,description,image,formation,parcours,vues,likes,quiz,nbrQuiz,num,nbJetons) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            ste.setString(1,p.getNom()) ; 
            ste.setString(2,p.getPrenom()) ; 
            ste.setString(3,p.getEmail());
            ste.setString(4,p.getSpecialite());
            ste.setInt(5,p.getRating());
            ste.setString(6,p.getAdresse());
            ste.setDouble(7,p.getPrix()) ; 
            ste.setInt(8,p.getDemande()) ;
             ste.setString(9,p.getDescription()) ; 
            ste.setString(10,p.getImage()) ; 
            ste.setString(11,p.getFormation());
            ste.setString(12,p.getParcours());
            ste.setInt(13,p.getVues());
            ste.setInt(14,p.getLikes());
            ste.setInt(15,p.getQuiz()) ; 
            ste.setInt(16,p.getNbrQuiz()) ;
            ste.setInt(17,p.getNum()) ; 
            ste.setInt(18,p.getNbJetons()) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
            System.out.println("probleme d'ajout");
        }
    
    }
    
     
    public void modifierPediatre (Pediatre p)
    {
        
        
      String req="update pediatre set nom='"+p.getNom()+"', prenom='"+p.getPrenom()+"' , email='"+p.getEmail()+"' , specialite='"+p.getSpecialite()+"', adresse='"+p.getAdresse()+"' , description='"+p.getDescription()+"' where id="+p.getId();  
       
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void DeletPediatre (int id)
    {
    String req="DELETE  from pediatre where  id =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            
            ste.setInt(1,id) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
            System.out.println("probleme de suppression");
        }
    
      }
     
    public List<Pediatre> selectPediatre ()
    {
        List<Pediatre> list =new ArrayList<>() ; 
        String req ; 
        req = "SELECT *  FROM pediatre";
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            list.add(new Pediatre(
                    result.getInt("id"),
                    result.getString("nom"),
                    result.getString("prenom"),
                    result.getString("email"),
                    result.getString("specialite"),
                    result.getInt("rating"),
                    result.getString("adresse"),
                    result.getDouble("prix"),
                    result.getInt("demande"),
                    result.getString("description"),
                    result.getString("image"),
                    result.getString("formation"),
                    result.getString("parcours"),
                    result.getInt("vues"),
                    result.getInt("likes"),
                    result.getInt("quiz"),
                    result.getInt("nbrQuiz"),
                    result.getInt("num"),
                    result.getInt("nbJetons"))
                                    
                                  
            );      
            }
            
        } catch (SQLException ex) {
            System.out.println("problemme d'affichage");
        }
    return list ; 
      }
    
    public List<Pediatre> selectTrierPediatre ()
    {
        List<Pediatre> list =new ArrayList<>() ; 
        String req ; 
        req = "SELECT * FROM `pediatre` ORDER BY rating DESC LIMIT 5";
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            list.add(new Pediatre(
                    result.getInt("id"),
                    result.getString("nom"),
                    result.getString("prenom"),
                    result.getString("email"),
                    result.getString("specialite"),
                    result.getInt("rating"),
                    result.getString("adresse"),
                    result.getDouble("prix"),
                    result.getInt("demande"),
                    result.getString("description"),
                    result.getString("image"),
                    result.getString("formation"),
                    result.getString("parcours"),
                    result.getInt("vues"),
                    result.getInt("likes"),
                    result.getInt("quiz"),
                    result.getInt("nbrQuiz"),
                    result.getInt("num"),
                    result.getInt("nbJetons"))
                                    
                                  
            );      
            }
            
        } catch (SQLException ex) {
            System.out.println("problemme d'affichage trier");
        }
    return list ; 
      }
    
}
