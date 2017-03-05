package model;

import gui.GameWindow;
import utils.RandomAll;
import utils.Utils;

/**
 * Created by HongUyen on 02-Mar-17.
 */
public class IsLandModel  extends GameModel{
    public static final int  SPEED = 5 ;
    public static final int  WIDTH = 60;
    public static final int  HEIGHT = 60;

    public IsLandModel(int x, int y, int width, int height) {
       super(x, y, width, height);
    }



    public void setDefaultLocation(){
        y = 0;
        x = RandomAll.nextX(GameWindow.SCREEN_WIDTH - width * 2, 0);
    }

    public void run(){
        y += SPEED;
    }
}

