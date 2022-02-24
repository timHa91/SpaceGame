package actions;

import characters.Player;
import game.GameState;
import game.GameStateE;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MousePressed implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent mouseEvent) {

        if(GameState.state == GameStateE.INGAME){
            Player.isShooting = true;
            Player.move((int)mouseEvent.getX());
        }
    }
}
