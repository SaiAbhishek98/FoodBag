/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype1;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;


/**
 *
 * @author Abhishek
 */
import javafx.scene.layout.VBox;
public class Animators {
    public void applyTranslateAnimationOn(Node node, int duration, double from, double to) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(duration), node);
        translateTransition.setFromX(from);
        translateTransition.setToX(to);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
    }
 public FadeTransition applyFadeAnimationOn(Node node, int duration, double from, double to, EventHandler<ActionEvent> eventHandler) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(duration), node);
        fadeTransition.setOnFinished(eventHandler);
        fadeTransition.setFromValue(from);
        fadeTransition.setToValue(to);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
        return fadeTransition;
    }
  public void applyRotationOn(Node node, int duration, double angle, int cycleCount) {
        RotateTransition rotateTransition =
                new RotateTransition(Duration.millis(duration), node);
        rotateTransition.setByAngle(angle);
        rotateTransition.setCycleCount(cycleCount);
        rotateTransition.setAutoReverse(true);
        rotateTransition.play();
    }
  public Timeline applyTimeLine(VBox node,int duration, double start, double stop){
      Timeline t = new Timeline();
      t.getKeyFrames().addAll(new KeyFrame(Duration.ZERO,new KeyValue(node.prefWidthProperty(),start)),new KeyFrame(Duration.millis(duration),new KeyValue(node.prefWidthProperty(),stop)));
      t.play();
      return t;
  }
}
