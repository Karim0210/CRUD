/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Article;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import services.ArticleService;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class GererListeArticleController implements Initializable {

    @FXML
    private TableColumn<Article, Boolean> editcol;
    @FXML
    private TableColumn<Article, String> activationcol;
    @FXML
    private TableColumn<? , ?> idcol;
    @FXML
    private Button modifiered;
    @FXML
    private TableView<Article> tableviewarticle;
    @FXML
    private TableColumn<Article, String> titrecol;
    @FXML
    private TableColumn<Article, String> autheurcol;
    @FXML
    private TableColumn<Article, String> textcol;
    @FXML
    private TableColumn<Article, String> typecol;
    @FXML
    private TextField titreed;
    @FXML
    private TextField autheured;
    @FXML
    private TextField texted;
    @FXML
    private TextField typeed;
    @FXML
    private TextField ided;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherArticle();
    }    
    
    
    public void afficherArticle()
    {
        Article a=new Article();
        ArticleService as=new ArticleService();
        List<Article> l;
        
        l = as.selectArticle();

        ObservableList data = FXCollections.observableArrayList(l);
       
        //System.out.println(data);
        
        tableviewarticle.setItems(data);
        /////////////// input ta3 lbouton toggle /////////////////
        Callback<TableColumn<Article, Boolean>, TableCell<Article, Boolean>> cellFactory = 
			new Callback<TableColumn<Article, Boolean>, TableCell<Article, Boolean>>()
	{
		@Override
		public TableCell<Article, Boolean> call( final TableColumn<Article, Boolean> param)
		{
                    
			final TableCell<Article, Boolean> cell = new TableCell<Article, Boolean>()
			{
                                javafx.scene.image.Image imgdel = new Image(getClass().getResourceAsStream("/images/delete.png"));
                                final Button btnSupp = new Button();
                               
                                
                               
				
				@Override
				public void updateItem(Boolean check, boolean empty)
				{
					super.updateItem(check, empty);
					if(empty)
					{
						setGraphic(null);
						setText(null);
					}
					else{
						                                                
                                                btnSupp.setOnAction(e ->{
                                                    System.out.println("delete active : "+getTableView().getItems().get(getIndex()).getId());
                                                    as.DeletArticle(getTableView().getItems().get(getIndex()).getId());
                                                    afficherArticle();
						});
                                                
                                                 
						
                                                
                                                 
                                                 
                                                
                                                //css
                                                btnSupp.setStyle("-fx-background-color: transparent;");
						ImageView iv = new ImageView();
                                                iv.setFitHeight(20);
                                                iv.setFitWidth(20);
                                                iv.setTranslateX(20);
                                                iv.setImage(imgdel);
                                                iv.setPreserveRatio(true);
                                                iv.setSmooth(true);
                                                iv.setCache(true);
						btnSupp.setGraphic(iv);
						
						setGraphic(btnSupp);
						setAlignment(Pos.CENTER);
						setText(null);
                                                
                                                btnSupp.setText("   ");
						setGraphic(btnSupp);
						setAlignment(Pos.CENTER);      
						
                                        }
				}
			};
			return cell;
		}        
	};
    
    ////////////////////////////// fin input bouton ///////////////////////
                                             
           
        titrecol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        autheurcol.setCellValueFactory(new PropertyValueFactory<>("autheur"));
        textcol.setCellValueFactory(new PropertyValueFactory<>("text"));
        typecol.setCellValueFactory(new PropertyValueFactory<>("type"));
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        editcol.setCellFactory(cellFactory);
        
    }

    @FXML
    private void editer(MouseEvent event) {
        titreed.setText((String) titrecol.getCellData(tableviewarticle.getSelectionModel().getSelectedCells().get(0).getRow()));
        autheured.setText((String) autheurcol.getCellData(tableviewarticle.getSelectionModel().getSelectedCells().get(0).getRow()));
        texted.setText((String) textcol.getCellData(tableviewarticle.getSelectionModel().getSelectedCells().get(0).getRow()));
        typeed.setText((String) typecol.getCellData(tableviewarticle.getSelectionModel().getSelectedCells().get(0).getRow()));
        ided.setText(idcol.getCellData(tableviewarticle.getSelectionModel().getSelectedCells().get(0).getRow()).toString());
        
    }

    @FXML
    private void modifierArticle(ActionEvent event) {
        
        Article a= new Article();
           ArticleService as=new ArticleService();
           a.setId(Integer.parseInt(ided.getText()));
           a.setNom(titreed.getText());
           a.setAutheur(autheured.getText());
           a.setText(texted.getText());
           a.setType(typeed.getText());
           as.modifierArticle(a);
           System.out.println(a);
           afficherArticle();
        
    }
    
}
