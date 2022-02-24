package actions;

import characters.Player;
import clocks.AsteroidCreation;
import clocks.BulletCreation;
import clocks.MainClock;
import clocks.StarMovement;
import gui.Gui;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    Gui g = new Gui();


    private static Stage window;




    @Override
    public void start(Stage stage) throws Exception {

    g.init();
    g.create(stage);

    new Player();
    new MainClock(); // Anonymes Objekt erstellen der nur den Konstruktor aufruf

    AsteroidCreation.start();

    new BulletCreation();
    new StarMovement();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
