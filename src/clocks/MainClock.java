package clocks;

import game.GameState;
import game.GameStateE;
import gui.Gui;

import java.util.Timer;
import java.util.TimerTask;

public class MainClock {
    Timer timer;

    public MainClock(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                // Fehler abfangen mit try catch
                try {
                    Gui.gcMain.clearRect(0,0,Gui.GAME_WIDTH, Gui.GAME_HEIGHT); // Alles wird gecleart
                    Gui.dm.draw(Gui.gcMain);
                    if(GameState.state == GameStateE.INGAME) {
                        AsteroidMovement.asteroidMove();
                        AsteroidCollision.collide();
                        BulletMovement.move();
                        StarMovement.move();
                    }

                } catch (Exception e) {
                    System.out.println("Main timer error");
                }


            }
        }, 30, 30); // braucht 30ms zum starten und wird alle 30ms refresht
    }

}
