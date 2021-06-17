import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainClass extends Application {
    public static HBox bars;
    private VBox menubars;
    private Scene scene;
    private Label l1;
    private Button b1;
    private Button b2;
    private TextField field;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        bars = new HBox();
        menubars = new VBox();
        
        l1 = new Label("Enter the number of bars you would like to sort (850 or less) and select how you would like to sort them");
        b1 = new Button("Bubble Sort");
        b2 = new Button("Insertion Sort");
        field = new TextField();

        menubars.getChildren().addAll(l1, b1, b2, field);
        menubars.setAlignment(Pos.BASELINE_CENTER);
        
        bars.setAlignment(Pos.BOTTOM_CENTER);
        
        scene = new Scene(menubars, 600, 105);
        Image icon = new Image("sans lol.png");
        stage.getIcons().add(icon);
        stage.setTitle("David's Epic Sorting Algorithm Visualizer");
        stage.setResizable(true);
        stage.setScene(scene);


        b1.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent arg0) {
                stage.setFullScreenExitHint("");
                stage.setFullScreen(true);
                scene.setRoot(bars);
                
                generateRectangles(getFieldNumber());

                BubbleSort sort = new BubbleSort();

                AnimationTimer timer = new AnimationTimer(){

                    @Override
                    public void handle(long arg0) {
                        if (sort.sort()) {
                            stop();
                        }
                        
                    }
                    
                };
                
                timer.start();
                
            }
            
        });

        b2.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent arg0) {
                stage.setFullScreenExitHint("");
                stage.setFullScreen(true);
                scene.setRoot(bars);
                
                generateRectangles(getFieldNumber());

                SelectionSort sort = new SelectionSort();

                AnimationTimer timer = new AnimationTimer(){

                    @Override
                    public void handle(long arg0) {
                        if (sort.sort()) {
                            stop();
                        }
                        
                    }
                    
                };
                
                timer.start();
                
            }
            
        });
        
        stage.show();
        
        
        
    }

    public void generateRectangles(int numOfRectangles){
        double rectangleBase = 895 / numOfRectangles;
        for (int i = 0; i < numOfRectangles; i++) {
            bars.getChildren().add(new Rectangle(1000 / numOfRectangles, rectangleBase * i, Color.BLACK));
        }

    }

    public int getFieldNumber(){
        return Integer.parseInt(field.getText());
    }
    
}