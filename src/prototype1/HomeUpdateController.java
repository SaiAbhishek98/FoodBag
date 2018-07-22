/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Abhishek
 */
public class HomeUpdateController implements Initializable {
    AnchorPane BB;
    Image back;
    
    public Image copyBackground(Stage stage,int xc,int yc,int Hght, int Wayt) {
        final int X = ((int) stage.getX()+xc);
        final int Y = ((int) stage.getY()+yc);
        final int W = (int) Hght;
        final int H = (int) Wayt;

        try {
            java.awt.Robot robot = new java.awt.Robot();
            java.awt.image.BufferedImage image = robot.createScreenCapture(new java.awt.Rectangle(X, Y, W, H));

            return SwingFXUtils.toFXImage(image, null);
        } catch (java.awt.AWTException e) {
            System.out.println("The robot of doom strikes!");

            return null;
        }
    }

    /**
     * Initializes the controller class.
   
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
