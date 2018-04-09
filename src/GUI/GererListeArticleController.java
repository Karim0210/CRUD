/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Karim
 */
public class GererListeArticleController implements Initializable {

    @FXML
    private TableView<?> tableviewpediatre;
    @FXML
    private TableColumn<?, ?> nomcol;
    @FXML
    private TableColumn<?, ?> prenomcol;
    @FXML
    private TableColumn<?, ?> emailcol;
    @FXML
    private TableColumn<?, ?> adressecol;
    @FXML
    private TableColumn<?, ?> specialitecol;
    @FXML
    private TableColumn<?, ?> descriptioncol;
    @FXML
    private TableColumn<?, ?> editcol;
    @FXML
    private TableColumn<?, ?> activationcol;
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
        // TODO
    }    

    @FXML
    private void editer(MouseEvent event) {
    }

    @FXML
    private void modifierPediatre(ActionEvent event) {
    }
    
}
