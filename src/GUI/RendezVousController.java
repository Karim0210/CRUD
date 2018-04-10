/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.User;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.xpath.internal.operations.Number;
import entities.Pediatre;
import entities.RendezVous;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.RendezVousService;


/**
 * FXML Controller class
 *
 * @author Karim
 */
public class RendezVousController implements Initializable {

    @FXML
    private DatePicker date;   
    @FXML
    private Label nom;
    private Label prenom;
    @FXML
    private Button btn;
    SendMail s;
    @FXML
    private Button btnaccueil;
    @FXML
    private Button btnlistepediatre;
    @FXML
    private JFXDatePicker heure;
    @FXML
    private JFXProgressBar barprogresse;
    private ImageView erreurnom;
    private ImageView erreurprenom;
    @FXML
    private ImageView erreurdate;
    @FXML
    private ImageView erreurheure;
    
    Boolean verif=true;
    @FXML
    private Label email;
    @FXML
    private AnchorPane an;
    User userinfo;
    @FXML
    private ImageView erreurnum;
    @FXML
    private JFXTextField num;
    
    Pediatre p ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p = ProfilPediatreController.getInsatance().pediatre();
         barprogresse.setVisible(false);
         
         btnaccueil.setStyle(
                
               
               "-fx-background-color: #ffffff;"+
               "-fx-border-radius: 4px;"+
               "-fx-padding: 4px 10px;"
        );
        btnlistepediatre.setStyle(
                
               
               "-fx-background-color: #ffffff;"+
               "-fx-border-radius: 4px;"+
               "-fx-padding: 4px 10px;"
        );
        
