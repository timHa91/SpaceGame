package characters;

import data.CustomMath;
import gui.Gui;

public class Asteroid {
    private int x,y, asteroidWidth, asteroidHeight, asteroidHealth, currentHealth, asteroidSpeed;
    private boolean isHit = false, containsIridium;
    private int value = 0;


    public Asteroid() {
        int ratio = CustomMath.limit((int)(Math.random()*200+50), 50, 200);

        int rnd = (int)(Math.random()*10 + 1); // Zufallszahl zwischen 1 und 10
        // Chance 1:5 das ein Asteroid Iridium enthält
        if(rnd % 5 == 0) {
            containsIridium = true;
        } else {
            containsIridium = false;
        }

        asteroidWidth = ratio;
        asteroidHeight = ratio;
        asteroidHealth = (asteroidWidth * asteroidHeight) /200;
        currentHealth = asteroidHealth;

        asteroidSpeed = (int) (Math.random() * 6)+1;

        x = CustomMath.limit((int)(Math.random() * Gui.GAME_WIDTH), asteroidWidth + Player.PLAYER_WIDTH/2, Gui.GAME_WIDTH- asteroidWidth -Player.PLAYER_WIDTH/2);
        y = -asteroidHeight;

        if(containsIridium){
            value = (asteroidWidth * asteroidHeight) / 400;
        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAsteroidWidth() {
        return asteroidWidth;
    }

    public void setAsteroidWidth(int asteroidWidth) {
        this.asteroidWidth = asteroidWidth;
    }

    public int getAsteroidHeight() {
        return asteroidHeight;
    }

    public void setAsteroidHeight(int asteroidHeight) {
        this.asteroidHeight = asteroidHeight;
    }

    public int getAsteroidHealth() {
        return asteroidHealth;
    }

    public void setAsteroidHealth(int asteroidHealth) {
        this.asteroidHealth = asteroidHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getAsteroidSpeed() {
        return asteroidSpeed;
    }

    public void setAsteroidSpeed(int asteroidSpeed) {
        this.asteroidSpeed = asteroidSpeed;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public boolean containsIridium() {
        return containsIridium;
    }

    public void setContainsIridium(boolean containsIridium) {
        this.containsIridium = containsIridium;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
