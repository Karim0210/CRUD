/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.User;
import entities.Pediatre;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import services.PediatreService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ListePediatreController implements Initializable {

    List<Pediatre> l= new ArrayList<Pediatre>();
    
    
    
    
    
    
    @FXML
    private ListView<Pane> listviewpediatre;
    
    private static ListePediatreController instance;
    @FXML
    private Button toppediatre;
    @FXML
    private Button btnajout;
    private Button btnlistepediatre;
    @FXML
    private Button btnaccueil;
    
    User userinfo;
    
    public ListePediatreController()
    {
        instance = this;
    }
    
    public static ListePediatreController getInsatance()
    {
        return instance;
    }
    
    public Pediatre pediatre()
    {
        return (Pediatre) listviewpediatre.getSelectionModel().getSelectedItem().getUserData();
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userinfo = LoginPageController.getInstance().userinfo();
              btnaccueil.setStyle(
               "-fx-background-color: #ffffff;"+
               "-fx-border-radius: 4px;"+
               "-fx-padding: 4px 10px;"
        );
        afficher();
    }  
    
    public void afficher(){
        
        PediatreService ps=new PediatreService();
        
        
        l.clear();
        listviewpediatre.getItems().clear();
        l = ps.selectPediatre();
        
        l.stream().filter(e->e.getDemande()==1).forEach((Pediatre p)->{
            
            Text fNom=new Text("Nom : ");
            Text fLikes=new Text("Likes : ");
            Text fSpecialite=new Text("Specialite : ");
            
            Text Nom=new Text(fNom.getText()+p.getNom());
            Text Likes=new Text(fLikes.getText()+p.getLikes());
            Text Specialite=new Text(fSpecialite.getText()+p.getSpecialite());
            
            /////css////
            Likes.setWrappingWidth(200);
            Nom.setFont(Font.font ("Ubuntu Bold", 15));
            Likes.setFont(Font.font ("Ubuntu Bold", 15));
            Specialite.setFont(Font.font ("Ubuntu Bold", 15));
            
            Nom.setStyle("-fx-fill: #1bb4b9");
            Specialite.setStyle("-fx-fill: #1bb4b9");
            //// fin css ////
            
            ////img////
            ImageView img=new ImageView();
            try{
                img=new ImageView("/images/"+p.getImage());
            }
            catch(Exception e)
                {img=new ImageView("/images/imgtraitemnt.png");}
            img.setFitHeight(100);
            img.setFitWidth(100);
            ////img////
            
            Pane pan=new Pane();
            Pane pan1=new Pane();
            Pane pan2=new Pane();
            Pane pan3=new Pane();
            Pane pan4=new Pane();
            
            img.layoutXProperty().bind(pan1.widthProperty().subtract(img.getFitWidth()).divide(2));
            pan1.getChildren().add(img);
            pan1.setPrefHeight(50);
            
            HBox hbox = new HBox();
            hbox.setSpacing(20);
            hbox.setTranslateX(120);
            hbox.setTranslateY(35);
            pan2.getChildren().add(Nom);
            pan2.setPrefHeight(50);
            hbox.getChildren().add(pan2);
            Rating rating = new Rating();
            try
                {
                    if(ps.getnbr(p.getId())==0)
                {
                    rating=new Rating(5,0);
                }
                    else
                {   
                    //System.out.println(Math.round(ps.calculerRating(p)));
                    rating = new Rating(5, (int) Math.round(ps.calculerRating(p)));
                    rating.setDisable(true);
                    
                }
                } catch (SQLException ex) {
                Logger.getLogger(ListePediatreController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            pan4.getChildren().add(rating);
            pan4.setTranslateX(450);
            pan4.setTranslateY(13);
            pan4.setPrefHeight(50);
            
            pan3.getChildren().add(Specialite);
            pan3.setPrefHeight(50);
            hbox.getChildren().add(pan3);
            hbox.getChildren().add(pan4);
            hbox.setAlignment(Pos.CENTER);
            pan.setUserData(p); //// emplacement pan ///
            pan.getChildren().add(pan1);
            pan.getChildren().add(hbox);
            pan.getChildren().get(0).setLayoutX(0);
           // pan.getChildren().add(pan2);
           // pan.getChildren().get(1).setLayoutX(110);
           // pan.getChildren().get(2).setLayoutX(250);
            pan.getChildren().add(pan4);
           // pan.getChildren().get(3).setLayoutX(450);
            pan.setTranslateY(30);
            
           listviewpediatre.getItems().add(pan);
           listviewpediatre.getItems().get(listviewpediatre.getItems().size()-1).setPrefHeight(100);
           
           
        });
       
        
    }

   

    @FXML
    private void handle(MouseEvent event) throws IOException, SQLException {
        
//

        PediatreService ps=new PediatreService();
        
        
        System.out.println(listviewpediatre.getSelectionModel().
                getSelectedItem().getUserData());
       Pediatre p=new Pediatre();
       p=(Pediatre) listviewpediatre.getSelectionModel().
                getSelectedItem().getUserData();
       
        if(ps.verifVues(p,userinfo)==0)
        {
            ps.AjouterVues(p, userinfo);
            p.setVues(p.getVues()+1);
            ps.modifierNbvue(p);
        }
        
        
        p.setRating((int)Math.round(ps.calculerRating(p)));
        ps.modifierRating(p);
        
        
        
       Parent root= FXMLLoader.load(getClass().getResource("ProfilPediatre.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.show();
       
       ((Node) (event.getSource())).getScene().getWindow().hide();
        
      
    }

//    @FXML
//    private void affichmesannonces(ActionEvent event) throws IOException {
//        
//       Parent root= FXMLLoader.load(getClass().getResource("AffichermesProduit.fxml"));
//       Scene scene = new Scene(root);
//       Stage stage = new Stage();
//       stage.setScene(scene);
//       stage.show();
//    }

    @FXML
    private void top(MouseEvent event) throws IOException {
       
       
        PediatreService ps=new PediatreService();   
               
        l.clear();
        listviewpediatre.getItems().clear();
        l = ps.selectPediatre();
        
        l.stream().filter(e->e.getDemande()==1).sorted((a,b)-> b.getRating() - a.getRating()).limit(3).forEach(p->{
            Text fNom=new Text("Nom : ");
            Text fLikes=new Text("Likes : ");
            Text fSpecialite=new Text("Specialite : ");
            
            Text Nom=new Text(fNom.getText()+p.getNom());
            Text Likes=new Text(fLikes.getText()+p.getLikes());
            Text Specialite=new Text(fSpecialite.getText()+p.getSpecialite());
            
            /////css////
            Likes.setWrappingWidth(200);
            Nom.setFont(Font.font ("Arial Black", 14));
            Likes.setFont(Font.font ("Arial Black", 14));
            Specialite.setFont(Font.font ("Arial Black", 14));
            //// fin css ////
            
            ////img////
            ImageView img=new ImageView("/images/"+p.getImage());
            img.setFitHeight(100);
            img.setFitWidth(100);
            ////img////
            
            Pane pan=new Pane();
            Pane pan1=new Pane();
            Pane pan2=new Pane();
            Pane pan3=new Pane();
            Pane pan4=new Pane();
            
            img.layoutXProperty().bind(pan1.widthProperty().subtract(img.getFitWidth()).divide(2));
            pan1.getChildren().add(img);
            pan1.setPrefHeight(50);
            
            pan2.getChildren().add(Nom);
            pan2.setPrefHeight(50);
             Rating rating = new Rating();
            try
                {
                    if(ps.getnbr(p.getId())==0)
                {
                    rating=new Rating(5,0);
                }
                    else
                {
                    
                    rating = new Rating(5, (int) Math.round(ps.calculerRating(p)));
                    rating.setDisable(true);
                    
                }
                } catch (SQLException ex) {
                Logger.getLogger(ListePediatreController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            pan4.getChildren().add(rating);
            pan4.setPrefHeight(50);
            
            pan3.getChildren().add(Specialite);
            pan3.setPrefHeight(50);
            
            pan.setUserData(p); //// set ta3 l'objet ///
            pan.getChildren().add(pan1);
            pan.getChildren().get(0).setLayoutX(0);
            pan.getChildren().add(pan2);
            pan.getChildren().get(1).setLayoutX(110);
            pan.getChildren().add(pan3);
            pan.getChildren().get(2).setLayoutX(250);
            pan.getChildren().add(pan4);
            pan.getChildren().get(3).setLayoutX(500);
            pan.setTranslateY(30);
            
           listviewpediatre.getItems().add(pan);
           listviewpediatre.getItems().get(listviewpediatre.getItems().size()-1).setPrefHeight(100);
           
           
        });
       
               
    }
     


    @FXML
    private void ajouterPediatre(ActionEvent event) throws IOException {
        
        
       Parent root= FXMLLoader.load(getClass().getResource("AjouterPediatre.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.show();
       
       ((Node) (event.getSource())).getScene().getWindow().hide();
        
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