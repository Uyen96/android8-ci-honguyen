package model;

import gui.GameWindow;

/**
 * Created by HongUyen on 26-Feb-17.
 */
public class PlayerPlaneModel extends GameModel{
    private static final int SPEED = 5;

    public PlayerPlaneModel(int x, int y, int width, int height) {
        super(x, y, width, height);

    }


    /**
     *    move playerPlane
     * @param status : 1 : up, 2 : right, 3 : left, 4 : right
     */
    public void run(int status){
        switch (status){
            case 1 :
                //move up
                if(y - SPEED > 0)
                    y -= SPEED;
                break;

            case 2 :
                //move down
                if(y + SPEED < GameWindow.SCREEN_HEIGHT - height)
                    y += SPEED;
                break;

            case 3 :
                //move left
                if(x - SPEED > 0) {
                    x -= SPEED;
                }
                break;

            case 4 :
                //move right
                if(x + SPEED < GameWindow.SCREEN_WIDTH - width) {
                    x += SPEED;
                }
                break;
        }
    }




}
