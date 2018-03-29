/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Pediatre;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
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
    
    private  File selectedFile;
    private  FileChooser file;
    
    @FXML
    private ImageView imgpediatre;
    @FXML
    private AnchorPane ajoutpedanchor;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterPediatre(ActionEvent event) throws IOException {
        
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
        p.setImage(nom+prenom+".jpg");
        
       
            try{
            File f=new File(selectedFile.getAbsolutePath());
            f.renameTo(new File("C:\\Users\\Karim\\Documents\\NetBeansProjects\\CRUD\\src\\images\\"+nom+prenom+".jpg"));
            java.lang.Thread.sleep(1000);}
            catch(Exception errim)
            {System.out.println("Erreur image : "+errim.getMessage());};
     
        
        ps.ajouterPediatre(p);
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root= FXMLLoader.load(getClass().getResource("ListePediatre.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.show();
                
       
    }
    
    
    @FXML
    private void ajoutimage(MouseEvent event) throws InterruptedException {
        try
        {
        file=new FileChooser();
        selectedFile=file.showOpenDialog(null);
        Image i=new Image("file:\\"+selectedFile.getAbsolutePath());
        imgpediatre.setImage(i);
        }
        catch(Exception errim)
            {System.out.println("Erreur image : "+errim.getMessage());};
        

    }
    
}
