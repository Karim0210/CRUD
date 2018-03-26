/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Pediatre;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import services.PediatreService;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class GererListePediatreController implements Initializable {

    @FXML
    private TableView<Pediatre> tableviewpediatre;
    @FXML
    private TableColumn<Pediatre, String> nomcol;
    @FXML
    private TableColumn<Pediatre, String> prenomcol;
    @FXML
    private TableColumn<Pediatre, String> emailcol;
    @FXML
    private TableColumn<Pediatre, String> adressecol;
    @FXML
    private TableColumn<Pediatre, String> specialitecol;
    @FXML
    private TableColumn<Pediatre, String> descriptioncol;
   
    @FXML
    private TableColumn<Pediatre, Boolean> editcol;
    @FXML
    private TableColumn<?, ?> idcol;
    @FXML
    private TextField nomed;
    @FXML
    private TextField prenomed;
    @FXML
    private TextField emailed;
    @FXML
    private TextField adresseed;
    @FXML
    private TextField specialiteed;
    @FXML
    private TextField descriptioned;
    @FXML
    private TextField ided;
    @FXML
    private Button modifiered;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        afficherPediatre();
       
    }    

    public void afficherPediatre()
    {
        Pediatre a=new Pediatre();
        PediatreService as=new PediatreService();
        List<Pediatre> l;
        
        l = as.selectPediatre();

        ObservableList data = FXCollections.observableArrayList(l);
       
        //System.out.println(data);
        
        tableviewpediatre.setItems(data);
        /////////////// input ta3 lbouton toggle /////////////////
        Callback<TableColumn<Pediatre, Boolean>, TableCell<Pediatre, Boolean>> cellFactory = 
			new Callback<TableColumn<Pediatre, Boolean>, TableCell<Pediatre, Boolean>>()
	{
		@Override
		public TableCell<Pediatre, Boolean> call( final TableColumn<Pediatre, Boolean> param)
		{
                    
			final TableCell<Pediatre, Boolean> cell = new TableCell<Pediatre, Boolean>()
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
                                                    as.DeletPediatre(getTableView().getItems().get(getIndex()).getId());
                                                    afficherPediatre();
						});
                                                
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
        nomcol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomcol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        emailcol.setCellValueFactory(new PropertyValueFactory<>("email"));
        adressecol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        specialitecol.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        descriptioncol.setCellValueFactory(new PropertyValueFactory<>("description"));
        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        editcol.setCellFactory(cellFactory);
        
        
    }

    @FXML
    private void editer(MouseEvent event) {
        nomed.setText((String) nomcol.getCellData(tableviewpediatre.getSelectionModel().getSelectedCells().get(0).getRow()));
        prenomed.setText((String) prenomcol.getCellData(tableviewpediatre.getSelectionModel().getSelectedCells().get(0).getRow()));
        emailed.setText((String) emailcol.getCellData(tableviewpediatre.getSelectionModel().getSelectedCells().get(0).getRow()));
        adresseed.setText((String) adressecol.getCellData(tableviewpediatre.getSelectionModel().getSelectedCells().get(0).getRow()));
        specialiteed.setText((String) specialitecol.getCellData(tableviewpediatre.getSelectionModel().getSelectedCells().get(0).getRow()));
        descriptioned.setText((String) descriptioncol.getCellData(tableviewpediatre.getSelectionModel().getSelectedCells().get(0).getRow()));
        ided.setText(idcol.getCellData(tableviewpediatre.getSelectionModel().getSelectedCells().get(0).getRow()).toString());
        
    }

    @FXML
    private void modifierPediatre(ActionEvent event) {
           
           Pediatre a= new Pediatre();
           PediatreService as=new PediatreService();
           a.setId(Integer.parseInt(ided.getText()));
           a.setPrenom(prenomed.getText());
           a.setNom(nomed.getText());
           a.setEmail(emailed.getText());
           a.setAdresse(adresseed.getText());
           a.setSpecialite(specialiteed.getText());
           a.setDescription(descriptioned.getText());
           as.modifierPediatre(a);
           System.out.println(a);
           afficherPediatre();
    }

   
}
