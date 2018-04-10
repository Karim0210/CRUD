/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Article;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import services.ArticleService;
import services.PediatreService;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class ListeArticleController implements Initializable {

    @FXML
    private Button btnaccueil;
    @FXML
    private ListView<Pane> listviewarticle;
    @FXML
    private Button toparticle;
    @FXML
    private Button btnpopulaire;
    
    List<Article> l= new ArrayList<Article>();
    private static ListeArticleController instance;
    @FXML
    private Button btnajout;

    /**
     * Initializes the controller class.
     */
    
    public ListeArticleController()
    {
        instance = this;
    }
    
    public static ListeArticleController getInsatance()
    {
        return instance;
    }
    
    public Article article()
    {
        return (Article) listviewarticle.getSelectionModel().getSelectedItem().getUserData();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherArticle();
    }  
    
    public void afficherArticle()
    {
        ArticleService as=new ArticleService();
        
        
        l.clear();
        listviewarticle.getItems().clear();
        l = as.selectArticle();
        
        l.stream().forEach((Article a)->{
            
            Text fTitre=new Text("Titre : ");
            Text fAutheur=new Text("Autheur : ");
            Text fText=new Text("Text : ");
            Text fType = new Text("Type : ");
            
            Label Titre=new Label(fTitre.getText()+a.getNom());
            /*Titre.setWrapText(true);*/
            Titre.setMaxWidth(150);
            Label Autheur=new Label(fAutheur.getText()+a.getAutheur());
            Autheur.setWrapText(true);
            Autheur.setMaxWidth(15);
            Label Text=new Label(fText.getText()+a.getText());
            Text.setMaxWidth(200);
            Label Type=new Label(fType.getText()+a.getType());
            
            /////css////
            //Autheur.setWrappingWidth(200);
            Titre.setFont(Font.font ("Ubuntu Bold", 15));
            Autheur.setFont(Font.font ("Ubuntu Bold", 15));
            Text.setFont(Font.font ("Ubuntu Bold", 15));
            Type.setFont(Font.font ("Ubuntu Bold", 15));
            
            Titre.setStyle("-fx-fill: #1bb4b9");
            Text.setStyle("-fx-fill: #1bb4b9");
            Autheur.setStyle("-fx-fill: #1bb4b9");
            Type.setStyle("-fx-fill: #1bb4b9");
            //// fin css ////
            
            ////img////
            ImageView img=new ImageView();
            try{
                img=new ImageView("/images/"+a.getImage());
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
            pan2.getChildren().add(Titre);
            pan2.setPrefHeight(50);
            hbox.getChildren().add(pan2);
            
            
            
            
            pan4.getChildren().add(Type);
            pan4.setTranslateX(500);
            pan4.setTranslateY(32);
            pan4.setPrefHeight(50);
            
            pan3.getChildren().add(Text);
            pan3.setPrefHeight(50);
            hbox.getChildren().add(pan3);
            hbox.getChildren().add(pan4);
            hbox.setAlignment(Pos.CENTER);
            pan.setUserData(a); //// emplacement pan ///
            pan.getChildren().add(pan1);
            pan.getChildren().add(hbox);
            pan.getChildren().get(0).setLayoutX(0);
           // pan.getChildren().add(pan2);
           // pan.getChildren().get(1).setLayoutX(110);
           // pan.getChildren().get(2).setLayoutX(250);
            pan.getChildren().add(pan4);
           // pan.getChildren().get(3).setLayoutX(450);
            pan.setTranslateY(30);
            
           listviewarticle.getItems().add(pan);
           listviewarticle.getItems().get(listviewarticle.getItems().size()-1).setPrefHeight(100);
           
           
        });
       
        
    }

    @FXML
    private void handle(MouseEvent event) throws IOException {
         ArticleService as=new ArticleService();
        
        
        System.out.println(listviewarticle.getSelectionModel().
                getSelectedItem().getUserData());
       Article a=new Article();
       
       a=(Article) listviewarticle.getSelectionModel().
                getSelectedItem().getUserData();
       
        
        
       Parent root= FXMLLoader.load(getClass().getResource("AfficherArticle.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.show();
       
       ((Node) (event.getSource())).getScene().getWindow().hide();
        
      
    }

    @FXML
    private void top(MouseEvent event) {
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
    private void afficherPopulaire(ActionEvent event) {
    }

    @FXML
    private void ajouterArticle(ActionEvent event) throws IOException {
        
       Parent root= FXMLLoader.load(getClass().getResource("AjouterArticle.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.show();
       
       ((Node) (event.getSource())).getScene().getWindow().hide();
        
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
