package clocks;

import characters.Player;

import java.util.Timer;
import java.util.TimerTask;

public class PlayerHit {

    public static void start() {
        Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                Player.isHit = false;
                time.cancel();
            }
        }, 300);
    }
}
