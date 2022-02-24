package draw;

import characters.Asteroid;
import characters.Bullet;
import characters.Player;
import clocks.AsteroidCreation;
import clocks.BulletCreation;
import clocks.StarMovement;
import game.GameState;
import game.GameStateE;
import gui.Gui;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawMain {

    public void draw(GraphicsContext g){
        // Hintergrund zeichnen
        g.setFill(Color.BLACK);
        g.fillRect(0,0, Gui.GAME_WIDTH, Gui.GAME_HEIGHT);

        // Stars zeichnen
        g.setFill(Color.WHITE);
        for(int i = 0; i< StarMovement.stars.size(); i++){
            g.fillOval(StarMovement.stars.get(i).getX(),StarMovement.stars.get(i).getY(), StarMovement.stars.get(i).getSize(), StarMovement.stars.get(i).getSize());
        }

        // Rocket zeichnen
        if(!Player.isHit) {
            g.drawImage(ImageLoader.iPlayer, Player.x, Player.y, Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT);
            // Hitbox Rakete zeichnen
            //g.setStroke(Color.RED);
            //g.strokeRect(Player.x + 5, Player.y + 5, Player.PLAYER_WIDTH - 10, Player.PLAYER_HEIGHT-10);


        } else {
            g.drawImage(ImageLoader.iPlayerHit, Player.x, Player.y, Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT);
        }
        // Asteroids zeichnen
        for(Asteroid asteroid : AsteroidCreation.asteroids){
            if(asteroid.containsIridium()){
                g.drawImage(ImageLoader.asteroidIridium, asteroid.getX(), asteroid.getY(), asteroid.getAsteroidWidth(), asteroid.getAsteroidHeight());
            } else {
                g.drawImage(ImageLoader.asteroid, asteroid.getX(), asteroid.getY(), asteroid.getAsteroidWidth(), asteroid.getAsteroidHeight());
            }
            // Health zeichnen
            if(asteroid.isHit()){
                g.setFill(Color.DARKRED);
                g.setStroke(Color.BLACK);
                g.fillRect(asteroid.getX()+ asteroid.getAsteroidWidth()/4, asteroid.getY()-10, asteroid.getAsteroidWidth()/2, 10);

                // Health abziehen
                g.setFill(Color.RED);
                g.fillRect(asteroid.getX()+asteroid.getAsteroidWidth()/4, asteroid.getY()-10, asteroid.getAsteroidWidth()/2 * (double)asteroid.getCurrentHealth()/(double)asteroid.getAsteroidHealth(),10);
            }

            // Hitbox Asteroid zeichnen
            //g.setStroke(Color.BLUE);
            //g.strokeRect(asteroid.getX()+15, asteroid.getY()+15, asteroid.getAsteroidWidth() -30, asteroid.getAsteroidHeight()-30);
        }

        for (Bullet b : BulletCreation.bullets){
            g.drawImage(ImageLoader.iSchuss, b.getX(), b.getY(), b.getWidth(), b.getHeight());
        }



        if(GameState.state == GameStateE.PAUSE){
            g.setFill(new Color(0,0,0,0.5));
            g.fillRect(0,0, Gui.GAME_WIDTH, Gui.GAME_HEIGHT);
        }
    }


}
