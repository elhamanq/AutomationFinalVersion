package FinalVersion;
//
//package proj3;
//import java.awt.event.ActionEvent;
//
//import javax.swing.GroupLayout.Group;
//import javax.xml.crypto.dsig.keyinfo.KeyValue;
//
//import org.w3c.dom.Text;
//
//import javafx.animation.AnimationTimer;
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.effect.Lighting;
//import javafx.scene.layout.StackPane;
//import javafx.scene.shape.Circle;
//import javafx.stage.Stage;
// 
//public class JAVAFXJ extends Application {
//    
//    //main timeline
//    private Timeline timeline;
//    private AnimationTimer timer;
// 
//    //variable for storing actual frame
//    private Integer i=0;
// 
//    @Override public void start(Stage stage) {
//        Group p = new Group();
//        Scene scene = new Scene(p);
//        stage.setScene(scene);
//        stage.setWidth(500);
//        stage.setHeight(500);
//        p.setTranslateX(80);
//        p.setTranslateY(80);
// 
//        //create a circle with effect
//        final Circle circle = new Circle( 50,  Color.rgb(156,216,255));
//        circle.setEffect(new Lighting());
//        final Circle circle1 = new Circle(100,Color.RED);
//        circle.setEffect(new Lighting());
//        final Circle circle2 = new Circle(10,  Color.BLUE);
//        circle.setEffect(new Lighting());
//        circle1.setEffect(new Lighting());
//        circle2.setEffect(new Lighting());
//        //create a text inside a circle
//        final Text text = new Text (i.toString());
//        text.setStroke(Color.RED);
//        //create a layout for circle with text inside
//        final StackPane stack = new StackPane();
//        stack.getChildren().add(circle);
//        stack.setLayoutX(50);
//        stack.setLayoutY(50);
//        stack.getChildren().add(circle1);
//        stack.setLayoutX(100);
//        stack.setLayoutY(100);
//        stack.getChildren().add(circle2);
//
//   //     stack.getChildren().addAll(circle1, text);
//    //    stack.getChildren().addAll(circle2, text);
//        stack.setLayoutX(30);
//        stack.setLayoutY(30);
// 
//        p.getChildren().add(stack);
//      
//        stage.show();
//       
//        //create a timeline for moving the circle
//        timeline = new Timeline();
//       // timeline.setCycleCount(Timeline.INDEFINITE);
//      //  timeline.setAutoReverse(true);
// 
////You can add a specific action when each frame is started.
//        timer = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//   //             text.setText(i.toString());
//    //            i++;
//            	if(circle.isPressed()) {
//            	circle.autosize();   }                                                                   
//            }
// 
//        };
// 
//        //create a keyValue with factory: scaling the circle 2times
//        KeyValue keyValueX = new KeyValue(stack.scaleXProperty(), 2);
//        KeyValue keyValueY = new KeyValue(stack.scaleYProperty(), 2);
// 
//        //create a keyFrame, the keyValue is reached at time 2s
//        Duration duration = Duration.millis(1);
//        //one can add a specific action when the keyframe is reached
//        EventHandler onFinished = new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent t) {
//       //          stack.setTranslateX(java.lang.Math.random()*200-100);
//                 //reset counter
//                 i = 0;
//            }
//        };
// 
//  KeyFrame keyFrame = new KeyFrame(duration, onFinished , keyValueX, keyValueY);
// 
//        //add the keyframe to the timeline
//        timeline.getKeyFrames().add(keyFrame);
// 
//        timeline.play();
//      //  timer.start();
//    } 
//        
//        
//    public static void main(String[] args) {
//        Application.launch(args);
//    }
//  } 