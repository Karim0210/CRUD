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
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.PediatreService;

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
    @FXML
    private Label nbrlikes;
    @FXML
    private Label nbrrating;
    @FXML
    private Text formation;
    @FXML
    private Text parcours;
    @FXML
    private Text prenom;
    @FXML
    private Button btnrendezvous;
    
    private static ProfilPediatreController instance;
    @FXML
    private Button btnlike;
    @FXML
    private Button btnconsulter;
    @FXML
    private Button btnsignaler;
    @FXML
    private Button btnaccueil;
    @FXML
    private Button btnlistepediatre;
    /**
     * Initializes the controller class.
     */    
     public ProfilPediatreController()
    {
        instance = this;
    }
    
    public static ProfilPediatreController getInsatance()
    {
        return instance;
    }
    
    public Pediatre pediatre()
    {
        return (Pediatre) pinfo;
    }
    
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
        
        setPediatre(ListePediatreController.getInsatance().pediatre());
        description.setWrappingWidth(600);
              
    }    

    private void setPediatre(Pediatre p) {
        Image img=new Image("/images/"+p.getImage());
        this.imgpediatre.setImage(img);
        this.nom.setText(p.getNom());
        this.prenom.setText(p.getPrenom());
        this.specialite.setText(p.getSpecialite());
        this.description.setText(p.getDescription());
        this.formation.setText(p.getFormation());
        this.parcours.setText(p.getParcours());
        this.nbrvues.setText(String.valueOf(p.getVues()));
        this.nbrlikes.setText(String.valueOf(p.getLikes()));
        this.nbrrating.setText(String.valueOf(p.getRating()));
        //this.btnechange.setText(p.getParent().getNom());
        pinfo = p;
        
        
        
    }

    @FXML
    private void prendreRendezVous(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("RendezVous.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.show();
       
       ((Node) (event.getSource())).getScene().getWindow().hide();
        
    }

    @FXML
    private void like(ActionEvent event) {
        PediatreService ps=new PediatreService();
        System.out.println(pinfo.getLikes());
        pinfo.setLikes(pinfo.getLikes()+1);
        ps.modifierlikes(pinfo);
        btnlike.setVisible(false);
        this.nbrlikes.setText(String.valueOf(pinfo.getLikes()));
        
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
    private void btnreturn(ActionEvent event) throws IOException {
        
       Parent root= FXMLLoader.load(getClass().getResource("ListePediatre.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.show();
       
       ((Node) (event.getSource())).getScene().getWindow().hide(); 
    }
    
}
