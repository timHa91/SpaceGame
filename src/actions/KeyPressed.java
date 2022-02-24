package actions;

import game.GameState;
import game.GameStateE;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyPressed implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent keyEvent) {
        switch (keyEvent.getCode()){
            case ESCAPE:
                if(GameState.state == GameStateE.PAUSE){
                    GameState.state = GameStateE.INGAME;
                }else {
                    GameState.state = GameStateE.PAUSE;
                }
                break;
        }

    }
}
