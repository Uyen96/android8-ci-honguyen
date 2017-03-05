package model;

import controllers.GameController;
import gui.GameWindow;

import java.util.ServiceConfigurationError;

/**
 * Created by HongUyen on 27-Feb-17.
 */
public class BackGroundModel extends GameModel{
   public static final int SPEED = 5;

    public BackGroundModel(int x, int y, int width, int height) {
        super(x, y, width, height);
    }


    public void run() {
        y += SPEED;
    }


}
