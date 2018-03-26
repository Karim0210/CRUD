/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Article;
import entities.Pediatre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DataSource;

/**
 *
 * @author Karim
 */
public class ArticleService {
    
    static DataSource ds =DataSource.getInstance(); 
    
    
    public static void ajouterArticle (Article a)
    {
    String req="INSERT INTO article (nom,autheur,vues,text,likes,image,video,type,rating) VALUES(?,?,?,?,?,?,?,?,?)" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            ste.setString(1,a.getNom()) ; 
            ste.setString(2,a.getAutheur()) ; 
            ste.setInt(3,a.getVues());
            ste.setString(4,a.getText());
            ste.setInt(5,a.getLikes());
            ste.setString(6,a.getImage());
            ste.setString(7,a.getVideo()) ; 
            ste.setString(8,a.getType()) ;
            ste.setInt(9,a.getRating()) ;
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
            System.out.println("probleme d'ajout");
        }
    
    }
    
     
    public static void modifierArticle (Article a ,int id)
    {
    String req="UPDATE article SET nom=?,autheur=?,vues=?,text=?,likes=?,image=?,video=?,type=?,rating=? WHERE id =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
            ste.setString(1,a.getNom()) ; 
            ste.setString(2,a.getAutheur()) ; 
            ste.setInt(3,a.getVues());
            ste.setString(4,a.getText());
            ste.setInt(5,a.getLikes());
            ste.setString(6,a.getImage());
            ste.setString(7,a.getVideo()) ; 
            ste.setString(8,a.getType()) ;
            ste.setInt(9,a.getRating()) ; 
            ste.setInt(10,id) ;
            
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
            System.out.println("probleme de modification");
        }
    
    }
    
     public static void DeletArticle(int id)
    {
    String req="DELETE  from article where  id =?" ; 
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             
            
            ste.setInt(1,id) ;
            ste.executeUpdate() ; 
            
        } catch (SQLException ex) {
            System.out.println("probleme de suppression");
        }
    
      }
     
    public static List<Article> selectArticle ()
    {
        List<Article> list =new ArrayList<>() ; 
        String req ; 
        req = "SELECT *  FROM article";
        try { 
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
             ResultSet result =ste.executeQuery() ; 
            while (result.next()){
            list.add(new Article(
                    result.getInt("id"),
                    result.getString("nom"),
                    result.getString("autheur"),
                    result.getInt("vues"),
                    result.getString("text"),
                    result.getInt("likes"),
                    result.getString("image"),
                    result.getString("video"),
                    result.getString("type"),
                    result.getInt("rating"))
            );      
            }
            
        } catch (SQLException ex) {
            System.out.println("problemme d'affichage");
        }
    return list ; 
      }
    
    
}
