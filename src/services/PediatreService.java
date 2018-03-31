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
    public void modifierNbvue (Pediatre p)
    {
        
        
      String req="update pediatre set vues='"+p.getVues()+"' where id="+p.getId();  
       
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifierlikes (Pediatre p)
    {
        
        
      String req="update pediatre set likes='"+p.getLikes()+"' where id="+p.getId();  
       
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifierRating (Pediatre p)
    {
        
        
      String req="update pediatre set rating='"+p.getRating()+"' where id="+p.getId();  
       
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void setdemandeOn(int id){
        String req="update pediatre set demande=1 where id=?";  
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
            ste.setInt(1,id) ;
            ste.executeUpdate() ; 
        } catch (SQLException ex) {
            System.out.println("probleme d'activation");
        }
        
    }
    
    public void setdemandeOff(int id){
        String req="update pediatre set demande=0 where id=?";  
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
            ste.setInt(1,id) ;
            ste.executeUpdate() ; 
        } catch (SQLException ex) {
            System.out.println("probleme de desactivation");
        }
        
    }
    
    public Pediatre getOne(int id) {
        String req="select * from pediatre where id="+id;  
        Pediatre p=new Pediatre();
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
            ResultSet result =ste.executeQuery() ; 
            while (result.next()){
                    p.setId(result.getInt("id"));
                    p.setNom(result.getString("nom"));
                    p.setPrenom(result.getString("prenom"));
                    p.setEmail(result.getString("email"));
                    p.setSpecialite(result.getString("specialite"));
                    p.setRating(result.getInt("rating"));
                    p.setAdresse(result.getString("adresse"));
                    p.setPrix(result.getDouble("prix"));
                    p.setDemande(result.getInt("demande"));
                    p.setDescription(result.getString("description"));
                    p.setImage(result.getString("image"));
                    p.setFormation( result.getString("formation"));
                    p.setParcours(result.getString("parcours"));
                    p.setVues(result.getInt("vues"));
                    p.setLikes(result.getInt("likes"));
                    p.setQuiz(result.getInt("quiz"));
                    p.setNbrQuiz(result.getInt("nbrQuiz"));
                    p.setNum(result.getInt("num"));
                    p.setNbJetons(result.getInt("nbJetons"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(PediatreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;

    }
    public int getnbr(int id) throws SQLException{
          int count =0;
          String req="Select round(AVG(rating)) from pediatre where id="+id;
          PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
            ResultSet result =ste.executeQuery() ; 
            while (result.next()){
             count = result.getInt(1);
            }
          return count;
        
    }
    
    public double calculerRating(Pediatre p )
    {
        double rating = ((double) p.getLikes()/(double) p.getVues())*5;
        return rating;       
    }
}
