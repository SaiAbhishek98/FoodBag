/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;




/**
 *
 * @author Abhishek
 */
public class FXMLDocumentController extends Prototype1 implements Initializable {
  
    @FXML
    
    public TextField username,username_signup;
    public PasswordField password,password_signup;
    public TextArea address;
    public Button sign_in;
    public Button sign_up,done;
    public ImageView back_signup;
    public StackPane SigninPane;
    public Pane SignupPane;
    public AnchorPane anchy;
    public Animators key;
     
    
    
      
    @FXML   
    public void Sign_in(ActionEvent event) {
       
       System.out.println(username.getText());
       System.out.println(password.getText());
       
       FadeConfirm();
    }
    
    private void FadeConfirm() {
        FadeTransition fd = new FadeTransition();
        fd.setDuration(Duration.millis(500));
        fd.setNode(anchy);
        fd.setFromValue(1);
        fd.setToValue(0);
        fd.play();
        fd.setOnFinished((ActionEvent event) -> {
            try {
                LoadConfirm();
            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
       
    }
    

    private void LoadConfirm(){
        try{
        Stage NStage = (Stage)(username.getScene().getWindow());
        Parent NChild = FXMLLoader.load(getClass().getResource("Confirm.fxml"));
        Scene Sn = new Scene(NChild);
        NStage.setScene(Sn);}
        catch(IOException e){
            System.out.println("Exception at LoadConfirm");
        }
    }
    public void Sign_up(ActionEvent event) throws Exception{
        System.out.println("You pressed Sign up");     
        Fade_out();
        //LoadSignupScene();
    }
    public void Done(ActionEvent event){
        System.out.println("Details taken");    
    }
    public void fback_signup(){
        System.out.println("Back button pressed");
        LoadSigninScene(); 
    }
    public void LoadSignupScene(){
        try{
     Stage CurrentStage = (Stage)username.getScene().getWindow();      
       Parent Signuproot = FXMLLoader.load(getClass().getResource("Signup.fxml"));    
       Scene X = new Scene(Signuproot);  
        CurrentStage.setScene(X); }
        catch(IOException e){
            System.out.println("Exception at LoadSignupScene");
        }
    }
    public void LoadSigninScene() {
        
            Animators animate = new Animators();
            
      Stage CurrentStage1 = (Stage)username_signup.getScene().getWindow(); 
      FadeTransition fd = animate.applyFadeAnimationOn(username_signup.getParent(), 500, 1, 0, null);
      fd.setOnFinished((ActionEvent event) -> {
          Parent Signinroot;
          try {
              Signinroot = FXMLLoader.load(FXMLDocumentController.this.getClass().getResource("FXMLDocument.fxml"));
              Scene X1 = new Scene(Signinroot);
              CurrentStage1.setScene(X1);
          }catch (IOException ex) {
              Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
          }
            });
       
    }
    public void OnExit1(){
        Platform.exit();
    }
    public void Fade_out(){
        FadeTransition FadeOut = new FadeTransition();
        FadeOut.setDuration(Duration.millis(500));
        FadeOut.setNode(SigninPane);
        FadeOut.setFromValue(1);
        FadeOut.setToValue(0);
        FadeOut.play();
        FadeOut.setOnFinished((ActionEvent event) -> {
            try {
                LoadSignupScene();
            } catch (Exception ex) {
                // Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        key = new Animators();
    }
   
}
        
        

    



