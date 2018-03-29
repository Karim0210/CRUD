/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Pediatre;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class ProfilPediatreController implements Initializable {

    @FXML
    private ImageView imgpediatre;
    @FXML
    private Text nom;
    @FXML
    private Text description;
    @FXML
    private Text specialite;
    
    Pediatre pinfo;
    @FXML
    private Label nbrvues;

    /**
     * Initializes the controller class.
     */    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setPediatre(ListePediatreController.getInsatance().pediatre());
        description.setWrappingWidth(900);
              
    }    

    private void setPediatre(Pediatre p) {
        Image img=new Image("/images/"+p.getImage());
        this.imgpediatre.setImage(img);
        this.nom.setText(p.getNom());
        this.specialite.setText(p.getSpecialite());
        this.description.setText(p.getDescription());
        //this.btnechange.setText(p.getParent().getNom());
        pinfo = p;
        nbrvues.setText(String.valueOf(p.getVues()));
        
        
    }
    
}
