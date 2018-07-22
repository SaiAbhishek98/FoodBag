/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype1;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Abhishek
 */
public class Prototype1 extends Application {
    
    public Parent root;
    @FXML
   // public static final Effect Frost_Effect = new BoxBlur(15, 15, 3);
   // public ImageView backg;
    
  
        
        
    @Override
    public void start(Stage stage) throws Exception {
        
        root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        //scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        scene.setFill(null);
        stage.setScene(scene);
        stage.show();
    }
       
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       
       launch(args);
    }
    
    
}

