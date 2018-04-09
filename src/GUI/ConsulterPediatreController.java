/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;
import entities.Pediatre;
import java.io.File;
import java.net.URL;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import services.PediatreService;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class ConsulterPediatreController implements Initializable {

    @FXML
    Text tminute = new Text();
    
    int i ;
    
    @FXML
    private AnchorPane karim;
    
    LocalTime heure;
    
    AnimationTimer timer = new MyTimer();
    
    Time timemax = java.sql.Time.valueOf("00:00:00");
    
    Thread thread = new Thread();
    
    @FXML
    private Button btnstop;
    @FXML
    private Button btnaccueil;
    @FXML
    private Label warning;
    @FXML
    private Text question;
    @FXML
    private JFXToggleButton q1;
    @FXML
    private JFXToggleButton q2;
    @FXML
    private JFXToggleButton q3;
    @FXML
    private JFXToggleButton q4;
    @FXML
    private JFXButton validerquestion;
    @FXML
    private Pane qpane;
    /**
     * Initializes the controller class.
     */
    int note;
    Pediatre pinfo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        
        pinfo = ProfilPediatreController.getInsatance().pediatre();
        
        qpane.setVisible(false);
        warning.setVisible(false);
        
        timemax = java.sql.Time.valueOf("00:00:00");
        tminute.setText("00:00:00");
        i=0;
        note=0;
        timer.start();
        
        

    
        
    } 

    @FXML
    private void terminerAppel(ActionEvent event) {
        timer.stop();
        qpane.setVisible(true);
        
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
    private void calculernote(ActionEvent event) {
        
        PediatreService ps = new PediatreService();
        
        if(q1.isSelected() == true){note++;}
        if(q2.isSelected() == true){note++;}
        if(q3.isSelected() == true){note++;}
        if(q4.isSelected() == true){note++;}
        

        pinfo.setQuiz(pinfo.getQuiz() + note);
        ps.modifierQuiz(pinfo);
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
  
    
    
   
        
    
    
    public class MyTimer extends AnimationTimer {

        @Override
        public void handle(long now) {
        
            try {
                doHandle();
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsulterPediatreController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void doHandle() throws InterruptedException {
            
            timemax.setSeconds(timemax.getSeconds()+1);
            
            thread.sleep(1000);
            tminute.setText(timemax.toString());
            i++;
            System.out.println(timemax.toString());
            warning.setVisible(false);

            if (i >= 10) {
                warning.setText("Vous avez dépassé 5 min avec le pediatre. Vous devez payer 100.");
                warning.setVisible(true);
              
                i=0;
            }
            
        }
        
    }

    
}
