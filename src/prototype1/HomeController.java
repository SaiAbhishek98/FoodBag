/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype1;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import org.controlsfx.control.PopOver;


/**
 * FXML Controller class
 *
 * @author Abhishek
 */
public class HomeController extends FXMLDocumentController implements Initializable {
    public JFXButton p1;
    public VBox vb,vbz;
    public static int vb_width = 210;
    public static int vb_min_width = 1;
    private boolean flag;
    public AnchorPane anch;
    public BorderPane bp;
    public ImageView Iv;
    public AnchorPane BorderTop;
    public ImageView backg;
    public AnchorPane ParentPane;
    public Button btn;
    public StackPane ToolbarStack;
    public PopOver pop;
     /**
     *
     */
    public Tools tool;
    public Animators obj;
    private double vboxwidth = 0.0d;
    public HomeController() {
        this.flag = false;
        obj = new Animators(); 
    }
    public void OpenAnimation(){
    vb.setPrefWidth(1);
    bp.setLeft(vb);   
    System.out.println("Open Ham invoked");
    Timeline s = obj.applyTimeLine(vb, 200, vb_min_width, vboxwidth);
    obj.applyFadeAnimationOn(vb,300, 0, 1, null);
    obj.applyTranslateAnimationOn(p1,200,0,150);  
    flag = true;
    }
    public void CloseAnimation(){
      
        System.out.println("Close Ham invoked");
       Timeline s  = obj.applyTimeLine(vb, 500, vboxwidth, vb_min_width);
       obj.applyFadeAnimationOn(vb, 300, 1, 0, null);
       s.setOnFinished((evt) -> bp.setLeft(null));
        obj.applyTranslateAnimationOn(p1, 300, 150, 0);
       // obj.applyRotationOn(p1, 400, -180 ,1);
        flag = false;
    }
    public void Ham(){
       
    if(flag)
        CloseAnimation();
    else
        OpenAnimation();
    }
    public void OnExit() throws Exception{
      Platform.exit();
    }
    public void LogOut() {
      //  obj.applyTranslateAnimationOn(ParentPane, 400, 0, ParentPane.getWidth());
        obj.applyFadeAnimationOn(ParentPane, 600, 1, 0, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
          try {
            Stage lt = (Stage)(p1.getScene().getWindow());
            Parent pt = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene S = new Scene(pt);
            //tool.ChangeNode(p1,"FXMLDocument.fxml");
            lt.setScene(S);
    
        } catch (Exception ex) {
            System.out.println("Log Out Exception");
            ex.printStackTrace();
        }
            }
        });
    }         
     public void Lister(){
         for(int i=0;i<5;i++)
      vbz.getChildren().add(new Label("hello"));
     }   
     public void User_Details_Navigate(){
         CloseAnimation();
        try {
            Parent rot = FXMLLoader.load(getClass().getResource("User_Details.fxml"));
            obj.applyFadeAnimationOn(bp, 300, 0, 1, (evt)->{bp.setCenter(null);
            bp.setCenter(rot);});
             } catch (IOException ex) {
            System.out.println("User Details Navigate ");
            ex.printStackTrace();
        }
     }
    public void minimise(){
        try{
    // st.setIconified(true);
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    public void Hi() throws IOException{
       Node X = FXMLLoader.load(getClass().getResource("BGTest.fxml"));
        pop = new PopOver(X);
        pop.setCornerRadius(5);
        pop.setArrowSize(10);
        pop.setAutoHide(true);
        pop.setHideOnEscape(true);
        pop.setArrowLocation(PopOver.ArrowLocation.TOP_CENTER);
        pop.setDetachable(false);
        pop.show(btn);
        }
    
    public void DemZXCA() throws IOException{
        Stage NStage = (Stage)(p1.getScene().getWindow());
        Parent NChild = FXMLLoader.load(getClass().getResource("HomeUpdate.fxml"));
        Scene Sn = new Scene(NChild);
        NStage.setScene(Sn);
        NStage.setX(0);
        NStage.setY(0);
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try{
         bp.setLeft(null);
        vboxwidth = vb.getPrefWidth();}
       catch(Exception e){
       System.out.println("Initialize");
       }
           }    
    
}
