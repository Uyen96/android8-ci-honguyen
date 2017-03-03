package model;

import gui.GameWindow;
import utils.Utils;

/**
 * Created by HongUyen on 02-Mar-17.
 */
public class IsLandModel  extends GameModel{
    private static final int  SPEED = 10;

    public IsLandModel(int x, int y, int width, int height) {
       super(x, y, width, height);
    }



    public void setDefaultLocation(){
        y = 0;
        x = Utils.RandomAll(GameWindow.SCREEN_WIDTH-width*2,0);
    }

    public void run(){
        y += SPEED;
    }
}

