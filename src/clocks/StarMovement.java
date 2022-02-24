package clocks;

import game.Star;
import gui.Gui;

import java.util.ArrayList;

public class StarMovement {

    public static ArrayList<Star> stars = new ArrayList<>();

    public StarMovement() {
        for(int i = 0; i<100; i++) {
            stars.add(new Star((int) (Math.random() * Gui.GAME_WIDTH), (int) (Math.random() * Gui.GAME_HEIGHT), (int) (Math.random() * 2 + 1)));
        }
    }

    public static void move(){
        for (int i = 0; i<100; i++){
            stars.get(i).setY(stars.get(i).getY()+1);

            if(stars.get(i).getY() >= Gui.GAME_HEIGHT){
                stars.get(i).setY(0);
            }
        }

    }
}
