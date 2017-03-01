package utils;

import gui.GameWindow;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by HongUyen on 01-Mar-17.
 */
public class KeyInPut extends KeyAdapter {
    GameWindow gameWindow;

    public KeyInPut(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    public void keyPressed(KeyEvent e){
        gameWindow.keyPressed(e);
    }

    public void keyReleased(KeyEvent e){
        gameWindow.keyReleased(e);
    }
}
