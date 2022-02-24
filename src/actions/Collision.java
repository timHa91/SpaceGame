package actions;

import characters.Asteroid;
import characters.Bullet;
import characters.Player;

public class Collision {
    /* Kollesionsabfrage
    public static boolean collide(int x , int y , int width, int height, int x1, int y1, int width1, int height1){
        if (x < x1 + width1 && x + width > x1 && y < y1 + height1 && y + height > y1)
        {return true;}
        return false;
    }
     */

    public static boolean collisionPlayerAsteroid(Asteroid asteroid){
        return (Player.x + 5 < asteroid.getX() + 15 + asteroid.getAsteroidWidth()-30 && Player.x + 1 + Player.PLAYER_WIDTH-10 > asteroid.getX()+15 && Player.y + 15 < asteroid.getY()+15 + asteroid.getAsteroidHeight()-30 && Player.y
        +5 + Player.PLAYER_HEIGHT - 10 > asteroid.getY() +15);
    }

    public static boolean collisionBulletAsteroid(Bullet bullet, Asteroid asteroid){
        return(bullet.getX() < asteroid.getX() + asteroid.getAsteroidWidth() && bullet.getX() + bullet.getWidth() > asteroid.getX() && bullet.getY() < asteroid.getY() + asteroid.getAsteroidHeight() && bullet.getY() + bullet.getHeight() > asteroid.getY());
    }
}
