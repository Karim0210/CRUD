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
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
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
    @FXML
    private Button btnaccueil;
    @FXML
    private Button btnlistepediatre;
    @FXML
    private ImageView erreurnom;
    @FXML
    private ImageView erreurprenom;
    @FXML
    private ImageView erreuremail;
    @FXML
    private ImageView erreurspecialite;
    @FXML
    private ImageView erreurnum;
    @FXML
    private ImageView erreuradresse;
    @FXML
    private ImageView erreurparcours;
    @FXML
    private ImageView erreurformation;
    @FXML
    private ImageView erreurdescription;
    @FXML
    private ImageView erreurimg;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        
        erreurnom.setVisible(false);
        erreurprenom.setVisible(false);
        erreuremail.setVisible(false);
        erreuradresse.setVisible(false);
        erreurdescription.setVisible(false);
        erreurformation.setVisible(false);
        erreurnum.setVisible(false);
        erreurspecialite.setVisible(false);
        erreurparcours.setVisible(false);
        erreurimg.setVisible(false);
        
        
        
        
        
    }    
    
    public boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }
    
    public boolean checkTextField(TextField text) {
        if (text.getText().isEmpty()) {
            return false;
        } else if (Pattern.matches("[a-zA-Z]+", text.getCharacters())) {
            return true;
        }

        return false;
    }

    @FXML
    private void ajouterPediatre(ActionEvent event) throws IOException {
        
        Boolean verif = true;
        if(nomT.getText().equals("") || nomT.getText().contains(" ") || checkTextField(nomT)==false)
        {erreurnom.setVisible(true);verif=false;}
        else{erreurnom.setVisible(false);}
       
        if(prenomT.getText().equals("") || prenomT.getText().contains(" ") || checkTextField(prenomT)==false)
        {erreurprenom.setVisible(true);verif=false;}
        else{erreurprenom.setVisible(false);}
        
        if(emailT.getText().equals("") || emailT.getText().contains(" ") || isValid(emailT.getText())==false )
        {erreuremail.setVisible(true);verif=false;}
        else{erreuremail.setVisible(false);}
        
         if(specialiteT.getText().equals("") || specialiteT.getText().contains(" ") || checkTextField(specialiteT)==false)
        {erreurspecialite.setVisible(true);verif=false;}
        else{erreurspecialite.setVisible(false);}
          
         if(numT.getText().equals("") || numT.getText().contains(" ")|| !numT.getText().matches("[0-9]+") || numT.getText().length()!=8)
        {erreurnum.setVisible(true);verif=false;}
        else{erreurnum.setVisible(false);}
         
         if(parcoursT.getText().equals("") || parcoursT.getText().contains(" ") || checkTextField(parcoursT)==false)
        {erreurparcours.setVisible(true);verif=false;}
        else{erreurparcours.setVisible(false);}
          
         if(formationT.getText().equals("") || formationT.getText().contains(" ") || checkTextField(formationT)==false)
        {erreurformation.setVisible(true);verif=false;}
        else{erreurformation.setVisible(false);}
           
         if(descriptionT.getText().equals("") || descriptionT.getText().contains(" ") || checkTextField(descriptionT)==false)
        {erreurdescription.setVisible(true);verif=false;}
        else{erreurdescription.setVisible(false);}
            
         if(adresseT.getText().equals("") || adresseT.getText().contains(" ") || checkTextField(adresseT)==false)
        {erreuradresse.setVisible(true);verif=false;}
        else{erreuradresse.setVisible(false);}
         
         if(selectedFile == null )
        {erreurimg.setVisible(true);verif=false;}
        else{erreurimg.setVisible(false);}
         
          
   
       
        
        
        
        if(verif==true)
        {
     
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
        p.setDemande(0);
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
    private void returnAccueil(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Menu.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.show();
       
       ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
}
