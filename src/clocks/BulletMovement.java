package clocks;

import gui.Gui;

public class BulletMovement {
    public static void move(){
        for(int i = 0; i < BulletCreation.bullets.size(); i ++){
            BulletCreation.bullets.get(i).setY(BulletCreation.bullets.get(i).getY() - BulletCreation.bullets.get(i).getSpeed());
            if(BulletCreation.bullets.get(i).getY() > Gui.GAME_HEIGHT){
                BulletCreation.bullets.remove(i);
            }
        }
    }
}
