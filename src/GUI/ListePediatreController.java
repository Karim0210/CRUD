/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Pediatre;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
        afficher();
    }  
    
    public void afficher(){
        
        PediatreService ps=new PediatreService();
        
        
        l.clear();
        listviewpediatre.getItems().clear();
        l = ps.selectPediatre();
        
        l.forEach(p->{
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
            
            
            pan3.getChildren().add(Likes);
            pan3.setPrefHeight(50);
            
            pan4.getChildren().add(Specialite);
            pan4.setPrefHeight(50);
            
            pan.setUserData(p); //// set ta3 l'objet ///
            pan.getChildren().add(pan1);
            pan.getChildren().get(0).setLayoutX(0);
            pan.getChildren().add(pan2);
            pan.getChildren().get(1).setLayoutX(110);
            pan.getChildren().add(pan3);
            pan.getChildren().get(2).setLayoutX(250);
            pan.getChildren().add(pan4);
            pan.getChildren().get(3).setLayoutX(370);
            pan.setTranslateY(30);
            
           listviewpediatre.getItems().add(pan);
           listviewpediatre.getItems().get(listviewpediatre.getItems().size()-1).setPrefHeight(100);
           
           
        });
       
        
    }

   

    @FXML
    private void handle(MouseEvent event) throws IOException {
        
//
        
        System.out.println(listviewpediatre.getSelectionModel().
                getSelectedItem().getUserData());
       
       Parent root= FXMLLoader.load(getClass().getResource("ProfilPediatre.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.show();
        
      
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
        
       System.out.println("nouvelle fenetre"); 
       Parent root= FXMLLoader.load(getClass().getResource("ListePediatreTrier.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.show();
        
    }
    
    
    
    
}