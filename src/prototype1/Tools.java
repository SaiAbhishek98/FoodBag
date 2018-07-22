/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype1;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Abhishek
 */
public class Tools {
public void ChangeNode(Node n,String fxmlfile) {
        try{
        Stage X = (Stage)(n.getScene().getWindow());
        Parent P = FXMLLoader.load(getClass().getResource(fxmlfile));
        Scene S=new Scene(P);
        X.setScene(S);
    }
        catch(Exception E){
            System.out.println("\nException caught");
        }
}
}