        erreurnum.setVisible(false);
        erreurdate.setVisible(false);
        erreurheure.setVisible(false);
        userinfo = LoginPageController.getInstance().userinfo();
        nom.setText(userinfo.getUsername());
        email.setText(userinfo.getEmail());
        
        
        
    }    

    @FXML
    private void rendezvous(ActionEvent event) throws SQLException {
        
        verif=true;
        
       
        if(date.getValue() == null)
        {erreurdate.setVisible(true);verif=false;}
        else{erreurdate.setVisible(false);}
        
//        if(heure.getValue()== null)
//        {erreurheure.setVisible(true);verif=false;}
//        else{erreurheure.setVisible(false);}
        
        if(num.getText()== null)
        {erreurnum.setVisible(true);verif=false;}
        else{erreurnum.setVisible(false);}
        
        if(verif== true)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("SORRY");
        RendezVousService rs=new RendezVousService();
        RendezVous r=new RendezVous();
        r.setIdPediatre(ProfilPediatreController.getInsatance().pediatre().getId());
        r.setIdUser(1);
        r.setNom(nom.getText());
        r.setHeure(java.sql.Time.valueOf(heure.getTime()));
        r.setDateRendezVous(java.sql.Date.valueOf(date.getValue()));
        
        System.out.println(heure.getTime().getHour());
        try {
            //System.out.println(rs.getdate(r.getIdPediatre(), (Date) r.getDateRendezVous(),r.getHeure()));
            if(rs.getdate(r.getIdPediatre(), (Date) r.getDateRendezVous(),heure.getTime())>=1)
            {
                alert.setContentText("sorry this time is already reserved");
                alert.showAndWait();
            }
            else if ((heure.getTime().getHour() > 8) && (heure.getTime().getHour() < 20)){
                rs.AjouterRendezVous(r);
                 s.send(email.getText(), "RendezVousPediatre", "Cordialement.", "all.for.kids.pidev@gmail.com", "all4kids",r);
                
               //////////sms////////
            
            
             try {
			// Construct data
			String apiKey = "apikey=" + "8awYUh/BZ3w-6KsXjFL5ovBVz1IxvOhFY0qhXdk9zu";
			//String message = "&message=" + "vous avez pris un rendez-vous le"+date+"à"+heure+" soyez le bienvenu";
                        String message = "&message=" + "vous avez pris un rendez-vous avec le docteur"+p.getNom()+" "+p.getPrenom()+"  le "+r.getDateRendezVous()+" à "+r.getHeure()+". Soyez le bienvenu";

			String sender = "&sender=" + "All4Kids";
			String numbers = "&numbers=" + "00216"+num.getText();
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				
                                JOptionPane.showMessageDialog(null, "message"+line);
			}
			rd.close();
			
			} catch (Exception e) {
			
                        JOptionPane.showMessageDialog(null, e);
		}
             
                
                
             Parent root= FXMLLoader.load(getClass().getResource("ListePediatre.fxml"));
             Scene scene = new Scene(root);
             Stage stage = new Stage();
             stage.setScene(scene);
             stage.show();
       
       ((Node) (event.getSource())).getScene().getWindow().hide();
            }
            else
        {
            alert.setContentText("sorry pediatre is close");
                alert.showAndWait();
               
        }
            
        } catch (Exception e) {
            alert.setContentText("sorry s");
            alert.showAndWait();
        }
        }
        
        
        
                
    }

    @FXML
    private void HoverImage(MouseEvent event) {
    }

    @FXML
    private void ExitHoverMenu(MouseEvent event) {
           ((Control)event.getSource()).setStyle("-fx-background-color: #666666;" +"-fx-text-fill: #F2F2F2;");
            ((Control)event.getSource()).setEffect(null);
            
            //POUR LE CHANGEMENT DE COULEUR DS IMAGES
             for( Node child: ((Control)event.getSource()).getChildrenUnmodifiable()) {
        if( child instanceof ImageView) {
           ImageView imageView = (ImageView) child;
            String string = imageView.getImage().impl_getUrl().substring(6, imageView.getImage().impl_getUrl().length());
            if(string.contains("icon11.png") ){
                 File file = new File("C://Users/Karim/Documents/NetBeansProjects/CRUD/src/images/icon1.png");
                 Image newImage = new Image(file.toURI().toString());
                 imageView.setImage(newImage);
            }
            else if(string.contains("icon22.png") ){
                 File file = new File("C://Users/Karim/Documents/NetBeansProjects/CRUD/src/images/icon2.png");
                 Image newImage = new Image(file.toURI().toString());
                 imageView.setImage(newImage);
            }
            else if(string.contains("icon33.png") ){
                 File file = new File("C://Users/Karim/Documents/NetBeansProjects/CRUD/src/images/icon3.png");
                 Image newImage = new Image(file.toURI().toString());
                 imageView.setImage(newImage);
            }
            else if(string.contains("icon4.png") ){
                 File file = new File("C://Users/Karim/Documents/NetBeansProjects/CRUD/src/images/icon41.png");
                 Image newImage = new Image(file.toURI().toString());
                 imageView.setImage(newImage);
            }
            else if(string.contains("icon5.png") ){
                 File file = new File("C://Users/Karim/Documents/NetBeansProjects/CRUD/src/images/icon6.png");
                 Image newImage = new Image(file.toURI().toString());
                 imageView.setImage(newImage);
            }
        }
          }
    }

    @FXML
    private void HoverMenu(MouseEvent event) {
            DropShadow dropShadow = new DropShadow();
            dropShadow.setRadius(16.01);
            dropShadow.setOffsetX(0);
            dropShadow.setOffsetY(10.0);
            dropShadow.setHeight(66.04);
            dropShadow.setColor(Color.color(0, 0, 0));
         ((Control)event.getSource()).setStyle("-fx-background-color: #F2F2F2;" +"-fx-text-fill: #666666;");
         ((Control)event.getSource()).setEffect(dropShadow);
         
         //POUR LE CHANGEMENT DE COULEUR DS IMAGES
          for( Node child: ((Control)event.getSource()).getChildrenUnmodifiable()) {
        if( child instanceof ImageView) {
            ImageView imageView = (ImageView) child;
            String string = imageView.getImage().impl_getUrl().substring(6, imageView.getImage().impl_getUrl().length());
            if(string.contains("icon1.png") ){
                 File file = new File("C://Users/Karim/Documents/NetBeansProjects/CRUD/src/images/icon11.png");
                 Image newImage = new Image(file.toURI().toString());
                 imageView.setImage(newImage);
            }
            else if(string.contains("icon2.png") ){
                 File file = new File("C://Users/Karim/Documents/NetBeansProjects/CRUD/src/images/icon22.png");
                 Image newImage = new Image(file.toURI().toString());
                 imageView.setImage(newImage);
            }
            else if(string.contains("icon3.png") ){
                 File file = new File("C://Users/Karim/Documents/NetBeansProjects/CRUD/src/images/icon33.png");
                 Image newImage = new Image(file.toURI().toString());
                 imageView.setImage(newImage);
            }
            else if(string.contains("icon41.png") ){
                 File file = new File("C://Users/Karim/Documents/NetBeansProjects/CRUD/src/images/icon4.png");
                 Image newImage = new Image(file.toURI().toString());
                 imageView.setImage(newImage);
            }
            else if(string.contains("icon6.png") ){
                 File file = new File("C://Users/Karim/Documents/NetBeansProjects/CRUD/src/images/icon5.png");
                 Image newImage = new Image(file.toURI().toString());
                 imageView.setImage(newImage);
            }
        }
          }
    }

    @FXML
    private void afficherBar(MouseEvent event) {
        barprogresse.setVisible(true);
    }

    @FXML
    private void returnListe(ActionEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("ListePediatre.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.show();
       
       ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    
}
