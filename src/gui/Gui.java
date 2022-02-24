package gui;

import actions.*;
import draw.DrawMain;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Gui {

    public static DrawMain dm;
    public static final int GAME_WIDTH = 1280;
    public static final int GAME_HEIGHT = 720;
    public static GraphicsContext gcMain; // Wird benötigt zum zeichnen

    public void init(){
        dm = new DrawMain();

    }

    public void create(Stage stage){
        Canvas canvasMain; // Wird benötigt zum zeichnen
        StackPane root = new StackPane();
        //int cWidth = GAME_WIDTH -10, cHeight = GAME_HEIGHT- 10; // Workaround

        canvasMain = new Canvas(GAME_WIDTH,GAME_HEIGHT); // erstell ein Zeichenboard
        gcMain = canvasMain.getGraphicsContext2D();
        dm.draw(gcMain);

        root.getChildren().addAll(canvasMain);
        Scene scene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);

        scene.setOnKeyPressed(new KeyPressed());
        scene.setOnKeyReleased(new KeyReleased());

        scene.setOnMouseMoved(new MouseMoved());
        scene.setOnMouseDragged(new MouseDragged());
        scene.setOnMousePressed(new MousePressed());
        scene.setOnMouseReleased(new MouseReleased());



        stage.setTitle("Space Adventure");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Platform.exit();
                System.exit(0);
            }
        });

    }


}
