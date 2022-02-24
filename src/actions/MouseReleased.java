package actions;

import characters.Player;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseReleased implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent mouseEvent) {
        Player.move((int)mouseEvent.getX());
        Player.isShooting = false;
    }
}
