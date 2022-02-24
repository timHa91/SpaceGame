package clocks;

import characters.Bullet;
import characters.Player;
import game.GameState;
import game.GameStateE;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class BulletCreation {

    public static ArrayList<Bullet> bullets = new ArrayList<>();
    public static Timer timer;

    public BulletCreation(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(GameState.state == GameStateE.INGAME){
                    if(Player.isShooting){
                        bullets.add(new Bullet(Player.x + Player.PLAYER_WIDTH/2 - 8, Player.y - 50, 15, 50, 20));
                    }
                }
            }
        },200,200);
    }


}
