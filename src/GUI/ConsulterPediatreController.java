/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

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
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        
        timemax = java.sql.Time.valueOf("00:00:00");
        tminute.setText("00:00:00");
        i=0;
        timer.start();
        
       
        
        
    } 

    @FXML
    private void terminerAppel(ActionEvent event) {
        timer.stop();
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
            
            if (i >= 5) {
                System.out.println("5aless");
                i=0;
            }
            
        }
        
    }

    
}
