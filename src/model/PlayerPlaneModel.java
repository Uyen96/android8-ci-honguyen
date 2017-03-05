package model;

import gui.GameWindow;

/**
 * Created by HongUyen on 26-Feb-17.
 */
public class PlayerPlaneModel extends GameModel{
    public static final int SPEED = 20;
    public static final int DEFAULT_WIDTH = 35;
    public static final int DEFAULT_HEIGHT = 31;

    public static final int TIME_DELAY_SHOOT = 10;

    private int time_shoot = 0;

    public PlayerPlaneModel(int x, int y, int width, int height) {
        super(x, y, width, height);

    }


    public void flyUp(){
        if(y- SPEED>=0){
            y -= SPEED;
        }
    }

    public void flyDown(){
        if(y+ SPEED<= (GameWindow.SCREEN_HEIGHT-height)) {
            y += SPEED;
        }
    }

    public void flyLeft(){
        if(x- SPEED>=0) {
            x -= SPEED;
        }
    }

    public void flyRight(){
        if(x+ SPEED<=(GameWindow.SCREEN_WIDTH-width)) {
            x += SPEED;
        }
    }

    public void increaseTimeShoot(){
        time_shoot += GameWindow.TIME_GAME_LOOP;
    }

    public boolean shoot(){
        time_shoot += GameWindow.TIME_GAME_LOOP;
        if(time_shoot>=TIME_DELAY_SHOOT){
            time_shoot = 0;
            return  true;
        }
        return false;
    }
}
