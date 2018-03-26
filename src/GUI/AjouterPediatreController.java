/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Pediatre;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.PediatreService;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class AjouterPediatreController implements Initializable {

    @FXML
    private TextField nomT;
    @FXML
    private TextField prenomT;
    @FXML
    private TextField emailT;
    @FXML
    private TextField specialiteT;
    @FXML
    private TextField numT;
    @FXML
    private TextField parcoursT;
    @FXML
    private TextField formationT;
    @FXML
    private Button ajouterbtn;
    @FXML
    private TextField descriptionT;
    @FXML
    private TextField adresseT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterPediatre(ActionEvent event) {
        
        PediatreService ps = new PediatreService();
        
        String nom = nomT.getText();
        String prenom = prenomT.getText();
        String email = emailT.getText();
        String specialite = specialiteT.getText();
        int num = Integer.parseInt(numT.getText());
        String parcours = parcoursT.getText();
        String formation = formationT.getText();
        String description = descriptionT.getText();
        String adresse = adresseT.getText();
        
        Pediatre p = new Pediatre();
        p.setNom(nom);
        p.setPrenom(prenom);
        p.setEmail(email);
        p.setSpecialite(specialite);
        p.setNum(num);
        p.setParcours(parcours);
        p.setFormation(formation);
        p.setDescription(description);
        p.setAdresse(adresse);
        p.setPrix(0);
        
        ps.ajouterPediatre(p);
       
    }
    
}
