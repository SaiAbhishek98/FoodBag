/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import prototype1.HomeController;

/**
 * FXML Controller class
 *
 * @author Abhishek
 */
import javafx.scene.control.Button;
public class BGTestController implements Initializable {

    public Button bat;
    public void Act(){
       
        bat.setText("Im Clicked");
        //User_Details_Navigate();
       
       
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
