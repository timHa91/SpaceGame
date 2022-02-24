package characters;

import game.GameState;
import game.GameStateE;
import gui.Gui;

public class Player {

    public static int x,y;
    public static final int PLAYER_WIDTH = 56;
    public static final int PLAYER_HEIGHT = 152;
    public static boolean isShooting = false;
    public static boolean isHit = false;
    public static int health = 3;
    public static long iridium = 10000000L;

    public Player(){
        x = Gui.GAME_WIDTH/2 - PLAYER_WIDTH/2;
        y = Gui.GAME_HEIGHT -200;
    }

    public static void move(int xMouse) {

        if (GameState.state == GameStateE.INGAME) {
            if (xMouse >= PLAYER_WIDTH && xMouse <= Gui.GAME_WIDTH - PLAYER_WIDTH) {
                x = xMouse - PLAYER_WIDTH / 2;
            }
        }
    }
    public static void decrementHealth(){
        if(health>1){
            health --;
        } else {
            health = 3;
        }
    }

}
