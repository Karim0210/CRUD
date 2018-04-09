/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.BCrypt;
import Entities.User;
import Services.UserService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author riadh
 */
public class LoginPageController implements Initializable {

    @FXML
    private TextField loginname;
    @FXML
    private TextField loginmdp;
    @FXML
    private Button btnlogin;

    /**
     * Initializes the controller class.
     */
    User userinfo;
    
    public static LoginPageController instance;
    
    public LoginPageController(){
        instance = this;
    }
    
    public static LoginPageController getInstance(){
        return instance;
    }  
    
    public User userinfo(){
        return userinfo;
    }
        
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    private void login(ActionEvent event) throws IOException, SQLException {
        userinfo=null;
        UserService us=new UserService();
        //System.out.println(loginname.getText()+loginmdp.getText());
        //userinfo = us.getLoginAccount(loginname.getText(),loginmdp.getText());
                userinfo = us.CheckLogin(loginname.getText(),loginmdp.getText());

        if ( userinfo != null){
            
            ((Node) (event.getSource())).getScene().getWindow().hide();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListePediatre.fxml"));
            Parent root;
            root = loader.load();
            Stage primaryStage = new Stage();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
                    
        }
        //System.out.println(userinfo);
    }
    
}
