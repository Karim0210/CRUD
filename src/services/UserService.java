/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.BCrypt;
import Entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.U;
import util.DataSource;

/**
 *
 * @author riadh
 */
public class UserService {
    
    Statement st;
    PreparedStatement pst;
    ResultSet res;
    
    
    static DataSource ds =DataSource.getInstance(); 
     //public Statement ste;
   //ResultSet res;
    
  
    public User getLoginAccount(String login, String password) throws SQLException {
//        
//        System.out.println(login+password);
//        
//        String mdpcript;
//        mdpcript = BCrypt.hashpw(password,BCrypt.gensalt());
//        mdpcript = "$2y" + mdpcript.substring(3);
//        //$2y$13$cYuQi6YOgi21XVw0GSiEH.g8uVQLLoEFF7dlBtWUEnoljHGxCt1SS
//
//        
//        System.out.println(mdpcript);
        String req="select * from user where username='"+login;  
  User p=new User();         
        PreparedStatement ste = ds.getConnection().prepareStatement(req) ;

        res=ste.executeQuery(req);
 
        if(res.next())
           {
               p.setId(res.getInt("id"));
            p.setUsername(res.getString("username"));
            p.setCanonicalUsername(res.getString("username_canonical"));
            p.setEmail(res.getString("email"));
            p.setCanonicalEmail(res.getString("email_canonical"));
            p.setEnabled(res.getInt("enabled"));
            p.setPassword(res.getString("password"));
           // p.setLastLogin(res.getInt("last_login"));
            p.setRole(res.getString("roles"));
            p.setNbJetons(res.getInt("nbJetons"));

            
             //  p = this.getOne(res.getInt("id"));
               System.out.println("monuserrrr ="+p);
           }
        else 
           {
               System.out.println("Introuvable user");}

        return p;
    }
    

    public User getOne(int id) throws SQLException {
       String req="select * from user where id="+id;  
        User p=new User();
        
            //st=Connexion.getInstance().getConnection().createStatement();
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;

            res=ste.executeQuery(req);
            while(res.next()){
            p.setId(res.getInt("id"));
            p.setUsername(res.getString("username"));
            p.setCanonicalUsername(res.getString("username_canonical"));
            p.setEmail(res.getString("email"));
            p.setCanonicalEmail(res.getString("email_canonical"));
            p.setEnabled(res.getInt("enabled"));
            p.setPassword(res.getString("password"));
           // p.setLastLogin(res.getInt("last_login"));
            p.setRole(res.getString("roles"));
                        p.setNbJetons(res.getInt("nbJetons"));


            

            
        }
        
        
        return p;
     }
    
    
     public void modifierNbJetons (User u)
    {
        
        
      String req="update user set nbJetons='"+u.getNbJetons()+"' where id="+u.getId();  
       
        try {
            PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ArticleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public User CheckLogin(String username,String password) throws SQLException{
        
        String req = "Select * from user WHERE username ='"+username+"';";
         
         PreparedStatement ste = ds.getConnection().prepareStatement(req) ;
        res=ste.executeQuery(req);
     User p=new User(); 
       
        while(res.next())
        {
          //  System.out.println(res.getString(1));
           // String test=res.getString(2);
           // System.out.println("VARIABLE TEST "+test);
               if(res.getString(2).equals(username))             
               { 
                   
           //// prend le role de la table users         
    /*String input = res.getString(12);
   SerializedPhpParser serializedPhpParser = new SerializedPhpParser(input);
  Object result = serializedPhpParser.parse();
   String test=result.toString();*/
  //System.out.println("SUBSTRING="+test.substring(2,test.indexOf('}')));  
                 
                
  
                   
      /*  SerializedPhpParser serializedPhpParser = new SerializedPhpParser(res.getString(12));
        Object result = serializedPhpParser.parse();

        System.out.println("LE ROLE EST = "+result.toString());
        System.out.println("LE ROLE  = "+result.toString().toUpperCase());*/
// gensalt's log_rounds parameter determines the complexity
// the work factor is 2**log_rounds, and the default is 10
System.out.println("Password FOS = " + res.getString(8));
// JBCrypt requires version $2a, change the prefix
String hashed2 = "$2a" + res.getString(8).substring(3);
System.out.println("HASHED PASSWORD =" + hashed2);

if (BCrypt.checkpw(password, hashed2)) {
    p.setId(res.getInt("id"));
            p.setUsername(res.getString("username"));
            p.setCanonicalUsername(res.getString("username_canonical"));
            p.setEmail(res.getString("email"));
            p.setCanonicalEmail(res.getString("email_canonical"));
            p.setEnabled(res.getInt("enabled"));
            p.setPassword(res.getString("password"));
           // p.setLastLogin(res.getInt("last_login"));
            p.setRole(res.getString("roles"));
            p.setNbJetons(res.getInt("nbJetons"));
                    

            
}
else
{
    System.out.println("DOES NOT MATCH");
}
              
               }
        }
                    System.out.println("USER 1  = "+p);

        return p;
     
    }
}






