/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype1;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author Abhishek
 */

public class ConfirmController implements Initializable {

    public AnchorPane anch;
    public Label lb;
    private void LoadNextWindow() throws Exception{
    Stage CurrentStage = (Stage) (lb.getScene().getWindow());
    Parent Home = FXMLLoader.load(getClass().getResource("Home.fxml"));
    Scene NS=new Scene(Home);
    CurrentStage.setScene(NS);
   
}
    private void  fade_out(){
        FadeTransition Fd = new FadeTransition();
        Fd.setDuration(Duration.millis(1000));
        Fd.setNode(anch);
        Fd.setFromValue(1);
        Fd.setToValue(0);
        Fd.play();
        Fd.setOnFinished(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    LoadNextWindow();
                } catch (Exception ex) {
                    //Logger.getLogger(ConfirmController.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Confirm Controller, Fade out");
                }
            }
        });
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FadeTransition Ft = new FadeTransition();
        Ft.setDuration(Duration.millis(1000));
        Ft.setNode(anch);
        Ft.setFromValue(0);
        Ft.setToValue(1);
        Ft.play();
        Ft.setOnFinished(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    //LoadNextWindow();
                    fade_out();
                } catch (Exception ex) {
                    Logger.getLogger(ConfirmController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }    
    
}
